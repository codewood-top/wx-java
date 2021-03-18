package top.codewood.wx.config.property;

public class WxAppProperty {

    private String appid;
    private String secret;
    /**
     * 应用类型 公众号 | 小程序 | app
     * @see top.codewood.wx.common.api.WxConstants.AppType
     */
    private String type;
    private String mchid;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }
}
