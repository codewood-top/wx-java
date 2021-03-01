package top.codewood.wx.mp.bean.kefu.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMpKfOnlineList implements Serializable {

    @SerializedName("kf_online_list")
    private List<WxMpKfInfo> onlineList;

    public List<WxMpKfInfo> getOnlineList() {
        return onlineList;
    }

    public void setOnlineList(List<WxMpKfInfo> onlineList) {
        this.onlineList = onlineList;
    }
}
