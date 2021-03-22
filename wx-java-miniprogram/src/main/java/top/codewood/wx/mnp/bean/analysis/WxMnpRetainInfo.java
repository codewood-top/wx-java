package top.codewood.wx.mnp.bean.analysis;

import java.io.Serializable;
import java.util.Map;

public class WxMnpRetainInfo implements Serializable {

    /**
     * 日期
     * 日留存：日期，yyyymmdd 格式，如 20210321
     * 周留存：时间，如"20210301-20210321"
     * 月留存：时间，如"202103"
     */
    private String refDate;

    /**
     * 新增用户留存
     * key: 标识，0开始，表示当天，1表示1天后。依此类推，key取值分别是：0,1,2,3,4,5,6,7,14,30
     * value: key对应日期的新增用户数/活跃用户数（key=0时）或留存用户数（k>0时）
     */
    private Map<Integer, Integer> visitUvNew;

    /**
     * 活跃用户留存
     * key: 标识，0开始，表示当天，1表示1天后。依此类推，key取值分别是：0,1,2,3,4,5,6,7,14,30
     * value: key对应日期的新增用户数/活跃用户数（key=0时）或留存用户数（k>0时）
     */
    private Map<Integer, Integer> visitUv;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public Map<Integer, Integer> getVisitUvNew() {
        return visitUvNew;
    }

    public void setVisitUvNew(Map<Integer, Integer> visitUvNew) {
        this.visitUvNew = visitUvNew;
    }

    public Map<Integer, Integer> getVisitUv() {
        return visitUv;
    }

    public void setVisitUv(Map<Integer, Integer> visitUv) {
        this.visitUv = visitUv;
    }

    @Override
    public String toString() {
        return "WxMnpRetainInfo{" +
                "refDate='" + refDate + '\'' +
                ", visitUvNew=" + visitUvNew +
                ", visitUv=" + visitUv +
                '}';
    }
}
