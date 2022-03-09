package top.codewood.wx.mnp.bean.auth;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpCode2SessionResult implements Serializable {

    private String openid;
    @SerializedName("session_key")
    private String sessionKey;
    @SerializedName("unionid")
    private String unionId;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Override
    public String toString() {
        return "WxMnpCode2SessionResult{" +
                "openid='" + openid + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", unionId='" + unionId + '\'' +
                '}';
    }
}
