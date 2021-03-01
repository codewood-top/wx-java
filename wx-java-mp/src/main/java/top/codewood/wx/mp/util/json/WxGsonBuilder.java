package top.codewood.wx.mp.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.util.json.WxErrorGsonAdapter;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.mp.bean.result.WxMpQrcodeTicket;

public class WxGsonBuilder {

    private static final GsonBuilder BUILDER = new GsonBuilder();

    static {
        BUILDER.disableHtmlEscaping();
        BUILDER.registerTypeAdapter(WxError.class, new WxErrorGsonAdapter());
        BUILDER.registerTypeAdapter(WxMenu.class, new WxMenuGsonAdapter());
        BUILDER.registerTypeAdapter(WxMpQrcodeTicket.class, new WxMpQrcodeTicketAdapter());
        BUILDER.registerTypeAdapter(WxMpKfMessage.class, new WxMpKfMessageGsonAdapter());
    }

    public static Gson create() {
        return BUILDER.create();
    }


}
