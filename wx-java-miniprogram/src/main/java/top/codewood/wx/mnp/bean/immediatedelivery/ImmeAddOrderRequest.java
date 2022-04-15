package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeAddOrderRequest implements Serializable {

    /**
     * (非必填)预下单接口返回的参数，配送公司可保证在一段时间内运费不变
     */
    @SerializedName("delivery_token")
    private String deliveryToken;

    /**
     * 商家id，由配送公司分配的appkey
     */
    @SerializedName("shopid")
    private String shopId;

    /**
     * 唯一标识订单的 ID，由商户生成, 不超过128字节
     */
    @SerializedName("shop_order_id")
    private String shopOrderId;

    /**
     * 商家门店编号，在配送公司登记，如果只有一个门店，美团闪送必填, 值为店铺id
     */
    @SerializedName("shop_no")
    private String shopNo;

    /**
     * 用配送公司提供的appSecret加密的校验串说明
     */
    @SerializedName("delivery_sign")
    private String deliverySign;

    /**
     * 配送公司ID
     */
    @SerializedName("delivery_id")
    private String deliveryId;

    /**
     * 下单用户的openid
     */
    private String openid;

    /**
     * 子商户id，区分小程序内部多个子商户
     */
    @SerializedName("sub_biz_id")
    private String subBizId;

    /**
     * 发件人信息，顺丰同城急送必须填写，美团配送、达达、闪送，若传了shop_no的值可不填该字段
     */
    private ImmeSender sender;

    /**
     * 收件人信息
     */
    private ImmeReceiver receiver;

    /**
     * 货物信息
     */
    private ImmeCargo cargo;

    /**
     * 订单信息
     */
    @SerializedName("order_info")
    private ImmeOrderInfo orderInfo;

    /**
     * 商品信息，会展示到物流通知消息中
     */
    private ImmeOrderShop shop;

    public String getDeliveryToken() {
        return deliveryToken;
    }

    public void setDeliveryToken(String deliveryToken) {
        this.deliveryToken = deliveryToken;
    }

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSubBizId() {
        return subBizId;
    }

    public void setSubBizId(String subBizId) {
        this.subBizId = subBizId;
    }

    public ImmeSender getSender() {
        return sender;
    }

    public void setSender(ImmeSender sender) {
        this.sender = sender;
    }

    public ImmeReceiver getReceiver() {
        return receiver;
    }

    public void setReceiver(ImmeReceiver receiver) {
        this.receiver = receiver;
    }

    public ImmeCargo getCargo() {
        return cargo;
    }

    public void setCargo(ImmeCargo cargo) {
        this.cargo = cargo;
    }

    public ImmeOrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(ImmeOrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public ImmeOrderShop getShop() {
        return shop;
    }

    public void setShop(ImmeOrderShop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "AddOrderRequest{" +
                "deliveryToken='" + deliveryToken + '\'' +
                ", shopId='" + shopId + '\'' +
                ", shopOrderId='" + shopOrderId + '\'' +
                ", shopNo='" + shopNo + '\'' +
                ", deliverySign='" + deliverySign + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", openid='" + openid + '\'' +
                ", subBizId='" + subBizId + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", cargo=" + cargo +
                ", orderInfo=" + orderInfo +
                ", shop=" + shop +
                '}';
    }


}
