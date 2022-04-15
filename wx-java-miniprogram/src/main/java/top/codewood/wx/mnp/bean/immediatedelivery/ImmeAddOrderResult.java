package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImmeAddOrderResult implements Serializable {

    /**
     * 实际运费(单位：元)，运费减去优惠券费用
     */
    private BigDecimal fee;
    /**
     * 运费(单位：元)
     */
    @SerializedName("deliverfee")
    private BigDecimal deliverFee;
    /**
     * 优惠券费用(单位：元)
     */
    @SerializedName("couponfee")
    private BigDecimal couponFee;
    /**
     * 小费(单位：元)
     */
    private BigDecimal tips;
    /**
     * 保价费(单位：元)
     */
    @SerializedName("insurancefee")
    private BigDecimal insuranceFee;
    /**
     * 配送距离(整数单位：米)
     */
    private Integer distance;
    /**
     * 配送单号
     */
    @SerializedName("waybill_id")
    private String waybillId;
    /**
     * 配送状态，详见<a href="https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/industry/immediate-delivery/order_status.html">order_status 枚举值</a>
     */
    @SerializedName("order_status")
    private Integer orderStatus;
    /**
     * 收货码
     */
    @SerializedName("finish_code")
    private Integer finishCode;
    /**
     * 取货码
     */
    @SerializedName("pickup_code")
    private Integer pickupCode;
    /**
     * 预计骑手接单时间，单位秒，比如5分钟，就填300, 无法预计填0
     */
    @SerializedName("dispatch_duration")
    private int dispatchDuration;

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }

    public BigDecimal getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(BigDecimal couponFee) {
        this.couponFee = couponFee;
    }

    public BigDecimal getTips() {
        return tips;
    }

    public void setTips(BigDecimal tips) {
        this.tips = tips;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
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

    public Integer getFinishCode() {
        return finishCode;
    }

    public void setFinishCode(Integer finishCode) {
        this.finishCode = finishCode;
    }

    public Integer getPickupCode() {
        return pickupCode;
    }

    public void setPickupCode(Integer pickupCode) {
        this.pickupCode = pickupCode;
    }

    public int getDispatchDuration() {
        return dispatchDuration;
    }

    public void setDispatchDuration(int dispatchDuration) {
        this.dispatchDuration = dispatchDuration;
    }

    @Override
    public String toString() {
        return "AddOrderResult{" +
                "fee=" + fee +
                ", deliverFee=" + deliverFee +
                ", couponFee=" + couponFee +
                ", tips=" + tips +
                ", insuranceFee=" + insuranceFee +
                ", distance=" + distance +
                ", waybillId='" + waybillId + '\'' +
                ", orderStatus=" + orderStatus +
                ", finishCode=" + finishCode +
                ", pickupCode=" + pickupCode +
                ", dispatchDuration=" + dispatchDuration +
                '}';
    }
}
