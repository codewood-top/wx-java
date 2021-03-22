package top.codewood.wx.mnp.bean.analysis;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxMnpPerformanceRequest implements Serializable {

    /**
     * 开始和结束日期的时间戳，时间跨度不能超过30天
     */
    private Time time;

    /**
     * 查询数据的类型
     * 10016: 打开率, params字段可传入网络类型和机型
     * 10017: 启动各阶段耗时，params字段可传入网络类型和机型
     * 10021: 页面切换耗时，params数组字段可传入机型
     * 10022: 内存指标，params数组字段可传入机型
     * 10023: 内存异常，params数组字段可传入机型
     * @see Module
     */
    private String module;

    /**
     * 查询条件，比如机型，网络类型等等
     * networktype: 网络类型作为查询条件，value=“-1,3g,4g,wifi”分别表示 全部网络类型，3G，4G，WIFI,不传networktype默认为全部网络类型
     * device_level: 机型作为查询条件，此时value=“-1,1,2,3”分别表示 全部机型，高档机，中档机，低档机,不传device_level默认为全部机型
     * device: 平台作为查询条件，此时value="-1,1,2"分别表示 全部平台，IOS平台，安卓平台,不传device默认为全部平台
     */
    private List<Param> params;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public void addParam(String field, String value) {
        if (this.params == null) this.params = new ArrayList<>();
        this.params.add(new Param(field, value));
    }

    public static class Time {
        /**
         * 开始日期时间戳
         */
        @SerializedName("begin_timestamp")
        private long beginTimeStamp;

        /**
         * 结束日期时间戳
         */
        @SerializedName("end_timestamp")
        private long endTimeStamp;

        public Time() {}

        public Time(Date beginDate, Date endDate) {
            this.beginTimeStamp = beginDate.getTime() / 1000;
            this.endTimeStamp = endDate.getTime() / 1000;
        }

        public Time(LocalDate beginDate, LocalDate endDate) {
            this.beginTimeStamp = beginDate.atStartOfDay(ZoneOffset.ofHours(8)).toEpochSecond();
            this.endTimeStamp = endDate.atStartOfDay(ZoneOffset.ofHours(8)).toEpochSecond();
        }

        public long getBeginTimeStamp() {
            return beginTimeStamp;
        }

        public void setBeginTimeStamp(long beginTimeStamp) {
            this.beginTimeStamp = beginTimeStamp;
        }

        public long getEndTimeStamp() {
            return endTimeStamp;
        }

        public void setEndTimeStamp(long endTimeStamp) {
            this.endTimeStamp = endTimeStamp;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "beginTimeStamp=" + beginTimeStamp +
                    ", endTimeStamp=" + endTimeStamp +
                    '}';
        }
    }

    public interface Module {

        /**
         * 打开率, params字段可传入网络类型和机型
         */
        String M_10016 = "10016";

        /**
         * 启动各阶段耗时，params字段可传入网络类型和机型
         */
        String M_10017 = "10017";

        /**
         * 页面切换耗时，params数组字段可传入机型
         */
        String M_10021 = "10021";

        /**
         * 内存指标，params数组字段可传入机型
         */
        String M_10022 = "10022";

        /**
         * 内存异常，params数组字段可传入机型
         */
        String M_10023 = "10023";

    }

    public static class Param {
        /**
         * 查询条件
         */
        private String field;
        /**
         * 查询条件值
         */
        private String value;

        public Param() {}

        public Param(String field, String value) {
            this.field = field;
            this.value = value;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Param{" +
                    "field='" + field + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PreformanceRequest{" +
                "time=" + time +
                ", module='" + module + '\'' +
                ", params=" + params +
                '}';
    }
}
