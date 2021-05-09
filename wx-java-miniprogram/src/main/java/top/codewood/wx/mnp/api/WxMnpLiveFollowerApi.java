package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.live.WxMnpLiveFollowerListResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxMnpLiveFollowerApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpLiveFollowerApi INSTANCE = new WxMnpLiveFollowerApi();
    }

    public static WxMnpLiveFollowerApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 获取长期订阅用户
     * 调用此接口获取长期订阅用户列表
     * 调用额度：5000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/subscribe-api.html#1">参考文档</a>
     *
     * @param accessToken
     * @param limit
     * @param pageBreak
     * @return
     */
    public WxMnpLiveFollowerListResult listFollowers(String accessToken, Integer limit, Integer pageBreak) {
        assert accessToken != null && limit != null && pageBreak != null;
        String url = String.format("https://api.weixin.qq.com/wxa/business/get_wxa_followers?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        if (limit != null) {
            json.addProperty("limit", limit);
        }
        if (pageBreak != null) {
            json.addProperty("page_break", pageBreak);
        }

        String respStr = post(url, json.toString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveFollowerListResult.class);
    }

    /**
     *  长期订阅群发接口
     *  向长期订阅用户群发直播间开始事件
     *
     *  调用额度：5000次/一天；群发订阅用户个数限制：2000/次
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/subscribe-api.html#2">参考文档</a>
     *
     * @param accessToken
     * @param roomId
     * @param openids
     * @return
     */
    public String pushMessage(String accessToken, Integer roomId, List<String> openids) {
        assert accessToken != null && roomId != null && openids != null;
        String url = String.format("https://api.weixin.qq.com/wxa/business/push_message?access_token=%s", accessToken);
        Map<String, Object> map = new HashMap<>();
        map.put("room_id", roomId);
        map.put("user_openid", openids);

        String respStr = post(url, WxGsonBuilder.instance().toJson(map));
        return WxGsonBuilder.instance().fromJson(respStr, JsonObject.class).get("message_id").getAsString();
    }

}
