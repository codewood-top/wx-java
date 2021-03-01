package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsBuilder extends BaseBuilder<NewsBuilder> {

    private List<WxMpKfMessage.WxArticle> articles = new ArrayList<>();

    public NewsBuilder() {
        this.msgType = WxConstants.KefuMsgType.NEWS;
    }

    public NewsBuilder addArticle(WxMpKfMessage.WxArticle... articles) {
        Collections.addAll(this.articles, articles);
        return this;
    }

    public NewsBuilder articles(List<WxMpKfMessage.WxArticle> articles) {
        this.articles = articles;
        return this;
    }

    @Override
    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = super.build();
        kfMessage.setArticles(this.articles);
        return kfMessage;
    }
}
