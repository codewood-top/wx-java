package top.codewood.wx.pay.v2.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * transaction_id || out_trade_no 二选一
 */
@XStreamAlias("xml")
public class WxPayOrderQueryV2Request extends WxPayBaseRequest {

    /**
     * 微信的订单号，建议优先使用
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

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

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {
        private String transactionId;
        private String outTradeNo;

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }


        public WxPayOrderQueryV2Request build() {
            WxPayOrderQueryV2Request orderQueryV2Request = new WxPayOrderQueryV2Request();
            orderQueryV2Request.setAppid(this.appid);
            orderQueryV2Request.setMchid(this.mchid);
            orderQueryV2Request.setNonceStr(this.nonceStr);
            if (this.transactionId != null) {
                orderQueryV2Request.setTransactionId(this.transactionId);
            }
            if (this.outTradeNo != null) {
                orderQueryV2Request.setOutTradeNo(this.outTradeNo);
            }
            if (this.signType != null) {
                orderQueryV2Request.setSignType(this.signType);
            }
            return orderQueryV2Request;
        }

    }

    @Override
    public String toString() {
        return "WxPayOrderQueryV2Request{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }
}
