package top.codewood.wx.mp.bean.result;

import java.io.Serializable;

public class WxMpQrcodeTicket implements Serializable {

    protected String ticket;
    /**
     * 值为 -1: 永久二维码
     */
    protected int expireSeconds = -1;
    protected String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WxMpQrcodeTicket{" +
                "ticket='" + ticket + '\'' +
                ", expireSeconds=" + expireSeconds +
                ", url='" + url + '\'' +
                '}';
    }
}
