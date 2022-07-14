package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressCancelOrderRequest implements Serializable {

    /**
     * 必填：是
     * 订单 ID，需保证全局唯一
     */
    @SerializedName("order_id")
    private String orderId;
    /**
     * 必填：否
     * 用户openid，当add_source=2时无需填写（不发送物流服务通知）
     */
    private String openid;
    /**
     * 必填：是
     * 快递公司ID，参见getAllDelivery
     */
    @SerializedName("delivery_id")
    private String deliveryId;
    /**
     * 必填：是
     * 运单ID
     */
    @SerializedName("waybill_id")
    private String waybillId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    @Override
    public String toString() {
        return "WxMnpExpressCancelOrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", openid='" + openid + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", waybillId='" + waybillId + '\'' +
                '}';
    }
}
