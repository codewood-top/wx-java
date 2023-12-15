package top.codewood.wx.pay.v3.api;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import top.codewood.wx.pay.v3.bean.error.WxPayError;
import top.codewood.wx.pay.v3.bean.error.WxPayErrorException;
import top.codewood.wx.pay.v3.bean.notify.WxPayNotify;
import top.codewood.wx.pay.v3.cert.CertificateItem;
import top.codewood.wx.pay.v3.cert.CertificateList;
import top.codewood.wx.pay.v3.common.WxPayConstants;
import top.codewood.wx.pay.v3.common.WxPayHttpClient;
import top.codewood.wx.pay.v3.util.crypt.PemUtils;
import top.codewood.wx.pay.v3.util.crypt.WxPayV3CryptUtils;
import top.codewood.wx.pay.v3.util.json.WxV3GsonBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.util.*;

/**
 *  添加相应的微信支付商户资料
 *  WxPayV3Api.setPrivateKey(mchid, cert);
 *  WxPayV3Api.loadCertificates(mchid, serialNo, v3SecretKey);
 */
public class WxPayV3Api {

    public static final String EMPTY_STR = "";

    private static Map<String, WxPayV3CryptUtils> wxPayV3CryptUtilsMap = new HashMap<>();

    private static WxPayStorageService wxPayStorageService = new WxPayStorageServiceDefaultImpl();

    public static void setWxPayStorageService(WxPayStorageService wxPayStorageService) {
        WxPayV3Api.wxPayStorageService = wxPayStorageService;
    }

    private static PrivateKey loadPrivateKey(String mchid) {
        String privateKeyStr = wxPayStorageService.getPrivateKey(mchid);
        return PemUtils.loadPrivateKey(privateKeyStr);
    }

    /**
     * 加载私钥
     * @param mchid 微信支付商户号
     * @param inputStream apiclient_key.pem文件输入流
     */
    public static PrivateKey setPrivateKey(String mchid, InputStream inputStream) {

        String privateKeyStr = PemUtils.loadPrivateKeyString(inputStream);
        return setPrivateKey(mchid, privateKeyStr);
    }

    /**
     * 加载私钥
     * @param mchid 微信支付商户号
     * @param privateKeyStr apiclient_key.pem文件内容
     */
    public static PrivateKey setPrivateKey(String mchid, String privateKeyStr) {
        PrivateKey privateKey = PemUtils.loadPrivateKey(privateKeyStr);
        wxPayStorageService.setPrivateKey(mchid, privateKeyStr);
        return privateKey;
    }

    private static Certificate getCertificate(String serialNo) {
        String publicKey = wxPayStorageService.getCertificatePublicKey(serialNo);
        return PemUtils.loadCertificate(new ByteArrayInputStream(publicKey.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 在更换证书过程中，新老证书都生效，这时可转成map,通过serialNo快速查找
     * List<CertificateItem> to Map<String, CertificateItem> -> serialNo: CertificateItem
     * @param certificates
     * @return
     */
    public static Map<String, CertificateItem> certificateListToMap(List<CertificateItem> certificates) {
        Map<String, CertificateItem> map = new HashMap<>();
        certificates.forEach(certificateItem -> map.put(certificateItem.getSerialNo(), certificateItem));
        return map;
    }

    /**
     *
     * 这个api没有做签名校验
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wechatpay/wechatpay5_1.shtml">商户API证书</a>
     *
     * @param mchid 发起请求的商户（包括直连商户、服务商或渠道商）的商户号 mchid
     * @param serialNo 用于声明所使用的证书
     *
     * @return
     */
    public static void loadCertificates(String mchid, String serialNo, String apiV3Key) {
        try {
            String url = WxPayConstants.V3PayUrl.CERTIFICATE_LIST_URL;
            String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, EMPTY_STR);
            String respStr = new WxPayHttpClient().get(url, token);
            CertificateList certificateList = WxV3GsonBuilder.getInstance().fromJson(respStr, CertificateList.class);
            WxPayV3CryptUtils wxPayV3CryptUtils = wxPayV3CryptUtilsMap.get(mchid);
            if (wxPayV3CryptUtils == null) {
                wxPayV3CryptUtils = new WxPayV3CryptUtils(apiV3Key.getBytes(StandardCharsets.UTF_8));
                wxPayV3CryptUtilsMap.put(mchid, wxPayV3CryptUtils);
            }
            List<CertificateItem> certificateItems = certificateList.getCerts();
            for (CertificateItem certificateItem : certificateItems) {
                String publicKey = wxPayV3CryptUtils.decrypt(certificateItem.getEncryptCertificateItem().getAssociatedData().getBytes(StandardCharsets.UTF_8),
                        certificateItem.getEncryptCertificateItem().getNonce().getBytes(StandardCharsets.UTF_8),
                        certificateItem.getEncryptCertificateItem().getCipherText());
                wxPayStorageService.setCertificateSerialPublicKey(certificateItem.getSerialNo(), publicKey);

            }
        } catch (IOException | GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密证书和回调报文
     *
     * <a href="https://pay.weixin.qq.com/docs/merchant/development/interface-rules/certificate-callback-decryption.html">如何解密证书和回调报文</a>
     *
     * @param mchid
     * @param encryptedData
     * @param tClass
     * @return
     * @param <T>
     */
    public static <T> T decryptNotifyData(String mchid, String encryptedData, Class<T> tClass) {
        WxPayNotify wxPayNotify = WxV3GsonBuilder.getInstance().fromJson(encryptedData, WxPayNotify.class);
        WxPayV3CryptUtils wxPayV3CryptUtils = wxPayV3CryptUtilsMap.get(mchid);
        if (wxPayV3CryptUtils == null) throw new IllegalStateException(String.format("支付商户号[%s]未调用loadCertificates", mchid));

        try {
            String decrypted = wxPayV3CryptUtils.decrypt(wxPayNotify.getResource().getAssociatedData().getBytes(StandardCharsets.UTF_8),
                    wxPayNotify.getResource().getNonce().getBytes(StandardCharsets.UTF_8),
                    wxPayNotify.getResource().getCipherText());
            return WxV3GsonBuilder.getInstance().fromJson(decrypted, tClass);
        } catch (Exception e) {
            throw new IllegalStateException(e);
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
        if ("get".equalsIgnoreCase(method) && url.getQuery() != null) {
            signUrl += "?" + url.getQuery();
        }
        return method + "\n" + signUrl + "\n" + timeStamp + "\n" + nonceStr + "\n" + body + "\n";
    }

    public static String sign(String mchid, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        PrivateKey privateKey = loadPrivateKey(mchid);
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message);
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    public static boolean verify(String serialNo, String wechatTimeStamp, String wechatPayNonce, String body, String wechatSignature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Certificate certificate = getCertificate(serialNo);
        String message = wechatTimeStamp + "\n" + wechatPayNonce + "\n" + body + "\n";
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(certificate);
        signature.update(message.getBytes(StandardCharsets.UTF_8));

        return signature.verify(Base64.getDecoder().decode(wechatSignature));
    }

    private static String verifyHttpResponse(HttpResponse httpResponse) throws IOException {

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
        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            WxPayError wxPayError = WxV3GsonBuilder.getInstance().fromJson(respBody, WxPayError.class);
            if (wxPayError.getCode() != null && wxPayError.getMessage() != null) {
                throw new RuntimeException(wxPayError.getMessage());
            }

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

    public static String get(String mchid, String serialNo, String url) {
        try {
            String token  = getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, EMPTY_STR);
            HttpResponse httpResponse = WxPayHttpClient.getInstance().getWithResponse(url, token);
            String respBody = verifyHttpResponse(httpResponse);
            return errorFilterResponse(httpResponse.getStatusLine().getStatusCode(), respBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getForResult(String mchid, String serialNo, String url, Class<T> resultClass) {
        String respStr = get(mchid, serialNo, url);
        return WxV3GsonBuilder.getInstance().fromJson(respStr, resultClass);
    }

    public static String post(String mchid, String serialNo, String url, String data) {
        try {
            String token = WxPayV3Api.getToken(mchid, serialNo, WxPayConstants.HttpMethod.POST, url, data);
            HttpResponse httpResponse = WxPayHttpClient.getInstance().postWithResponse(url, data, token);
            String respBody = verifyHttpResponse(httpResponse);
            return errorFilterResponse(httpResponse.getStatusLine().getStatusCode(), respBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static <T> T postForResult(String mchid, String serialNo, String url, String data, Class<T> resultClass) {
        String respStr = post(mchid, serialNo, url, data);
        return WxV3GsonBuilder.getInstance().fromJson(respStr, resultClass);
    }

    private static String errorFilterResponse(int httpStatus, String resp) {
        JsonObject json = WxV3GsonBuilder.getInstance().fromJson(resp, JsonObject.class);
        if (json.has("code") && json.has("message")) {
            WxPayError wxPayError = WxV3GsonBuilder.getInstance().fromJson(resp, WxPayError.class);
            if (wxPayError.getCode() != null) {
                //wxPayError.setStatus(httpStatus);
                throw new WxPayErrorException(wxPayError);
            }
        }

        return resp;
    }


}
