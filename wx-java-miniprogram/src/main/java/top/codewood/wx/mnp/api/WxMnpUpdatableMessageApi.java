package top.codewood.wx.mnp.api;

import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.updatablemsg.WxMnpSetUpdatableMsgRequest;
import top.codewood.wx.mnp.bean.updatablemsg.WxMnpUpdatableMessageResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpUpdatableMessageApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpUpdatableMessageApi INSTANCE = new WxMnpUpdatableMessageApi();
    }

    public static WxMnpUpdatableMessageApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * updatableMessage.createActivityId
     *
     * 创建被分享动态消息或私密消息的 activity_id。详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/share/updatable-message.html">动态消息</a>。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.createActivityId.html">参考文档</a>
     *
     * @param accessToken
     * @param unionId 为私密消息创建activity_id时，指定分享者为unionid用户。其余用户不能用此activity_id分享私密消息。openid与unionid填一个即可。私密消息暂不支持云函数生成activity id。
     * @param openid 为私密消息创建activity_id时，指定分享者为openid用户。其余用户不能用此activity_id分享私密消息。openid与unionid填一个即可。私密消息暂不支持云函数生成activity id。
     * @return
     */
    public WxMnpUpdatableMessageResult createActivityId(String accessToken, String unionId, String openid) {
        assert accessToken != null;
        if (unionId == null && openid == null) throw new RuntimeException("unionId & openid 不能同时为null。");
        String url = null;

        if (unionId != null) {
            url = String.format("https://api.weixin.qq.com/cgi-bin/message/wxopen/activityid/create?access_token=%s&unionid=%s", accessToken, unionId);
        } else if (openid != null) {
            url = String.format("https://api.weixin.qq.com/cgi-bin/message/wxopen/activityid/create?access_token=%s&openid=%s", accessToken, openid);
        }
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpUpdatableMessageResult.class);
    }

    /**
     * updatableMessage.setUpdatableMsg
     *
     * 修改被分享的动态消息。详见<a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.createActivityId.html">动态消息</a>。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.setUpdatableMsg.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param setUpdatableMsgRequest
     */
    public void setUpdatableMsg(String accessToken, WxMnpSetUpdatableMsgRequest setUpdatableMsgRequest) {
        assert accessToken != null && setUpdatableMsgRequest != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/wxopen/updatablemsg/send?access_token=%s", accessToken);
        post(url, WxGsonBuilder.instance().toJson(setUpdatableMsgRequest));
    }

}