package top.codewood.wx.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "weixin.config.properties")
public class WxConfigProperties {

    private final Map<String, WxAppProperty> appPropertyMap;
    private final Map<String, WxPayProperty> payPropertyMap;

    {
        appPropertyMap = new HashMap<>();
        payPropertyMap = new HashMap<>();
    }

    private WxAppProperty[] apps;

    private WxPayProperty[] pays;

    public WxAppProperty[] getApps() {
        return apps;
    }

    public void setApps(WxAppProperty[] apps) {
        this.apps = apps;
    }

    public WxPayProperty[] getPays() {
        return pays;
    }

    public void setPays(WxPayProperty[] pays) {
        this.pays = pays;
    }

    public WxAppProperty getAppProperty(String appid) {
        WxAppProperty wxAppProperty = appPropertyMap.get(appid);
        if (wxAppProperty == null) throw new RuntimeException(String.format("appid: %s 尚未配置！"));
        return wxAppProperty;
    }

    public WxAppProperty getAppPropertyByType(String type) {
        for (WxAppProperty app : apps) {
            if (type.equals(app.getType())) return app;
        }
        throw new RuntimeException(String.format("未配置类型 %s 的参数！", type));
    }

    public WxPayProperty getPayProperty(String mchid, String version) {
        WxPayProperty wxPayProperty = payPropertyMap.get(String.format("%s_%s", mchid, version));
        if (wxPayProperty == null) throw new RuntimeException(String.format("mchid: %s, version: %s 尚未配置！", mchid, version));
        return wxPayProperty;
    }

    @PostConstruct
    public void postConstruct() {
        if (apps != null) {
            for (WxAppProperty app : apps) {
                if (appPropertyMap.containsKey(app.getAppid())) {
                    throw new RuntimeException(String.format("appid: %s 有重复配置！", app.getAppid()));
                }
                appPropertyMap.put(app.getAppid(), app);
            }
        }

        if (pays != null) {
            for (WxPayProperty pay : pays) {
                if (pay.getVersion() == null) {
                    throw new RuntimeException(String.format("mchid: %s 属性 version 未配置！", pay.getMchid()));
                }
                if (pay.getMchid() == null) {
                    throw new RuntimeException("weixin.config.properties.pays 配置有误！");
                }
                payPropertyMap.put(String.format("%s_%s", pay.getMchid(), pay.getVersion()), pay);
            }
        }

    }

}
