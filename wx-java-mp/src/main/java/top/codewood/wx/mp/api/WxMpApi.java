package top.codewood.wx.mp.api;

import top.codewood.util.http.WxHttpClient;
import top.codewood.wx.common.bean.WxAccessToken;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.mp.bean.WxMpJsapiTicket;
import top.codewood.wx.mp.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WxMpApi {

    protected static String get(String url) {
        try {
            String respStr = WxHttpClient.getInstance().get(url);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String post(String url, String postData) {
        try {
            String respStr = WxHttpClient.getInstance().post(url, postData);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String upload(String url, File file) {
        try {
            String respStr = WxHttpClient.getInstance().upload(url, file);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static InputStream getInputStream(String url) {
        try {
            return WxHttpClient.getInstance().getInputStream(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String handleResponse(String resp) {
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
    public static WxAccessToken getAccessToken(String appid, String appsecret) {
        assert appid != null && appsecret != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appid, appsecret);
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxAccessToken.class);
    }

    /**
     * jsapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取。由于获取jsapi_ticket的api调用次数非常有限，频繁刷新jsapi_ticket会导致api调用受限，影响自身业务，开发者必须在自己的服务全局缓存jsapi_ticket
     * @param accessToken
     * @return
     */
    public static WxMpJsapiTicket getJsapiTicket(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi", accessToken);
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxMpJsapiTicket.class);
    }

}
