package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeAbnormalConfirmRequest implements Serializable {

    /**
     * 商家id，由配送公司分配的appkey
     */
    @SerializedName("shopid")
    private String shopId;
    /**
     * 唯一标识订单的 ID，由商户生成
     */
    @SerializedName("shop_order_id")
    private String shopOrderId;
    /**
     * 商家门店编号，在配送公司登记，闪送必填，值为店铺id
     */
    @SerializedName("shop_no")
    private String shopNo;
    /**
     * 用配送公司提供的appSecret加密的校验串说明
     */
    @SerializedName("delivery_sign")
    private String deliverySign;
    /**
     * 配送单id
     */
    @SerializedName("waybill_id")
    private String waybillId;
    /**
     * 备注(非必填)
     */
    private String remark;

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

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
