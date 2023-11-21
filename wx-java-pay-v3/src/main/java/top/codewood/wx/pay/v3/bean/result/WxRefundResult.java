package top.codewood.wx.pay.v3.bean.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class WxRefundResult implements Serializable {

    /**
     * 微信支付退款号
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * 商户退款单号
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    @SerializedName("out_refund_no")
    private String outRefundNo;

    /**
     * 微信支付订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * 原支付交易对应的商户订单号
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 退款渠道
     * 枚举值：
     * ORIGINAL：原路退款
     * BALANCE：退回到余额
     * OTHER_BALANCE：原账户异常退到其他余额账户
     * OTHER_BANKCARD：原银行卡异常退到其他银行卡
     */
    private String channel;

    /**
     * 退款入账账户
     * 取当前退款单的退款入账方，有以下几种情况：
     * 1）退回银行卡：{银行名称}{卡类型}{卡尾号}
     * 2）退回支付用户零钱：支付用户零钱
     * 3）退还商户：商户基本账户商户结算银行账户
     * 4）退回支付用户零钱通：支付用户零钱通。
     * 示例值：招商银行信用卡0403
     */
    @SerializedName("user_received_account")
    private String userReceivedAccount;

    /**
     * 退款成功时间
     * 退款成功时间，当退款状态为退款成功时有返回。遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
     * 示例值：2020-12-01T16:18:12+08:00
     */
    @SerializedName("success_time")
    private OffsetDateTime successTime;

    /**
     * 退款创建时间
     * 退款受理时间。 遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
     * 示例值：2020-12-01T16:18:12+08:00
     */
    @SerializedName("create_time")
    private OffsetDateTime createTime;

    /**
     * 退款状态
     * 退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台-交易中心，手动处理此笔退款。
     * 枚举值：
     * SUCCESS：退款成功
     * CLOSED：退款关闭
     * PROCESSING：退款处理中
     * ABNORMAL：退款异常
     * 示例值：SUCCESS
     */
    private String status;

    /**
     * 资金账户
     * 退款所使用资金对应的资金账户类型。 枚举值：
     * UNSETTLED : 未结算资金
     * AVAILABLE : 可用余额
     * UNAVAILABLE : 不可用余额
     * OPERATION : 运营户
     * 示例值：UNSETTLED
     */
    @SerializedName("funds_account")
    private String fundsAccount;

    /**
     * 金额信息
     * 金额详细信息。
     */
    private Amount amount;

    /**
     * 优惠退款信息
     */
    @SerializedName("promotion_detail")
    private PromotionDetail[] promotionDetails;

    public static class Amount implements Serializable {

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
        @SerializedName("payer_total")
        private int payerTotal;

        /**
         * 用户退款金额
         * 退款给用户的金额，不包含所有优惠券金额。
         */
        @SerializedName("payer_refund")
        private int payerRefund;

        /**
         * 应结退款金额
         * 去掉非充值代金券退款金额后的退款金额，单位为分，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额。
         */
        @SerializedName("settlement_refund")
        private int settlementRefund;

        /**
         * 应结订单金额
         * 应结订单金额=订单金额-免充值代金券金额，应结订单金额<=订单金额，单位为分。
         */
        @SerializedName("settlement_total")
        private int settlementTotal;

        /**
         * 优惠退款金额
         * 优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠，单位为分。
         */
        @SerializedName("discount_refund")
        private int discountRefund;

        /**
         * 退款币种
         * 符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。
         */
        private String currency;

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

        public int getSettlementRefund() {
            return settlementRefund;
        }

        public void setSettlementRefund(int settlementRefund) {
            this.settlementRefund = settlementRefund;
        }

        public int getSettlementTotal() {
            return settlementTotal;
        }

        public void setSettlementTotal(int settlementTotal) {
            this.settlementTotal = settlementTotal;
        }

        public int getDiscountRefund() {
            return discountRefund;
        }

        public void setDiscountRefund(int discountRefund) {
            this.discountRefund = discountRefund;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public static class PromotionDetail {

        /**
         * 券ID
         * 券或者立减优惠id。
         */
        @SerializedName("promotion_id")
        private String promotionId;

        /**
         * 优惠范围
         * 枚举值：
         * GLOBAL：全场代金券
         * SINGLE：单品优惠
         * 示例值：SINGLE
         */
        private String scope;

        /**
         * 优惠类型
         * 枚举值：
         * COUPON：代金券，需要走结算资金的充值型代金券
         * DISCOUNT：优惠券，不走结算资金的免充值型优惠券
         * 示例值：DISCOUNT
         */
        private String type;

        /**
         * 优惠券面额
         * 用户享受优惠的金额（优惠券面额=微信出资金额+商家出资金额+其他出资方金额 ），单位为分。
         */
        private int amount;

        /**
         * 优惠退款金额
         * 优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为用户支付的现金，说明详见代金券或立减优惠，单位为分。
         */
        @SerializedName("refund_amount")
        private int refundAmount;

        /**
         * 商品列表
         * 优惠商品发生退款时返回商品信息。
         */
        @SerializedName("goods_detail")
        private GoodsDetail[] goodsDetails;

        public String getPromotionId() {
            return promotionId;
        }

        public void setPromotionId(String promotionId) {
            this.promotionId = promotionId;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(int refundAmount) {
            this.refundAmount = refundAmount;
        }

        public GoodsDetail[] getGoodsDetails() {
            return goodsDetails;
        }

        public void setGoodsDetails(GoodsDetail[] goodsDetails) {
            this.goodsDetails = goodsDetails;
        }
    }

    public static class GoodsDetail implements Serializable {

        /**
         * 商户侧商品编码
         * 由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。
         */
        @SerializedName("merchant_goods_id")
        private String merchantGoodsId;

        /**
         * 微信侧商品编码
         * 微信支付定义的统一商品编号（没有可不传）。
         */
        @SerializedName("wechatpay_goods_id")
        private String wechatPayGoodsId;

        /**
         * 商品名称
         * 商品的实际名称。
         */
        @SerializedName("goods_name")
        private String goodsName;

        /**
         * 商品单价
         * 商品单价金额，单位为分。
         */
        @SerializedName("unit_price")
        private int unitPrice;

        /**
         * 商品退款金额
         * 商品退款金额，单位为分。
         */
        @SerializedName("refund_amount")
        private int refundAmount;

        /**
         * 商品退货数量
         * 单品的退款数量。
         */
        @SerializedName("refund_quantity")
        private int refundQuantity;

        public String getMerchantGoodsId() {
            return merchantGoodsId;
        }

        public void setMerchantGoodsId(String merchantGoodsId) {
            this.merchantGoodsId = merchantGoodsId;
        }

        public String getWechatPayGoodsId() {
            return wechatPayGoodsId;
        }

        public void setWechatPayGoodsId(String wechatPayGoodsId) {
            this.wechatPayGoodsId = wechatPayGoodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(int unitPrice) {
            this.unitPrice = unitPrice;
        }

        public int getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(int refundAmount) {
            this.refundAmount = refundAmount;
        }

        public int getRefundQuantity() {
            return refundQuantity;
        }

        public void setRefundQuantity(int refundQuantity) {
            this.refundQuantity = refundQuantity;
        }
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUserReceivedAccount() {
        return userReceivedAccount;
    }

    public void setUserReceivedAccount(String userReceivedAccount) {
        this.userReceivedAccount = userReceivedAccount;
    }

    public OffsetDateTime getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(OffsetDateTime successTime) {
        this.successTime = successTime;
    }

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFundsAccount() {
        return fundsAccount;
    }

    public void setFundsAccount(String fundsAccount) {
        this.fundsAccount = fundsAccount;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public PromotionDetail[] getPromotionDetails() {
        return promotionDetails;
    }

    public void setPromotionDetails(PromotionDetail[] promotionDetails) {
        this.promotionDetails = promotionDetails;
    }

    @Override
    public String toString() {
        return "WxRefundResult{" +
                "refundId='" + refundId + '\'' +
                ", outRefundNo='" + outRefundNo + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", channel='" + channel + '\'' +
                ", userReceivedAccount='" + userReceivedAccount + '\'' +
                ", successTime=" + successTime +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", fundsAccount='" + fundsAccount + '\'' +
                ", amount=" + amount +
                ", promotionDetails=" + promotionDetails +
                '}';
    }
}
