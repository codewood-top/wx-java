package top.codewood.wx.mnp.bean.wxacode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpWxaCodeBaseRequest implements Serializable {


    /**
     * 必填：否
     * default: release
     * 要打开的小程序版本。正式版为 release，体验版为 trial，开发版为 develop
     */
    @SerializedName("env_version")
    protected String envVersion;
    /**
     * 必填：否
     * default: 430
     * 二维码的宽度，单位 px，最小 280px，最大 1280px
     */
    protected Integer width;
    /**
     * 必填：否
     * default: false
     * 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认 false
     *
     */
    @SerializedName("auto_color")
    protected Boolean autoColor;

    /**
     * 必填：否
     * auto_color 为 false 时生效，使用 rgb 设置颜色
     * 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
     */
    @SerializedName("line_color")
    protected Color lineColor;
    /**
     * 必填：否
     * default: false
     * 是否需要透明底色，为 true 时，生成透明底色的小程序
     */
    @SerializedName("is_hyaline")
    protected Boolean hyaline;

    public String getEnvVersion() {
        return envVersion;
    }

    public void setEnvVersion(String envVersion) {
        this.envVersion = envVersion;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Boolean getAutoColor() {
        return autoColor;
    }

    public void setAutoColor(Boolean autoColor) {
        this.autoColor = autoColor;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Boolean getHyaline() {
        return hyaline;
    }

    public void setHyaline(Boolean hyaline) {
        this.hyaline = hyaline;
    }

    @Override
    public String toString() {
        return "WxMnpWxaCodeBaseRequest{" +
                "envVersion='" + envVersion + '\'' +
                ", width=" + width +
                ", autoColor=" + autoColor +
                ", lineColor=" + lineColor +
                ", hyaline=" + hyaline +
                '}';
    }

    public static class Color implements Serializable {
        private String r;
        private String g;
        private String b;

        public Color() {}

        public Color(String r, String g, String b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public String getR() {
            return r;
        }

        public void setR(String r) {
            this.r = r;
        }

        public String getG() {
            return g;
        }

        public void setG(String g) {
            this.g = g;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "r='" + r + '\'' +
                    ", g='" + g + '\'' +
                    ", b='" + b + '\'' +
                    '}';
        }
    }

}
