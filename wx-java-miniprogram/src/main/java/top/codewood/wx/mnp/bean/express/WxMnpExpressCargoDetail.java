package top.codewood.wx.mnp.bean.express;

import java.io.Serializable;

public class WxMnpExpressCargoDetail implements Serializable {

    /**
     * 必填：是
     * 商品名，不超过128字节
     */
    private String name;
    /**
     * 必填：是
     * 商品数量
     */
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WxMnpExpressCargoDetail{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
