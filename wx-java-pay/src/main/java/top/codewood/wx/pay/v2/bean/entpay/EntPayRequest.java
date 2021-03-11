package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;

import java.io.Serializable;

/**
 * 企业付款
 * 用于企业向微信用户个人付款
 * 目前支持向指定微信用户的openid付款。
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2">开发文档</a>
 */
@XStreamAlias("xml")
public class EntPayRequest implements Serializable {

    /**
     * 商户账号appid
     * 申请商户号的appid或商户号绑定的appid
     */
    @Required
    @XStreamAlias("mch_appid")
    private String mchAppid;

    /**
     * 商户号
     * 微信支付分配的商户号
     */
    @Required
    @XStreamAlias("mchid")
    private String mchid;

    /**
     * 设备号
     * 微信支付分配的终端设备号
     */
    @Required
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 随机字符串
     * 随机字符串，不长于32位
     */
    @Required
    @XStreamAlias("nonce_str")
    protected String nonceStr;

    /**
     * 签名
     * 详见<a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3">签名生成算法</a>
     */
    @Required
    protected String sign;

    /**
     * 商户订单号
     * 商户订单号，需保持唯一性
     * (只能是字母或者数字，不能包含有其它字符)
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 用户openid
     * 商户appid下，某用户的openid
     */
    @Required
    @XStreamAlias("openid")
    private String openid;

    /**
     * 校验用户姓名选项
     * NO_CHECK：不校验真实姓名
     * FORCE_CHECK：强校验真实姓名
     */
    @Required
    @XStreamAlias("check_name")
    private String checkName = "NO_CHECK";

    /**
     * 收款用户姓名
     * 收款用户真实姓名。
     * 如果check_name设置为FORCE_CHECK，则必填用户真实姓名
     * 如需电子回单，需要传入收款用户姓名
     */
    @XStreamAlias("re_user_name")
    private String reUserName;

    /**
     * 金额
     * 企业付款金额，单位为分
     */
    @Required
    private int amount;

    /**
     * 企业付款备注
     * 企业付款备注，必填。注意：备注中的敏感词会被转成字符*
     */
    @Required
    private String desc;

    /**
     * Ip地址
     * 该IP同在商户平台设置的IP白名单中的IP没有关联，该IP可传用户端或者服务端的IP。
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    public String getMchAppid() {
        return mchAppid;
    }

    public void setMchAppid(String mchAppid) {
        this.mchAppid = mchAppid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getReUserName() {
        return reUserName;
    }

    public void setReUserName(String reUserName) {
        this.reUserName = reUserName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }
}
