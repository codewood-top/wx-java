package top.codewood.wx.mp.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "weixin.pay.property")
public class WxPayProperty {

    public static String MCHID = null, SERIAL_NO = null, API_V3_KEY = null, CERT_PATH = null, NOTIFY_URL = null, REFUND_NOTIFY_URL = null;

    private String mchid;
    private String serialno;
    private String apiv3key;
    private String certpath;
    private String notifyurl;
    private String refundnotifyurl;

    @PostConstruct
    void postConstruct() {
        MCHID = mchid;
        SERIAL_NO = serialno;
        API_V3_KEY = apiv3key;
        CERT_PATH = certpath;
        NOTIFY_URL = notifyurl;
        REFUND_NOTIFY_URL = refundnotifyurl;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public void setApiv3key(String apiv3key) {
        this.apiv3key = apiv3key;
    }

    public void setCertpath(String certpath) {
        this.certpath = certpath;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

    public void setRefundnotifyurl(String refundnotifyurl) {
        this.refundnotifyurl = refundnotifyurl;
    }
}
