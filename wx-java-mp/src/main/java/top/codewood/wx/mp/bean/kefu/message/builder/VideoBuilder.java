package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

public class VideoBuilder extends BaseBuilder<VideoBuilder> {

    private String mediaId;
    private String thumbMediaId;
    private String title;
    private String description;

    public VideoBuilder() {
        this.msgType = WxConstants.KefuMsgType.VIDEO;
    }

    public VideoBuilder mediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public VideoBuilder thumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
        return this;
    }

    public VideoBuilder title(String title) {
        this.title = title;
        return this;
    }

    public VideoBuilder description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = super.build();
        kfMessage.setMediaId(this.mediaId);
        kfMessage.setThumbMediaId(this.thumbMediaId);
        kfMessage.setTitle(this.title);
        kfMessage.setDescription(this.description);
        return kfMessage;
    }
}
