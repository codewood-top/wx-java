/**
 * JSAPI/小程序下单API
 * 除付款码支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再按Native、JSAPI、APP等不同场景生成交易串调起支付。
 * <a href=“https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/pay/transactions/chapter3_2.shtml”>开发文档</a>
 */
package top.codewood.wx.pay.v3.request;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.pay.v3.request.bean.Amount;
import top.codewood.wx.pay.v3.request.bean.Detail;
import top.codewood.wx.pay.v3.request.bean.Payer;
import top.codewood.wx.pay.v3.request.bean.SceneInfo;

import java.io.Serializable;

public class WxPayRequest implements Serializable {

    /**
     * 直连商户申请的公众号或移动应用appid
     */
    private String appid;

    /**
     * 直连商户号
     * 直连商户的商户号，由微信支付生成并下发。
     */
    private String mchid;

    /**
     * 商品描述
     * 示例值：代码坞-素材-大好河山
     */
    private String description;

    /**
     * 商户订单号
     * 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 交易结束时间
     * 订单失效时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     * 示例值：2018-06-08T10:34:56+08:00
     */
    @SerializedName("time_expire")
    private String expireTime;

    /**
     * 附加数据
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    private String attach;

    /**
     * 通知地址
     * 通知URL必须为直接可访问的URL，不允许携带查询串。
     * 格式：URL
     */
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 订单优惠标记
     */
    @SerializedName("goods_tag")
    private String goodsTag;

    /**
     * 订单金额
     */
    private Amount amount;

    /**
     * 支付者
     */
    private Payer payer;

    /**
     * 优惠功能
     */
    private Detail detail;

    /**
     * 场景信息
     */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;

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
}
