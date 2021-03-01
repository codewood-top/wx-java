package top.codewood.wx.mp.bean.kefu.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMpKfSession implements Serializable {

    /**
     * 正在接待的客服，为空表示没有人在接待
     */
    @SerializedName("kf_account")
    private String kfAccount;

    /**
     * 会话接入的时间
     */
    @SerializedName("createtime")
    private Long createTime;

    /**
     * 粉丝的openid
     */
    private String openid;

    /**
     * 粉丝的最后一条消息的时间
     */
    @SerializedName("latest_time")
    private long latestTime;

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public long getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(long latestTime) {
        this.latestTime = latestTime;
    }

    @Override
    public String toString() {
        return "WxMpKfSession{" +
                "kfAccount='" + kfAccount + '\'' +
                ", createTime=" + createTime +
                ", openid='" + openid + '\'' +
                ", latestTime=" + latestTime +
                '}';
    }
}
