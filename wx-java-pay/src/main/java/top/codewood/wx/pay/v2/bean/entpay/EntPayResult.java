package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

@XStreamAlias("xml")
public class EntPayResult extends WxPayBaseResult {

    /**
     * 商户appid
     * 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）
     */
    @XStreamAlias("mch_appid")
    private String mchAppid;

    /**
     * 商户号
     * 微信支付分配的商户号
     */
    @XStreamAlias("mchid")
    private String mchId;

    /**
     * 随机字符串
     * 随机字符串，不长于32位
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 商户订单号
     * 商户订单号，需保持历史全局唯一性(只能是字母或者数字，不能包含有其它字符)
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 微信付款单号
     * 企业付款成功，返回的微信付款单号
     */
    @XStreamAlias("payment_no")
    private String paymentNo;

    /**
     * 付款成功时间
     * 企业付款成功时间
     * ex: 2015-05-19 15：26：59
     */
    @XStreamAlias("payment_time")
    private String paymentTime;

    public String getMchAppid() {
        return mchAppid;
    }

    public void setMchAppid(String mchAppid) {
        this.mchAppid = mchAppid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "EntPayResult{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", mchAppid='" + mchAppid + '\'' +
                ", mchId='" + mchId + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", partnerTradeNo='" + partnerTradeNo + '\'' +
                ", paymentNo='" + paymentNo + '\'' +
                ", paymentTime='" + paymentTime + '\'' +
                '}';
    }
}
