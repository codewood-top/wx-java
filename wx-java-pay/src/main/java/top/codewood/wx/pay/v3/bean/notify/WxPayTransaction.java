package top.codewood.wx.pay.v3.bean.notify;

import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class WxPayTransaction implements Serializable {

    /**
     * 应用ID
     * 直连商户申请的公众号或移动应用appid。
     */
    private String appid;

    /**
     * 商户号
     * 商户的商户号，由微信支付生成并下发。
     */
    @XStreamAlias("mch_id")
    private String mchid;

    /**
     * 商户订单号
     * 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一。
     * 特殊规则：最小字符长度为6
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 微信支付订单号
     * 微信支付系统生成的订单号。
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 交易类型
     * 交易类型，枚举值：
     * JSAPI：公众号支付
     * NATIVE：扫码支付
     * APP：APP支付
     * MICROPAY：付款码支付
     * MWEB：H5支付
     * FACEPAY：刷脸支付
     */
    @SerializedName("trade_type")
    private String tradeType;

    /**
     * 交易状态
     * 交易状态，枚举值：
     * SUCCESS：支付成功
     * REFUND：转入退款
     * NOTPAY：未支付
     * CLOSED：已关闭
     * REVOKED：已撤销（付款码支付）
     * USERPAYING：用户支付中（付款码支付）
     * PAYERROR：支付失败(其他原因，如银行返回失败)
     */
    @SerializedName("trade_state")
    private String tradeState;

    /**
     * 交易状态描述
     * 交易状态描述
     * 示例值：支付成功
     */
    @SerializedName("trade_state_desc")
    private String tradeStateDesc;

    /**
     * 付款银行
     * 银行类型，采用字符串类型的银行标识。银行标识请参考
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/terms_definition/chapter1_1_3.shtml#part-6">《银行类型对照表》</a>
     * 示例值：CMC
     */
    @SerializedName("bank_type")
    private String bankType;

    /**
     * 附加数据
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     * 示例值：自定义数据
     */
    private String attach;

    /**
     * 支付完成时间
     * 支付完成时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     * 示例值：2018-06-08T10:34:56+08:00
     */
    @SerializedName("success_time")
    private OffsetDateTime successTime;

    /**
     * 支付者
     */
    private Payer payer;

    /**
     * 订单金额
     * 订单金额信息
     */
    private Amount amount;

    /**
     * 场景信息
     * 支付场景信息描述
     */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;

    /**
     * 优惠功能
     * 优惠功能，享受优惠时返回该字段。
     */
    @SerializedName("promotion_detail")
    private PromotionDetail[] promotionDetails;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public OffsetDateTime getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(OffsetDateTime successTime) {
        this.successTime = successTime;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    public PromotionDetail[] getPromotionDetails() {
        return promotionDetails;
    }

    public void setPromotionDetails(PromotionDetail[] promotionDetails) {
        this.promotionDetails = promotionDetails;
    }

    @Override
    public String toString() {
        return "WxPayTransaction{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", tradeState='" + tradeState + '\'' +
                ", tradeStateDesc='" + tradeStateDesc + '\'' +
                ", bankType='" + bankType + '\'' +
                ", attach='" + attach + '\'' +
                ", successTime=" + successTime +
                ", payer=" + payer +
                ", amount=" + amount +
                ", sceneInfo=" + sceneInfo +
                ", promotionDetails=" + promotionDetails +
                '}';
    }

    /**
     * 支付者
     * 支付者信息
     */
    public static class Payer implements Serializable {

        /**
         * 用户标识
         * 用户在直连商户appid下的唯一标识。
         */
        private String openid;

        public Payer() {}

        public Payer(String openid) {
            this.openid = openid;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        @Override
        public String toString() {
            return "Payer{" +
                    "openid='" + openid + '\'' +
                    '}';
        }
    }

    /**
     * 订单金额
     * 订单金额信息
     */
    public static class Amount implements Serializable {

        /**
         * 用户支付金额
         * 用户支付金额，单位为分。
         */
        @SerializedName("payer_total")
        private int payerTotal;

        /**
         * 总金额
         * 订单总金额，单位为分。
         */
        private int total;

        /**
         * 货币类型
         * CNY：人民币，境内商户号仅支持人民币。
         */
        private String currency;

        /**
         * 用户支付币种
         * 用户支付币种
         * 示例值：CNY
         */
        @SerializedName("payer_currency")
        private String payerCurrency;

        public int getPayerTotal() {
            return payerTotal;
        }

        public void setPayerTotal(int payerTotal) {
            this.payerTotal = payerTotal;
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

        public String getPayerCurrency() {
            return payerCurrency;
        }

        public void setPayerCurrency(String payerCurrency) {
            this.payerCurrency = payerCurrency;
        }

        @Override
        public String toString() {
            return "Amount{" +
                    "payerTotal=" + payerTotal +
                    ", total=" + total +
                    ", currency='" + currency + '\'' +
                    ", payerCurrency='" + payerCurrency + '\'' +
                    '}';
        }
    }

    /**
     * 场景信息
     * 支付场景信息描述
     */
    public static class SceneInfo implements Serializable {

        /**
         * 商户端设备号
         * 终端设备号（门店号或收银设备ID）。
         */
        @SerializedName("device_id")
        private String deviceId;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        @Override
        public String toString() {
            return "SceneInfo{" +
                    "deviceId='" + deviceId + '\'' +
                    '}';
        }
    }

    /**
     * 优惠功能
     * 优惠功能，享受优惠时返回该字段。
     */
    public static class PromotionDetail implements Serializable {

        /**
         * 券ID
         */
        @SerializedName("coupon_id")
        private String couponId;

        /**
         * 优惠名称
         */
        private String name;

        /**
         * 优惠范围
         * GLOBAL：全场代金券
         * SINGLE：单品优惠
         */
        private String scope;

        /**
         * 优惠类型
         * CASH：充值
         * NOCASH：预充值
         */
        private String type;

        /**
         * 优惠券面额
         * 示例值：100
         */
        private int amount;

        /**
         * 活动ID
         */
        @SerializedName("stock_id")
        private String stockId;

        /**
         * 微信出资
         * 微信出资，单位为分
         * 示例值：0
         */
        @SerializedName("wechatpay_contribute")
        private int wechatPayContribute;

        /**
         * 商户出资
         * 商户出资，单位为分
         * 示例值：0
         */
        @SerializedName("merchant_contribute")
        private int merchantContribute;

        /**
         * 其他出资
         * 其他出资，单位为分
         * 示例值：0
         */
        @SerializedName("other_contribute")
        private int otherContribute;

        /**
         * 优惠币种
         * CNY：人民币，境内商户号仅支持人民币。
         * 示例值：CNY
         */
        private String currency;

        /**
         * 单品列表
         * 单品列表信息
         */
        @SerializedName("goods_detail")
        private GoodsDetail goodsDetail;

        public String getCouponId() {
            return couponId;
        }

        public void setCouponId(String couponId) {
            this.couponId = couponId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getStockId() {
            return stockId;
        }

        public void setStockId(String stockId) {
            this.stockId = stockId;
        }

        public int getWechatPayContribute() {
            return wechatPayContribute;
        }

        public void setWechatPayContribute(int wechatPayContribute) {
            this.wechatPayContribute = wechatPayContribute;
        }

        public int getMerchantContribute() {
            return merchantContribute;
        }

        public void setMerchantContribute(int merchantContribute) {
            this.merchantContribute = merchantContribute;
        }

        public int getOtherContribute() {
            return otherContribute;
        }

        public void setOtherContribute(int otherContribute) {
            this.otherContribute = otherContribute;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public GoodsDetail getGoodsDetail() {
            return goodsDetail;
        }

        public void setGoodsDetail(GoodsDetail goodsDetail) {
            this.goodsDetail = goodsDetail;
        }

        @Override
        public String toString() {
            return "PromotionDetail{" +
                    "couponId='" + couponId + '\'' +
                    ", name='" + name + '\'' +
                    ", scope='" + scope + '\'' +
                    ", type='" + type + '\'' +
                    ", amount=" + amount +
                    ", stockId='" + stockId + '\'' +
                    ", wechatPayContribute=" + wechatPayContribute +
                    ", merchantContribute=" + merchantContribute +
                    ", otherContribute=" + otherContribute +
                    ", currency='" + currency + '\'' +
                    ", goodsDetail=" + goodsDetail +
                    '}';
        }
    }

    /**
     * 单品列表
     */
    public static class GoodsDetail implements Serializable {

        /**
         * 商品编码
         */
        @SerializedName("goods_id")
        private String goodsId;

        /**
         * 商品数量
         * 用户购买的数量
         * 示例值：1
         */
        private int quantity;

        /**
         * 商品单价
         * 商品单价，单位为分
         * 示例值：100
         */
        @SerializedName("unit_price")
        private int unitPrice;

        /**
         * 商品优惠金额
         * 商品优惠金额
         * 示例值：0
         */
        @SerializedName("discount_amount")
        private int discountAmount;

        /**
         * 商品备注
         */
        @SerializedName("goods_remark")
        private String goodsRemark;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
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

        public int getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(int discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getGoodsRemark() {
            return goodsRemark;
        }

        public void setGoodsRemark(String goodsRemark) {
            this.goodsRemark = goodsRemark;
        }

        @Override
        public String toString() {
            return "GoodsDetail{" +
                    "goodsId='" + goodsId + '\'' +
                    ", quantity=" + quantity +
                    ", unitPrice=" + unitPrice +
                    ", discountAmount=" + discountAmount +
                    ", goodsRemark='" + goodsRemark + '\'' +
                    '}';
        }
    }


}
