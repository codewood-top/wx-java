package top.codewood.wx.mnp.bean.subscribemsg;

import java.io.Serializable;

public class WxMnpPubTemplateKeyword implements Serializable {

    private int kid;
    private String name;
    private String example;
    private String rule;

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "WxMnpPubTemplateKeyword{" +
                "kid=" + kid +
                ", name='" + name + '\'' +
                ", example='" + example + '\'' +
                ", rule='" + rule + '\'' +
                '}';
    }
}
