package top.codewood.wx.mp.bean.kefu.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMpKfMsgRecord implements Serializable {

    private String openid;

    /**
     * 操作码，2002（客服发送信息），2003（客服接收消息）
     */
    @SerializedName("opercode")
    private String operCode;

    /**
     * 聊天记录
     */
    private String text;

    /**
     * 操作时间，unix时间戳
     */
    private Long time;

    /**
     * 完整客服帐号，格式为：帐号前缀@公众号微信号
     */
    private String worker;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "WxMpKfMsgRecord{" +
                "openid='" + openid + '\'' +
                ", operCode='" + operCode + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", worker='" + worker + '\'' +
                '}';
    }
}
