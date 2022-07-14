package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.mnp.bean.express.WxMnpExpressWaybillData;

import java.io.Serializable;
import java.util.List;

public class WxMnpExpressGetOrderResult implements Serializable {

    /**
     * 运单 html 的 BASE64 结果
     */
    @SerializedName("print_html")
    private String printHtml;
    /**
     * 快递公司ID
     */
    @SerializedName("delivery_id")
    private String deliveryId;

    /**
     * 订单ID
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 运单号
     */
    @SerializedName("waybill_id")
    private String waybillId;
    /**
     * 运单状态, 0正常，1取消
     */
    @SerializedName("order_status")
    private Integer orderStatus;

    /**
     * 运单信息
     */
    @SerializedName("waybill_data")
    private List<WxMnpExpressWaybillData> waybillData;

    public String getPrintHtml() {
        return printHtml;
    }

    public void setPrintHtml(String printHtml) {
        this.printHtml = printHtml;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<WxMnpExpressWaybillData> getWaybillData() {
        return waybillData;
    }

    public void setWaybillData(List<WxMnpExpressWaybillData> waybillData) {
        this.waybillData = waybillData;
    }

    @Override
    public String toString() {
        return "WxMnpExpressGetOrderResult{" +
                "printHtml='" + printHtml + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", waybillId='" + waybillId + '\'' +
                ", orderStatus=" + orderStatus +
                ", waybillData=" + waybillData +
                '}';
    }
}
