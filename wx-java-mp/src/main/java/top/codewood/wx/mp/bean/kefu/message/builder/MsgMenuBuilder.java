package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MsgMenuBuilder extends BaseBuilder<MsgMenuBuilder> {

    private String headContent;
    private String tailContent;
    private List<WxMpKfMessage.MsgMenu> msgMenus = new ArrayList<>();


    public MsgMenuBuilder() {
        this.msgType = WxConstants.KefuMsgType.MSGMENU;
    }

    public MsgMenuBuilder headContent(String headContent) {
        this.headContent = headContent;
        return this;
    }

    public MsgMenuBuilder tailContent(String tailContent) {
        this.tailContent = tailContent;
        return this;
    }

    public MsgMenuBuilder addMsgMenus(WxMpKfMessage.MsgMenu... msgMenus) {
        Collections.addAll(this.msgMenus, msgMenus);
        return this;
    }

    public MsgMenuBuilder msgMenus(List<WxMpKfMessage.MsgMenu> msgMenus) {
        this.msgMenus = msgMenus;
        return this;
    }

    @Override
    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = super.build();
        kfMessage.setHeadContent(this.headContent);
        kfMessage.setTailContent(this.tailContent);
        kfMessage.setMsgMenus(this.msgMenus);
        return kfMessage;
    }
}
