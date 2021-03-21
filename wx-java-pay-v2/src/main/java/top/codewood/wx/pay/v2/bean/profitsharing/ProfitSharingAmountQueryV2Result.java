package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

import java.io.Serializable;

/**
 * 此Result只需验证 return_code == SUCCESS | FAIL
 *
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_10&index=7">开发文档</a>
 *
 */
@XStreamAlias("xml")
public class ProfitSharingAmountQueryV2Result extends WxPayBaseResult {

    /**
     * 调用接口时提供的商户号
     */
    @XStreamAlias("mch_id")
    private String mchid;

    /**
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 订单剩余待分金额，整数，单位为分
     */
    @XStreamAlias("unsplit_amount")
    private int unSplitAmount;

    /**
     * 微信返回的随机字符串
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 微信返回的签名
     */
    @XStreamAlias("sign")
    private String sign;


    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getUnSplitAmount() {
        return unSplitAmount;
    }

    public void setUnSplitAmount(int unSplitAmount) {
        this.unSplitAmount = unSplitAmount;
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
        return "ProfitSharingAmountQueryV2Result{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", mchid='" + mchid + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", unSplitAmount=" + unSplitAmount +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
