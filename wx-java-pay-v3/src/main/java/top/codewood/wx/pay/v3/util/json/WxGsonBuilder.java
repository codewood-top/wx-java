package top.codewood.wx.pay.v3.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.util.json.WxErrorGsonAdapter;
import top.codewood.wx.common.util.json.WxGsonBaseBuilder;

import java.time.OffsetDateTime;

public class WxGsonBuilder extends WxGsonBaseBuilder {

    private static final Gson INSTANCE;

    static {
        BUILDER.registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeTypeAdapter());
        INSTANCE = BUILDER.create();
    }

    public static Gson instance() {
        return INSTANCE;
    }

}
