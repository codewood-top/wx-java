package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeMockUpdateOrderRequest implements Serializable {

    /**
     * 商家id, 调用·immediateDelivery.mockUpdateOrder·时必须是 "test_shop_id"
     */
    @SerializedName("shopid")
    private String shopId;

    /**
     * 必填
     * 唯一标识订单的 ID，由商户生成
     */
    @SerializedName("shop_order_id")
    private String shopOrderId;

    /**
     * 必填
     * 状态变更时间点，Unix秒级时间戳
     */
    @SerializedName("action_time")
    private String actionTime;

    /**
     * 必填
     * 配送状态，详见<a href="https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/industry/immediate-delivery/order_status.html">order_status 枚举值</a>
     */
    @SerializedName("order_status")
    private String orderStatus;

    /**
     * 非必填
     * 附加信息
     */
    @SerializedName("action_msg")
    private String actionMsg;


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

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getActionMsg() {
        return actionMsg;
    }

    public void setActionMsg(String actionMsg) {
        this.actionMsg = actionMsg;
    }

    @Override
    public String toString() {
        return "ImmeMockUpdateOrderRequest{" +
                "shopId='" + shopId + '\'' +
                ", shopOrderId='" + shopOrderId + '\'' +
                ", actionTime='" + actionTime + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", actionMsg='" + actionMsg + '\'' +
                '}';
    }

}
