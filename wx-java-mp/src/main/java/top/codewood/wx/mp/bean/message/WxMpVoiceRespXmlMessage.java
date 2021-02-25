package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.util.xml.XStreamMediaIdConverter;

@XStreamAlias("xml")
public class WxMpVoiceRespXmlMessage extends WxMpRespXmlMessage {

    {
        this.msgType = WxConstants.XmlMsgType.VOICE;
    }

    @XStreamAlias("Voice")
    @XStreamConverter(XStreamMediaIdConverter.class)
    protected String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
