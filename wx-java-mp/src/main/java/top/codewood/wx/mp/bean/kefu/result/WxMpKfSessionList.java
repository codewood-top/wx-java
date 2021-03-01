package top.codewood.wx.mp.bean.kefu.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMpKfSessionList implements Serializable {

    @SerializedName("sessionlist")
    private List<WxMpKfSession> kfSessionList;

    public List<WxMpKfSession> getKfSessionList() {
        return kfSessionList;
    }

    public void setKfSessionList(List<WxMpKfSession> kfSessionList) {
        this.kfSessionList = kfSessionList;
    }
}
