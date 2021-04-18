package top.codewood.wx.pay.v2.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;
import top.codewood.wx.pay.v2.bean.WxPayV2Coupon;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("xml")
public class WxPayRefundV2Result extends WxPayBaseResult {

    /**
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 商户退款单号
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    /**
     * 微信退款单号
     */
    @XStreamAlias("refund_id")
    private String refundId;

    /**
     * 退款总金额,单位为分,可以做部分退款
     */
    @XStreamAlias("refund_fee")
    private int refundFee;

    /**
     * 应结退款金额
     * 去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    @XStreamAlias("settlement_refund_fee")
    private int settlementRefundFee;

    /**
     * 标价金额
     * 订单总金额，单位为分，只能为整数
     */
    @XStreamAlias("total_fee")
    private int totalFee;

    /**
     * 应结订单金额
     * 去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    @XStreamAlias("settlement_total_fee")
    private int settlementTotalFee;

    /**
     * 标价币种
     * 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * 现金支付金额
     * 现金支付金额，单位为分，只能为整数
     */
    @XStreamAlias("cash_fee")
    private String cashFee;

    /**
     * 现金支付币种
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;

    /**
     * 现金退款金额
     * 现金退款金额，单位为分，只能为整数
     */
    @XStreamAlias("cahs_refund_fee")
    private int cashRefundFee;

    /**
     * 代金券退款总金额
     * 代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金
     */
    @XStreamAlias("coupon_refund_fee")
    private int couponRefundFee;

    /**
     * 退款代金券使用数量
     */
    @XStreamAlias("coupon_count")
    private int couponCount;

    private List<WxPayV2Coupon> coupons;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(int refundFee) {
        this.refundFee = refundFee;
    }

    public int getSettlementRefundFee() {
        return settlementRefundFee;
    }

    public void setSettlementRefundFee(int settlementRefundFee) {
        this.settlementRefundFee = settlementRefundFee;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(int settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public int getCashRefundFee() {
        return cashRefundFee;
    }

    public void setCashRefundFee(int cashRefundFee) {
        this.cashRefundFee = cashRefundFee;
    }

    public int getCouponRefundFee() {
        return couponRefundFee;
    }

    public void setCouponRefundFee(int couponRefundFee) {
        this.couponRefundFee = couponRefundFee;
    }

    public int getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(int couponCount) {
        this.couponCount = couponCount;
    }

    public List<WxPayV2Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<WxPayV2Coupon> coupons) {
        this.coupons = coupons;
    }

    /**
     * 要先有couponCount，再转换
     * @param xml
     */
    public void setCouponsFromXml(String xml) {
        if (this.couponCount == 0) return;
        this.coupons = new ArrayList<>(this.couponCount);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            for (int i = 0; i < this.couponCount; i++) {
                WxPayV2Coupon coupon = new WxPayV2Coupon();
                coupon.setCouponId(root.elementText("coupon_id_" + i));
                coupon.setCouponType(root.elementText("coupon_type_" + i));
                coupon.setCouponFee(Integer.valueOf(root.elementText("coupon_fee_" +i)));
                coupons.add(coupon);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "WxPayRefundV2Result{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", outRefundNo='" + outRefundNo + '\'' +
                ", refundId='" + refundId + '\'' +
                ", refundFee=" + refundFee +
                ", settlementRefundFee=" + settlementRefundFee +
                ", totalFee=" + totalFee +
                ", settlementTotalFee=" + settlementTotalFee +
                ", feeType='" + feeType + '\'' +
                ", cashFee='" + cashFee + '\'' +
                ", cashFeeType='" + cashFeeType + '\'' +
                ", cashRefundFee=" + cashRefundFee +
                ", couponRefundFee=" + couponRefundFee +
                ", couponCount=" + couponCount +
                ", coupons=" + coupons +
                '}';
    }
}
