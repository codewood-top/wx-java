package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

public class ImageBuilder extends BaseBuilder<ImageBuilder> {

    private String mediaId;

    public ImageBuilder() {
        this.msgType = WxConstants.KefuMsgType.IMAGE;
    }

    public ImageBuilder mediaId(String mediaId) {
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
