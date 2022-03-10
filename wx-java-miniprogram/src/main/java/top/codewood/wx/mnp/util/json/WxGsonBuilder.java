package top.codewood.wx.mnp.util.json;

import com.google.gson.Gson;
import top.codewood.wx.common.util.json.WxGsonBaseBuilder;
import top.codewood.wx.mnp.bean.analysis.WxMnpRetainInfo;
import top.codewood.wx.mnp.bean.hardwaredevice.WxMnpHardwareDeviceSendRequest;
import top.codewood.wx.mnp.bean.msg.WxMnpUniformMessage;
import top.codewood.wx.mnp.bean.subscribemsg.WxMnpSubscribeMsg;

public class WxGsonBuilder extends WxGsonBaseBuilder {

    private static final Gson INSTANCE;

    static {
        BUILDER.registerTypeAdapter(WxMnpRetainInfo.class, new WxMnpRetainInfoGsonAdapter());
        BUILDER.registerTypeAdapter(WxMnpUniformMessage.class, new WxMnpUniformMessageGsonAdapter());
        BUILDER.registerTypeAdapter(WxMnpSubscribeMsg.class, new WxMnpSubscribeMsgGsonAdapter());
        BUILDER.registerTypeAdapter(WxMnpHardwareDeviceSendRequest.class, new WxMnpHardwareDeviceSendRequestGsonAdapter());
        INSTANCE = BUILDER.create();
    }

    public static Gson instance() {
        return INSTANCE;
    }

}