package top.codewood.wx.mnp.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 水印
 */
public class WaterMark implements Serializable {

    private String appid;
    @SerializedName("timestamp")
    private long timeStamp;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "WaterMark{" +
                "appid='" + appid + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
