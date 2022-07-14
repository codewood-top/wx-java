package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpExpressBatchGetOrderRequest implements Serializable {

    /**
     * 必填：是
     * 订单列表, 最多不能超过100个
     */
    @SerializedName("order_list")
    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "WxMnpExpressBatchGetOrderRequest{" +
                "orderList=" + orderList +
                '}';
    }

    public static class Order implements Serializable {

        /**
         * 必填：是
         * 订单ID
         */
        @SerializedName("order_id")
        private String orderId;
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
            return "WxMnpExpressOrder{" +
                    "orderId='" + orderId + '\'' +
                    ", deliveryId='" + deliveryId + '\'' +
                    ", waybillId='" + waybillId + '\'' +
                    '}';
        }
    }


}
