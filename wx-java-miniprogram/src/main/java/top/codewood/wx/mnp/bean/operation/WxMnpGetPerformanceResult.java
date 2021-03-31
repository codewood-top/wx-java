package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpGetPerformanceResult implements Serializable {

    private int errcode;
    private List<TimeData> defaultTimeData;
    private String compareTimeData;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public List<TimeData> getDefaultTimeData() {
        return defaultTimeData;
    }

    public void setDefaultTimeData(List<TimeData> defaultTimeData) {
        this.defaultTimeData = defaultTimeData;
    }

    public String getCompareTimeData() {
        return compareTimeData;
    }

    public void setCompareTimeData(String compareTimeData) {
        this.compareTimeData = compareTimeData;
    }

    @Override
    public String toString() {
        return "WxMnpGetPerformanceResult{" +
                "errcode=" + errcode +
                ", defaultTimeData=" + defaultTimeData +
                ", compareTimeData='" + compareTimeData + '\'' +
                '}';
    }

    public static class TimeData implements Serializable {
        @SerializedName("ref_date")
        private String refDate;
        @SerializedName("cost_time_type")
        private int costTimeType;
        @SerializedName("cost_time")
        private int costTime;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public int getCostTimeType() {
            return costTimeType;
        }

        public void setCostTimeType(int costTimeType) {
            this.costTimeType = costTimeType;
        }

        public int getCostTime() {
            return costTime;
        }

        public void setCostTime(int costTime) {
            this.costTime = costTime;
        }
    }

}
