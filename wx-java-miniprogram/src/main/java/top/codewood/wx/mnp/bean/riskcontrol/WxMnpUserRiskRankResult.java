package top.codewood.wx.mnp.bean.riskcontrol;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpUserRiskRankResult implements Serializable {

    /**
     * 0：风险等级0
     * 1：风险等级1
     * 2：风险等级2
     * 3：风险等级3
     * 4：风险等级4
     */
    @SerializedName("risk_rank")
    private int riskRank;

    /**
     * 唯一请求标识，标记单次请求
     */
    @SerializedName("unoin_id")
    private int unoinId;

    public int getRiskRank() {
        return riskRank;
    }

    public void setRiskRank(int riskRank) {
        this.riskRank = riskRank;
    }

    public int getUnoinId() {
        return unoinId;
    }

    public void setUnoinId(int unoinId) {
        this.unoinId = unoinId;
    }
}
