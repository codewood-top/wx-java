package top.codewood.wx.mp.bean.kefu.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMpKfList implements Serializable {

    @SerializedName("kf_list")
    private List<WxMpKfInfo> kfList;

    public List<WxMpKfInfo> getKfList() {
        return kfList;
    }

    public void setKfList(List<WxMpKfInfo> kfList) {
        this.kfList = kfList;
    }
}
