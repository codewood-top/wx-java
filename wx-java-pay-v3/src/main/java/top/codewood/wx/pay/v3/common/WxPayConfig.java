package top.codewood.wx.pay.v3.common;

public class WxPayConfig {

    private String mchid;

    /**
     * 证书序列号
     */
    private String serialNo;

    /**
     * 密钥: 微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->APIV3密钥设置
     */
    private String v3SecretKey;

    /**
     * v3: apiclient_key.pem
     */
    private String cert;

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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getV3SecretKey() {
        return v3SecretKey;
    }

    public void setV3SecretKey(String v3SecretKey) {
        this.v3SecretKey = v3SecretKey;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
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

    @Override
    public String toString() {
        return "WxPayConfig{" +
                "mchid='" + mchid + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", v3SecretKey='" + v3SecretKey + '\'' +
                ", cert='" + cert + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", refundNotifyUrl='" + refundNotifyUrl + '\'' +
                '}';
    }
}
