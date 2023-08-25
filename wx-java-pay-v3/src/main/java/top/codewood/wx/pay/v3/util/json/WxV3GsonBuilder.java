package top.codewood.wx.pay.v3.util.json;

import com.google.gson.Gson;
import top.codewood.wx.common.util.json.WxGsonBaseBuilder;

import java.time.OffsetDateTime;

public class WxV3GsonBuilder extends WxGsonBaseBuilder {

    private static final Gson INSTANCE;

    static {
        BUILDER.registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeTypeAdapter());
        INSTANCE = BUILDER.create();
    }

    public static Gson getInstance() {
        return INSTANCE;
    }

}
