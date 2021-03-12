package top.codewood.wx.pay.v3.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;
import top.codewood.util.http.AppHttpClient;
import top.codewood.wx.pay.v3.bean.error.WxPayError;
import top.codewood.wx.pay.v3.bean.error.WxPayErrorException;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.result.WxPayBillDownloadResult;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;
import top.codewood.wx.pay.v3.cert.CertificateItem;
import top.codewood.wx.pay.v3.cert.CertificateList;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v3.util.cert.AesUtil;
import top.codewood.wx.pay.v3.util.cert.PemUtil;
import top.codewood.wx.pay.v3.util.json.WxGsonBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.util.*;
import java.util.logging.Logger;

public class WxPayV3Api {

    public static final String EMPTY_STR = "";

    private static final Map<String, PrivateKey> PRIVATE_KEY_MAP = new HashMap<>();
    private static final Map<String, Certificate> CERTIFICATE_MAP = new HashMap<>();
    private static final Gson GSON;

    static {
        GSON = WxGsonBuilder.create();
    }

    public static String post(String url, String postData) {
        try {
            Response response = AppHttpClient.getInstance().postWithResponse(url, postData);
            return handleResponse(response.code(), response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String url, String token) {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            headers.put("Authorization", token);
            Response response = AppHttpClient.getInstance().getWithResponse(url, headers);
            return handleResponse(response.code(), response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response getWithReponse(String url, String token) {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            headers.put("Authorization", token);
            return AppHttpClient.getInstance().getWithResponse(url, headers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String post(String url, String postData, String token) {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            headers.put("Authorization", token);
            Response response = AppHttpClient.getInstance().postWithResponse(url, postData, headers);
            handleResponse(response);
            return handleResponse(response.code(), response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response postWithResponse(String url, String postData, String token) {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            headers.put("Authorization", token);
            return AppHttpClient.getInstance().postWithResponse(url, postData, headers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getToken(String mchid, String serialNo, String method, String reqUrl, String body) {
        try {
            long timeStamp = System.currentTimeMillis() / 1000;
            String nonceStr = UUID.randomUUID().toString().replace("-", "");
            String message = buildMessage(method, reqUrl, timeStamp, nonceStr, body);
            String signature = sign(mchid, message.getBytes(StandardCharsets.UTF_8));

            return String.format("WECHATPAY2-SHA256-RSA2048 mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%s\",signature=\"%s\",serial_no=\"%s\"",
                    mchid, nonceStr, timeStamp, signature, serialNo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String buildMessage(String method, String reqUrl, long timeStamp, String nonceStr, String body) throws MalformedURLException {
        URL url = new URL(reqUrl);
        String signUrl = url.getPath();
        if ("get".equals(method.toLowerCase()) && url.getQuery() != null) {
            signUrl += "?" + url.getQuery();
        }
        return method + "\n" + signUrl + "\n" + timeStamp + "\n" + nonceStr + "\n" + body + "\n";
    }

    public static String sign(String mchid, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        PrivateKey privateKey = PRIVATE_KEY_MAP.get(mchid);
        if (privateKey == null) throw new RuntimeException("私钥未初始化");
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message);
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    /**
     *
     * 这个api没有做签名校验
     *
     * @param mchid 发起请求的商户（包括直连商户、服务商或渠道商）的商户号 mchid
     * @param serialNo <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wechatpay/wechatpay3_1.shtml"></a>商户API证书</a>serial_no，用于声明所使用的证书
     * @return
     */
    public static List<CertificateItem> certificates(String mchid, String serialNo) {

        try {
            String url = "https://api.mch.weixin.qq.com/v3/certificates";
            String token = getToken(mchid, serialNo, "GET", url, EMPTY_STR);
            Response response = getWithReponse(url, token);

            //handleResponse(response);
            Gson gson = WxGsonBuilder.create();
            CertificateList certificateList = gson.fromJson(response.body().string(), CertificateList.class);
            return certificateList.getCerts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 在更换证书过程中，新老证书都生效，这时可转成map,通过serialNo快速查找
     * List<CertificateItem> to Map<String, CertificateItem> -> serialNo: CertificateItem
     * @param certificates
     * @return
     */
    public static Map<String, CertificateItem> certificateListToMap(List<CertificateItem> certificates) {
        Map<String, CertificateItem> map = new HashMap<>();
        certificates.stream().forEach(certificateItem -> map.put(certificateItem.getSerialNo(), certificateItem));
        return map;
    }

    /**
     * 加载私钥
     * @param inputStream
     */
    public static PrivateKey loadPrivateKey(String mchid, InputStream inputStream) {
        PrivateKey privateKey = PemUtil.loadPrivateKey(inputStream);
        PRIVATE_KEY_MAP.put(mchid, privateKey);
        return privateKey;
    }

    public static void loadCertificates(String apiV3Key, List<CertificateItem> certificateItems) {
        assert certificateItems != null;
        if (certificateItems.size() > 0) {
            AesUtil aesUtil = new AesUtil(apiV3Key.getBytes(StandardCharsets.UTF_8));
            certificateItems.stream().forEach(certificateItem -> {
                try {
                    String publicKey = aesUtil.decryptToString(certificateItem.getEncryptCertificateItem().getAssociatedData().getBytes(StandardCharsets.UTF_8),
                            certificateItem.getEncryptCertificateItem().getNonce().getBytes(StandardCharsets.UTF_8),
                            certificateItem.getEncryptCertificateItem().getCipherText());
                    CERTIFICATE_MAP.put(certificateItem.getSerialNo(), PemUtil.loadCertificate(new ByteArrayInputStream(publicKey.getBytes(StandardCharsets.UTF_8))));
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }


    private static Response handleResponse(Response response) throws IOException {
        String requestId = response.header("Request-ID");
        String wechatPayNonce = response.header("Wechatpay-Nonce");
        String wechatPaySignature = response.header("Wechatpay-Signature");
        String wechatPayTimeStamp = response.header("Wechatpay-Timestamp");
        String wechatPaySerial = response.header("Wechatpay-Serial");

        BufferedSource source = response.body().source();
        source.request(response.body().contentLength());
        Buffer buffer = source.getBuffer();
        String body = buffer.clone().readString(StandardCharsets.UTF_8);

        try {
            boolean verify = verify(wechatPaySerial, wechatPayTimeStamp, wechatPayNonce, body, wechatPaySignature);
            if (!verify) {
                throw new RuntimeException(String.format("请求数据签名校验失败, request-id: %s", requestId));
            }
        } catch (NoSuchAlgorithmException e) {
            //e.printStackTrace();
            throw new RuntimeException("校验算法错误！");
        } catch (InvalidKeyException e) {
            throw new RuntimeException("invalid key!");
        } catch (SignatureException e) {
            //e.printStackTrace();
            throw new RuntimeException("签名错误！");
        }

        return response;

    }

    public static boolean verify(String serialNo, String wechatTimeStamp, String wechatPayNonce, String body, String wechatSignature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (!CERTIFICATE_MAP.containsKey(serialNo)) {
            throw new RuntimeException(String.format("serialNo: %s 证书未配置!", serialNo));
        }
        String message = wechatTimeStamp + "\n" + wechatPayNonce + "\n" + body + "\n";
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(CERTIFICATE_MAP.get(serialNo));
        signature.update(message.getBytes(StandardCharsets.UTF_8));

        return signature.verify(Base64.getDecoder().decode(wechatSignature));
    }

    private static String handleResponse(int httpStatus, String resp) {
        JsonObject json = GSON.fromJson(resp, JsonObject.class);
        if (json.has("code") && json.has("message")) {
            WxPayError wxPayError = WxGsonBuilder.create().fromJson(resp, WxPayError.class);
            if (wxPayError.getCode() != null) {
                wxPayError.setStatus(httpStatus);
                throw new WxPayErrorException(wxPayError);
            }
        }

        return resp;
    }

    /**
     * 统一下单API
     * 商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再按Native、JSAPI、APP等不同场景生成交易串调起支付
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_1.shtml">统一下单</a>
     * @param mchid
     * @param serialNo
     * @param payType
     * @param wxPayRequest
     * @return
     */
    public static Map<String, String> unifiedOrder(String mchid, String serialNo, String payType, WxPayRequest wxPayRequest) {
        assert payType != null && wxPayRequest != null;
        if (WxPayConstants.PayType.JSAPI.getType().equals(payType)) {
            Gson gson = WxGsonBuilder.create();
            JsonObject json = gson.toJsonTree(wxPayRequest).getAsJsonObject();

            String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.POST, WxPayConstants.V3PayUrl.WX_PAY_JSAPI_URL, json.toString());
            String respStr = post(WxPayConstants.V3PayUrl.WX_PAY_JSAPI_URL, json.toString(), token);
            return gson.fromJson(respStr, Map.class);
        } else {
            throw new RuntimeException("无效的支付方式：" + payType);
        }
    }

    /**
     * 申请退款API
     * 当交易发生之后一年内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付金额退还给买家，微信支付将在收到退款请求并且验证成功之后，将支付款按原路退还至买家帐号上。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_9.shtml">申请退款</a>
     * @param mchid
     * @param serialNo
     * @param wxRefundRequest
     * @return
     */
    public static WxRefundResult refund(String mchid, String serialNo, WxRefundRequest wxRefundRequest) {
        assert wxRefundRequest != null;
        Gson gson = WxGsonBuilder.create();
        JsonObject json = gson.toJsonTree(wxRefundRequest).getAsJsonObject();
        String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.POST, WxPayConstants.V3PayUrl.REFUND_URL, json.toString());
        String respStr = post(WxPayConstants.V3PayUrl.REFUND_URL, json.toString(), token);
        return gson.fromJson(respStr, WxRefundResult.class);

    }

    /**
     * 查询单笔退款API
     * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，建议在提交退款申请后1分钟发起查询退款状态，一般来说零钱支付的退款5分钟内到账，银行卡支付的退款1-3个工作日到账。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_10.shtml">查询单笔退款</a>
     * @param mchid
     * @param serialNo
     * @param outTradeNo 商户退款单号: 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     * @return
     */
    public static WxRefundResult queryRefund(String mchid, String serialNo, String outTradeNo) {
        assert outTradeNo != null;
        Gson gson = WxGsonBuilder.create();
        String url = String.format("https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/%s", outTradeNo);
        String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, "");
        String respStr = get(url, token);
        return gson.fromJson(respStr, WxRefundResult.class);
    }

    /**
     * 微信支付订单号查询
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_2.shtml">查询订单</a>
     * @param mchid
     * @param serialNo
     * @param transactionId
     * @return
     */
    public static WxPayTransaction queryWithTransactionId(String mchid, String serialNo, String transactionId) {
        assert mchid != null && transactionId != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/pay/transactions/id/%s?mchid=%s", transactionId, mchid);
        String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, EMPTY_STR);
        String respStr = get(url, token);
        return WxGsonBuilder.create().fromJson(respStr, WxPayTransaction.class);
    }

    /**
     * 商户订单号查询
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_2.shtml">查询订单</a>
     * @param mchid
     * @param serialNo
     * @param outTradeNo
     * @return
     */
    public static WxPayTransaction queryWithOutTradeNo(String mchid, String serialNo, String outTradeNo) {
        assert mchid != null && outTradeNo != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/%s?mchid=%s", outTradeNo, mchid);
        String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, EMPTY_STR);
        String respStr = get(url, token);
        return WxGsonBuilder.create().fromJson(respStr, WxPayTransaction.class);
    }

    /**
     *
     * 以下情况需要调用关单接口：
     * 1、商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；
     * 2、系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_3.shtml">关闭订单</a>
     * @param mchid
     * @param serialNo
     * @param outTradeNo
     */
    public static void closeTransaction(String mchid, String serialNo, String outTradeNo) {
        assert mchid != null && outTradeNo != null;
        try {
            String body = String.format("{\"mchid\": \"%s\"}", mchid);
            String url = String.format("https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/%s/close", outTradeNo);
            String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.POST, url, body);
            Response response = postWithResponse(url, body, token);
            handleResponse(response.code(), response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 申请交易账单API
     * 微信支付按天提供交易账单文件，商户可以通过该接口获取账单文件的下载地址。文件内包含交易相关的金额、时间、营销等信息，供商户核对订单、退款、银行到账等情况。
     *
     * 注意：
     * • 微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致；
     * • 对账单中涉及金额的字段单位为“元”；
     * • 对账单接口只能下载三个月以内的账单。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_6.shtml">申请交易账单API</a>
     * @param mchid
     * @param serialNo
     * @param billDate 账单日期：格式YYYY-MM-DD
     *                 仅支持三个月内的账单下载申请。
     *                 示例值：2019-06-11
     * @param billType 账单类型： 不填则默认是ALL
     *                  枚举值：
     *                  ALL：返回当日所有订单信息（不含充值退款订单）
     *                  SUCCESS：返回当日成功支付的订单（不含充值退款订单）
     *                  REFUND：返回当日退款订单（不含充值退款订单）
     *                  示例值：ALL
     * @param tarType  不填则默认是数据流
     *                  枚举值：
     *                  GZIP：返回格式为.gzip的压缩包账单
     *                  示例值：GZIP
     */
    public static WxPayBillDownloadResult tradeBill(String mchid, String serialNo, String billDate, String billType, String tarType) {
        assert billDate != null;

        try {
            String url = String.format("https://api.mch.weixin.qq.com/v3/bill/tradebill?bill_date=%s", billDate);
            if (billType != null) {
                url += "&bill_type=" + billType;
            }
            if (tarType != null) {
                url += "&tar_type=" + tarType;
            }
            String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, EMPTY_STR);
            Response response = getWithReponse(url, token);
            String respStr = handleResponse(response.code(), response.body().string());
            return GSON.fromJson(respStr, WxPayBillDownloadResult.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * 申请交易账单API
     * 微信支付按天提供交易账单文件，商户可以通过该接口获取账单文件的下载地址。文件内包含交易相关的金额、时间、营销等信息，供商户核对订单、退款、银行到账等情况。
     *
     * 注意：
     * • 微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致；
     * • 对账单中涉及金额的字段单位为“元”；
     * • 对账单接口只能下载三个月以内的账单。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_6.shtml">申请交易账单API</a>
     * @param mchid
     * @param serialNo
     * @param billDate 账单日期：格式YYYY-MM-DD
     *                 仅支持三个月内的账单下载申请。
     *                 示例值：2019-06-11
     * @param billType 账单类型： 不填则默认是ALL
     *                  枚举值：
     *                  ALL：返回当日所有订单信息（不含充值退款订单）
     *                  SUCCESS：返回当日成功支付的订单（不含充值退款订单）
     *                  REFUND：返回当日退款订单（不含充值退款订单）
     *                  示例值：ALL
     * @param tarType  不填则默认是数据流
     *                  枚举值：
     *                  GZIP：返回格式为.gzip的压缩包账单
     *                  示例值：GZIP
     */
    public static InputStream downloadTradeBill(String mchid, String serialNo, String billDate, String billType, String tarType) {
        WxPayBillDownloadResult wxPayBillDownloadResult = tradeBill(mchid, serialNo, billDate, billType, tarType);

        String url = wxPayBillDownloadResult.getDownloadUrl();
        String token = WxPayV3Api.getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, WxPayV3Api.EMPTY_STR);
        Response response = WxPayV3Api.getWithReponse(url, token);
        InputStream inputStream = response.body().byteStream();
        return inputStream;
    }


    /**
     *
     * @param mchid
     * @param serialNo
     * @param mchid
     * @param serialNo
     * @param billDate 账单日期：格式YYYY-MM-DD
     *                 仅支持三个月内的账单下载申请。
     *                 示例值：2019-06-11
     * @param accountType 不填则默认是BASIC
     *                      枚举值：
     *                      BASIC：基本账户
     *                      OPERATION：运营账户
     *                      FEES：手续费账户
     *                      示例值：BASIC
     * @param tarType  不填则默认是数据流
     *                  枚举值：
     *                  GZIP：返回格式为.gzip的压缩包账单
     *                  示例值：GZIP
     * @return
     */
    public static WxPayBillDownloadResult fundFlowBill(String mchid, String serialNo, String billDate, String accountType, String tarType) {
        assert billDate != null;

        try {
            String url = String.format("https://api.mch.weixin.qq.com/v3/bill/fundflowbill?bill_date=%s", billDate);
            if (accountType != null) {
                url += "&account_type=" + accountType;
            }
            if (tarType != null) {
                url += "&tar_type=" + tarType;
            }
            String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, EMPTY_STR);
            Response response = getWithReponse(url, token);
            String respStr = handleResponse(response.code(), response.body().string());
            return GSON.fromJson(respStr, WxPayBillDownloadResult.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     *
     * @param mchid
     * @param serialNo
     * @param mchid
     * @param serialNo
     * @param billDate 账单日期：格式YYYY-MM-DD
     *                 仅支持三个月内的账单下载申请。
     *                 示例值：2019-06-11
     * @param accountType 不填则默认是BASIC
     *                      枚举值：
     *                      BASIC：基本账户
     *                      OPERATION：运营账户
     *                      FEES：手续费账户
     *                      示例值：BASIC
     * @param tarType  不填则默认是数据流
     *                  枚举值：
     *                  GZIP：返回格式为.gzip的压缩包账单
     *                  示例值：GZIP
     * @return
     */
    public static InputStream downloadFundFlowBill(String mchid, String serialNo, String billDate, String accountType, String tarType) {
        WxPayBillDownloadResult wxPayBillDownloadResult = fundFlowBill(mchid, serialNo, billDate, accountType, tarType);

        String url = wxPayBillDownloadResult.getDownloadUrl();
        String token = WxPayV3Api.getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, WxPayV3Api.EMPTY_STR);
        Response response = WxPayV3Api.getWithReponse(url, token);
        InputStream inputStream = response.body().byteStream();
        return inputStream;
    }

}
