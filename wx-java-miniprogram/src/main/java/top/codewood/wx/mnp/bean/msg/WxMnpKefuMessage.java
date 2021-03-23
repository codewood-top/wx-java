package top.codewood.wx.mnp.bean.msg;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpKefuMessage implements Serializable {

    /**
     * 用户的 OpenID
     */
    @SerializedName("touser")
    private String toUser;

    /**
     * 消息类型
     * @see top.codewood.wx.common.api.WxConstants.MiniprogramKefuMsgType
     */
    @SerializedName("msgtype")
    private String msgType;

    /**
     * 文本消息，msgtype="text" 时必填
     */
    private Text text;

    /**
     * 图片消息，msgtype="image" 时必填
     */
    private Image image;

    /**
     * 图文链接，msgtype="link" 时必填
     */
    private Link link;

    /**
     * 小程序卡片，msgtype="miniprogrampage" 时必填
     */
    @SerializedName("miniprogrampage")
    private MiniprogramPage miniprogramPage;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public MiniprogramPage getMiniprogramPage() {
        return miniprogramPage;
    }

    public void setMiniprogramPage(MiniprogramPage miniprogramPage) {
        this.miniprogramPage = miniprogramPage;
    }

    public static class Builder {
        private String toUser;
        private String msgType;
        private Text text;
        private Image image;
        private Link link;
        private MiniprogramPage miniprogramPage;

        public Builder toUser(String toUser) {
            this.toUser = toUser;
            return this;
        }

        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        public Builder text(Text text) {
            this.text = text;
            return this;
        }

        public Builder image(Image image) {
            this.image = image;
            return this;
        }

        public Builder link(Link link) {
            this.link = link;
            return this;
        }

        public Builder miniprogramPage(MiniprogramPage miniprogramPage) {
            this.miniprogramPage = miniprogramPage;
            return this;
        }

        public WxMnpKefuMessage build() {
            WxMnpKefuMessage kefuMessage = new WxMnpKefuMessage();
            kefuMessage.setToUser(toUser);
            kefuMessage.setMsgType(msgType);
            kefuMessage.setText(text);
            kefuMessage.setImage(image);
            kefuMessage.setLink(link);
            kefuMessage.setMiniprogramPage(miniprogramPage);
            return kefuMessage;
        }

    }

    @Override
    public String toString() {
        return "WxMnpKefuMessage{" +
                "toUser='" + toUser + '\'' +
                ", msgType='" + msgType + '\'' +
                ", text=" + text +
                ", image=" + image +
                ", link=" + link +
                ", miniprogramPage=" + miniprogramPage +
                '}';
    }

    public static class Text implements Serializable {

        /**
         * 文本消息内容
         */
        private String content;

        public Text() {}

        public Text(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Text{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    public static class Image implements Serializable {

        /**
         * 发送的图片的媒体ID，通过 新增素材接口 上传图片文件获得。
         */
        @SerializedName("media_id")
        private String mediaId;

        public Image() {}

        public Image(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        @Override
        public String toString() {
            return "Image{" +
                    "mediaId='" + mediaId + '\'' +
                    '}';
        }
    }

    public static class Link implements Serializable {

        /**
         * 消息标题
         */
        private String title;

        /**
         * 	图文链接消息
         */
        private String description;

        /**
         * 图文链接消息被点击后跳转的链接
         */
        private String url;

        /**
         * 图文链接消息的图片链接，支持 JPG、PNG 格式，较好的效果为大图 640 X 320，小图 80 X 80
         */
        @SerializedName("thumb_url")
        private String thumbUrl;

        public Link() {}

        public Link(String title, String description, String url, String thumbUrl) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.thumbUrl = thumbUrl;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }
    }

    public static class MiniprogramPage implements Serializable {

        /**
         * 消息标题
         */
        private String title;

        /**
         * 小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
         */
        @SerializedName("pagepath")
        private String pagePath;

        /**
         * 小程序消息卡片的封面， image 类型的 media_id，通过 新增素材接口 上传图片文件获得，建议大小为 520*416
         */
        @SerializedName("thumb_media_id")
        private String thumbMediaId;

        public MiniprogramPage() {}

        public MiniprogramPage(String title, String pagePath, String thumbMediaId) {
            this.title = title;
            this.pagePath = pagePath;
            this.thumbMediaId = thumbMediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPagePath() {
            return pagePath;
        }

        public void setPagePath(String pagePath) {
            this.pagePath = pagePath;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        @Override
        public String toString() {
            return "MiniprogramPage{" +
                    "title='" + title + '\'' +
                    ", pagePath='" + pagePath + '\'' +
                    ", thumbMediaId='" + thumbMediaId + '\'' +
                    '}';
        }
    }

}
