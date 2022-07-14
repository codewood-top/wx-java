package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressGetOrderRequest implements Serializable {

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
     * 快递公司ID，参见getAllDelivery, 必须和waybill_id对应
     */
    @SerializedName("delivery_id")
    private String deliveryId;
    /**
     * 必填：否
     * 运单ID
     */
    @SerializedName("waybill_id")
    private String waybillId;
    /**
     * 必填：否
     * 获取打印面单类型【1：一联单，0：二联单】，默认获取二联单
     */
    @SerializedName("print_type")
    private String printType;

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

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    @Override
    public String toString() {
        return "WxMnpExpressGetOrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", openid='" + openid + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", waybillId='" + waybillId + '\'' +
                ", printType='" + printType + '\'' +
                '}';
    }
}
