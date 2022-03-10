package top.codewood.wx.mnp.bean;

import java.io.Serializable;

public class WxMnpTemplateData  implements Serializable {

    private String name;
    private String value;
    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;

    public WxMnpTemplateData() {}

    public WxMnpTemplateData(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public WxMnpTemplateData(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "WxMnpTemplateData{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }


}
