package top.codewood.wx.mnp.bean.live;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpLiveRoomReplayResult implements Serializable {

    /**
     * 回放视频片段个数
     */
    private Integer total;

    @SerializedName("live_replay")
    private List<WxMnpLiveReplayInfo> liveReplay;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<WxMnpLiveReplayInfo> getLiveReplay() {
        return liveReplay;
    }

    public void setLiveReplay(List<WxMnpLiveReplayInfo> liveReplay) {
        this.liveReplay = liveReplay;
    }
}
