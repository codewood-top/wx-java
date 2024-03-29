package top.codewood.wx.pay.v3.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import top.codewood.wx.pay.v3.bean.error.WxPayError;
import top.codewood.wx.pay.v3.bean.error.WxPayErrorException;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.result.WxPayBillDownloadResult;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;
import top.codewood.wx.pay.v3.common.WxPayConfig;
import top.codewood.wx.pay.v3.common.WxPayConstants;
import top.codewood.wx.pay.v3.common.WxPayHttpClient;
import top.codewood.wx.pay.v3.util.json.WxGsonBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

public class WxPayV3Service {

    private WxPayConfig wxPayConfig;

    public WxPayV3Service(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
    }

    private static String errorFilterResponse(int httpStatus, String resp) {
        JsonObject json = WxGsonBuilder.instance().fromJson(resp, JsonObject.class);
        if (json.has("code") && json.has("message")) {
            WxPayError wxPayError = WxGsonBuilder.create().fromJson(resp, WxPayError.class);
            if (wxPayError.getCode() != null) {
                wxPayError.setStatus(httpStatus);
                throw new WxPayErrorException(wxPayError);
            }
        }

        return resp;
    }

    private String get(String url) {
        try {
            String token = WxPayV3Api.getToken(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), WxPayConstants.HttpMethod.GET, url, WxPayV3Api.EMPTY_STR);
            HttpResponse httpResponse = new WxPayHttpClient().getWithResponse(url, token);
            String respBody = verifyHttpResponse(httpResponse);
            return errorFilterResponse(httpResponse.getStatusLine().getStatusCode(), respBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String post(String url, String data) {
        try {
            String token = WxPayV3Api.getToken(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), WxPayConstants.HttpMethod.POST, url, data);
            HttpResponse httpResponse = new WxPayHttpClient().postWithResponse(url, data,  token);
            String respBody = verifyHttpResponse(httpResponse);
            return errorFilterResponse(httpResponse.getStatusLine().getStatusCode(), respBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String verifyHttpResponse(HttpResponse httpResponse) throws IOException {

        HttpEntity httpEntity = httpResponse.getEntity();
        String respBody = EntityUtils.toString(httpEntity, "UTF-8");

        String requestId = null, wechatPayNonce = null, wechatPaySignature = null, wechatPayTimeStamp = null, wechatPaySerial = null;

        Header requestIdHeader = httpResponse.getFirstHeader("Request-ID");
        if (requestIdHeader != null) {
            requestId = requestIdHeader.getValue();
        }
        Header wechatPayNonceHeader = httpResponse.getFirstHeader("Wechatpay-Nonce");
        if (wechatPayNonceHeader != null) {
            wechatPayNonce = wechatPayNonceHeader.getValue();
        }
        Header wechatPaySignatureHeader = httpResponse.getFirstHeader("Wechatpay-Signature");
        if (wechatPayNonceHeader != null) {
            wechatPaySignature = wechatPaySignatureHeader.getValue();
        }
        Header wechatPayTimeStampHeader = httpResponse.getFirstHeader("Wechatpay-Timestamp");
        if (wechatPayTimeStampHeader != null) {
            wechatPayTimeStamp = wechatPayTimeStampHeader.getValue();
        }
        Header wechatPaySerialHeader = httpResponse.getFirstHeader("Wechatpay-Serial");
        if (wechatPaySerialHeader != null) {
            wechatPaySerial = wechatPaySerialHeader.getValue();
        }

        try {
            boolean verify = WxPayV3Api.verify(wechatPaySerial, wechatPayTimeStamp, wechatPayNonce, respBody, wechatPaySignature);
            if (!verify) {
                throw new RuntimeException(String.format("请求数据签名校验失败, request-id: %s", requestId));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("校验算法错误！");
        } catch (InvalidKeyException e) {
            throw new RuntimeException("invalid key!");
        } catch (SignatureException e) {
            throw new RuntimeException("签名错误！");
        }

        return respBody;
    }


    /**
     * 统一下单API
     * 商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再按Native、JSAPI、APP等不同场景生成交易串调起支付
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_1.shtml">统一下单</a>
     *
     * @param payType
     * @param wxPayRequest
     * @return
     */
    public Map<String, String> unifiedOrder(String payType, WxPayRequest wxPayRequest) {
        assert wxPayConfig != null && payType != null && wxPayRequest != null;

        if (WxPayConstants.PayType.JSAPI.getType().equalsIgnoreCase(payType)) {
            JsonObject json = WxGsonBuilder.instance().toJsonTree(wxPayRequest).getAsJsonObject();
            String respStr = post(WxPayConstants.V3PayUrl.WX_PAY_JSAPI_URL, json.toString());
            return WxGsonBuilder.instance().fromJson(respStr, Map.class);
        } else {
            throw new RuntimeException("无效的支付方式：" + payType);
        }
    }

    /**
     * 申请退款API
     * 当交易发生之后一年内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付金额退还给买家，微信支付将在收到退款请求并且验证成功之后，将支付款按原路退还至买家帐号上。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_9.shtml">申请退款</a>
     * @param wxRefundRequest
     * @return
     */
    public WxRefundResult refund(WxRefundRequest wxRefundRequest) {
        assert  wxPayConfig != null && wxRefundRequest != null;
        Gson gson = WxGsonBuilder.create();
        JsonObject json = gson.toJsonTree(wxRefundRequest).getAsJsonObject();
        String respStr = post(WxPayConstants.V3PayUrl.REFUND_URL, json.toString());
        return gson.fromJson(respStr, WxRefundResult.class);
    }

    /**
     * 查询单笔退款API
     * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，建议在提交退款申请后1分钟发起查询退款状态，一般来说零钱支付的退款5分钟内到账，银行卡支付的退款1-3个工作日到账。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_10.shtml">查询单笔退款</a>
     * @param outTradeNo 商户退款单号: 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     * @return
     */
    public WxRefundResult queryRefund(String outTradeNo) {
        assert wxPayConfig != null && outTradeNo != null;
        Gson gson = WxGsonBuilder.create();
        String url = String.format("https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/%s", outTradeNo);
        String respStr = get(url);
        return gson.fromJson(respStr, WxRefundResult.class);
    }

    /**
     * 微信支付订单号查询
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_2.shtml">查询订单</a>
     * @param transactionId
     * @return
     */
    public  WxPayTransaction queryWithTransactionId(String transactionId) {
        assert wxPayConfig != null && transactionId != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/pay/transactions/id/%s?mchid=%s", transactionId, wxPayConfig.getMchid());
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxPayTransaction.class);
    }

    /**
     * 商户订单号查询
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_2.shtml">查询订单</a>
     * @param outTradeNo
     * @return
     */
    public WxPayTransaction queryWithOutTradeNo(String outTradeNo) {
        assert wxPayConfig != null && outTradeNo != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/%s?mchid=%s", outTradeNo, wxPayConfig.getMchid());
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxPayTransaction.class);
    }

    /**
     *
     * 以下情况需要调用关单接口：
     * 1、商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；
     * 2、系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_3.shtml">关闭订单</a>
     * @param outTradeNo
     */
    public void closeTransaction(String outTradeNo) {
        assert wxPayConfig != null && outTradeNo != null;
        String body = String.format("{\"mchid\": \"%s\"}", wxPayConfig.getMchid());
        String url = String.format("https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/%s/close", outTradeNo);
        post(url, body);
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
    public WxPayBillDownloadResult tradeBill(String billDate, String billType, String tarType) {
        assert wxPayConfig != null &&  billDate != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/bill/tradebill?bill_date=%s", billDate);
        if (billType != null) {
            url += "&bill_type=" + billType;
        }
        if (tarType != null) {
            url += "&tar_type=" + tarType;
        }
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxPayBillDownloadResult.class);
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
     *
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
    public InputStream downloadTradeBill(String billDate, String billType, String tarType) {
        WxPayBillDownloadResult wxPayBillDownloadResult = tradeBill(billDate, billType, tarType);
        String url = wxPayBillDownloadResult.getDownloadUrl();
        String respStr = get(url);
        return new ByteArrayInputStream(respStr.getBytes(StandardCharsets.UTF_8));
    }

    /**
     *
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
    public WxPayBillDownloadResult fundFlowBill(String billDate, String accountType, String tarType) {
        assert billDate != null;

        String url = String.format("https://api.mch.weixin.qq.com/v3/bill/fundflowbill?bill_date=%s", billDate);
        if (accountType != null) {
            url += "&account_type=" + accountType;
        }
        if (tarType != null) {
            url += "&tar_type=" + tarType;
        }
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxPayBillDownloadResult.class);

    }

    /**
     *
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
    public InputStream downloadFundFlowBill(String billDate, String accountType, String tarType) {
        WxPayBillDownloadResult wxPayBillDownloadResult = fundFlowBill(billDate, accountType, tarType);
        String url = wxPayBillDownloadResult.getDownloadUrl();
        String respStr = get(url);
        return new ByteArrayInputStream(respStr.getBytes(StandardCharsets.UTF_8));
    }

}
