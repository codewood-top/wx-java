package top.codewood.wx.pay.v2.bean.request;

import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

import java.io.Serializable;

@XStreamAlias("xml")
public class WxPayRequest extends WxPayBaseRequest {

    /**
     * 签名类型，默认为MD5，支持HMAC-SHA256和MD5。
     */
    @XStreamAlias("sign_type")
    private String signType;

    /**
     * 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 商品简单描述，该字段请按照规范传递，具体请见<a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_2">参数规定</a>
     */
    @Required
    private String body;

    /**
     * 商品详情
     * 商品详细描述，对于使用单品优惠的商户，该字段必须按照规范上传，详见<a href="https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_102&index=2">单品优惠参数说明</a>
     */
    private String detail;

    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
     */
    private String attach;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号
     */
    @Required
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 标价币种
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型
     */
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * 标价金额
     * 订单总金额，单位为分，详见支付金额
     */
    @Required
    @XStreamAlias("total_fee")
    private int totalFee;

    /**
     * 终端IP
     * 支持IPV4和IPV6两种格式的IP地址。用户的客户端IP
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    /**
     * 交易起始时间
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @XStreamAlias("time_start")
    private String timeStart;

    /**
     * 交易结束时间
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。其他详见时间规则
     * time_expire只能第一次下单传值，不允许二次修改，二次修改系统将报错。如用户支付失败后，需再次支付，需更换原订单号重新下单。
     * 建议：最短失效时间间隔大于1分钟
     */
    @XStreamAlias("time_expire")
    private String timeExpire;

    /**
     * 订单优惠标记
     * 订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见<a href="https://pay.weixin.qq.com/wiki/doc/api/tools/sp_coupon.php?chapter=12_7&index=3">代金券或立减优惠</a>
     */
    @XStreamAlias("goods_tag")
    private String goodsTag;

    /**
     * 通知地址
     * 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
     */
    @XStreamAlias("notify_url")
    private String notifyUrl;

    /**
     * 交易类型
     * JSAPI -JSAPI支付
     * NATIVE -Native支付
     * APP -APP支付
     * 说明详见参数规定
     */
    @Required
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * 商品ID
     * trade_type=NATIVE时，此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
     */
    @XStreamAlias("product_id")
    private String productId;

    /**
     * 指定支付方式
     * 上传此参数no_credit--可限制用户不能使用信用卡支付
     */
    @XStreamAlias("limit_pay")
    private String limitPay;

    /**
     * 用户标识
     * trade_type=JSAPI时（即JSAPI支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。
     */
    private String openid;

    /**
     * 电子发票入口开放标识
     * Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     */
    private String receipt;

    /**
     * 是否需要分账
     * Y-是，需要分账
     * N-否，不分账
     * 字母要求大写，不传默认不分账
     */
    @XStreamAlias("profit_sharing")
    private String profitSharing;

    /**
     * 场景信息
     * 该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }}
     */
    @XStreamAlias("scene_info")
    private SceneInfo sceneInfo;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getProfitSharing() {
        return profitSharing;
    }

    public void setProfitSharing(String profitSharing) {
        this.profitSharing = profitSharing;
    }

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    /**
     * 场景信息
     * 支付场景描述
     */
    public static class SceneInfo implements Serializable {
        /**
         * 商户门店信息
         */
        @SerializedName("store_info")
        private StoreInfo storeInfo;

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
        @XStreamAlias("area_code")
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

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        private String signType;
        private String deviceInfo;
        private String body;
        private String detail;
        private String attach;
        private String outTradeNo;
        private String feeType;
        private int totalFee;
        private String spbillCreateIp;
        private String timeStart;
        private String timeExpire;
        private String goodsTag;
        private String notifyUrl;
        private String tradeType;
        private String productId;
        private String limitPay;
        private String openid;
        private String receipt;
        private String profitSharing;
        private SceneInfo sceneInfo;

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public Builder deviceinfo(String deviceinfo) {
            this.deviceInfo = deviceinfo;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder attach(String attach) {
            this.attach = attach;
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public Builder feeType(String feeType) {
            this.feeType = feeType;
            return this;
        }

        public Builder totalFee(int totalFee) {
            this.totalFee = totalFee;
            return this;
        }

        public Builder spbillCreateIp(String spbillCreateIp) {
            this.spbillCreateIp = spbillCreateIp;
            return this;
        }

        public Builder timeStart(String timeStart) {
            this.timeStart = timeStart;
            return this;
        }

        public Builder timeExpire(String timeExpire) {
            this.timeExpire = timeExpire;
            return this;
        }

        public Builder goodsTag(String goodsTag) {
            this.goodsTag = goodsTag;
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public Builder tradeType(String tradeType) {
            this.tradeType = tradeType;
            return this;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder limitPay(String limitPay) {
            this.limitPay = limitPay;
            return this;
        }

        public Builder openid(String openid) {
            this.openid = openid;
            return this;
        }

        public Builder receipt(String receipt) {
            this.receipt = receipt;
            return this;
        }

        public Builder profitSharing(String profitSharing) {
            this.profitSharing = profitSharing;
            return this;
        }

        public Builder sceneInfo(SceneInfo sceneInfo) {
            this.sceneInfo = sceneInfo;
            return this;
        }

        public WxPayRequest build() {
            WxPayRequest wxPayRequest = new WxPayRequest();
            wxPayRequest.setAppid(appid);
            wxPayRequest.setMchid(this.mchid);
            wxPayRequest.setNonceStr(this.nonceStr);

            wxPayRequest.setDeviceInfo(this.deviceInfo);
            wxPayRequest.setBody(this.body);
            wxPayRequest.setDetail(this.detail);
            wxPayRequest.setAttach(this.attach);
            wxPayRequest.setOutTradeNo(this.outTradeNo);
            wxPayRequest.setFeeType(this.feeType);
            wxPayRequest.setTotalFee(this.totalFee);
            wxPayRequest.setSpbillCreateIp(this.spbillCreateIp);
            wxPayRequest.setTimeStart(this.timeStart);
            wxPayRequest.setTimeExpire(this.timeExpire);
            wxPayRequest.setGoodsTag(this.goodsTag);
            wxPayRequest.setNotifyUrl(this.notifyUrl);
            wxPayRequest.setTradeType(this.tradeType);
            wxPayRequest.setProductId(this.productId);
            wxPayRequest.setLimitPay(this.limitPay);
            wxPayRequest.setOpenid(this.openid);
            wxPayRequest.setReceipt(this.receipt);
            wxPayRequest.setSceneInfo(this.sceneInfo);

            if (signType != null) {
                wxPayRequest.setSignType(this.signType);
            }

            return wxPayRequest;
        }

    }

    @Override
    public String toString() {
        return "WxPayRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", body='" + body + '\'' +
                ", detail='" + detail + '\'' +
                ", attach='" + attach + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", feeType='" + feeType + '\'' +
                ", totalFee=" + totalFee +
                ", spbillCreateIp='" + spbillCreateIp + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeExpire='" + timeExpire + '\'' +
                ", goodsTag='" + goodsTag + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", productId='" + productId + '\'' +
                ", limitPay='" + limitPay + '\'' +
                ", openid='" + openid + '\'' +
                ", receipt='" + receipt + '\'' +
                ", profitSharing='" + profitSharing + '\'' +
                ", sceneInfo=" + sceneInfo +
                '}';
    }
}
