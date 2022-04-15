package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImmeGoods implements Serializable {
    /**
     * 必填
     * 货物数量
     */
    @SerializedName("good_count")
    private int goodCount;

    /**
     * 必填
     * 货品名称
     */
    @SerializedName("good_name")
    private String goodName;

    /**
     * 非必填
     * 货品单价，精确到小数点后两位（如果小数点后位数多于两位，则四舍五入保留两位小数
     */
    @SerializedName("good_price")
    private BigDecimal goodPrice;

    /**
     * 非必填
     * 货品单位，最长不超过20个字符
     */
    @SerializedName("good_unit")
    private String goodUnit;

    public int getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodUnit() {
        return goodUnit;
    }

    public void setGoodUnit(String goodUnit) {
        this.goodUnit = goodUnit;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodCount=" + goodCount +
                ", goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                ", goodUnit='" + goodUnit + '\'' +
                '}';
    }
}
