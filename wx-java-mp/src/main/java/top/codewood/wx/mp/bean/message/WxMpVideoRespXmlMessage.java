package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.common.api.WxConstants;

import java.io.Serializable;

@XStreamAlias("xml")
public class WxMpVideoRespXmlMessage extends WxMpRespXmlMessage {

    {
        this.msgType = WxConstants.XmlMsgType.VIDEO;
    }

    @XStreamAlias("Video")
    protected Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public static class Video implements Serializable {

        @XStreamAlias("MediaId")
        private String mediaId;
        @XStreamAlias("Title")
        private String title;
        @XStreamAlias("Description")
        private String description;

        public Video() {}

        public Video(String mediaId, String title, String description) {
            this.mediaId = mediaId;
            this.title = title;
            this.description = description;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

}
