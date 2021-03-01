package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

public class MpNewsBuilder extends BaseBuilder<MpNewsBuilder> {

    private String mediaId;

    public MpNewsBuilder() {
        this.msgType = WxConstants.KefuMsgType.MPNEWS;
    }

    public MpNewsBuilder mediaId(String mediaId) {
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
