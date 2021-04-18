package top.codewood.wx.pay.v2.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * transaction_id || out_trade_no 二选一
 */
@XStreamAlias("xml")
public class WxPayRefundV2Request extends WxPayBaseRequest {

    /**
     * 微信支付订单号
     * 微信生成的订单号，在支付通知中有返回
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     * transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 商户退款单号
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    @Required
    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    /**
     * 订单总金额，单位为分，只能为整数
     */
    @Required
    @XStreamAlias("total_fee")
    private int totalFee;

    /**
     * 退款总金额，订单总金额，单位为分，只能为整数
     */
    @Required
    @XStreamAlias("refund_fee")
    private int refundFee;

    /**
     * 退款货币类型，需与支付一致，或者不填。符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    @XStreamAlias("refund_fee_type")
    private String refundFeeType;

    /**
     * 退款原因
     * 若商户传入，会在下发给用户的退款消息中体现退款原因
     * 注意：若订单退款金额≤1元，且属于部分退款，则不会在退款消息中体现退款原因
     */
    @XStreamAlias("refund_desc")
    private String refundDesc;

    /**
     * 退款资金来源
     * 仅针对老资金流商户使用
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     */
    @XStreamAlias("refund_account")
    private String refundAccount;

    /**
     * 退款结果通知url
     * 异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数
     * 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。
     */
    @XStreamAlias("notify_url")
    private String notifyUrl;

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

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(int refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "WxPayRefundV2Request{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", outRefundNo='" + outRefundNo + '\'' +
                ", totalFee=" + totalFee +
                ", refundFee=" + refundFee +
                ", refundFeeType='" + refundFeeType + '\'' +
                ", refundDesc='" + refundDesc + '\'' +
                ", refundAccount='" + refundAccount + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {
        private String transactionId;
        private String outTradeNo;
        private String outRefundNo;
        private int totalFee;
        private int refundFee;
        private String refundFeeType;
        private String refundDesc;
        private String refundAccount;
        private String notifyUrl;

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public Builder outRefundNo(String outRefundNo) {
            this.outRefundNo = outRefundNo;
            return this;
        }

        public Builder totalFee(int totalFee) {
            this.totalFee = totalFee;
            return this;
        }

        public Builder refundFee(int refundFee) {
            this.refundFee = refundFee;
            return this;
        }

        public Builder refundFeeType(String refundFeeType) {
            this.refundFeeType = refundFeeType;
            return this;
        }

        public Builder refundDesc(String refundDesc) {
            this.refundDesc = refundDesc;
            return this;
        }

        public Builder refundAccount(String refundAccount) {
            this.refundAccount = refundAccount;
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public WxPayRefundV2Request build() {
            WxPayRefundV2Request refundV2Request = new WxPayRefundV2Request();
            refundV2Request.setAppid(this.appid);
            refundV2Request.setMchid(this.mchid);
            refundV2Request.setNonceStr(this.nonceStr);
            refundV2Request.setTransactionId(this.transactionId);
            refundV2Request.setOutTradeNo(this.outTradeNo);
            refundV2Request.setOutRefundNo(this.outRefundNo);
            refundV2Request.setTotalFee(this.totalFee);
            refundV2Request.setRefundFee(this.refundFee);
            refundV2Request.setRefundFeeType(this.refundFeeType);
            refundV2Request.setRefundDesc(this.refundDesc);
            refundV2Request.setRefundAccount(this.refundAccount);
            refundV2Request.setNotifyUrl(this.notifyUrl);
            if (this.signType != null) {
                refundV2Request.setSignType(this.signType);
            }
            return refundV2Request;
        }
    }

}
