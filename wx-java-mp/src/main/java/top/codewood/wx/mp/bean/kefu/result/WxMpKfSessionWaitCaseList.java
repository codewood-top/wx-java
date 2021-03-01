package top.codewood.wx.mp.bean.kefu.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMpKfSessionWaitCaseList implements Serializable {

    /**
     * 未接入会话数量
     */
    private int count;

    /**
     * 未接入会话列表，最多返回100条数据，按照来访顺序
     */
    @SerializedName("waitcaselist")
    private List<WxMpKfSession> kfSessionWaitCaseList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<WxMpKfSession> getKfSessionWaitCaseList() {
        return kfSessionWaitCaseList;
    }

    public void setKfSessionWaitCaseList(List<WxMpKfSession> kfSessionWaitCaseList) {
        this.kfSessionWaitCaseList = kfSessionWaitCaseList;
    }

    @Override
    public String toString() {
        return "WxMpKfSessionWaitCaseList{" +
                "count=" + count +
                ", kfSessionWaitCaseList=" + kfSessionWaitCaseList +
                '}';
    }
}
