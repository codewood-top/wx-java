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
public class ProfitSharingAmountQueryResult implements Serializable {

    /**
     * 返回状态码
     * 枚举值：
     * SUCCESS：分账回退处理成功
     * FAIL：分账回退处理失败
     */
    @XStreamAlias("return_code")
    private String returnCode;

    /**
     * 错误代码
     * 如果返回状态码为FAIL，则本字段存在，且为失败的错误码
     * 详见错误码列表
     */
    @XStreamAlias("error_code")
    private String errorCode;

    /**
     * 返回信息
     * 如果返回状态码为FAIL，则本字段存在，且为失败的错误信息
     */
    @XStreamAlias("error_msg")
    private String errorMsg;

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
    @XStreamAlias("un_split_amount")
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

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

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
}
