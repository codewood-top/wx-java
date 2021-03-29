package top.codewood.wx.mnp.api;

import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.msg.WxMnpKefuMessage;
import top.codewood.wx.mnp.bean.msg.WxMnpUniformMessage;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpKefuApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpKefuApi INSTANCE = new WxMnpKefuApi();
    }

    public static WxMnpKefuApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * customerServiceMessage.send
     * 发送客服消息给用户。详细规则见 发送客服消息
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.send.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param kefuMessage
     */
    public void sendKefuMsg(String accessToken, WxMnpKefuMessage kefuMessage) {
        assert accessToken != null && kefuMessage != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s", accessToken);
        post(url, WxGsonBuilder.instance().toJson(kefuMessage));
    }

    /**
     *  客服输入状态
     *  此接口需要客服消息接口权限。
     *  1、如果不满足发送客服消息的触发条件，则无法下发输入状态。
     *  2、下发输入状态，需要客服之前30秒内跟用户有过消息交互。
     *  3、在输入状态中（持续15s），不可重复下发输入态。
     *  4、在输入状态中，如果向用户下发消息，会同时取消输入状态。
     * @param accessToken
     * @param toUser 用户openid
     * @param typing "Typing"：对用户下发“正在输入"状态 "CancelTyping"：取消对用户的”正在输入"状态
     */
    public void typing(String accessToken, String toUser, boolean typing) {
        assert accessToken != null && toUser != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token=%s", accessToken);
        String typingStr = String.format("{\"touser\": \"%s\", \"command\": \"%s\"}", toUser, typing?"Typing":"CancelTyping");
        post(url, typingStr);
    }

    /**
     * uniformMessage.send
     * 下发小程序和公众号统一的服务消息
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/uniform-message/uniformMessage.send.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param uniformMessage
     */
    public void sendUniformMsg(String accessToken, WxMnpUniformMessage uniformMessage) {
        assert accessToken != null && uniformMessage != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send?access_token=%s", accessToken);
        String postJson = WxGsonBuilder.instance().toJson(uniformMessage);
        post(url, postJson);
    }

}
