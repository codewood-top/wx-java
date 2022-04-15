package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImmeOrderInfo implements Serializable {
    /**
     * 非必填
     * 配送服务代码 不同配送公司自定义, 顺丰和达达不填
     */
    @SerializedName("delivery_service_code")
    private String deliveryServiceCode;

    /**
     * 非必填
     * 订单类型, 0: 即时单 1 预约单，如预约单，需要设置expected_delivery_time或expected_finish_time或expected_pick_time
     */
    @SerializedName("order_type")
    private int orderType;

    /**
     * 非必填
     * 期望派单时间(达达支持，表示达达系统调度时间, 到那个时间才会有状态更新的回调通知)，unix-timestamp, 比如1586342180
     */
    @SerializedName("expected_delivery_time")
    private int expectedDeliveryTime;

    /**
     * 非必填
     * 期望送达时间(美团、顺丰同城急送支持），unix-timestamp, 比如1586342180
     */
    @SerializedName("expected_finish_time")
    private int expectedFinishTime;

    /**
     * 非必填
     * 期望取件时间（闪送、顺丰同城急送支持，闪送需要设置两个小时后的时间，顺丰同城急送只需传expected_finish_time或expected_pick_time其中之一即可，同时都传则以expected_finish_time为准），unix-timestamp, 比如1586342180
     */
    @SerializedName("expected_pick_time")
    private int expectedPickTime;

    /**
     * 非必填
     * 门店订单流水号，建议提供，方便骑手门店取货，最长不超过32个字符
     */
    @SerializedName("poi_seq")
    private int poiSeq;

    /**
     * 非必填
     * 备注，最长不超过200个字符
     */
    private String note;

    /**
     * 非必填
     * 用户下单付款时间, 顺丰必填, 比如1555220757
     */
    @SerializedName("order_time")
    private Integer orderTime;

    /**
     * 非必填
     * 是否保价，0，非保价，1.保价
     */
    @SerializedName("is_insured")
    private int insured;

    /**
     * 非必填
     * 保价金额，单位为元，精确到分
     */
    @SerializedName("declared_value")
    private BigDecimal declaredValue;

    /**
     * 非必填
     * 小费，单位为元, 下单一般不加小费
     */
    private BigDecimal tips;

    /**
     * 非必填
     * 是否选择直拿直送（0：不需要；1：需要。选择直拿直送后，同一时间骑手只能配送此订单至完成，配送费用也相应高一些，闪送必须选1，达达可选0或1，其余配送公司不支持直拿直送）
     */
    @SerializedName("is_direct_delivery")
    private Integer directDelivery;

    /**
     * 非必填
     * 骑手应付金额，单位为元，精确到分
     */
    @SerializedName("cash_on_delivery")
    private BigDecimal cashOnDelivery;

    /**
     * 非必填
     * 骑手应收金额，单位为元，精确到分
     */
    @SerializedName("cash_on_pickup")
    private BigDecimal cashOnPickup;

    /**
     * 非必填
     * 物流流向，1：从门店取件送至用户；2：从用户取件送至门店
     */
    @SerializedName("rider_pick_method")
    private Integer riderPickMethod;

    /**
     * 非必填
     * 收货码（0：不需要；1：需要。收货码的作用是：骑手必须输入收货码才能完成订单妥投）
     */
    @SerializedName("is_finish_code_needed")
    private Integer finishCodeNeeded;

    /**
     * 取货码（0：不需要；1：需要。取货码的作用是：骑手必须输入取货码才能从商家取货）
     */
    @SerializedName("is_pickup_code_needed")
    private Integer pickupCodeNeeded;

    public String getDeliveryServiceCode() {
        return deliveryServiceCode;
    }

    public void setDeliveryServiceCode(String deliveryServiceCode) {
        this.deliveryServiceCode = deliveryServiceCode;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(int expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public int getExpectedFinishTime() {
        return expectedFinishTime;
    }

    public void setExpectedFinishTime(int expectedFinishTime) {
        this.expectedFinishTime = expectedFinishTime;
    }

    public int getExpectedPickTime() {
        return expectedPickTime;
    }

    public void setExpectedPickTime(int expectedPickTime) {
        this.expectedPickTime = expectedPickTime;
    }

    public int getPoiSeq() {
        return poiSeq;
    }

    public void setPoiSeq(int poiSeq) {
        this.poiSeq = poiSeq;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

    public int getInsured() {
        return insured;
    }

    public void setInsured(int insured) {
        this.insured = insured;
    }

    public BigDecimal getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(BigDecimal declaredValue) {
        this.declaredValue = declaredValue;
    }

    public BigDecimal getTips() {
        return tips;
    }

    public void setTips(BigDecimal tips) {
        this.tips = tips;
    }

    public Integer getDirectDelivery() {
        return directDelivery;
    }

    public void setDirectDelivery(Integer directDelivery) {
        this.directDelivery = directDelivery;
    }

    public BigDecimal getCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(BigDecimal cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    public BigDecimal getCashOnPickup() {
        return cashOnPickup;
    }

    public void setCashOnPickup(BigDecimal cashOnPickup) {
        this.cashOnPickup = cashOnPickup;
    }

    public Integer getRiderPickMethod() {
        return riderPickMethod;
    }

    public void setRiderPickMethod(Integer riderPickMethod) {
        this.riderPickMethod = riderPickMethod;
    }

    public Integer getFinishCodeNeeded() {
        return finishCodeNeeded;
    }

    public void setFinishCodeNeeded(Integer finishCodeNeeded) {
        this.finishCodeNeeded = finishCodeNeeded;
    }

    public Integer getPickupCodeNeeded() {
        return pickupCodeNeeded;
    }

    public void setPickupCodeNeeded(Integer pickupCodeNeeded) {
        this.pickupCodeNeeded = pickupCodeNeeded;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "deliveryServiceCode='" + deliveryServiceCode + '\'' +
                ", orderType=" + orderType +
                ", expectedDeliveryTime=" + expectedDeliveryTime +
                ", expectedFinishTime=" + expectedFinishTime +
                ", expectedPickTime=" + expectedPickTime +
                ", poiSeq=" + poiSeq +
                ", note='" + note + '\'' +
                ", orderTime=" + orderTime +
                ", insured=" + insured +
                ", declaredValue=" + declaredValue +
                ", tips=" + tips +
                ", directDelivery=" + directDelivery +
                ", cashOnDelivery=" + cashOnDelivery +
                ", cashOnPickup=" + cashOnPickup +
                ", riderPickMethod=" + riderPickMethod +
                ", finishCodeNeeded=" + finishCodeNeeded +
                ", pickupCodeNeeded=" + pickupCodeNeeded +
                '}';
    }
}
