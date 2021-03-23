package top.codewood.wx.mnp.bean.subscribemsg;

import java.io.Serializable;

public class WxMnpTemplateCategory implements Serializable {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WxMnpTemplateCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
