package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeCancelOrderRequest implements Serializable {

    /**
     * 必填
     * 商家id， 由配送公司分配的appkey
     */
    @SerializedName("shopid")
    private String shopId;

    /**
     * 必填
     * 唯一标识订单的 ID，由商户生成
     */
    @SerializedName("shop_order_id")
    private String shopOrderId;

    /**
     * 必填
     * 商家门店编号，如果只有一个门店，闪送shop_no必填，值为店铺id
     */
    @SerializedName("shop_no")
    private String shopNo;

    /**
     * 必填
     * 用配送公司提供的appSecret加密的校验串说明
     */
    @SerializedName("delivery_sign")
    private String deliverySign;

    /**
     * 必填
     * 快递公司ID
     */
    @SerializedName("delivery_id")
    private String deliveryId;

    /**
     * 非必填
     * 配送单id
     */
    @SerializedName("waybill_id")
    private String waybillId;

    /**
     * 必填
     * 取消原因Id
     * 1: 暂时不需要邮寄;
     * 2: 价格不合适;
     * 3: 订单信息有误，重新下单;
     * 4: 骑手取货不及时;
     * 5: 骑手配送不及时;
     * 6: 其他原因( 如果选择6，需要填写取消原因，否则不需要填写 )
     */
    @SerializedName("cancel_reason_id")
    private Integer cancelReasonId;

    /**
     * 非必填
     * 取消原因
     */
    @SerializedName("cancel_reason")
    private String cancelReason;

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

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public Integer getCancelReasonId() {
        return cancelReasonId;
    }

    public void setCancelReasonId(Integer cancelReasonId) {
        this.cancelReasonId = cancelReasonId;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    @Override
    public String toString() {
        return "ImmeCancelOrderRequest{" +
                "shopId='" + shopId + '\'' +
                ", shopOrderId='" + shopOrderId + '\'' +
                ", shopNo='" + shopNo + '\'' +
                ", deliverySign='" + deliverySign + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", waybillId='" + waybillId + '\'' +
                ", cancelReasonId=" + cancelReasonId +
                ", cancelReason='" + cancelReason + '\'' +
                '}';
    }
}
