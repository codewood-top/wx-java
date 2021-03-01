package top.codewood.wx.mp.bean.kefu.message;

import top.codewood.wx.mp.bean.kefu.message.builder.ImageBuilder;
import top.codewood.wx.mp.bean.kefu.message.builder.TextBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WxMpKfMessage implements Serializable {

    private String toUser;
    /**
     * 消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
     */
    private String msgType;
    private String content;
    /**
     * 发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
     */
    private String mediaId;
    /**
     * 缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
     */
    private String thumbMediaId;
    /**
     * 图文消息/视频消息/音乐消息/小程序卡片的标题
     */
    private String title;
    /**
     * 图文消息/视频消息/音乐消息的描述
     */
    private String description;
    /**
     * 音乐链接
     */
    private String musicUrl;
    /**
     * 高品质音乐链接，wifi环境优先使用该链接播放音乐
     */
    private String hqMusicUrl;
    /**
     * 图文消息被点击后跳转的链接
     */
    private String url;
    /**
     * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
     */
    private String picUrl;
    /**
     * 小程序的appid，要求小程序的appid需要与公众号有关联关系
     */
    private String appid;
    /**
     * 小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
     */
    private String pagePath;

    private String cardId;

    private String headContent;
    private String tailContent;

    private List<WxArticle> articles = new ArrayList<>();

    private List<MsgMenu> msgMenus = new ArrayList<>();

    public static TextBuilder textBuilder() {
        return new TextBuilder();
    }

    public static ImageBuilder imageBuilder() {
        return new ImageBuilder();
    }


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public List<WxArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<WxArticle> articles) {
        this.articles = articles;
    }

    public String getHeadContent() {
        return headContent;
    }

    public void setHeadContent(String headContent) {
        this.headContent = headContent;
    }

    public String getTailContent() {
        return tailContent;
    }

    public void setTailContent(String tailContent) {
        this.tailContent = tailContent;
    }

    public List<MsgMenu> getMsgMenus() {
        return msgMenus;
    }

    public void setMsgMenus(List<MsgMenu> msgMenus) {
        this.msgMenus = msgMenus;
    }

    public static class WxArticle implements Serializable {
        private String title;
        private String description;
        private String url;
        private String picUrl;

        public WxArticle() {}

        public WxArticle(String title, String description, String url, String picUrl) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.picUrl = picUrl;
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

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }

    public static class MsgMenu implements Serializable {
        private String id;
        private String content;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
