package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_1&index=1">参考文档</a>
 */
@XStreamAlias("xml")
public class ProfitSharingV2Request extends WxPayBaseRequest {

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
     * 商户系统内部的分账单号，在商户系统内部唯一（单次分账、多次分账、完结分账应使用不同的商户分账单号），同一分账单号多次请求等同一次。只能是数字、大小写字母_-|*@
     */
    @Required
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    /**
     * 分账接收方列表
     * 分账接收方列表，不超过50个json对象，不能设置分账方作为分账接受方
     *
     * [
     *     {
     *          "type": "MERCHANT_ID",
     *          "account":"190001001",
     *          "amount":100,
     *          "description": "分到商户"
     *      },
     *     {
     *          "type": "PERSONAL_OPENID",
     *          "account":"86693952",
     *          "amount":888,
     *          "description": "分到个人"
     *      }
     * ]
     *
     */
    @Required
    private String receivers;


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

    public String getReceivers() {
        return receivers;
    }

    public void setReceivers(String receivers) {
        this.receivers = receivers;
    }


    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        private String signType;
        private String transactionId;
        private String outOrderNo;
        private String receivers;

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

        public Builder receivers(String receivers) {
            this.receivers = receivers;
            return this;
        }

        public ProfitSharingV2Request build() {
            ProfitSharingV2Request request = new ProfitSharingV2Request();
            request.setMchid(this.mchid);
            request.setAppid(this.appid);
            request.setNonceStr(this.nonceStr);
            request.setTransactionId(this.transactionId);
            request.setOutOrderNo(this.outOrderNo);
            request.setReceivers(this.receivers);
            if (this.signType != null) {
                request.setSignType(this.signType);
            }
            return request;
        }

    }

    @Override
    public String toString() {
        return "ProfitSharingRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", receivers='" + receivers + '\'' +
                '}';
    }
}
