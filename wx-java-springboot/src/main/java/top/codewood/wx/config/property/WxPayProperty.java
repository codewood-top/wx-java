package top.codewood.wx.config.property;

public class WxPayProperty {

    /**
     * 支付版本信息 v2 | v3
     * @see top.codewood.wx.pay.common.WxPayConstants.Version
     */
    private String version;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
}
