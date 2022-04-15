package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeGetOrderResult implements Serializable {

    /**
     * 配送状态,
     * 详见 <a href="https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/industry/immediate-delivery/order_status.html">order_status 枚举值</a>
     */
    @SerializedName("order_status")
    private Integer orderStatus;

    /**
     * 配送单号
     */
    @SerializedName("waybill_id")
    private String waybillId;

    /**
     * 骑手姓名
     */
    @SerializedName("rider_name")
    private String riderName;

    /**
     * 骑手电话
     */
    @SerializedName("rider_phone")
    private String riderPhone;

    /**
     * 骑手位置经度, 配送中时返回
     */
    @SerializedName("rider_lng")
    private double riderLng;

    /**
     * 骑手位置纬度, 配送中时返回
     */
    @SerializedName("rider_lat")
    private double riderLat;

    /**
     * 预计还剩多久送达时间, 配送中时返回，单位秒， 已取货配送中需返回，比如5分钟后送达，填300
     */
    @SerializedName("reach_time")
    private Integer reachTime;

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public String getRiderPhone() {
        return riderPhone;
    }

    public void setRiderPhone(String riderPhone) {
        this.riderPhone = riderPhone;
    }

    public double getRiderLng() {
        return riderLng;
    }

    public void setRiderLng(double riderLng) {
        this.riderLng = riderLng;
    }

    public double getRiderLat() {
        return riderLat;
    }

    public void setRiderLat(double riderLat) {
        this.riderLat = riderLat;
    }

    public Integer getReachTime() {
        return reachTime;
    }

    public void setReachTime(Integer reachTime) {
        this.reachTime = reachTime;
    }

    @Override
    public String toString() {
        return "ImmeGetOrderResult{" +
                "orderStatus=" + orderStatus +
                ", waybillId='" + waybillId + '\'' +
                ", riderName='" + riderName + '\'' +
                ", riderPhone='" + riderPhone + '\'' +
                ", riderLng=" + riderLng +
                ", riderLat=" + riderLat +
                ", reachTime=" + reachTime +
                '}';
    }

}