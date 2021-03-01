package top.codewood.wx.mp.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "weixin.mp.property")
public class WxMpProperty {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpProperty.class);

    public static String APP_ID = null, APP_SECRET = null;

    String appid;
    String appsecret;

    @PostConstruct
    void postConstruct() {
        APP_ID = appid;
        APP_SECRET = appsecret;
        LOGGER.debug("appid: {}", appid);
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }
}
