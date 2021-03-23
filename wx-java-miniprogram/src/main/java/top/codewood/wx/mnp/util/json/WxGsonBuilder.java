package top.codewood.wx.mnp.util.json;

import com.google.gson.Gson;
import top.codewood.wx.common.util.json.WxGsonBaseBuilder;
import top.codewood.wx.mnp.bean.analysis.WxMnpRetainInfo;

public class WxGsonBuilder extends WxGsonBaseBuilder {

    static {
        BUILDER.registerTypeAdapter(WxMnpRetainInfo.class, new WxMnpRetainInfoGsonAdapter());
    }

    public static Gson create() {
        return BUILDER.create();
    }

}