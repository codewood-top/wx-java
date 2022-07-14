package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.mnp.bean.express.WxMnpExpressService;

import java.io.Serializable;
import java.util.List;

public class WxMnpExpressGetAllDeliveryResult implements Serializable {

    /**
     * 快递公司数量
     */
    private Integer count;
    /**
     * 快递公司信息列表
     */
    private List<Delivery> data;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Delivery> getData() {
        return data;
    }

    public void setData(List<Delivery> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxMnpExpressGetAllDeliveryResult{" +
                "count=" + count +
                ", data=" + data +
                '}';
    }

    public static class Delivery implements Serializable {
        /**
         * 快递公司 ID
         */
        @SerializedName("delivery_id")
        private String deliveryId;
        /**
         * 快递公司名称
         */
        @SerializedName("delivery_name")
        private String deliveryName;
        /**
         * 是否支持散单, 1表示支持
         */
        @SerializedName("can_use_cash")
        private Integer canUseCash;
        /**
         * 是否支持查询面单余额, 1表示支持
         */
        @SerializedName("can_get_quota")
        private Integer canGetQuota;
        /**
         * 散单对应的bizid，当can_use_cash=1时有效
         */
        @SerializedName("cash_biz_id")
        private String cashBizId;

        /**
         * service_type
         * 支持的服务类型
         */
        @SerializedName("service_type")
        private List<WxMnpExpressService> services;

        public String getDeliveryId() {
            return deliveryId;
        }

        public void setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
        }

        public String getDeliveryName() {
            return deliveryName;
        }

        public void setDeliveryName(String deliveryName) {
            this.deliveryName = deliveryName;
        }

        public Integer getCanUseCash() {
            return canUseCash;
        }

        public void setCanUseCash(Integer canUseCash) {
            this.canUseCash = canUseCash;
        }

        public Integer getCanGetQuota() {
            return canGetQuota;
        }

        public void setCanGetQuota(Integer canGetQuota) {
            this.canGetQuota = canGetQuota;
        }

        public String getCashBizId() {
            return cashBizId;
        }

        public void setCashBizId(String cashBizId) {
            this.cashBizId = cashBizId;
        }

        public List<WxMnpExpressService> getServices() {
            return services;
        }

        public void setServices(List<WxMnpExpressService> services) {
            this.services = services;
        }

        @Override
        public String toString() {
            return "Delivery{" +
                    "deliveryId='" + deliveryId + '\'' +
                    ", deliveryName='" + deliveryName + '\'' +
                    ", canUseCash=" + canUseCash +
                    ", canGetQuota=" + canGetQuota +
                    ", cashBizId='" + cashBizId + '\'' +
                    ", services=" + services +
                    '}';
        }
    }


}
