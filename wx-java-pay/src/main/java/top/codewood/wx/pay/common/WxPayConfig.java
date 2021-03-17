package top.codewood.wx.pay.common;

import java.io.InputStream;

public class WxPayConfig {

    private String appid;
    private String mchid;

    /**
     * 证书序列号
     */
    private String serialNo;

    /**
     * 密钥: 微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     */
    private String Key;

    /**
     * v2: apiclient_cert.p12
     * v3: apiclient_key.pem
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
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

    public InputStream getCertStream() {
        if (this.certPath == null) throw new RuntimeException("certPath 未配置");
        return this.getClass().getResourceAsStream(this.certPath);
    }


    /**
     * HTTP(S) 连接超时时间，单位毫秒
     * @return
     */
    public int getConnectTimeoutMs() {
        return 3 * 1000;
    }

    /**
     * HTTP(S) 读数据超时时间，单位毫秒
     * @return
     */
    public int getReadTimeoutMs() {
        return 3 * 1000;
    }


    @Override
    public String toString() {
        return "WxPayConfig{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", Key='" + Key + '\'' +
                ", certPath='" + certPath + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", refundNotifyUrl='" + refundNotifyUrl + '\'' +
                '}';
    }
}
