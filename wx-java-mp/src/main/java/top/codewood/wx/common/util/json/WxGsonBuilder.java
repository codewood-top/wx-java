package top.codewood.wx.common.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import top.codewood.wx.mp.bean.menu.WxMenu;

public class WxGsonBuilder {

    private static final GsonBuilder BUILDER = new GsonBuilder();

    static {
        BUILDER.disableHtmlEscaping();
        BUILDER.registerTypeAdapter(WxMenu.class, new WxMenuGsonAdapter());
    }

    public static Gson create() {
        return BUILDER.create();
    }


}
