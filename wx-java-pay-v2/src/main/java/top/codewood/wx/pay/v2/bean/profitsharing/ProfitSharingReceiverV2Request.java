package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

@XStreamAlias("xml")
public class ProfitSharingReceiverV2Request extends WxPayBaseRequest {

    /**
     * 分账接收方
     * 分账接收方对象，json格式
     */
    private String receiver;

    public ProfitSharingReceiverV2Request() {
        signType = WxPayConstants.SignType.HMAC_SHA256;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        private String signType;
        private String receiver;

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public Builder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public ProfitSharingReceiverV2Request build() {
            ProfitSharingReceiverV2Request receiverRequest = new ProfitSharingReceiverV2Request();
            receiverRequest.setNonceStr(this.nonceStr);
            receiverRequest.setMchid(this.mchid);
            receiverRequest.setAppid(this.appid);
            receiverRequest.setReceiver(this.receiver);

            if (this.signType != null) {
                receiverRequest.setSignType(this.signType);
            }

            return receiverRequest;
        }
    }

    @Override
    public String toString() {
        return "ProfitSharingReceiverRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", receiver='" + receiver + '\'' +
                '}';
    }
}
