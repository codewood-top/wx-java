package top.codewood.wx.pay.v3.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.common.WxPayHttpClient;
import top.codewood.wx.pay.v3.bean.error.WxPayError;
import top.codewood.wx.pay.v3.bean.error.WxPayErrorException;
import top.codewood.wx.pay.v3.cert.CertificateItem;
import top.codewood.wx.pay.v3.cert.CertificateList;
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

public class WxPayV3Api {

    public static final String EMPTY_STR = "";

    private static final Map<String, PrivateKey> PRIVATE_KEY_MAP = new HashMap<>();
    private static final Map<String, Certificate> CERTIFICATE_MAP = new HashMap<>();
    private static final Gson GSON;

    static {
        GSON = WxGsonBuilder.create();
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
            String respStr = new WxPayHttpClient().v3Get(url, token);
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


}
