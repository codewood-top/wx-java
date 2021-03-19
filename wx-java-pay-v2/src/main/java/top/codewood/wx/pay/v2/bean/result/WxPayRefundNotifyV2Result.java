package top.codewood.wx.pay.v2.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("root")
public class WxPayRefundNotifyV2Result implements Serializable {

    /**
     * 微信订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户系统内部的订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 微信退款单号
     */
    @XStreamAlias("refund_id")
    private String refundId;

    /**
     * 微信退款单号
     */
    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    /**
     * 订单金额
     * 订单总金额，单位为分，只能为整数
     */
    @XStreamAlias("total_fee")
    private int totalFee;


    /**
     * 退款资金来源
     * REFUND_SOURCE_RECHARGE_FUNDS 可用余额退款/基本账户
     * REFUND_SOURCE_UNSETTLED_FUNDS 未结算资金退款
     */
    @XStreamAlias("refund_account")
    private String refundAccount;

    /**
     * 申请退款金额
     * 退款总金额,单位为分
     */
    @XStreamAlias("refund_fee")
    private int refundFee;

    /**
     * 退款入账账户
     * 取当前退款单的退款入账方
     * 1）退回银行卡：
     * {银行名称}{卡类型}{卡尾号}
     * 2）退回支付用户零钱:
     * 支付用户零钱
     * 3）退还商户:
     * 商户基本账户
     * 商户结算银行账户
     * 4）退回支付用户零钱通:
     * 支付用户零钱通
     */
    @XStreamAlias("refund_recv_account")
    private String refundRecvAccount;

    /**
     * 退款发起来源
     * API接口
     * VENDOR_PLATFORM商户平台
     */
    @XStreamAlias("refund_request_srouce")
    private String refundRequestSource;

    /**
     * 退款状态
     * SUCCESS-退款成功
     * CHANGE-退款异常
     * REFUNDCLOSE—退款关闭
     */
    @XStreamAlias("refund_status")
    private String refundStatus;

    /**
     * 退款金额
     * 退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    @XStreamAlias("settlement_refund_fee")
    private int settlementRefundFee;

    /**
     * 应结订单金额
     * 当该订单有使用非充值券时，返回此字段。应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    @XStreamAlias("settlement_total_fee")
    private int settlementTotalFee;

    /**
     * 退款成功时间
     * 资金退款至用户帐号的时间，格式2017-12-15 09:46:01
     */
    @XStreamAlias("success_time")
    private String successTime;



    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(int refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundRecvAccount() {
        return refundRecvAccount;
    }

    public void setRefundRecvAccount(String refundRecvAccount) {
        this.refundRecvAccount = refundRecvAccount;
    }

    public String getRefundRequestSource() {
        return refundRequestSource;
    }

    public void setRefundRequestSource(String refundRequestSource) {
        this.refundRequestSource = refundRequestSource;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public int getSettlementRefundFee() {
        return settlementRefundFee;
    }

    public void setSettlementRefundFee(int settlementRefundFee) {
        this.settlementRefundFee = settlementRefundFee;
    }

    public int getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(int settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "WxPayRefundNotifyV2Result{" +
                "outRefundNo='" + outRefundNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", refundAccount='" + refundAccount + '\'' +
                ", refundFee=" + refundFee +
                ", refundId='" + refundId + '\'' +
                ", refundRecvAccount='" + refundRecvAccount + '\'' +
                ", refundRequestSource='" + refundRequestSource + '\'' +
                ", refundStatus='" + refundStatus + '\'' +
                ", settlementRefundFee=" + settlementRefundFee +
                ", settlementTotalFee=" + settlementTotalFee +
                ", successTime='" + successTime + '\'' +
                ", totalFee=" + totalFee +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
