package top.codewood.wx.mp.bean.kefu.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMpKfMsgList implements Serializable {

    @SerializedName("recordlist")
    private List<WxMpKfMsgRecord> records;

    private int number;

    private Long msgid;

    public List<WxMpKfMsgRecord> getRecords() {
        return records;
    }

    public void setRecords(List<WxMpKfMsgRecord> records) {
        this.records = records;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    @Override
    public String toString() {
        return "WxMpKfMsgList{" +
                "records=" + records +
                ", number=" + number +
                ", msgid=" + msgid +
                '}';
    }
}
