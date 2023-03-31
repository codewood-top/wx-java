package top.codewood.wx.pay.v3.bean.profitsharing;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ProfitSharingReturnV3Result implements Serializable {

    /**
     * 微信分账单号
     * 微信分账单号，微信支付系统返回的唯一标识
     */
    @SerializedName("order_id")
    private String orderId;
    /**
     * 商户分账单号
     * 商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次。 取值范围：[0-9a-zA-Z_*@-]
     */
    @SerializedName("out_order_no")
    private String outOrderNo;
    /**
     * 商户回退单号
     * 此回退单号是商户在自己后台生成的一个新的回退单号，在商户后台唯一
     */
    @SerializedName("out_return_no")
    private String outReturnNo;
    /**
     * 微信回退单号
     * 微信分账回退单号，微信支付系统返回的唯一标识
     */
    @SerializedName("return_id")
    private String returnId;
    /**
     * 回退商户号
     * 只能对原分账请求中成功分给商户接收方进行回退
     */
    @SerializedName("return_mchid")
    private String returnMchid;
    /**
     * 回退金额
     * 需要从分账接收方回退的金额，单位为分，只能为整数
     */
    private Integer amount;
    /**
     * 回退描述
     * 分账回退的原因描述
     */
    private String description;
    /**
     * 回退结果
     * 如果请求返回为处理中，则商户可以通过调用回退结果查询接口获取请求的最终处理结果。如果查询到回退结果在处理中，请勿变更商户回退单号，使用相同的参数再次发起分账回退，否则会出现资金风险。在处理中状态的回退单如果5天没有成功，会因为超时被设置为已失败。
     * 枚举值：
     * PROCESSING：处理中
     * SUCCESS：已成功
     * FAILED：已失败
     */
    private String result;
    /**
     * 失败原因。
     * 包含以下枚举值：
     * ACCOUNT_ABNORMAL：原分账接收方账户异常
     * TIME_OUT_CLOSED：超时关单
     * PAYER_ACCOUNT_ABNORMAL：原分账分出方账户异常
     */
    @SerializedName("fail_reason")
    private String failReason;
    /**
     * 分账回退创建时间，
     * 遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     */
    @SerializedName("create_time")
    private OffsetDateTime createTime;
    /**
     * 分账回退完成时间，
     * 遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     */
    @SerializedName("finish_time")
    private OffsetDateTime finishTime;

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

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getReturnMchid() {
        return returnMchid;
    }

    public void setReturnMchid(String returnMchid) {
        this.returnMchid = returnMchid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public OffsetDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(OffsetDateTime finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "ProfitSharingReturnV3Result{" +
                "orderId='" + orderId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", outReturnNo='" + outReturnNo + '\'' +
                ", returnId='" + returnId + '\'' +
                ", returnMchid='" + returnMchid + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                ", failReason='" + failReason + '\'' +
                ", createTime=" + createTime +
                ", finishTime=" + finishTime +
                '}';
    }
}
