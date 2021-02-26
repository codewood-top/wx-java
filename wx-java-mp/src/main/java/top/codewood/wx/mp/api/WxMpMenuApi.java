package top.codewood.wx.mp.api;

import top.codewood.wx.mp.bean.menu.WxMenu;

public class WxMpMenuApi extends WxMpApi {

    /**
     * 微信公众号菜单更新
     * @param accessToken
     * @param wxMenu
     * @return
     */
    public static String create(String accessToken, WxMenu wxMenu) {
        assert accessToken != null && wxMenu != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", accessToken);
        return post(url, wxMenu.toJson());
    }

    /**
     * 微信公众号菜单查询
     * @param accessToken
     * @return
     */
    public static String query(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=%s", accessToken);
        return get(url);
    }

    /**
     * 微信公众号菜单删除
     * @param accessToken
     * @return
     */
    public static String delete(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s", accessToken);
        return get(url);
    }

}
