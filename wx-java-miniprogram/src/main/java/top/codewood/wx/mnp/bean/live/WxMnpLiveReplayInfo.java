package top.codewood.wx.mnp.bean.live;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpLiveReplayInfo implements Serializable {

    /**
     * 回放视频url过期时间
     */
    @SerializedName("expire_time")
    private Integer expireTime;

    /**
     * 回放视频创建时间
     */
    @SerializedName("create_time")
    private Integer createTime;

    /**
     * 回放视频链接
     */
    @SerializedName("media_url")
    private Integer mediaUrl;

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(Integer mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
