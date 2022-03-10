package top.codewood.wx.mnp.bean.security;

import com.google.gson.annotations.SerializedName;

public class WxMnpSecurityMediaCheckAsyncRequest extends WxMnpSecurityBaseRequest {

    /**
     * 必填
     * 要检测的图片或音频的url，支持图片格式包括jpg, jepg, png, bmp, gif（取首帧），支持的音频格式包括mp3, aac, ac3, wma, flac, vorbis, opus, wav
     */
    @SerializedName("media_url")
    private String mediaUrl;

    /**
     * 必填
     *  1:音频;2:图片
     */
    @SerializedName("media_type")
    private Integer mediaType;

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return "WxMnpSecurityMediaCheckAsyncRequest{" +
                "mediaUrl='" + mediaUrl + '\'' +
                ", mediaType=" + mediaType +
                ", version=" + version +
                ", openid='" + openid + '\'' +
                ", scene=" + scene +
                '}';
    }

    public static class Builder {
        private String mediaUrl;
        private Integer mediaType;
        private Integer version = 2;
        private String openid;
        private Integer scene;

        public Builder mediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
            return this;
        }

        public Builder mediaType(Integer mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        public Builder openid(String openid) {
            this.openid = openid;
            return this;
        }

        public Builder scene(Integer scene) {
            this.scene = scene;
            return this;
        }

        public WxMnpSecurityMediaCheckAsyncRequest build() {
            WxMnpSecurityMediaCheckAsyncRequest request = new WxMnpSecurityMediaCheckAsyncRequest();

            request.setMediaUrl(this.mediaUrl);
            request.setMediaType(this.mediaType);
            request.setVersion(this.version);
            request.setOpenid(this.openid);
            request.setScene(this.scene);

            return request;
        }

    }

}
