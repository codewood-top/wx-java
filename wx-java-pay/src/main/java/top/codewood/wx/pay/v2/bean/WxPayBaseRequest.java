package top.codewood.wx.pay.v2.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;

import java.io.Serializable;

public class WxPayBaseRequest implements Serializable {

    /**
     * Appid
     */
    protected String appid;

    /**
     * 商户号
     *
     */
    @Required
    @XStreamAlias("mch_id")
    protected String mchId;

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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
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
}
