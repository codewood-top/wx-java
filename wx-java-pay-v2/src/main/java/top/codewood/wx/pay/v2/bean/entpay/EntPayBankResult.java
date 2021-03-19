package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

@XStreamAlias("xml")
public class EntPayBankResult extends WxPayBaseResult {

    /**
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * 商户订单号，需要保持唯一
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 代付金额RMB:分
     */
    private int amount;

    /**
     * 随机字符串，长度小于32位
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 返回包携带签名给商户
     */
    private String sign;

    /**
     * 微信企业付款单号
     * 代付成功后，返回的内部业务单号
     */
    @XStreamAlias("payment_no")
    private String paymentNo;

    /**
     * 手续费金额
     * 	手续费金额 RMB：分
     */
    @XStreamAlias("cmms_amt")
    private String cmmsAmt;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getCmmsAmt() {
        return cmmsAmt;
    }

    public void setCmmsAmt(String cmmsAmt) {
        this.cmmsAmt = cmmsAmt;
    }

    @Override
    public String toString() {
        return "EntPayBankResult{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", mchId='" + mchId + '\'' +
                ", partnerTradeNo='" + partnerTradeNo + '\'' +
                ", amount=" + amount +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", paymentNo='" + paymentNo + '\'' +
                ", cmmsAmt='" + cmmsAmt + '\'' +
                '}';
    }
}
