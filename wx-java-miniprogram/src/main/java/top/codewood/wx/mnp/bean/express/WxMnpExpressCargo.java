package top.codewood.wx.mnp.bean.express;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class WxMnpExpressCargo implements Serializable {

    /**
     * 必填：是
     * 包裹数量, 默认为1
     */
    private Integer count;

    /**
     * 必填： 是
     * 包裹总重量，单位是千克(kg)
     */
    private BigDecimal weight;

    /**
     * 必填：是
     * 包裹长度，单位厘米(cm)
     */
    @SerializedName("space_x")
    private BigDecimal spaceX;
    /**
     * 必填：是
     * 包裹宽度，单位厘米(cm)
     */
    @SerializedName("space_y")
    private BigDecimal spaceY;

    /**
     * 必填：是
     * 包裹高度，单位厘米(cm)
     */
    @SerializedName("space_z")
    private BigDecimal spaceZ;

    /**
     * 必填：是
     * 包裹中商品详情列表
     */
    @SerializedName("detail_list")
    private List<WxMnpExpressCargoDetail> detailList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getSpaceX() {
        return spaceX;
    }

    public void setSpaceX(BigDecimal spaceX) {
        this.spaceX = spaceX;
    }

    public BigDecimal getSpaceY() {
        return spaceY;
    }

    public void setSpaceY(BigDecimal spaceY) {
        this.spaceY = spaceY;
    }

    public BigDecimal getSpaceZ() {
        return spaceZ;
    }

    public void setSpaceZ(BigDecimal spaceZ) {
        this.spaceZ = spaceZ;
    }

    public List<WxMnpExpressCargoDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<WxMnpExpressCargoDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return "WxMnpExpressCargo{" +
                "count=" + count +
                ", weight=" + weight +
                ", spaceX=" + spaceX +
                ", spaceY=" + spaceY +
                ", spaceZ=" + spaceZ +
                ", detailList=" + detailList +
                '}';
    }
}
