package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

@XStreamAlias("xml")
public class ProfitSharingQueryV2Result extends WxPayBaseResult {

    /**
     * 调用接口时提供的商户号
     */
    @XStreamAlias("mch_id")
    private String mchid;

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
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户分账单号
     * 商户系统内部的分账单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一分账单号多次请求等同一次。
     */
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    /**
     * 微信分账单号
     */
    @XStreamAlias("order_id")
    private String orderId;

    /**
     * 分账单状态：
     * PROCESSING—处理中
     * FINISHED—处理完成
     */
    private String status;

    /**
     * 关单原因
     * NO_AUTH:分账授权已解除
     */
    @XStreamAlias("close_reason")
    private String closeReason;

    /**
     * 分账接收方列表
     * 分账接收方列表，不超过50个json对象，仅当查询分账结果时，存在本字段
     *
     */
    private String receivers;

    /**
     * 分账金额
     * 分账完结的分账金额，单位为分， 仅当查询分账完结的执行结果时，存在本字段
     */
    private int amount;

    /**
     * 分账描述
     * 分账完结的原因描述，仅当查询分账完结的执行结果时，存在本字段
     */
    private String description;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getReceivers() {
        return receivers;
    }

    public void setReceivers(String receivers) {
        this.receivers = receivers;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProfitSharingQueryResult{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", status='" + status + '\'' +
                ", closeReason='" + closeReason + '\'' +
                ", receivers='" + receivers + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
