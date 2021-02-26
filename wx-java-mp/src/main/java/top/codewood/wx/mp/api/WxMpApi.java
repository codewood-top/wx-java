package top.codewood.wx.mp.api;

import top.codewood.util.http.AppHttpClient;

import java.io.IOException;
import java.io.InputStream;

public class WxMpApi {

    protected static String get(String url) {
        try {
            return AppHttpClient.getInstance().get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String post(String url, String postData) {
        try {

            return AppHttpClient.getInstance().post(url, postData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static InputStream getStream(String url) {
        try {
            return AppHttpClient.getInstance().getStream(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param appid
     * @param appsecret
     * @return
     *  success: {"access_token":"ACCESS_TOKEN","expires_in":7200}
     *  failure: {"errcode":40013,"errmsg":"invalid appid"}
     */
    public static String getAccessToken(String appid, String appsecret) {
        assert appid != null && appsecret != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appid, appsecret);
        return get(url);
    }


}
