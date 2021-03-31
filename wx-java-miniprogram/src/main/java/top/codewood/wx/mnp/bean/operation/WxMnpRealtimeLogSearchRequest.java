package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;
import org.dom4j.CDATA;
import top.codewood.wx.annotation.Required;

import java.io.Serializable;

public class WxMnpRealtimeLogSearchRequest implements Serializable {

    /**
     * YYYYMMDD格式的日期，仅支持最近7天
     */
    @Required
    private String date;

    /**
     * 开始时间，必须是date指定日期的时间
     */
    @Required
    @SerializedName("begintime")
    private long beginTime;

    /**
     * 结束时间，必须是date指定日期的时间
     */
    @Required
    @SerializedName("endtime")
    private long endTime;

    /**
     * 开始返回的数据下标，用作分页，默认为0
     */
    private int start = 0;

    /**
     * 返回的数据条数，用作分页，默认为20
     */
    private int limit = 20;

    /**
     * 小程序启动的唯一ID，按TraceId查询会展示该次小程序启动过程的所有页面的日志。
     */
    private String traceId;

    /**
     * 小程序页面路径，例如pages/index/index
     */
    private String url;

    /**
     * 用户微信号或者OpenId
     */
    private String id;

    /**
     * 开发者通过setFileterMsg/addFilterMsg指定的filterMsg字段
     */
    private String filterMsg;

    /**
     * 日志等级，返回大于等于level等级的日志，level的定义为2（Info）、4（Warn）、8（Error），如果指定为4，则返回大于等于4的日志，即返回Warn和Error日志。
     */
    private Integer level;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilterMsg() {
        return filterMsg;
    }

    public void setFilterMsg(String filterMsg) {
        this.filterMsg = filterMsg;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "WxMnpRealtimeLogSearchRequest{" +
                "date='" + date + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", start=" + start +
                ", limit=" + limit +
                ", traceId='" + traceId + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", filterMsg='" + filterMsg + '\'' +
                ", level=" + level +
                '}';
    }

    public static class Builder {
        private String date;
        private long beginTime;
        private long endTime;
        private int start = 0;
        private int limit = 20;
        private String traceId;
        private String url;
        private String id;
        private String filterMsg;
        private Integer level;

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder beginTime(long beginTime) {
            this.beginTime = beginTime;
            return this;
        }

        public Builder endTime(long endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder start(int start) {
            this.start = start;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public Builder traceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder filterMsg(String filterMsg) {
            this.filterMsg = filterMsg;
            return this;
        }

        public Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public WxMnpRealtimeLogSearchRequest build() {
            WxMnpRealtimeLogSearchRequest realtimeLogSearchRequest = new WxMnpRealtimeLogSearchRequest();
            realtimeLogSearchRequest.setDate(this.date);
            realtimeLogSearchRequest.setBeginTime(this.beginTime);
            realtimeLogSearchRequest.setEndTime(this.endTime);
            realtimeLogSearchRequest.setStart(this.start);
            realtimeLogSearchRequest.setLimit(this.limit);
            realtimeLogSearchRequest.setTraceId(this.traceId);
            realtimeLogSearchRequest.setUrl(this.url);
            realtimeLogSearchRequest.setId(this.id);
            realtimeLogSearchRequest.setFilterMsg(this.filterMsg);
            realtimeLogSearchRequest.setLevel(this.level);
            return realtimeLogSearchRequest;
        }

    }

}
