package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.mnp.bean.express.WxMnpExpressWaybillData;

import java.io.Serializable;
import java.util.List;

public class WxMnpExpressAddOrderResult implements Serializable {

    /**
     * 订单ID，下单成功时返回
     */
    @SerializedName("order_id")
    private String orderId;
    /**
     * 运单ID，下单成功时返回
     */
    @SerializedName("waybill_id")
    private String  waybillId;
    /**
     * 运单信息，下单成功时返回
     */
    @SerializedName("waybill_data")
    private List<WxMnpExpressWaybillData> waybillData;
    /**
     * 快递侧错误码，下单失败时返回
     */
    @SerializedName("delivery_resultcode")
    private String deliveryResultCode;
    /**
     * 快递侧错误信息，下单失败时返回
     */
    @SerializedName("delivery_resultmsg")
    private String deliveryResultMsg;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public List<WxMnpExpressWaybillData> getWaybillData() {
        return waybillData;
    }

    public void setWaybillData(List<WxMnpExpressWaybillData> waybillData) {
        this.waybillData = waybillData;
    }

    public String getDeliveryResultCode() {
        return deliveryResultCode;
    }

    public void setDeliveryResultCode(String deliveryResultCode) {
        this.deliveryResultCode = deliveryResultCode;
    }

    public String getDeliveryResultMsg() {
        return deliveryResultMsg;
    }

    public void setDeliveryResultMsg(String deliveryResultMsg) {
        this.deliveryResultMsg = deliveryResultMsg;
    }

    @Override
    public String toString() {
        return "WxMnpExpressAddOrderResult{" +
                "orderId='" + orderId + '\'' +
                ", waybillId='" + waybillId + '\'' +
                ", waybillData=" + waybillData +
                ", deliveryResultCode='" + deliveryResultCode + '\'' +
                ", deliveryResultMsg='" + deliveryResultMsg + '\'' +
                '}';
    }
}
