package top.codewood.wx.config.property;

public class WxPayProperty2 {

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
     * APIV3密钥
     */
    private String v3Key;

    /**
     * v2: apiclient_cert.p12
     */
    private String certPath;

    /**
     * v3: apiclient_key.pem
     */
    private String keyPath;

    /**
     * 支付通知url
     */
    private String v2NotifyUrl;

    /**
     * 退款通知url
     */
    private String v2RefundNotifyUrl;

    private String v3NotifyUrl;

    private String v3RefundNotifyUrl;

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

    public String getV3Key() {
        return v3Key;
    }

    public void setV3Key(String v3Key) {
        this.v3Key = v3Key;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public String getV2NotifyUrl() {
        return v2NotifyUrl;
    }

    public void setV2NotifyUrl(String v2NotifyUrl) {
        this.v2NotifyUrl = v2NotifyUrl;
    }

    public String getV2RefundNotifyUrl() {
        return v2RefundNotifyUrl;
    }

    public void setV2RefundNotifyUrl(String v2RefundNotifyUrl) {
        this.v2RefundNotifyUrl = v2RefundNotifyUrl;
    }

    public String getV3NotifyUrl() {
        return v3NotifyUrl;
    }

    public void setV3NotifyUrl(String v3NotifyUrl) {
        this.v3NotifyUrl = v3NotifyUrl;
    }

    public String getV3RefundNotifyUrl() {
        return v3RefundNotifyUrl;
    }

    public void setV3RefundNotifyUrl(String v3RefundNotifyUrl) {
        this.v3RefundNotifyUrl = v3RefundNotifyUrl;
    }
}
