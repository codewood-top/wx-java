package top.codewood.wx.mnp.bean.live;

import java.io.Serializable;
import java.util.List;

public class WxMnpLiveAssistantListResult implements Serializable {

    /**
     * 小助手个数
     */
    private Integer count;

    /**
     * 小助手最大个数
     */
    private Integer maxCount;

    /**
     * 小助手列表
     */
    private List<WxMnpLiveAssistantInfo> list;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public List<WxMnpLiveAssistantInfo> getList() {
        return list;
    }

    public void setList(List<WxMnpLiveAssistantInfo> list) {
        this.list = list;
    }
}
