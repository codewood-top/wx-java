package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

public class WxCardBuilder extends BaseBuilder<WxCardBuilder> {

    private String cardId;

    public WxCardBuilder() {
        this.msgType = WxConstants.KefuMsgType.WXCARD;
    }

    public WxCardBuilder cardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    @Override
    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = super.build();
        kfMessage.setCardId(this.cardId);
        return kfMessage;
    }
}
