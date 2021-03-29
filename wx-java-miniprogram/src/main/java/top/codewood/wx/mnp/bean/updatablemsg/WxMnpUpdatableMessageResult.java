package top.codewood.wx.mnp.bean.updatablemsg;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpUpdatableMessageResult implements Serializable {

    /**
     * 动态消息的 ID
     */
    @SerializedName("activity_id")
    private String activityId;

    @SerializedName("expiration_time")
    private long expirationTime;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "WxMnpCreateActivityResult{" +
                "activityId='" + activityId + '\'' +
                ", expirationTime=" + expirationTime +
                '}';
    }
}
