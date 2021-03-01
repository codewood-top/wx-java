package top.codewood.wx.mp.bean.kefu.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMpKfInfo implements Serializable {

    /**
     * 客服工号
     */
    @SerializedName("kf_id")
    private String id;

    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    @SerializedName("kf_account")
    private String account;

    /**
     * 客服昵称
     */
    @SerializedName("kf_nick")
    private String nickname;

    /**
     * 客服昵称，最长6个汉字或12个英文字符
     */
    @SerializedName("kf_headimgurl")
    private String headImgUrl;

    /**
     * 客服绑定的微信号
     */
    @SerializedName("kf_wx")
    private String wx;

    /**
     * 如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请， 则此处显示绑定邀请的微信号
     */
    @SerializedName("invite_wx")
    private String inviteWx;

    /**
     * 如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请， 邀请的过期时间，为unix 时间戳
     */
    @SerializedName("invite_expire_time")
    private Long inviteExpireTime;

    /**
     * 邀请的状态，有等待确认“waiting”，被拒绝“rejected”， 过期“expired”
     */
    @SerializedName("invite_status")
    private String inviteStatus;

    /**
     * 客服在线状态，目前为：1、web 在线
     */
    private String status;

    /**
     * 客服当前正在接待的会话数
     */
    @SerializedName("accepted_case")
    private Integer acceptedCase;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getInviteWx() {
        return inviteWx;
    }

    public void setInviteWx(String inviteWx) {
        this.inviteWx = inviteWx;
    }

    public Long getInviteExpireTime() {
        return inviteExpireTime;
    }

    public void setInviteExpireTime(Long inviteExpireTime) {
        this.inviteExpireTime = inviteExpireTime;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAcceptedCase() {
        return acceptedCase;
    }

    public void setAcceptedCase(Integer acceptedCase) {
        this.acceptedCase = acceptedCase;
    }
}