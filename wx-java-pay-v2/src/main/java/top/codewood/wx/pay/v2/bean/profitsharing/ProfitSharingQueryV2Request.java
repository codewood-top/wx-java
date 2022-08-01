package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * 此request不能填下appid
 */
@XStreamAlias("xml")
public class ProfitSharingQueryV2Request extends WxPayBaseRequest {

    /**
     * 微信订单号
     */
    @Required
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户分账单号
     * 查询分账结果，输入申请分账时的商户分账单号； 查询分账完结执行的结果，输入发起分账完结时的商户分账单号
     */
    @Required
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    public ProfitSharingQueryV2Request() {
        signType = WxPayConstants.SignType.HMAC_SHA256;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        private String signType;
        private String transactionId;
        private String outOrderNo;

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder outOrderNo(String outOrderNo) {
            this.outOrderNo = outOrderNo;
            return this;
        }

        public ProfitSharingQueryV2Request build() {
            ProfitSharingQueryV2Request queryRequest = new ProfitSharingQueryV2Request();

            queryRequest.setNonceStr(this.nonceStr);
            queryRequest.setTransactionId(this.transactionId);
            queryRequest.setMchid(this.mchid);
            queryRequest.setOutOrderNo(this.outOrderNo);

            if (this.signType != null) {
                queryRequest.setSignType(this.signType);
            }

            return queryRequest;
        }

    }

    @Override
    public String toString() {
        return "ProfitSharingQueryRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                '}';
    }
}
