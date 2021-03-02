package top.codewood.wx.mp.bean.template;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMpTemplate implements Serializable {

    /**
     * 模板id
     */
    @SerializedName("template_id")
    private String templateId;

    /**
     * 模板标题
     */
    private String title;

    /**
     * 模板所属行业的一级行业
     */
    @SerializedName("primary_industry")
    private String primaryIndustry;

    /**
     * 模板所属行业的二级行业
     */
    @SerializedName("deputy_industry")
    private String deputyIndusttry;

    /**
     * 模板内容
     */
    private String content;

    /**
     * 模板示例
     */
    private String example;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public String getDeputyIndusttry() {
        return deputyIndusttry;
    }

    public void setDeputyIndusttry(String deputyIndusttry) {
        this.deputyIndusttry = deputyIndusttry;
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

    @Override
    public String toString() {
        return "WxMpTemplate{" +
                "templateId='" + templateId + '\'' +
                ", title='" + title + '\'' +
                ", primaryIndustry='" + primaryIndustry + '\'' +
                ", deputyIndusttry='" + deputyIndusttry + '\'' +
                ", content='" + content + '\'' +
                ", example='" + example + '\'' +
                '}';
    }
}
