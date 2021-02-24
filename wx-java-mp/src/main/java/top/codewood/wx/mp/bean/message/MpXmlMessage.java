package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * <xml>
 *  <ToUserName><![CDATA[粉丝号]]></ToUserName>
 *  <FromUserName><![CDATA[公众号]]></FromUserName>
 *  <CreateTime>1460541339</CreateTime>
 *  <MsgType><![CDATA[text]]></MsgType>
 *  <Content><![CDATA[test]]></Content>
 * </xml>
 */
@XStreamAlias("xml")
public class MpXmlMessage implements Serializable {

    @XStreamAlias("ToUserName")
    private String toUser;

    @XStreamAlias("FromUserName")
    private String fromUser;

    @XStreamAlias("CreateTime")
    private Long createTime;

    @XStreamAlias("MsgType")
    private String msgType;

    @XStreamAlias("Content")
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MpXmlMessage{" +
                "toUser='" + toUser + '\'' +
                ", fromUser='" + fromUser + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
