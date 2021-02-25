package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.common.api.WxConstants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("xml")
public class WxMpNewsRespXmlMessage extends WxMpRespXmlMessage {

    {
        this.msgType = WxConstants.XmlMsgType.NEWS;
    }

    @XStreamAlias("ArticleCount")
    protected int articleCount;

    @XStreamAlias("Articles")
    protected List<Item> articles = new ArrayList<>();

    public void addItem(Item item) {
        articles.add(item);
        articleCount = articles.size();
    }

    public int getArticleCount() {
        return articleCount;
    }


    public List<Item> getArticles() {
        return articles;
    }

    public void setArticles(List<Item> articles) {
        this.articles = articles;
    }

    @XStreamAlias("item")
    public static class Item implements Serializable {

        @XStreamAlias("Title")
        private String title;

        @XStreamAlias("Description")
        private String description;

        @XStreamAlias("PicUrl")
        private String picUrl;

        @XStreamAlias("Url")
        private String url;

        public Item() {}

        public Item(String title, String description, String picUrl, String url) {
            this.title = title;
            this.description = description;
            this.picUrl = picUrl;
            this.url = url;
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

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
