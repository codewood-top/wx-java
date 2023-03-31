package top.codewood.wx.pay.v3.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import top.codewood.wx.pay.v3.bean.error.WxPayError;
import top.codewood.wx.pay.v3.bean.error.WxPayErrorException;
import top.codewood.wx.pay.v3.cert.CertificateItem;
import top.codewood.wx.pay.v3.cert.CertificateList;
import top.codewood.wx.pay.v3.common.WxPayConstants;
import top.codewood.wx.pay.v3.common.WxPayHttpClient;
import top.codewood.wx.pay.v3.util.crypt.PemUtils;
import top.codewood.wx.pay.v3.util.crypt.WxPayV3CryptUtils;
import top.codewood.wx.pay.v3.util.json.WxGsonBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.util.*;

public class WxPayV3Api {

    public static final String EMPTY_STR = "";

    private static final Map<String, PrivateKey> PRIVATE_KEY_MAP = new HashMap<>();
    private static final Map<String, Certificate> CERTIFICATE_MAP = new HashMap<>();


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
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wechatpay/wechatpay5_1.shtml">商户API证书</a>
     *
     * @param mchid 发起请求的商户（包括直连商户、服务商或渠道商）的商户号 mchid
     * @param serialNo 用于声明所使用的证书
     *
     * @return
     */
    public static List<CertificateItem> certificates(String mchid, String serialNo) {

        try {
            String url = WxPayConstants.V3PayUrl.CERTIFICATE_LIST_URL;
            String token = getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, EMPTY_STR);
            String respStr = new WxPayHttpClient().get(url, token);
            Gson gson = WxGsonBuilder.create();
            CertificateList certificateList = gson.fromJson(respStr, CertificateList.class);
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
        PrivateKey privateKey = PemUtils.loadPrivateKey(inputStream);
        PRIVATE_KEY_MAP.put(mchid, privateKey);
        return privateKey;
    }

    public static void loadCertificates(String apiV3Key, List<CertificateItem> certificateItems) {
        assert certificateItems != null;
        if (certificateItems.size() > 0) {
            WxPayV3CryptUtils wxPayV3CryptUtils = new WxPayV3CryptUtils(apiV3Key.getBytes(StandardCharsets.UTF_8));
            certificateItems.stream().forEach(certificateItem -> {
                try {
                    String publicKey = wxPayV3CryptUtils.decrypt(certificateItem.getEncryptCertificateItem().getAssociatedData().getBytes(StandardCharsets.UTF_8),
                            certificateItem.getEncryptCertificateItem().getNonce().getBytes(StandardCharsets.UTF_8),
                            certificateItem.getEncryptCertificateItem().getCipherText());
                    CERTIFICATE_MAP.put(certificateItem.getSerialNo(), PemUtils.loadCertificate(new ByteArrayInputStream(publicKey.getBytes(StandardCharsets.UTF_8))));
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

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
        return WxGsonBuilder.instance().fromJson(respStr, resultClass);
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
        return WxGsonBuilder.instance().fromJson(respStr, resultClass);
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


}
