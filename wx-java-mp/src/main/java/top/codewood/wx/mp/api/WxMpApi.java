package top.codewood.wx.mp.api;

import top.codewood.util.http.AppHttpClient;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.mp.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WxMpApi {

    protected static String get(String url) {
        try {
            String respStr = AppHttpClient.getInstance().get(url);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String post(String url, String postData) {
        try {
            String respStr = AppHttpClient.getInstance().post(url, postData);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String upload(String url, File file) {
        try {
            String respStr = AppHttpClient.getInstance().upload(url, file);
            return handleResponse(respStr);
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

    private static String handleResponse(String resp) {
        WxError wxError = WxGsonBuilder.create().fromJson(resp, WxError.class);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }

        return resp;
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
