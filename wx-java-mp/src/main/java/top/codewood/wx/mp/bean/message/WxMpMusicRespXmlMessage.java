package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.common.api.WxConstants;

import java.io.Serializable;

@XStreamAlias("xml")
public class WxMpMusicRespXmlMessage extends WxMpRespXmlMessage {

    {
        this.msgType = WxConstants.XmlMsgType.MUSIC;
    }

    @XStreamAlias("Music")
    protected Music music;

    public static class Music implements Serializable {

        @XStreamAlias("Title")
        private String title;

        @XStreamAlias("Description")
        private String description;

        @XStreamAlias("MusicUrl")
        private String musicUrl;

        @XStreamAlias("HQMusicUrl")
        private String hqMusicUrl;

        @XStreamAlias("ThumbMediaId")
        private String thumbMediaId;

        public Music() {}

        public Music(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
            this.title = title;
            this.description = description;
            this.musicUrl = musicUrl;
            this.hqMusicUrl = hqMusicUrl;
            this.thumbMediaId = thumbMediaId;
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

        public String getMusicUrl() {
            return musicUrl;
        }

        public void setMusicUrl(String musicUrl) {
            this.musicUrl = musicUrl;
        }

        public String getHqMusicUrl() {
            return hqMusicUrl;
        }

        public void setHqMusicUrl(String hqMusicUrl) {
            this.hqMusicUrl = hqMusicUrl;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }

}
