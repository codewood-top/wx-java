package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImmeCargo implements Serializable {
    /**
     * 必填
     * 货物价格，单位为元，精确到小数点后两位（如果小数点后位数多于两位，则四舍五入保留两位小数），范围为(0-5000]
     */
    @SerializedName("goods_value")
    private BigDecimal goodsValue;
    /**
     * 非必填
     * 货物高度，单位为cm，精确到小数点后两位（如果小数点后位数多于两位，则四舍五入保留两位小数），范围为(0-45]
     */
    @SerializedName("goods_height")
    private BigDecimal goodsHeight;
    /**
     * 非必填
     * 货物长度，单位为cm，精确到小数点后两位（如果小数点后位数多于两位，则四舍五入保留两位小数），范围为(0-65]
     */
    @SerializedName("goods_length")
    private BigDecimal goodsLength;
    /**
     * 非必填
     * 货物宽度，单位为cm，精确到小数点后两位（如果小数点后位数多于两位，则四舍五入保留两位小数），范围为(0-50]
     */
    @SerializedName("goods_width")
    private BigDecimal goodsWidth;
    /**
     * 必填
     * 货物重量，单位为kg，精确到小数点后两位（如果小数点后位数多于两位，则四舍五入保留两位小数），范围为(0-50]
     */
    @SerializedName("goods_weight")
    private BigDecimal goodsWeight;
    /**
     * 非必填
     * 货物详情，最长不超过10240个字符
     */
    @SerializedName("goods_detail")
    private ImmeGoods goodsDetail;
    /**
     * 非必填
     * 货物取货信息，用于骑手到店取货，最长不超过100个字符
     */
    @SerializedName("goods_pickup_info")
    private String goodsPickupInfo;
    /**
     * 非必填
     * 货物交付信息，最长不超过100个字符
     */
    @SerializedName("goods_delivery_info")
    private String goodsDeliveryInfo;
    /**
     * 必填
     * 品类一级类目, 详见<a href="https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/industry/immediate-delivery/category.html">品类表</a>
     */
    @SerializedName("cargo_first_class")
    private String cargoFirstClass;
    /**
     * 必填
     * 品类二级类目
     */
    @SerializedName("cargo_second_class")
    private String cargoSecondClass;

    public BigDecimal getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(BigDecimal goodsValue) {
        this.goodsValue = goodsValue;
    }

    public BigDecimal getGoodsHeight() {
        return goodsHeight;
    }

    public void setGoodsHeight(BigDecimal goodsHeight) {
        this.goodsHeight = goodsHeight;
    }

    public BigDecimal getGoodsLength() {
        return goodsLength;
    }

    public void setGoodsLength(BigDecimal goodsLength) {
        this.goodsLength = goodsLength;
    }

    public BigDecimal getGoodsWidth() {
        return goodsWidth;
    }

    public void setGoodsWidth(BigDecimal goodsWidth) {
        this.goodsWidth = goodsWidth;
    }

    public BigDecimal getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(BigDecimal goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public ImmeGoods getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(ImmeGoods goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getGoodsPickupInfo() {
        return goodsPickupInfo;
    }

    public void setGoodsPickupInfo(String goodsPickupInfo) {
        this.goodsPickupInfo = goodsPickupInfo;
    }

    public String getGoodsDeliveryInfo() {
        return goodsDeliveryInfo;
    }

    public void setGoodsDeliveryInfo(String goodsDeliveryInfo) {
        this.goodsDeliveryInfo = goodsDeliveryInfo;
    }

    public String getCargoFirstClass() {
        return cargoFirstClass;
    }

    public void setCargoFirstClass(String cargoFirstClass) {
        this.cargoFirstClass = cargoFirstClass;
    }

    public String getCargoSecondClass() {
        return cargoSecondClass;
    }

    public void setCargoSecondClass(String cargoSecondClass) {
        this.cargoSecondClass = cargoSecondClass;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "goodsValue=" + goodsValue +
                ", goodsHeight=" + goodsHeight +
                ", goodsLength=" + goodsLength +
                ", goodsWidth=" + goodsWidth +
                ", goodsWeight=" + goodsWeight +
                ", goodsDetail=" + goodsDetail +
                ", goodsPickupInfo='" + goodsPickupInfo + '\'' +
                ", goodsDeliveryInfo='" + goodsDeliveryInfo + '\'' +
                ", cargoFirstClass='" + cargoFirstClass + '\'' +
                ", cargoSecondClass='" + cargoSecondClass + '\'' +
                '}';
    }
}
