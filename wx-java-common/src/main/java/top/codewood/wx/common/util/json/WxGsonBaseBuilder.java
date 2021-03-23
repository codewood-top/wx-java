package top.codewood.wx.common.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.bean.media.WxMediaUploadResult;

public class WxGsonBaseBuilder {

    protected static final GsonBuilder BUILDER = new GsonBuilder();

    static {
        BUILDER.disableHtmlEscaping();
        BUILDER.registerTypeAdapter(WxError.class, new WxErrorGsonAdapter());
        BUILDER.registerTypeAdapter(WxMediaUploadResult.class, new WxMediaUploadResultAdapter());
    }

    public static Gson create() {
        return BUILDER.create();
    }

}