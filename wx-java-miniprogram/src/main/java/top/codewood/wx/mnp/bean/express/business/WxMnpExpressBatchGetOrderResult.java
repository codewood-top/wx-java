package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.mnp.bean.express.WxMnpExpressWaybillData;

import java.io.Serializable;
import java.util.List;

public class WxMnpExpressBatchGetOrderResult implements Serializable {

    /**
     * 运单列表
     */
    @SerializedName("order_list")
    private List<Order> orderList;
    /**
     * 运单状态, 0正常，1取消
     */
    @SerializedName("order_status")
    private Integer orderStatus;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public static class Order implements Serializable {

        /**
         * 错误码
         */
        @SerializedName("errcode")
        private Integer errCode;
        /**
         * 错误信息
         */
        @SerializedName("errmsg")
        private String errMsg;
        /**
         * 订单ID
         */
        @SerializedName("order_id")
        private String orderId;
        /**
         * 快递公司ID，参见getAllDelivery
         */
        @SerializedName("delivery_id")
        private String deliveryId;
        /**
         * 运单ID
         */
        @SerializedName("waybill_id")
        private String waybillId;
        /**
         * 运单 html 的 BASE64 结果
         */
        @SerializedName("print_html")
        private String printHtml;
        /**
         * 运单信息
         */
        @SerializedName("waybill_data")
        private List<WxMnpExpressWaybillData> waybillData;


        public Integer getErrCode() {
            return errCode;
        }

        public void setErrCode(Integer errCode) {
            this.errCode = errCode;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
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

        public String getPrintHtml() {
            return printHtml;
        }

        public void setPrintHtml(String printHtml) {
            this.printHtml = printHtml;
        }

        public List<WxMnpExpressWaybillData> getWaybillData() {
            return waybillData;
        }

        public void setWaybillData(List<WxMnpExpressWaybillData> waybillData) {
            this.waybillData = waybillData;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "errCode=" + errCode +
                    ", errMsg='" + errMsg + '\'' +
                    ", orderId='" + orderId + '\'' +
                    ", deliveryId='" + deliveryId + '\'' +
                    ", waybillId='" + waybillId + '\'' +
                    ", printHtml='" + printHtml + '\'' +
                    ", waybillData=" + waybillData +
                    '}';
        }
    }


}
