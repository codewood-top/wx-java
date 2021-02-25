package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.common.api.WxConstants;

@XStreamAlias("xml")
public class WxMpTextRespXmlMessage extends WxMpRespXmlMessage {

    {
        this.msgType = WxConstants.XmlMsgType.TEXT;
    }

    @XStreamAlias("Content")
    protected String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
