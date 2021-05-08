package top.codewood.wx.mnp.bean.live;

import java.io.Serializable;

public class WxMnpLiveAssistant implements Serializable {

    /**
     * 用户微信号
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    public WxMnpLiveAssistant() {}

    public WxMnpLiveAssistant(String username, String nickname) {
        this.username = username;
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
