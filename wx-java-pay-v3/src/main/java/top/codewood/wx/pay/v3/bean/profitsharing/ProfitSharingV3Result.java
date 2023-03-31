package top.codewood.wx.pay.v3.bean.profitsharing;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

public class ProfitSharingV3Result implements Serializable {

    /**
     * 微信支付订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;
    /**
     * 商户分账单号
     * 商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次。只能是数字、大小写字母_-|*@
     */
    @SerializedName("out_order_no")
    private String outOrderNo;
    /**
     * 微信分账单号
     * 微信分账单号，微信支付系统返回的唯一标识
     */
    @SerializedName("order_id")
    private String orderId;
    /**
     * 分账单状态
     * 分账单状态（每个接收方的分账结果请查看receivers中的result字段），枚举值：
     * 1、PROCESSING：处理中
     * 2、FINISHED：分账完成
     */
    private String state;
    /**
     * 分账接收方列表
     */
    private List<Receiver> receivers;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receiver> receivers) {
        this.receivers = receivers;
    }

    public static class Receiver implements Serializable {

        /**
         * 分账金额
         * 分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
         */
        private Integer amount;
        /**
         * 分账描述
         * 分账的原因描述，分账账单中需要体现
         */
        private String description;
        /**
         * 接收方类型
         * 1、MERCHANT_ID：商户号
         * 2、PERSONAL_OPENID：个人openid（由父商户APPID转换得到）
         */
        private String type;
        /**
         * 接收方账号
         * 1、分账接收方类型为MERCHANT_ID时，分账接收方账号为商户号
         * 2、分账接收方类型为PERSONAL_OPENID时，分账接收方账号为个人openid
         */
        private String account;
        /**
         * 分账结果
         * 枚举值：
         * 1、PENDING：待分账
         * 2、SUCCESS：分账成功
         * 3、CLOSED：已关闭
         */
        private String result;
        /**
         * 分账失败原因
         * 当分账结果result为CLOSED（已关闭）时，返回该字段
         * 枚举值：
         * 1、ACCOUNT_ABNORMAL：分账接收账户异常
         * 2、NO_RELATION：分账关系已解除
         * 3、RECEIVER_HIGH_RISK：高风险接收方
         * 4、RECEIVER_REAL_NAME_NOT_VERIFIED：接收方未实名
         * 5、NO_AUTH：分账权限已解除
         * 6、RECEIVER_RECEIPT_LIMIT：接收方已达收款限额
         * 7、PAYER_ACCOUNT_ABNORMAL：分出方账户异常
         */
        @SerializedName("fail_reason")
        private String failReason;
        /**
         * 分账创建时间
         * 遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
         */
        @SerializedName("create_time")
        private OffsetDateTime createTime;
        /**
         * 分账完成时间
         * 遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
         */
        @SerializedName("finish_time")
        private OffsetDateTime finishTime;
        /**
         * 分账明细单号
         * 微信分账明细单号，每笔分账业务执行的明细单号，可与资金账单对账使用
         */
        @SerializedName("detail_id")
        private String detailId;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
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

        public String getDetailId() {
            return detailId;
        }

        public void setDetailId(String detailId) {
            this.detailId = detailId;
        }
    }

    @Override
    public String toString() {
        return "ProfitSharingV3Result{" +
                "transactionId='" + transactionId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", state='" + state + '\'' +
                ", receivers=" + receivers +
                '}';
    }
}
