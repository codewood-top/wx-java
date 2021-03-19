package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * 此request不能填下appid
 */
@XStreamAlias("xml")
public class ProfitSharingQueryRequest extends WxPayBaseRequest {

    /**
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

        public ProfitSharingQueryRequest build() {
            ProfitSharingQueryRequest queryRequest = new ProfitSharingQueryRequest();

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
