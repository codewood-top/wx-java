package top.codewood.wx.mp.api;

import top.codewood.util.http.AppHttpClient;
import top.codewood.wx.mp.bean.menu.WxMenu;

import java.io.IOException;

public class WxMpApi {

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
        try {
            return AppHttpClient.getInstance().get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String createMenu(String accessToken, WxMenu wxMenu) {
        assert accessToken != null && wxMenu != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", accessToken);
        try {
            String menuJsonStr = wxMenu.toJson();
            return AppHttpClient.getInstance().post(url, menuJsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String queryMenu(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=%s", accessToken);
        try {
            return AppHttpClient.getInstance().get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String deleteMenu(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s", accessToken);

        try {
            return AppHttpClient.getInstance().get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
