package top.codewood.wx.mp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.Response;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.codewood.wx.pay.v3.api.WxPayApi;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.result.WxPayBillDownloadResult;
import top.codewood.wx.pay.v3.cert.CertificateItem;
import top.codewood.wx.pay.v3.common.WxPayConstants;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


public class WxPayTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(WxPayTest.class);

    String mchid = "";
    String serialNo = "";
    String apiV3Key = "";
    String appid = "";
    String openid = "";

    String certPath = "";

    //@Before
    public void before() {

        WxPayApi.loadPrivateKey(mchid, this.getClass().getResourceAsStream(certPath));
        LOGGER.info("已加载私钥");

        //String body = "{\"data\":[{\"effective_time\":\"2021-03-04T10:05:21+08:00\",\"encrypt_certificate\":{\"algorithm\":\"AEAD_AES_256_GCM\",\"associated_data\":\"certificate\",\"ciphertext\":\"09ffgbBCLdjxWM0dZWfVYdwUqgeUxwD0ijlCdgJ8qPFKlHk+IXQvRL8d7HxpFDKNjrLAcT1u7gfAjQU5z3CfbHngtOwRRnlZf5p/wdh6LcLbX7kq0ms8ZUUc01CHgsD15NN6ZGbBkxjlXSJZNP89T0DKNOUPEF6ziqczcS9Sm/BS/9RjT6/VcsiJyWw8B1jn9zSaBMKEsPHJVj4aLYOstg2rTa4sBka+xj71f4krV62t+bph4oo+XR7O9pES1/LDWb/6d6vJA3pFiDwEHYDzpXZ6gFTzqt4JNFALvax0EHJvOfrTbhhizf0cIhAFgA09ApqnkXMSc7GN4XHtYo9X9v5/k03xk1YhyAa6u3KZCFbxdwOgn0beHLhgWu8hKh9vCqSU+ZHSrZ2CkaSUOJJTc3dFCNSYtqEQHFx6sYygYaZAV09zaJFMmXoiFuyXMiK9XUWht8h9nquIagg78f0gLhTHy+HcJ/5MZX6G4dlcHogsKSbs5I/hU+1I+6ZJCQn53ivEnvnb8tDU3o5pTA2A8anPHNjQMYLwIUmpD99iVUu8tDfY3z6w3FgOTa93LMUngp1JD2ily1+LWMnkqxN/3adJGOAB1DpkCRaiRTbGJ/yJb4aX1Q6FZaomALBiq5NXAb7i3zUB7t6iJh0WHjL/ShIAVfi3cy4Yn7Sov5k5vy2b7/+kw7NV8IY9i/gPqer98i0QkiaQuxy0j/Togo+3eRP3rt3nJpzXhLAkXtLOOWaISn6Dm8aXQB6zEGjamLq30WKiIOycjZi0pvq48mcWIM8faYtVw+eR7N8JW4LMymXIm6jci++ig/40SRjI37sVTN92vVIO17ZJlugbDjvZoz9KkXChfKcR8AR4EuZwGeu7oHyV/24InUSeP0oII9WEzr8o7Ii4eJiKfKjb/91EmHbvtNI45klIb7ucoW2tOKvTsnMS6Ejxk4+Uk7D2yk4vP2PwLcsuniaLiU+RFRcf+SE9XeLrEWT2e+92L5IZV4dBZc3YdBQeOsNRMtIxTL/7C65GXvqJzK6Z/lHA/9B5CGoJ15ivZN/k4PVwNfiLTUK5WoBayFZch/gqnponuuwbk9TNuM+u/e4zQAljTpCExibXRlwmiz/OPQIj2K8FM50joNi4OExMe38oXR0EVekkbZq68+c3d1UEU3NEIjAnMZSPiCbX1CirIp/Fo9j7zYPmM10AHr0Qvd3FQyNTV2kiMPOgHrNmizf6l5bG6MeJAJ4SQcnYmcy3cM3UeEqxCdyLsv9nf9BmK8EAF1LvXE99exC1/AVgFRi6LXJ3Ha8jtXEj8UXAxgvV6AygMKPa0F9IyVW/BUgNQBMXZbO3lffr/nshxjZ3cAppU61wBE0lcVbZ1DuhHOzRI1ybF4IMplrFTikKLo5c3k1qxRB8/y1kyHOzXfvrgzq1y4m85LI7w571RwohrP9iWW1vDWe20RAnvKRAbGT1OyUl1qAGPVXj7yCLdlS9US2qU8LoY02b6Mc0PuTTrQbvp5NC8KxXeEw5NltAVvMDGLqnmMbzGvmlN946LjmFUjkWYTRaIxxpOe0RiZ88u6pMbkDAb8o077IfygHDUnL+gT+9uPlXdDhXVZBHlpz8XJJSPZeuQvPJU95jAMYuPOaA4dURW4bcQPks8Ids7hpFrJ4EuV9yClZcPGMagbVKlj7UuD9KJzEduHoDRLocP5v90rx8El2q3+/uQDgJTj1GExfXJDEkCHmrNJoyoza1ax61Q6rPnSq0OXAuGjnnkeNdJObURl64aG9q+gAUmsV1uKegMPOlimqz/kMJxbLsRHerMi5747nnJblxQcZFAQLYTKa00UtaUx4bH5bAWd3QAH2JVBrnxZfxf6zmgAI3KTaNrYNHQSRrUnN13TepUQ==\",\"nonce\":\"0a05efd074c9\"},\"expire_time\":\"2026-03-03T10:05:21+08:00\",\"serial_no\":\"34D84EB24DE81570E2F3B3E3224DAB280796E8BD\"}]}";
        //CertificateList certificateList = WxGsonBuilder.create().fromJson(body, CertificateList.class);
        List<CertificateItem> certificates = WxPayApi.certificates(mchid, serialNo);
        WxPayApi.loadCertificates(apiV3Key, certificates);
        LOGGER.info("已加载证书");
    }

    //@Test
    public void generateOrderNumberTest() {
        StringBuilder sb = new StringBuilder();
        sb.append(DateTimeFormatter.ofPattern("yyyyMMddHHMM").format(LocalDateTime.now()));
        for (int i = 0; i < 5; i++) {
            sb.append(Double.valueOf(Math.random() * 10).intValue());
        }
        sb.append("000001");
        System.out.println(sb.toString());
    }


    //@Test
    public void payRequestTest() throws MalformedURLException, SignatureException, NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String expireTimeStr = sdf.format(Date.from(LocalDateTime.now().plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant()));
        Double total = 16.68 * 100;

        WxPayRequest payRequest = new WxPayRequest();
        payRequest.setAppid(appid);
        payRequest.setMchid(mchid);
        payRequest.setDescription("代码坞-素材小店-大好河生");
        payRequest.setOutTradeNo("20210304114915398000001");
        payRequest.setExpireTime(expireTimeStr);
        payRequest.setNotifyUrl("http://notify_url/wx/pay/notify");
        payRequest.setAmount(total.intValue());
        payRequest.setPayer(openid);

        Gson gson = new Gson();
        JsonObject json = gson.toJsonTree(payRequest).getAsJsonObject();

        String token = WxPayApi.getToken(mchid, serialNo, WxPayConstants.HttpMethod.POST, WxPayConstants.PayUrl.WX_PAY_JSAPI_URL, json.toString());
        String respStr = WxPayApi.post(WxPayConstants.PayUrl.WX_PAY_JSAPI_URL, json.toString(), token);
        System.out.println(respStr);
    }

    //@Test
    public void verifySignature() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String requestId = "";
        String wechatPayNonce = "";
        String wechatPaySignature = "";
        String wechatTimeStamp = "";
        String wechatSerial = "";
        String body = "";

        String message = wechatTimeStamp + "\n" + wechatPayNonce + "\n" + body + "\n";
        boolean vertify = WxPayApi.verify(wechatSerial, wechatTimeStamp, wechatPayNonce, body, wechatPaySignature);

        System.out.println("vertify: " + vertify);
    }


    //@Test
    public void wxPayFundFlowBillTest() throws IOException {
        WxPayBillDownloadResult wxPayBillDownloadResult = WxPayApi.fundFlowBill(mchid, serialNo, "2021-03-07", null, null);
        String url = wxPayBillDownloadResult.getDownloadUrl();
        String token = WxPayApi.getToken(mchid, serialNo, WxPayConstants.HttpMethod.GET, url, WxPayApi.EMPTY_STR);
        Response response = WxPayApi.getWithReponse(url, token);
        InputStream inputStream = response.body().byteStream();
        FileOutputStream fileOutputStream = new FileOutputStream("your file path");
        IOUtils.copy(inputStream, fileOutputStream);
        inputStream.close();
        fileOutputStream.close();
    }

}
