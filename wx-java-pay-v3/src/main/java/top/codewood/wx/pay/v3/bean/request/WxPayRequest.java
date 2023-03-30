/**
 * JSAPI/小程序下单API
 * 除付款码支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再按Native、JSAPI、APP等不同场景生成交易串调起支付。
 * <a href=“https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/pay/transactions/chapter3_2.shtml”>开发文档</a>
 */
package top.codewood.wx.pay.v3.bean.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxPayRequest implements Serializable {

    /**
     * 必填：是
     * 直连商户申请的公众号或移动应用appid
     */
    private String appid;

    /**
     * 必填：是
     * 直连商户号
     * 直连商户的商户号，由微信支付生成并下发。
     */
    private String mchid;

    /**
     * 必填：是
     * 商品描述
     * 示例值：代码坞-素材-大好河山
     */
    private String description;

    /**
     * 必填：是
     * 商户订单号
     * 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 必填：否
     * 交易结束时间
     * 订单失效时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     * 示例值：2018-06-08T10:34:56+08:00
     */
    @SerializedName("time_expire")
    private String expireTime;

    /**
     * 必填：否
     * 附加数据
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    private String attach;

    /**
     * 必填：是
     * 通知地址
     * 通知URL必须为直接可访问的URL，不允许携带查询串。
     * 格式：URL
     */
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 必填：否
     * 订单优惠标记
     */
    @SerializedName("goods_tag")
    private String goodsTag;

    /**
     * 必填：否
     * 电子发票入口开放标识
     * 传入true时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效。
     */
    @SerializedName("support_fapiao")
    private Boolean supportFapiao;

    /**
     * 必填：是
     * 订单金额
     */
    private Amount amount;

    /**
     * jsapi支付必填，其它支付方式不填
     * 支付者
     */
    private Payer payer;

    /**
     * 必填：否
     * 优惠功能
     */
    private Detail detail;

    /**
     * 必填：否
     * 场景信息
     */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;

    /**
     * 必填：否
     * 结算信息
     */
    @SerializedName("settle_info")
    private SettleInfo settleInfo;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public void setAmount(Integer total) {
        this.amount = new Amount(total);
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public void setPayer(String openid) {
        this.payer = new Payer(openid);
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    public SettleInfo getSettleInfo() {
        return settleInfo;
    }

    public void setSettleInfo(SettleInfo settleInfo) {
        this.settleInfo = settleInfo;
    }

    public void setSettleInfo(boolean profitSharing) {
        this.settleInfo = new SettleInfo(profitSharing);
    }

    @Override
    public String toString() {
        return "WxPayRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", description='" + description + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", expireTime='" + expireTime + '\'' +
                ", attach='" + attach + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", goodsTag='" + goodsTag + '\'' +
                ", amount=" + amount +
                ", payer=" + payer +
                ", detail=" + detail +
                ", sceneInfo=" + sceneInfo +
                '}';
    }


    /**
     * 订单金额信息
     */
    public static class Amount implements Serializable {
        /**
         * 订单总金额，单位为分
         */
        private int total;
        /**
         * CNY：人民币，境内商户号仅支持人民币
         */
        private String currency = "CNY";

        public Amount() {}

        public Amount(int total) {
            this.total = total;
        }

        public Amount(int total, String currency) {
            this.total = total;
            this.currency = currency;
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

    }

    /**
     * 支付者信息
     */
    public static class Payer implements Serializable {
        /**
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

    }

    /**
     * 优惠功能
     *
     */
    public static class Detail implements Serializable {
        /**
         * 订单原价
         * 1、商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。
         * 2、当订单原价与支付金额不相等，则不享受优惠。
         * 3、该字段主要用于防止同一张小票分多次支付，以享受多次优惠的情况，正常支付订单不必上传此参数。
         */
        @SerializedName("cost_price")
        private int costPrice;
        /**
         * 商品小票ID
         */
        @SerializedName("invoice_id")
        private String invoiceId;
        /**
         * 单品列表
         */
        @SerializedName("goods_detail")
        private GoodsDetail goodsDetail;

        public int getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(int costPrice) {
            this.costPrice = costPrice;
        }

        public String getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
        }

        public GoodsDetail getGoodsDetail() {
            return goodsDetail;
        }

        public void setGoodsDetail(GoodsDetail goodsDetail) {
            this.goodsDetail = goodsDetail;
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

    }


    /**
     * 场景信息
     * 支付场景描述
     */
    public static class SceneInfo implements Serializable {

        /**
         * 用户终端IP
         * 调用微信支付API的机器IP，支持IPv4和IPv6两种格式的IP地址
         */
        @SerializedName("payer_client_ip")
        private String payerClientIp;
        /**
         * 商户端设备号
         * 商户端设备号（门店号或收银设备ID
         */
        @SerializedName("device_id")
        private String deviceId;
        /**
         * 商户门店信息
         */
        @SerializedName("store_info")
        private StoreInfo storeInfo;

        public String getPayerClientIp() {
            return payerClientIp;
        }

        public void setPayerClientIp(String payerClientIp) {
            this.payerClientIp = payerClientIp;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public StoreInfo getStoreInfo() {
            return storeInfo;
        }

        public void setStoreInfo(StoreInfo storeInfo) {
            this.storeInfo = storeInfo;
        }
    }

    /**
     * 商户门店信息
     */
    public static class StoreInfo implements Serializable {
        /**
         * 门店编号
         * 	商户侧门店编号
         */
        private String id;
        /**
         * 门店名称
         * 商户侧门店名称
         */
        private String name;
        /**
         * 地区编码
         * 地区编码，详细请见<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/ecommerce/applyments/chapter4_1.shtml">省市区编号对照表</a>
         */
        @SerializedName("area_code")
        private String areaCode;
        /**
         * 详细地址
         * 详细的商户门店地址
         */
        private String address;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    /**
     * 结算信息
     */
    public static class SettleInfo implements Serializable {

        /**
         *  是否指定分账
         */
        @SerializedName("profit_sharing")
        private boolean profitSharing;

        public SettleInfo() {}

        public SettleInfo(boolean profitSharing) {
            this.profitSharing = profitSharing;
        }

        public boolean isProfitSharing() {
            return profitSharing;
        }

        public void setProfitSharing(boolean profitSharing) {
            this.profitSharing = profitSharing;
        }
    }


}
