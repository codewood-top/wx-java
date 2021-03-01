package top.codewood.wx.mp.bean.kefu.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMpKfAccountRequest implements Serializable {

    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    @SerializedName("kf_account")
    private String kfAccount;

    /**
     * 客服昵称，最长6个汉字或12个英文字符
     */
    private String nickname;

    /**
     * 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
     */
    private String password;


    public WxMpKfAccountRequest() {}

    public WxMpKfAccountRequest(String kfAccount, String nickname, String password) {
        this.kfAccount = kfAccount;
        this.nickname = nickname;
        this.password = password;
    }

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
