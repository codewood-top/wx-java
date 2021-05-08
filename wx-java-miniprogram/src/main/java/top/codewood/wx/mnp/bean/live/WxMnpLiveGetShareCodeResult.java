package top.codewood.wx.mnp.bean.live;

import java.io.Serializable;

public class WxMnpLiveGetShareCodeResult implements Serializable {

    /**
     * 分享二维码
     */
    private String cdnUrl;

    /**
     * 分享路径
     */
    private String pagePath;

    /**
     * 分享海报
     */
    private String posterUrl;

    public String getCdnUrl() {
        return cdnUrl;
    }

    public void setCdnUrl(String cdnUrl) {
        this.cdnUrl = cdnUrl;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
