package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

@XStreamAlias("xml")
public class ProfitSharingFinishV2Request extends WxPayBaseRequest {

    /**
     * 签名类型
     * 签名类型，目前只支持HMAC-SHA256
     */
    @Required
    @XStreamAlias("sign_type")
    private String signType = WxPayConstants.SignType.HMAC_SHA256;

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

    /**
     * 分账完结的原因描述
     */
    @Required
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        private String signType;
        private String transactionId;
        private String outOrderNo;
        private String description;

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

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ProfitSharingFinishV2Request build() {
            ProfitSharingFinishV2Request finishRequest = new ProfitSharingFinishV2Request();

            finishRequest.setAppid(this.appid);
            finishRequest.setMchid(this.mchid);
            finishRequest.setNonceStr(this.nonceStr);

            if (signType != null) {
                finishRequest.setSignType(this.signType);
            }
            finishRequest.setTransactionId(this.transactionId);
            finishRequest.setOutOrderNo(this.outOrderNo);
            finishRequest.setDescription(this.description);

            return finishRequest;
        }

    }

    @Override
    public String toString() {
        return "ProfitSharingFinishRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
