package top.codewood.wx.pay.v3.bean.notify;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class WxRefundTransaction implements Serializable {

    /**
     * 直连商户号
     * 直连商户的商户号，由微信支付生成并下发。
     */
    private String mchid;

    /**
     * 商户订单号
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 微信支付订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户退款单号
     */
    @SerializedName("out_refund_no")
    private String outRefundNo;

    /**
     * 微信支付退款号
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * 退款状态
     * 退款状态，枚举值：
     * SUCCESS：退款成功
     * CLOSE：退款关闭
     * ABNORMAL：退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往【服务商平台—>交易中心】，手动处理此笔退款
     */
    @SerializedName("refund_status")
    private String refundStatus;

    /**
     * 退款成功时间
     * 1、退款成功时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
     * 2、当退款状态为退款成功时返回此参数。
     */
    @SerializedName("success_time")
    private OffsetDateTime successTime;

    /**
     * 退款入账账户
     * 取当前退款单的退款入账方。
     * 1、退回银行卡：{银行名称}{卡类型}{卡尾号}
     * 2、退回支付用户零钱: 支付用户零钱
     * 3、退还商户: 商户基本账户、商户结算银行账户
     * 4、退回支付用户零钱通：支付用户零钱通
     */
    @SerializedName("user_received_account")
    private String userReceivedAccount;

    /**
     * 金额信息
     */
    private Amount amount;

    /**
     * 金额信息
     */
    public static class Amount {

        /**
         * 订单金额
         * 订单总金额，单位为分，只能为整数，详见支付金额
         * 示例值：999
         */
        private int total;

        /**
         * 退款金额
         * 退款金额，币种的最小单位，只能为整数，不能超过原订单支付金额，如果有使用券，后台会按比例退。
         */
        private int refund;

        /**
         * 用户支付金额
         * 用户实际支付金额，单位为分，只能为整数，详见支付金额
         */
        private int payerTotal;

        /**
         * 用户退款金额
         * 退款给用户的金额，不包含所有优惠券金额
         */
        private int payerRefund;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getRefund() {
            return refund;
        }

        public void setRefund(int refund) {
            this.refund = refund;
        }

        public int getPayerTotal() {
            return payerTotal;
        }

        public void setPayerTotal(int payerTotal) {
            this.payerTotal = payerTotal;
        }

        public int getPayerRefund() {
            return payerRefund;
        }

        public void setPayerRefund(int payerRefund) {
            this.payerRefund = payerRefund;
        }

        @Override
        public String toString() {
            return "Amount{" +
                    "total=" + total +
                    ", refund=" + refund +
                    ", payerTotal=" + payerTotal +
                    ", payerRefund=" + payerRefund +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "WxRefundTransaction{" +
                "mchid='" + mchid + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outRefundNo='" + outRefundNo + '\'' +
                ", refundId='" + refundId + '\'' +
                ", refundStatus='" + refundStatus + '\'' +
                ", successTime=" + successTime +
                ", userReceivedAccount='" + userReceivedAccount + '\'' +
                ", amount=" + amount +
                '}';
    }
}
