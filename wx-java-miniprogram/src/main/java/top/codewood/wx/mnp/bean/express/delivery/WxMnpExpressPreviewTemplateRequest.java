package top.codewood.wx.mnp.bean.express.delivery;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.mnp.bean.express.*;

import java.io.Serializable;

public class WxMnpExpressPreviewTemplateRequest implements Serializable {

    /**
     * 必填：是
     * 运单 ID
     */
    @SerializedName("waybill_id")
    private String waybillId;

    /**
     * 必填：是
     * 面单 HTML 模板内容（需经 Base64 编码）
     */
    @SerializedName("waybill_template")
    private String waybillTemplate;

    /**
     * 必填：是
     * 面单数据。详情参考<a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.onAddOrder.html">下单事件</a>返回值中的 WaybillData
     */
    @SerializedName("waybill_data")
    private String waybillData;

    /**
     * 必填：是
     * 商户下单数据，格式是商户侧下单 API 中的请求体
     */
    private Custom custom;


    public static class Custom implements Serializable {
        @SerializedName("order_id")
        private String orderId;
        private String openid;
        @SerializedName("delivery_id")
        private String deliveryId;
        @SerializedName("biz_id")
        private String bizId;
        @SerializedName("custom_remark")
        private String customRemark;
        private WxMnpExpressPerson sender;
        private WxMnpExpressPerson receiver;
        private WxMnpExpressShop shop;
        private WxMnpExpressCargo cargo;
        private WxMnpExpressInsured insured;
        private WxMnpExpressService service;

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

        public String getBizId() {
            return bizId;
        }

        public void setBizId(String bizId) {
            this.bizId = bizId;
        }

        public String getCustomRemark() {
            return customRemark;
        }

        public void setCustomRemark(String customRemark) {
            this.customRemark = customRemark;
        }

        public WxMnpExpressPerson getSender() {
            return sender;
        }

        public void setSender(WxMnpExpressPerson sender) {
            this.sender = sender;
        }

        public WxMnpExpressPerson getReceiver() {
            return receiver;
        }

        public void setReceiver(WxMnpExpressPerson receiver) {
            this.receiver = receiver;
        }

        public WxMnpExpressShop getShop() {
            return shop;
        }

        public void setShop(WxMnpExpressShop shop) {
            this.shop = shop;
        }

        public WxMnpExpressCargo getCargo() {
            return cargo;
        }

        public void setCargo(WxMnpExpressCargo cargo) {
            this.cargo = cargo;
        }

        public WxMnpExpressInsured getInsured() {
            return insured;
        }

        public void setInsured(WxMnpExpressInsured insured) {
            this.insured = insured;
        }

        public WxMnpExpressService getService() {
            return service;
        }

        public void setService(WxMnpExpressService service) {
            this.service = service;
        }
    }

}
