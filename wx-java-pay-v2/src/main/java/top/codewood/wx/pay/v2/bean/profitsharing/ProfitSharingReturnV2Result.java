package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 此Result只需验证 return_code == SUCCESS | FAIL
 */
@XStreamAlias("xml")
public class ProfitSharingReturnV2Result implements Serializable {

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
     * 调用接口提供的公众账号ID
     */
    private String appid;

    /**
     * 微信返回的随机字符串
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 微信返回的签名
     */
    private String sign;

    /**
     * 微信分账单号
     * 原发起分账请求时，微信返回的微信分账单号
     */
    @XStreamAlias("order_id")
    private String orderId;

    /**
     * 商户分账单号
     * 原发起分账请求时使用的商户系统内部的分账单号。
     */
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    /**
     * 商户回退单号
     * 调用接口提供的商户系统内部的回退单号
     */
    @XStreamAlias("out_return_no")
    private String outReturnNo;

    /**
     * 微信回退单号
     * 微信分账回退单号，微信系统返回的唯一标识
     */
    @XStreamAlias("return_no")
    private String returnNo;

    /**
     * 回退方类型
     * 枚举值：
     * MERCHANT_ID：商户号（mch_id或者sub_mch_id）
     */
    @XStreamAlias("return_account_type")
    private String returnAccountType;

    /**
     * 回退方账号
     * 回退方类型是MERCHANT_ID时，商户号（mch_id或者sub_mch_id）
     */
    @XStreamAlias("return_account")
    private String returnAccount;

    /**
     * 回退金额，整数，单位为分
     */
    @XStreamAlias("return_amount")
    private int returnAmount;

    /**
     * 回退描述
     * 分账回退的原因描述
     */
    private String description;

    /**
     * 回退结果
     * 枚举值：
     * PROCESSING:处理中
     * SUCCESS:已成功
     * FAILED: 已失败
     * 如果返回为处理中，请勿变更商户回退单号，使用相同的参数再次发起分账回退，否则会出现资金风险
     * 在处理中状态的回退单如果5天没有成功，会因为超时被设置为已失败
     */
    private String result;

    /**
     * 失败原因
     * 枚举值：
     * ACCOUNT_ABNORMAL:分账接收方账户异常
     * TIME_OUT_CLOSED: 超时关单
     * 此字段仅回退结果为FAILED时存在
     */
    @XStreamAlias("fail_reason")
    private String failReason;

    /**
     * 完成时间
     * 分账回退完成时间
     * ex: 20180608170132
     */
    @XStreamAlias("finish_time")
    private String finishTime;

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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOutReturnNo() {
        return outReturnNo;
    }

    public void setOutReturnNo(String outReturnNo) {
        this.outReturnNo = outReturnNo;
    }

    public String getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

    public String getReturnAccountType() {
        return returnAccountType;
    }

    public void setReturnAccountType(String returnAccountType) {
        this.returnAccountType = returnAccountType;
    }

    public String getReturnAccount() {
        return returnAccount;
    }

    public void setReturnAccount(String returnAccount) {
        this.returnAccount = returnAccount;
    }

    public int getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(int returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "ProfitSharingReturnResult{" +
                "returnCode='" + returnCode + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", mchid='" + mchid + '\'' +
                ", appid='" + appid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", orderId='" + orderId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", outReturnNo='" + outReturnNo + '\'' +
                ", returnNo='" + returnNo + '\'' +
                ", returnAccountType='" + returnAccountType + '\'' +
                ", returnAccount='" + returnAccount + '\'' +
                ", returnAmount=" + returnAmount +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                ", failReason='" + failReason + '\'' +
                ", finishTime='" + finishTime + '\'' +
                '}';
    }
}
