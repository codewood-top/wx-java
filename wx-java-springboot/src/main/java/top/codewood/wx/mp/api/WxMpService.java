package top.codewood.wx.mp.api;

import top.codewood.wx.mp.bean.menu.WxMenu;

public interface WxMpService {

    String getAccessToken();

    void createMenu(WxMenu wxMenu);

    WxMenu queryMenu();

}
