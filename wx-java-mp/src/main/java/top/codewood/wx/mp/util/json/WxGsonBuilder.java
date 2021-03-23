package top.codewood.wx.mp.util.json;

import com.google.gson.Gson;
import top.codewood.wx.common.util.json.WxGsonBaseBuilder;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.mp.bean.result.WxMpQrcodeTicket;
import top.codewood.wx.mp.bean.template.WxMpTemplateMessage;

public class WxGsonBuilder extends WxGsonBaseBuilder {

    static {
        BUILDER.registerTypeAdapter(WxMenu.class, new WxMpMenuGsonAdapter());
        BUILDER.registerTypeAdapter(WxMpQrcodeTicket.class, new WxMpQrcodeTicketAdapter());
        BUILDER.registerTypeAdapter(WxMpKfMessage.class, new WxMpKfMessageGsonAdapter());
        BUILDER.registerTypeAdapter(WxMpTemplateMessage.class, new WxMpTemplateMessageGsonAdapter());
    }

    public static Gson create() {
        return BUILDER.create();
    }

}