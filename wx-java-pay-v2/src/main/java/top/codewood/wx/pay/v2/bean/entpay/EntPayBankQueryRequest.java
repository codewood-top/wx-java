package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;

import java.io.Serializable;

@XStreamAlias("xml")
public class EntPayBankQueryRequest implements Serializable {

    /**
     * 商户号
     * 微信支付分配的商户号
     */
    @Required
    @XStreamAlias("mch_id")
    private String mchid;

    /**
     * 商户企业付款单号
     * 商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]最短8位，最长32位）
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 随机字符串
     * 随机字符串，长度小于32位
     */
    @Required
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 签名
     * 详见<a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=4_3">参考文档</a>
     */
    private String sign;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "EntPayBankQueryRequest{" +
                "mchid='" + mchid + '\'' +
                ", partnerTradeNo='" + partnerTradeNo + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    public static class Builder {
        private String mchid;
        private String partnerTradeNo;
        private String nonceStr;

        public Builder mchid(String mchid) {
            this.mchid = mchid;
            return this;
        }

        public Builder partnerTradeNo(String partnerTradeNo) {
            this.partnerTradeNo = partnerTradeNo;
            return this;
        }

        public Builder nonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return this;
        }


        public EntPayBankQueryRequest build() {
            EntPayBankQueryRequest request = new EntPayBankQueryRequest();
            request.setMchid(this.mchid);
            request.setPartnerTradeNo(this.partnerTradeNo);
            request.setNonceStr(this.nonceStr);
            return request;
        }

    }

}
