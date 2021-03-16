package top.codewood.wx.pay.v2.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;
import top.codewood.wx.pay.v2.bean.WxPayV2Coupon;

import java.util.ArrayList;

@XStreamAlias("xml")
public class WxPayUnifiedOrderV2Result extends WxPayBaseResult {

    /**
     * 调用接口提交的公众账号ID
     */
    private String appid;

    /**
     * 调用接口提交的商户号
     */
    @XStreamAlias("mch_id")
    private String mchid;

    /**
     * 自定义参数，可以为请求支付的终端设备号等
     */
    @XStreamAlias("device_info")
    public String deviceInfo;

    /**
     * 微信返回的随机字符串
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 微信返回的签名值，详见<a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3">签名算法</a>
     */
    private String sign;

    /**
     * 交易类型
     * JSAPI -JSAPI支付
     * NATIVE -Native支付
     * APP -APP支付
     */
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * 预支付交易会话标识
     * 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    @XStreamAlias("prepay_id")
    private String prepayId;

    /**
     * 二维码链接
     * trade_type=NATIVE时有返回，此url用于生成支付二维码，然后提供给用户进行扫码支付。
     * 注意：code_url的值并非固定，使用时按照URL格式转成二维码即可
     */
    @XStreamAlias("code_url")
    private String codeUrl;

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

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    @Override
    public String toString() {
        return "WxPayResult{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                '}';
    }
}
