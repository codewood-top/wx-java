package top.codewood.wx.pay.v2.bean.notify;

import java.io.Serializable;

public class WxPayNotifyCoupon implements Serializable {

    private String couponId;
    private String couponType;
    private Integer couponFee;

    public WxPayNotifyCoupon() {}

    public WxPayNotifyCoupon(String couponId, String couponType, Integer couponFee) {
        this.couponId = couponId;
        this.couponType = couponType;
        this.couponFee = couponFee;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public Integer getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Integer couponFee) {
        this.couponFee = couponFee;
    }

    @Override
    public String toString() {
        return "WxPayNotifyCoupon{" +
                "couponId='" + couponId + '\'' +
                ", couponType='" + couponType + '\'' +
                ", couponFee=" + couponFee +
                '}';
    }
}
