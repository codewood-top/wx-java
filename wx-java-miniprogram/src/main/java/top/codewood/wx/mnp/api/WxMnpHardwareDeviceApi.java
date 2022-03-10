package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.hardwaredevice.WxMnpHardwareDeviceSendRequest;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpHardwareDeviceApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpHardwareDeviceApi INSTANCE = new WxMnpHardwareDeviceApi();
    }

    public static WxMnpHardwareDeviceApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * hardwareDevice.getSnTicket
     * 获取设备票据，5 分钟内有效
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/hardware-device/hardwareDevice.getSnTicket.html">参考文档</a>
     *
     * @param accessToken
     * @param sn
     * @param modelId
     * @return
     */
    public String getSnTicket(String accessToken, String sn, String modelId) {
        assert accessToken != null && sn != null && modelId != null;
        String url = String.format("https://api.weixin.qq.com/wxa/getsnticket?access_token=%s", accessToken);
        String postStr = String.format("{\"sn\":\"%s\", \"model_id\":\"%s\"}", sn, modelId);
        String respStr = post(url, postStr);
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);

        return respJson.get("sn_ticket").getAsString();
    }

    /**
     * hardwareDevice.send
     * 开发者可以通过该接口向用户发送设备消息
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/hardware-device/hardwareDevice.send.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     */
    public void send(String accessToken, WxMnpHardwareDeviceSendRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/device/subscribe/send?access_token=%s", accessToken);

        post(url, WxGsonBuilder.instance().toJson(request));
    }

}
