package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeGetOrderRequest implements Serializable {

    /**
     * 必填
     * 商家id， 由配送公司分配的appkey
     */
    @SerializedName("shop_id")
    private String shopId;
    /**
     * 必填
     * 唯一标识订单的 ID，由商户生成
     */
    @SerializedName("shop_order_id")
    private String shopOrderId;
    /**
     * 必填
     * 商家门店编号， 在配送公司登记，如果只有一个门店，可以不填
     */
    @SerializedName("shop_no")
    private String shopNo;
    /**
     * 必填
     * 用配送公司提供的appSecret加密的校验串说明
     */
    @SerializedName("delivery_sign")
    private String deliverySign;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopOrderId() {
        return shopOrderId;
    }

    public void setShopOrderId(String shopOrderId) {
        this.shopOrderId = shopOrderId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getDeliverySign() {
        return deliverySign;
    }

    public void setDeliverySign(String deliverySign) {
        this.deliverySign = deliverySign;
    }

    @Override
    public String toString() {
        return "ImmeGetOrderRequest{" +
                "shopId='" + shopId + '\'' +
                ", shopOrderId='" + shopOrderId + '\'' +
                ", shopNo='" + shopNo + '\'' +
                ", deliverySign='" + deliverySign + '\'' +
                '}';
    }
}
