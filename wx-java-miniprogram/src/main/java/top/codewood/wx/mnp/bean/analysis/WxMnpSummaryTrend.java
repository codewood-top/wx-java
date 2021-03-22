package top.codewood.wx.mnp.bean.analysis;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpSummaryTrend implements Serializable {

    /**
     * 	日期，格式为 yyyyMMdd
     */
    @SerializedName("ref_date")
    private String refDate;

    /**
     * 累计用户数
     */
    @SerializedName("visit_total")
    private String visitTotal;

    /**
     * 转发次数
     */
    @SerializedName("share_pv")
    private String sharePv;

    /**
     * 转发人数
     */
    @SerializedName("share_uv")
    private String shareUv;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public String getVisitTotal() {
        return visitTotal;
    }

    public void setVisitTotal(String visitTotal) {
        this.visitTotal = visitTotal;
    }

    public String getSharePv() {
        return sharePv;
    }

    public void setSharePv(String sharePv) {
        this.sharePv = sharePv;
    }

    public String getShareUv() {
        return shareUv;
    }

    public void setShareUv(String shareUv) {
        this.shareUv = shareUv;
    }

    @Override
    public String toString() {
        return "WxMnpSummaryTrend{" +
                "refDate='" + refDate + '\'' +
                ", visitTotal='" + visitTotal + '\'' +
                ", sharePv='" + sharePv + '\'' +
                ", shareUv='" + shareUv + '\'' +
                '}';
    }
}
