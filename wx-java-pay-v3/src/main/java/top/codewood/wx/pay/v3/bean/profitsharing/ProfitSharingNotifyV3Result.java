package top.codewood.wx.pay.v3.bean.profitsharing;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ProfitSharingNotifyV3Result implements Serializable {

    /**
     * 商户号
     */
    private String mchid;
    /**
     * 微信订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 微信分账/回退单号
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 商户分账/回退单号
     * 分账方系统内部的分账/回退单号
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 成功时间，遵循rfc3339标准
     * 格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     */
    @SerializedName("success_time")
    private OffsetDateTime successTime;

    public static class Receiver implements Serializable {
        /**
         * 分账接收方的类型，枚举值：
         * MERCHANT_ID：商户
         * PERSONAL_OPENID：个人
         */
        private String type;
        /**
         * 分账接收方的账号
         * 类型是MERCHANT_ID时，是商户号
         * 类型是PERSONAL_OPENID时，是个人openid
         */
        private String account;
        /**
         * 分账动账金额，单位为分，只能为整数
         */
        private Integer amount;
        /**
         * 分账/回退描述
         */
        private String description;

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

        @Override
        public String toString() {
            return "Receiver{" +
                    "type='" + type + '\'' +
                    ", account='" + account + '\'' +
                    ", amount=" + amount +
                    ", description='" + description + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "ProfitSharingNotifyV3Result{" +
                "mchid='" + mchid + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", successTime=" + successTime +
                '}';
    }
}
