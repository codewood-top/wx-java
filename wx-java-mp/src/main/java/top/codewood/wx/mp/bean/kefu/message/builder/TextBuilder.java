package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

public class TextBuilder extends BaseBuilder<TextBuilder> {

    private String content;

    public TextBuilder() {
        this.msgType = WxConstants.KefuMsgType.TEXT;
    }

    public TextBuilder content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = super.build();
        kfMessage.setContent(this.content);
        return kfMessage;
    }
}
