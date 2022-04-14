package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpServiceMarketApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpServiceMarketApi INSTANCE = new WxMnpServiceMarketApi();
    }

    public static WxMnpServiceMarketApi getInstance() { return Holder.INSTANCE; }

    /**
     * serviceMarket.invokeService
     * @param accessToken   服务 ID
     * @param service   接口名
     * @param api   接口名
     * @param data  服务提供方接口定义的 JSON 格式的数据
     * @param clientMsgId   随机字符串 ID，调用方请求的唯一标识
     * @return  返回的 JSON 数据包
     */
    public String invokeService(String accessToken, String service, String api, String data, String clientMsgId) {
        assert accessToken != null && service != null && api != null && data != null && clientMsgId != null;

        String url = String.format("https://api.weixin.qq.com/wxa/servicemarket?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("service", service);
        json.addProperty("api", api);
        json.addProperty("data", data);
        json.addProperty("client_msg_id", clientMsgId);

        String respStr = post(url, json.getAsString());
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return respJson.get("data").getAsString();
    }

}
