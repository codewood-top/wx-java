package top.codewood.wx.mnp.bean.subscribemsg;

import java.io.Serializable;

/**
 * subscribeMessage.getTemplateList data结构
 * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getTemplateList.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
 */
public class WxMnpTemplateInfo implements Serializable {

    /**
     * 添加至帐号下的模板 id，发送小程序订阅消息时所需
     */
    private String priTmplId;

    /**
     * 模版标题
     */
    private String title;

    /**
     * 模版内容
     */
    private String content;

    /**
     * 模板内容示例
     */
    private String example;

    /**
     * 模版类型，2 为一次性订阅，3 为长期订阅
     */
    private String type;

    public String getPriTmplId() {
        return priTmplId;
    }

    public void setPriTmplId(String priTmplId) {
        this.priTmplId = priTmplId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TemplateInfo{" +
                "priTmplId='" + priTmplId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", example='" + example + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
