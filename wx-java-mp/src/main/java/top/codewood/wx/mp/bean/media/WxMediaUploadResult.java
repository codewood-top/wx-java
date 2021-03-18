package top.codewood.wx.mp.bean.media;

import java.io.Serializable;

public class WxMediaUploadResult implements Serializable {

    private String url;
    private String type;
    private String mediaId;
    private long createdAt;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WxMediaUploadResult{" +
                "url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
