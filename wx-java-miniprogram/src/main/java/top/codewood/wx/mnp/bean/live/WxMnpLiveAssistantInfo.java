package top.codewood.wx.mnp.bean.live;

import java.io.Serializable;

public class WxMnpLiveAssistantInfo implements Serializable {

    /**
     * 修改时间
     */
    private Integer timestamp;

    /**
     * 头像
     */
    private String headimg;

    /**
     *  昵称
     */
    private String nickname;

    /**
     * 微信号
     */
    private String alias;

    /**
     * openid
     */
    private String openid;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
