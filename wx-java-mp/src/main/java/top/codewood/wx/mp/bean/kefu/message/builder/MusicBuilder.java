package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

public class MusicBuilder extends BaseBuilder<MusicBuilder> {

    private String title;
    private String description;
    private String musicUrl;
    private String hqMusicUrl;
    private String thumbMediaId;

    public MusicBuilder() {
        this.msgType = WxConstants.KefuMsgType.MUSIC;
    }

    public MusicBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MusicBuilder description(String description) {
        this.description = description;
        return this;
    }

    public MusicBuilder musicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
        return this;
    }

    public MusicBuilder hqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
        return this;
    }

    public MusicBuilder thumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
        return this;
    }

    @Override
    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = super.build();
        kfMessage.setTitle(this.title);
        kfMessage.setDescription(this.description);
        kfMessage.setMusicUrl(this.musicUrl);
        kfMessage.setHqMusicUrl(this.hqMusicUrl);
        kfMessage.setThumbMediaId(this.thumbMediaId);
        return kfMessage;
    }
}
