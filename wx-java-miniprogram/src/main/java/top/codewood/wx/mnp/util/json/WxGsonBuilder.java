package top.codewood.wx.mnp.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.util.json.WxErrorGsonAdapter;

public class WxGsonBuilder {

    private static final GsonBuilder BUILDER = new GsonBuilder();

    static {
        BUILDER.disableHtmlEscaping();
        BUILDER.registerTypeAdapter(WxError.class, new WxErrorGsonAdapter());
    }

    public static Gson create() {
        return BUILDER.create();
    }

}