package top.codewood.wx.pay.v2.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.common.util.bean.BeanUtils;
import top.codewood.wx.common.util.xml.XStreamConverter;

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
    protected String mchid;

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
    protected String sign;


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

    /**
     * 自检测字段缺失
     */
    public void checkRequiredFields() {
        BeanUtils.checkRequiredFields(this);
    }

    public String toXml() {
        return XStreamConverter.toXml(this);
    }

    /**
     * sign 字段需要生成具体对象后再传入
     */
    public static abstract class Builder<T extends Builder> {

        protected String appid;
        protected String mchid;
        protected String nonceStr;

        public T appid(String appid) {
            this.appid = appid;
            return (T) this;
        }

        public T mchid(String mchid) {
            this.mchid = mchid;
            return (T) this;
        }

        public T nonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return (T) this;
        }

    }

}
