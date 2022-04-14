package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpSoterApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpSoterApi INSTANCE = new WxMnpSoterApi();
    }

    public static WxMnpSoterApi getInstance() { return Holder.INSTANCE; }

    /**
     * soter.verifySignature
     * SOTER 生物认证秘钥签名验证
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.addTemplate.html">参考文档</a>
     *
     * @param accessToken
     * @param openid 用户 openid
     * @param jsonString  通过 <a href="https://developers.weixin.qq.com/miniprogram/dev/api/open-api/soter/wx.startSoterAuthentication.html">wx.startSoterAuthentication</a>  成功回调获得的 resultJSON 字段
     * @param jsonSignature 通过 <a href="https://developers.weixin.qq.com/miniprogram/dev/api/open-api/soter/wx.startSoterAuthentication.html">wx.startSoterAuthentication</a> 成功回调获得的 resultJSONSignature 字段
     * @return is_ok 验证结果
     */
    public boolean verifySignature(String accessToken, String openid, String jsonString, String jsonSignature) {
        assert accessToken != null && openid != null && jsonString != null && jsonSignature != null;

        String url = String.format("https://api.weixin.qq.com/cgi-bin/soter/verify_signature?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("openid", openid);
        json.addProperty("json_string", jsonString);
        json.addProperty("json_signature", jsonSignature);

        String respStr = post(url, json.getAsString());
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return respJson.get("is_ok").getAsBoolean();
    }

}
