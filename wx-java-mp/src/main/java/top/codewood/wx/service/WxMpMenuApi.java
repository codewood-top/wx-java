package top.codewood.wx.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.mp.util.json.WxGsonBuilder;

public class WxMpMenuApi extends WxMpApi {

    private static class Holder {
        private static final WxMpMenuApi INSTANCE = new WxMpMenuApi();
    }

    public static WxMpMenuApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 微信公众号菜单更新
     * @param accessToken
     * @param wxMenu
     * @return
     */
    public String create(String accessToken, WxMenu wxMenu) {
        assert accessToken != null && wxMenu != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", accessToken);
        return post(url, wxMenu.toJson());
    }

    /**
     * 微信公众号菜单查询
     * @param accessToken
     * @return
     */
    public WxMenu query(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=%s", accessToken);
        String respStr = get(url);

        WxMenu wxMenu = null;
        Gson gson = WxGsonBuilder.create();
        JsonObject json = gson.fromJson(respStr, JsonObject.class);
        if (json.get("is_menu_open").getAsInt() == 0) {
            // 微信公众号菜单未启用
        } else {
            wxMenu = WxGsonBuilder.create().fromJson(json.get("selfmenu_info"), WxMenu.class);
        }
        return wxMenu;
    }

    /**
     * 微信公众号菜单删除
     * @param accessToken
     * @return
     */
    public String delete(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s", accessToken);
        return get(url);
    }

}
