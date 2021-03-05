package top.codewood.wx.mp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import top.codewood.wx.pay.v3.api.WxPayApi;
import top.codewood.wx.pay.v3.common.WxPayConstants;
import top.codewood.wx.pay.v3.request.WxPayRequest;
import top.codewood.wx.pay.v3.cert.CertificateItem;
import top.codewood.wx.pay.v3.cert.CertificateList;
import top.codewood.wx.pay.v3.util.json.WxGsonBuilder;
import top.codewood.wx.util.Strings;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


public class WxPayTest {

    /**
     *
     */
    @Test
    public void payRequestTest() throws MalformedURLException, SignatureException, NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException {

        String mchid = "";
        String serialNo = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String expireTimeStr = sdf.format(Date.from(LocalDateTime.now().plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant()));
        Double total = 16.68 * 100;
        String openid = "";

        WxPayRequest payRequest = new WxPayRequest();
        payRequest.setAppid("wxede42e7913751e17");
        payRequest.setMchid(mchid);
        payRequest.setDescription("代码坞-素材小店-大好河生");
        payRequest.setOutTradeNo("20210304114915398000001");
        payRequest.setExpireTime(expireTimeStr);
        payRequest.setNotifyUrl("http://notify_url");
        payRequest.setAmount(total.intValue());
        payRequest.setPayer(openid);

        Gson gson = new Gson();
        JsonObject json = gson.toJsonTree(payRequest).getAsJsonObject();

        String authorizationHeader = getAuthorizationHeader("POST", WxPayConstants.PayUrl.WX_PAY_JSAPI_URL, mchid, serialNo, json.toString());
        String respStr = WxPayApi.post(WxPayConstants.PayUrl.WX_PAY_JSAPI_URL, json.toString(), authorizationHeader);
        System.out.println(respStr);
    }

    private static String getAuthorizationHeader(String method, String url, String mchid, String serialNo, String body) throws MalformedURLException, NoSuchAlgorithmException, FileNotFoundException, InvalidKeyException, SignatureException {

        long timeStamp = System.currentTimeMillis() / 1000;
        String nonceStr = Strings.randomString(16);
        String signature = WxPayApi.buildMessage(method, url, timeStamp, nonceStr, body);
        //System.out.println("signature: \n" + signature);

        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(loadPrivateKey(new FileInputStream("")));
        sign.update(signature.getBytes(StandardCharsets.UTF_8));
        String signStr = Base64.getEncoder().encodeToString(sign.sign());
        String authorization = String.format("WECHATPAY2-SHA256-RSA2048 mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%s\",signature=\"%s\",serial_no=\"%s\"",
                mchid, nonceStr, signStr, timeStamp, serialNo);
        System.out.println("authorization: " + authorization) ;
        return authorization;
    }

    @Test
    public void authorizationTest() throws MalformedURLException, NoSuchAlgorithmException, SignatureException, FileNotFoundException, InvalidKeyException {
        String mchid = "";
        String nonceStr = Strings.randomString(32);
        long timeStamp = System.currentTimeMillis() / 1000;
        String serialNo = "";
        String body = "";
        String signature = WxPayApi.buildMessage("GET", WxPayConstants.PayUrl.WX_PAY_JSAPI_URL, timeStamp, nonceStr, body);
        System.out.println("signature: \n" + signature);

        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(loadPrivateKey(new FileInputStream("")));
        sign.update(signature.getBytes(StandardCharsets.UTF_8));
        String str = Base64.getEncoder().encodeToString(sign.sign());
        System.out.println(str);
    }

    @Test
    public void str32Test() {
        System.out.println(Strings.randomString(32));

    }

    public static PrivateKey loadPrivateKey(InputStream inputStream) {
        try {
            ByteArrayOutputStream array = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                array.write(buffer, 0, length);
            }

            String privateKey = array.toString("utf-8")
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s+", "");

            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("当前Java环境不支持RSA", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("无效的密钥格式");
        } catch (IOException e) {
            throw new RuntimeException("无效的密钥");
        }
    }

    public static X509Certificate loadCertificate(InputStream inputStream) {
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inputStream);
            cert.checkValidity();
            return cert;
        } catch (CertificateExpiredException e) {
            throw new RuntimeException("证书已过期", e);
        } catch (CertificateNotYetValidException e) {
            throw new RuntimeException("证书尚未生效", e);
        } catch (CertificateException e) {
            throw new RuntimeException("无效的证书", e);
        }
    }

    @Test
    public void certificatesTest() throws MalformedURLException, SignatureException, NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException {
        String mchid = "";
        String serialNo = "";
        WxPayApi.loadPrivateKey(new FileInputStream(""));
        List<CertificateItem> certificates = WxPayApi.certificates(mchid, serialNo);
        System.out.println(certificates);

    }

    @Test
    public void verifySignature() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String requestId = "";
        String wechatPayNonce = "";
        String wechatPaySignature = "";
        String wechatTimeStamp = "";
        String wechatSerial = "";
        String body = "";

        CertificateList certificateList = WxGsonBuilder.create().fromJson(body, CertificateList.class);

        WxPayApi.loadCertificates("", certificateList.getCerts());

        String message = wechatTimeStamp + "\n" + wechatPayNonce + "\n" + body + "\n";

        boolean vertify = WxPayApi.vertify(wechatSerial, wechatTimeStamp, wechatPayNonce, body, wechatPaySignature);

        System.out.println("vertify: " + vertify);

    }

}
