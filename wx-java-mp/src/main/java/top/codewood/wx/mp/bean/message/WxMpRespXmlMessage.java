package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.LongConverter;

import java.io.Serializable;

@XStreamAlias("xml")
public class WxMpRespXmlMessage implements Serializable {

    {
        this.createTime = System.currentTimeMillis() / 1000;
    }

    @XStreamAlias("ToUserName")
    protected String toUser;

    @XStreamAlias("FromUserName")
    protected String fromUser;

    @XStreamAlias("CreateTime")
    @XStreamConverter(LongConverter.class)
    protected Long createTime;

    @XStreamAlias("MsgType")
    protected String msgType;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

}
