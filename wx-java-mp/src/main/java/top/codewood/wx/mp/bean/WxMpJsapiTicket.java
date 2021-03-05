package top.codewood.wx.mp.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMpJsapiTicket implements Serializable {

    private String ticket;

    @SerializedName("expires_in")
    private int expiresIn;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
