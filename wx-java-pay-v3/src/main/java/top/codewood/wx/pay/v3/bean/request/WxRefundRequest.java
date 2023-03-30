package top.codewood.wx.pay.v3.bean.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxRefundRequest implements Serializable {

    /**
     * 必填：transactionId、outTradeNo 二选一
     * 微信支付订单号
     * 原支付交易对应的微信订单号。
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 必填：transactionId、outTradeNo 二选一
     * 商户订单号
     * 原支付交易对应的商户订单号。
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 必填：否
     * 商户退款单号
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    @SerializedName("out_refund_no")
    private String outRefundNo;

    /**
     * 必填：否
     * 退款原因
     * 若商户传入，会在下发给用户的退款消息中体现退款原因。
     * 示例值：商品已售完
     */
    private String reason;

    /**
     * 必填：否
     * 退款结果回调url
     * 异步接收微信支付退款结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
     * 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效，优先回调当前传的这个地址。
     */
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 必填：否
     * 退款资金来源
     * 若传递此参数则使用对应的资金账户退款，否则默认使用未结算资金退款（仅对老资金流商户适用）。
     * 枚举值：
     * AVAILABLE：可用余额账户
     * 示例值：AVAILABLE
     */
    @SerializedName("funds_account")
    private String fundsAccount;

    /**
     * 必填： 是
     * 金额信息
     */
    private Amount amount;

    /**
     * 退款商品
     * 指定商品退款需要传此参数，其他场景无需传递。
     */
    @SerializedName("goods_detail")
    private GoodsDetail goodsDetail;


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

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
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

    public void setAmount(int total, int refund) {
        this.amount = new Amount(total, refund);
    }

    public GoodsDetail getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(GoodsDetail goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    /**
     * 订单金额信息
     */
    public static class Amount implements Serializable {


        /**
         * 必填：否
         * 退款出资账户及金额
         * 退款需要从指定账户出资时，传递此参数指定出资金额（币种的最小单位，只能为整数）。
         * 同时指定多个账户出资退款的使用场景需要满足以下条件：
         *   1、未开通退款支出分离产品功能；
         *   2、订单属于分账订单，且分账处于待分账或分账中状态。
         * 参数传递需要满足条件：
         *   1、基本账户可用余额出资金额与基本账户不可用余额出资金额之和等于退款金额；
         *   2、账户类型不能重复。
         * 上述任一条件不满足将返回错误
         */
        private From[] from;

        /**
         * 必填：是
         * 原支付交易的订单总金额，币种的最小单位，只能为整数
         */
        private int total;

        /**
         * 必填：是
         * CNY：人民币，境内商户号仅支持人民币
         */
        private String currency = "CNY";

        /**
         * 必填：是
         * 退款金额
         * 退款金额，币种的最小单位，只能为整数，不能超过原订单支付金额。
         */
        private int refund;

        public Amount() {}

        public Amount(int total) {
            this.total = total;
        }

        public Amount(int total, int refund) {
            this.total = total;
            this.refund = refund;
        }

        public Amount(int total, String currency) {
            this.total = total;
            this.currency = currency;
        }

        public From[] getFrom() {
            return from;
        }

        public void setFrom(From[] from) {
            this.from = from;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getRefund() {
            return refund;
        }

        public void setRefund(int refund) {
            this.refund = refund;
        }
    }

    /**
     * 单品列表信息
     */
    public static class GoodsDetail implements Serializable {

        /**
         * 商户侧商品编码
         * 由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。
         */
        @SerializedName("merchant_goods_id")
        private String merchantGoodsId;
        /**
         * 微信侧商品编码
         * 微信支付定义的统一商品编号（没有可不传）
         */
        @SerializedName("wechatpay_goods_id")
        private String wechatPayGoodsId;
        /**
         * 商品名称
         * 商品的实际名称
         */
        @SerializedName("goods_name")
        private String goodsName;
        /**
         * 商品数量
         * 用户购买的数量
         */
        private int quantity;
        /**
         * 商品单价
         * 商品单价，单位为分
         */
        @SerializedName("unit_price")
        private int unitPrice;

        /**
         * 商品退款金额
         * 商品退款金额，单位为分。
         * 示例值：528800
         */
        @SerializedName("refund_amount")
        private int refundAmount;

        /**
         * 商品退货数量
         * 单品的退款数量。
         * 示例值：1
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

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
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


    public static class From implements Serializable {
        /**
         * 必填：是
         * 出资账户类型
         * 下面枚举值多选一。
         * 枚举值：
         * AVAILABLE : 可用余额
         * UNAVAILABLE : 不可用余额
         * 示例值：AVAILABLE
         */
        private String account;

        /**
         * 必填：是
         * 对应账户出资金额
         * 示例值：444
         */
        private int amount;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

}
