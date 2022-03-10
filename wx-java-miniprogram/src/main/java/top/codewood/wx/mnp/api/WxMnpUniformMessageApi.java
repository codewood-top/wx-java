package top.codewood.wx.mnp.api;

import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.msg.WxMnpUniformMessage;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpUniformMessageApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpUniformMessageApi INSTANCE = new WxMnpUniformMessageApi();
    }

    public static WxMnpUniformMessageApi getInstance() {
        return Holder.INSTANCE;
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
