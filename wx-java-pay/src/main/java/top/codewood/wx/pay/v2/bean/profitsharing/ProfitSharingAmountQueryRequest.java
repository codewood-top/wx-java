package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * 此request不需要传appid
 */
@XStreamAlias("xml")
public class ProfitSharingAmountQueryRequest extends WxPayBaseRequest {

    /**
     * 微信订单号
     */
    @Required
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 签名类型
     * 签名类型，目前只支持HMAC-SHA256
     */
    @Required
    @XStreamAlias("sign_type")
    private String signType = WxPayConstants.SignType.HMAC_SHA256;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        private String transactionId;

        private String signType;

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public ProfitSharingAmountQueryRequest build() {
            ProfitSharingAmountQueryRequest amountQueryRequest = new ProfitSharingAmountQueryRequest();

            amountQueryRequest.setNonceStr(this.nonceStr);
            amountQueryRequest.setMchid(this.mchid);
            amountQueryRequest.setTransactionId(this.transactionId);
            if (this.signType != null) {
                amountQueryRequest.setSignType(this.signType);
            }
            return amountQueryRequest;
        }

    }

    @Override
    public String toString() {
        return "ProfitSharingAmountQueryRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }
}
