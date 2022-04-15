package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImmePreAddOrderResult implements Serializable {

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
     * 预计骑手接单时间，单位秒，比如5分钟，就填300, 无法预计填0
     */
    @SerializedName("dispatch_duration")
    private int dispatchDuration;

    /**
     * 配送公司可以返回此字段，当用户下单时候带上这个字段，保证在一段时间内运费不变
     */
    @SerializedName("delivery_token")
    private String deliveryToken;

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

    public int getDispatchDuration() {
        return dispatchDuration;
    }

    public void setDispatchDuration(int dispatchDuration) {
        this.dispatchDuration = dispatchDuration;
    }

    public String getDeliveryToken() {
        return deliveryToken;
    }

    public void setDeliveryToken(String deliveryToken) {
        this.deliveryToken = deliveryToken;
    }

    @Override
    public String toString() {
        return "ImmePreAddOrderResult{" +
                "fee=" + fee +
                ", deliverFee=" + deliverFee +
                ", couponFee=" + couponFee +
                ", tips=" + tips +
                ", insuranceFee=" + insuranceFee +
                ", distance=" + distance +
                ", dispatchDuration=" + dispatchDuration +
                ", deliveryToken='" + deliveryToken + '\'' +
                '}';
    }
}
