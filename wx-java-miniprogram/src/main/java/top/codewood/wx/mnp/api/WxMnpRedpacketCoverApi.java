package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpRedpacketCoverApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpRedpacketCoverApi INSTANCE = new WxMnpRedpacketCoverApi();
    }

    public static WxMnpRedpacketCoverApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * redpacketcover.getAuthenticationUrl
     * 本接口用于获得指定用户可以领取的红包封面链接。获取参数ctoken参考微信红包封面开放平台。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/redpacketcover/redpacketcover.getAuthenticationUrl.html">参考文档</a>
     *
     * @param accessToken
     * @param openid 可领取用户的openid
     * @param ctoken 在红包封面平台获取发放ctoken（需要指定可以发放的appid）
     * @return 指定用户可以领取的链接（带鉴权的链接）
     */
    public String getAuthenticationUrl(String accessToken, String openid, String ctoken) {
        assert accessToken != null && openid != null && ctoken != null;
        String url = String.format("https://api.weixin.qq.com/redpacketcover/wxapp/cover_url/get_by_token?access_token=%s", accessToken);

        String postStr = String.format("{\"openid\":\"%s\", \"ctoken\":\"%s\"}", openid, ctoken);
        String respStr = post(url, postStr);
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return respJson.getAsJsonObject("data").get("url").getAsString();
    }

}
