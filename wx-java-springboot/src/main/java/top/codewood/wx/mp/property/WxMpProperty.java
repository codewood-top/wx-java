package top.codewood.wx.mp.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "weixin.mp.property")
public class WxMpProperty {

    public static String APP_ID = null, APP_SECRET = null;

    private String appid;
    private String appsecret;

    @PostConstruct
    void postConstruct() {
        APP_ID = appid;
        APP_SECRET = appsecret;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

}
