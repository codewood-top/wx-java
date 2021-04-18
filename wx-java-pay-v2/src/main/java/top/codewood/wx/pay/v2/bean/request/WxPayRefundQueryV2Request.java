package top.codewood.wx.pay.v2.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * transactionId || outTradeNo || outRefundNo || refundId 四选一
 */
@XStreamAlias("xml")
public class WxPayRefundQueryV2Request extends WxPayBaseRequest {

    /**
     * 微信订单号
     * 微信订单号查询的优先级是： refund_id > out_refund_no > transaction_id > out_trade_no
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
     * 微信生成的退款单号，在申请退款接口有返回
     */
    @XStreamAlias("refund_id")
    private String refundId;

    /**
     * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
     */
    private int offset;

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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "WxPayRefundQueryRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", outRefundNo='" + outRefundNo + '\'' +
                ", refundId='" + refundId + '\'' +
                ", offset=" + offset +
                '}';
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        private String transactionId;
        private String outTradeNo;
        private String outRefundNo;
        private String refundId;
        private Integer offset;

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

        public Builder refundId(String refundId) {
            this.refundId = refundId;
            return this;
        }

        public Builder offset(int offset) {
            this.offset = offset;
            return this;
        }

        public WxPayRefundQueryV2Request build() {
            WxPayRefundQueryV2Request queryRequest = new WxPayRefundQueryV2Request();
            queryRequest.setAppid(this.appid);
            queryRequest.setMchid(this.mchid);
            queryRequest.setNonceStr(this.nonceStr);
            queryRequest.setTransactionId(this.transactionId);
            queryRequest.setOutRefundNo(this.outRefundNo);
            queryRequest.setOutTradeNo(this.outTradeNo);
            queryRequest.setRefundId(this.refundId);
            queryRequest.setOffset(this.offset);

            if (signType != null) {
                queryRequest.setSignType(this.signType);
            }

            return queryRequest;
        }

    }
}
