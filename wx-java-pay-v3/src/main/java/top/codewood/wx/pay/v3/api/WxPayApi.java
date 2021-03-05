package top.codewood.wx.pay.v3.api;

import com.google.gson.Gson;
import okhttp3.Response;
import top.codewood.util.http.AppHttpClient;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.bean.error.WxErrorException;
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

public class WxPayApi {

    private static PrivateKey PRIVATE_KEY = null;

    private static final Map<String, Certificate> CERTIFICATE_MAP = new HashMap<>();

    public static String post(String url, String postData) {
        try {
            String respStr = AppHttpClient.getInstance().post(url, postData);
            return handleResponse(respStr);
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
            String respStr = AppHttpClient.getInstance().get(url, headers);
            return handleResponse(respStr);
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
            String respStr = AppHttpClient.getInstance().post(url, postData, headers);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getToken(String mchid, String serialNo, String method, String reqUrl, String body) throws MalformedURLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        long timeStamp = System.currentTimeMillis() / 1000;
        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        String message = buildMessage(method, reqUrl, timeStamp, nonceStr, body);
        String signature = sign(message.getBytes(StandardCharsets.UTF_8));

        return String.format("WECHATPAY2-SHA256-RSA2048 mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%s\",signature=\"%s\",serial_no=\"%s\"",
                mchid, nonceStr, timeStamp, signature, serialNo);
    }

    public static String buildMessage(String method, String reqUrl, long timeStamp, String nonceStr, String body) throws MalformedURLException {
        URL url = new URL(reqUrl);
        String signUrl = url.getPath();
        if ("get".equals(method.toLowerCase()) && url.getQuery() != null) {
            signUrl += "?" + url.getQuery();
        }
        return method + "\n" + signUrl + "\n" + timeStamp + "\n" + nonceStr + "\n" + body + "\n";
    }

    public static String sign(byte[] message) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (PRIVATE_KEY == null) throw new RuntimeException("私钥未初始化");
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(PRIVATE_KEY);
        sign.update(message);
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    /**
     *
     * @param mchid 发起请求的商户（包括直连商户、服务商或渠道商）的商户号 mchid
     * @param serialNo <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wechatpay/wechatpay3_1.shtml"></a>商户API证书</a>serial_no，用于声明所使用的证书
     * @return
     */
    public static List<CertificateItem> certificates(String mchid, String serialNo) {

        try {
            String url = "https://api.mch.weixin.qq.com/v3/certificates";
            String token = getToken(mchid, serialNo, "GET", url, "");
            Response response = getWithReponse(url, token);

            handleResponse(response);

            Gson gson = WxGsonBuilder.create();
            CertificateList certificateList = gson.fromJson(response.body().string(), CertificateList.class);
            return certificateList.getCerts();
        } catch (Exception e) {
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
    public static void loadPrivateKey(InputStream inputStream) {
        PRIVATE_KEY = PemUtil.loadPrivateKey(inputStream);
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
        String wechatTimeStamp = response.header("Wechatpay-Timestamp");
        String wechatSerial = response.header("Wechatpay-Serial");

        InputStream inputStream = response.body().byteStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String body = new String(bytes);

        System.out.println(String.format("requestId: %s\nwechatPayNonce: %s\n wechatPaySignature: %s\n wechatTimeStamp: %s\nwechatSerial: %s\nbody: %s\n",
                requestId, wechatPayNonce, wechatPaySignature, wechatTimeStamp, wechatSerial, body));

        return response;

    }

    public static boolean vertify(String serialNo, String wechatTimeStamp, String wechatPayNonce, String body, String wechatSignature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (!CERTIFICATE_MAP.containsKey(serialNo)) {
            throw new RuntimeException(String.format("serialNo: %s 证书未配置!", serialNo));
        }
        String message = wechatTimeStamp + "\n" + wechatPayNonce + "\n" + body + "\n";
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(CERTIFICATE_MAP.get(serialNo));
        signature.update(message.getBytes(StandardCharsets.UTF_8));

        return signature.verify(Base64.getDecoder().decode(wechatSignature));
    }

    private static String handleResponse(String resp) {
        WxError wxError = WxGsonBuilder.create().fromJson(resp, WxError.class);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
        return resp;
    }

}
