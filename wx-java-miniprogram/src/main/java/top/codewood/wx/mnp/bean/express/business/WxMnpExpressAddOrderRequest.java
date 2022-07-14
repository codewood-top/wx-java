package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.mnp.bean.express.*;

import java.io.Serializable;

/**
 *
 */
public class WxMnpExpressAddOrderRequest implements Serializable {

    /**
     * 必填：是
     * 订单来源，0为小程序订单，2为 App 或H5订单，填2则不发送物流服务通知
     */
    @SerializedName("add_source")
    private Integer addSource;

    /**
     * 必填：否
     * App或H5的appid，add_source=2时必填，需和开通了物流助手的小程序绑定同一 open 帐号
     */
    @SerializedName("wx_appid")
    private String wxAppid;

    /**
     * 必填：是
     * 订单ID，须保证全局唯一，不超过512字节
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
     * 快递客户编码或者现付编码
     */
    @SerializedName("biz_id")
    private String bizId;

    /**
     * 必填：否
     * 快递备注信息，比如"易碎物品"，不超过1024字节，该字段会体现在电子面单上
     */
    @SerializedName("custom_remark")
    private String customRemark;

    /**
     * 必填：否
     * 订单标签id，用于平台型小程序区分平台上的入驻方，tagid须与入驻方账号一一对应，非平台型小程序无需填写该字段
     */
    @SerializedName("tagid")
    private Integer tagId;

    /**
     * 必填：是
     * 发件人信息
     */
    private WxMnpExpressPerson sender;

    /**
     * 必填：是
     * 收件人信息
     */
    private WxMnpExpressPerson receiver;

    /**
     * 必填：是
     * 包裹信息，将传递给快递公司
     */
    private WxMnpExpressCargo cargo;

    /**
     * 必填：是
     * 商品信息，会展示到物流服务通知和电子面单中
     */
    private WxMnpExpressShop shop;

    /**
     * 必填：是
     * 保价信息
     */
    private WxMnpExpressInsured insured;

    /**
     * 必填：是
     * 服务类型
     */
    private WxMnpExpressService service;

    /**
     * 必填：否
     * Unix 时间戳, 单位秒，顺丰必须传。 预期的上门揽件时间，0表示已事先约定取件时间；
     * 否则请传预期揽件时间戳，需大于当前时间，收件员会在预期时间附近上门。
     * 例如expect_time为“1557989929”，表示希望收件员将在2019年05月16日14:58:49-15:58:49内上门取货。
     * 说明：若选择 了预期揽件时间，请不要自己打单，由上门揽件的时候打印。
     * 如果是下顺丰散单，则必传此字段，否则不会有收件员上门揽件。
     */
    @SerializedName("expect_time")
    private Integer expectTime;

    /**
     * 必填：否
     * 分单策略，【0：线下网点签约，1：总部签约结算】，不传默认线下网点签约。目前支持圆通。
     */
    @SerializedName("take_mode")
    private Integer takeMode;

    public Integer getAddSource() {
        return addSource;
    }

    public void setAddSource(Integer addSource) {
        this.addSource = addSource;
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }

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

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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

    public WxMnpExpressCargo getCargo() {
        return cargo;
    }

    public void setCargo(WxMnpExpressCargo cargo) {
        this.cargo = cargo;
    }

    public WxMnpExpressShop getShop() {
        return shop;
    }

    public void setShop(WxMnpExpressShop shop) {
        this.shop = shop;
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

    public Integer getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Integer expectTime) {
        this.expectTime = expectTime;
    }

    public Integer getTakeMode() {
        return takeMode;
    }

    public void setTakeMode(Integer takeMode) {
        this.takeMode = takeMode;
    }

    @Override
    public String toString() {
        return "WxMnpExpressAddOrderRequest{" +
                "addSource=" + addSource +
                ", wxAppid='" + wxAppid + '\'' +
                ", orderId='" + orderId + '\'' +
                ", openid='" + openid + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", bizId='" + bizId + '\'' +
                ", customRemark='" + customRemark + '\'' +
                ", tagId=" + tagId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", cargo=" + cargo +
                ", shop=" + shop +
                ", insured=" + insured +
                ", service=" + service +
                ", expectTime=" + expectTime +
                ", takeMode=" + takeMode +
                '}';
    }

    public static class Builder {
        private Integer addSource;
        private String wxAppid;
        private String orderId;
        private String openid;
        private String deliveryId;
        private String bizId;
        private String customRemark;
        private Integer tagId;
        private WxMnpExpressPerson sender;
        private WxMnpExpressPerson receiver;
        private WxMnpExpressCargo cargo;
        private WxMnpExpressShop shop;
        private WxMnpExpressInsured insured;
        private WxMnpExpressService service;
        private Integer expectTime;
        private Integer takeMode;

        public Builder addSource(Integer addSource) {
            this.addSource = addSource;
            return this;
        }

        public Builder wxAppid(String wxAppid) {
            this.wxAppid = wxAppid;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder openid(String openid) {
            this.openid = openid;
            return this;
        }

        public Builder deliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
            return this;
        }

        public Builder bizId(String bizId) {
            this.bizId = bizId;
            return this;
        }

        public Builder customRemark(String customRemark) {
            this.customRemark = customRemark;
            return this;
        }

        public Builder tagId(Integer tagId) {
            this.tagId = tagId;
            return this;
        }

        public Builder sender(WxMnpExpressPerson sender) {
            this.sender = sender;
            return this;
        }

        public Builder receiver(WxMnpExpressPerson receiver) {
            this.receiver = receiver;
            return this;
        }

        public Builder cargo(WxMnpExpressCargo cargo) {
            this.cargo = cargo;
            return this;
        }

        public Builder shop(WxMnpExpressShop  shop) {
            this.shop = shop;
            return this;
        }

        public  Builder insured(WxMnpExpressInsured insured) {
            this.insured = insured;
            return this;
        }

        public Builder service(WxMnpExpressService service) {
            this.service = service;
            return this;
        }

        public Builder expectTime(Integer expectTime) {
            this.expectTime = expectTime;
            return this;
        }

        public Builder takeMode(Integer takeMode) {
            this.takeMode = takeMode;
            return this;
        }

        public WxMnpExpressAddOrderRequest build() {
            WxMnpExpressAddOrderRequest request = new WxMnpExpressAddOrderRequest();
            request.setAddSource(this.addSource);
            request.setWxAppid(this.wxAppid);
            request.setOrderId(this.orderId);
            request.setOpenid(this.openid);
            request.setDeliveryId(this.deliveryId);
            request.setBizId(this.bizId);
            request.setCustomRemark(this.customRemark);
            request.setTagId(this.tagId);
            request.setSender(this.sender);
            request.setReceiver(this.receiver);
            request.setCargo(this.cargo);
            request.setShop(this.shop);
            request.setInsured(this.insured);
            request.setService(this.service);
            request.setExpectTime(this.expectTime);
            request.setTakeMode(this.takeMode);
            return request;
        }

    }


}
