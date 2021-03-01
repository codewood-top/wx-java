package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

public class VoiceBuilder extends BaseBuilder<VoiceBuilder> {

    private String mediaId;

    public VoiceBuilder() {
        this.msgType = WxConstants.KefuMsgType.VOICE;
    }

    public VoiceBuilder mediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    @Override
    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = super.build();
        kfMessage.setMediaId(this.mediaId);
        return kfMessage;
    }
}
