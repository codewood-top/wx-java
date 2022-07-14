package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpExpressGetPrinterResult implements Serializable {

    private Integer count;
    @SerializedName("openid")
    private List<String> openids;
    @SerializedName("tagid_list")
    private List<String> tagidList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getOpenids() {
        return openids;
    }

    public void setOpenids(List<String> openids) {
        this.openids = openids;
    }

    public List<String> getTagidList() {
        return tagidList;
    }

    public void setTagidList(List<String> tagidList) {
        this.tagidList = tagidList;
    }
}
