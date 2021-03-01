package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

public class BaseBuilder<T> {

    protected String msgType;
    protected String toUser;

    public T toUser(String toUser) {
        this.toUser = toUser;
        return (T)this;
    }

    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = new WxMpKfMessage();
        kfMessage.setMsgType(this.msgType);
        kfMessage.setToUser(this.toUser);
        return kfMessage;
    }

}
