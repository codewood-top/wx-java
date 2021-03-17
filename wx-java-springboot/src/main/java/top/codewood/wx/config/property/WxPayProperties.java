package top.codewood.wx.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import top.codewood.wx.pay.common.WxPayConfig;

@ConfigurationProperties(prefix = "weixin.pay")
public class WxPayProperties {

    private WxPayConfig v2;
    private WxPayConfig v3;

    public WxPayConfig getV2() {
        return v2;
    }

    public void setV2(WxPayConfig v2) {
        this.v2 = v2;
    }

    public WxPayConfig getV3() {
        return v3;
    }

    public void setV3(WxPayConfig v3) {
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "WxPayProperties{" +
                "v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }
}
