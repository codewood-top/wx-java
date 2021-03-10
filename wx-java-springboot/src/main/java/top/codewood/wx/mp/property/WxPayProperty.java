package top.codewood.wx.mp.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "weixin.pay.property")
public class WxPayProperty {

    public static String MCHID = null, SERIAL_NO = null,
            API_V2_KEY = null,
            API_V3_KEY = null,
            KEY_FILE_PATH = null,
            CERT_FILE_PATH = null,
            NOTIFY_URL = null,
            REFUND_NOTIFY_URL = null;

    private String mchid;
    private String serialno;
    private String apiV2Key;
    private String apiV3Key;
    private String keyFilePath;
    private String certFilePath;
    private String notifyUrl;
    private String refundNotifyUrl;

    @PostConstruct
    void postConstruct() {
        MCHID = mchid;
        SERIAL_NO = serialno;
        API_V2_KEY = apiV2Key;
        API_V3_KEY = apiV3Key;
        KEY_FILE_PATH = keyFilePath;
        CERT_FILE_PATH = certFilePath;
        NOTIFY_URL = notifyUrl;
        REFUND_NOTIFY_URL = refundNotifyUrl;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public void setApiV2Key(String apiV2Key) {
        this.apiV2Key = apiV2Key;
    }

    public void setApiV3Key(String apiV3Key) {
        this.apiV3Key = apiV3Key;
    }

    public void setKeyFilePath(String keyFilePath) {
        this.keyFilePath = keyFilePath;
    }

    public void setCertFilePath(String certFilePath) {
        this.certFilePath = certFilePath;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl;
    }
}
