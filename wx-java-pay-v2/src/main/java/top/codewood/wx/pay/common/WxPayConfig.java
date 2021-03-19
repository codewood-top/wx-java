package top.codewood.wx.pay.common;

import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;

public class WxPayConfig {

    private String mchid;


    /**
     * 密钥: 微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     */
    private String key;


    /**
     * v2: apiclient_cert.p12
     */
    private String certPath;

    /**
     * 支付通知url
     */
    private String notifyUrl;

    /**
     * 退款通知url
     */
    private String refundNotifyUrl;


    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl;
    }

    public InputStream certFileInputStream() {
        if (this.certPath == null) throw new RuntimeException("certpath 未配置！");
        return getClass().getResourceAsStream(this.certPath);
    }

    @Override
    public String toString() {
        return "WxPayConfig{" +
                "mchid='" + mchid + '\'' +
                ", key='" + key + '\'' +
                ", certPath='" + certPath + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", refundNotifyUrl='" + refundNotifyUrl + '\'' +
                '}';
    }

}
