package top.codewood.wx.mnp.bean.analysis;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

public class WxMnpVisitTrend implements Serializable {

    /**
     * 日期，格式为 yyyyMMdd
     * 周：yyyyMMdd-yyyyMMdd
     * 月：yyyyMM
     */
    @XStreamAlias("ref_date")
    private String refDate;

    /**
     * 打开次数
     */
    @XStreamAlias("session_cnt")
    private int sessionCnt;

    /**
     * 访问次数
     */
    @XStreamAlias("visit_pv")
    private int visitPv;

    /**
     * 访问人数
     */
    @XStreamAlias("visit_uv")
    private int visitUv;

    /**
     * 新用户数
     */
    @XStreamAlias("visit_uv_new")
    private int visitUvNew;

    /**
     * 人均停留时长 (浮点型，单位：秒)
     */
    @XStreamAlias("stay_time_uv")
    private int stayTimeUv;

    /**
     * 次均停留时长 (浮点型，单位：秒)
     */
    @XStreamAlias("stay_time_session")
    private int stayTimeSession;

    /**
     * 平均访问深度 (浮点型)
     */
    @XStreamAlias("visit_depth")
    private int visitDepth;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public int getSessionCnt() {
        return sessionCnt;
    }

    public void setSessionCnt(int sessionCnt) {
        this.sessionCnt = sessionCnt;
    }

    public int getVisitPv() {
        return visitPv;
    }

    public void setVisitPv(int visitPv) {
        this.visitPv = visitPv;
    }

    public int getVisitUv() {
        return visitUv;
    }

    public void setVisitUv(int visitUv) {
        this.visitUv = visitUv;
    }

    public int getVisitUvNew() {
        return visitUvNew;
    }

    public void setVisitUvNew(int visitUvNew) {
        this.visitUvNew = visitUvNew;
    }

    public int getStayTimeUv() {
        return stayTimeUv;
    }

    public void setStayTimeUv(int stayTimeUv) {
        this.stayTimeUv = stayTimeUv;
    }

    public int getStayTimeSession() {
        return stayTimeSession;
    }

    public void setStayTimeSession(int stayTimeSession) {
        this.stayTimeSession = stayTimeSession;
    }

    public int getVisitDepth() {
        return visitDepth;
    }

    public void setVisitDepth(int visitDepth) {
        this.visitDepth = visitDepth;
    }

    @Override
    public String toString() {
        return "WxMnpVisitTrend{" +
                "refDate='" + refDate + '\'' +
                ", sessionCnt=" + sessionCnt +
                ", visitPv=" + visitPv +
                ", visitUv=" + visitUv +
                ", visitUvNew=" + visitUvNew +
                ", stayTimeUv=" + stayTimeUv +
                ", stayTimeSession=" + stayTimeSession +
                ", visitDepth=" + visitDepth +
                '}';
    }
}
