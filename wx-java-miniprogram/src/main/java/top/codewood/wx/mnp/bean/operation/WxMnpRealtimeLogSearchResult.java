package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpRealtimeLogSearchResult implements Serializable {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxMnpRealtimeLogSearchResult{" +
                "data=" + data +
                '}';
    }

    public static class Data implements Serializable {
        private List<LogData> list;
        private int total;

        public List<LogData> getList() {
            return list;
        }

        public void setList(List<LogData> list) {
            this.list = list;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "list=" + list +
                    ", total=" + total +
                    '}';
        }
    }

    public static class LogData implements Serializable {
        /**
         * 日志等级，是msg数组里面的所有level字段的或操作得到的结果。例如msg数组里有两条日志，Info（值为2）和Warn（值为4），则level值为6
         */
        private Integer level;

        /**
         * 基础库版本
         */
        private String libraryVersion;

        /**
         * 客户端版本
         */
        private String clientVersion;

        /**
         * 微信用户OpenID
         */
        private String id;

        /**
         * 打日志的Unix时间戳
         */
        @SerializedName("timestamp")
        private long timeStamp;

        /**
         * 1 安卓 2 IOS
         */
        private int platform;

        /**
         * 小程序页面链接
         */
        private String url;

        /**
         * 日志内容数组，log.info等的内容存在这里
         */
        private List<Msg> msg;

        /**
         * 小程序启动的唯一ID，按TraceId查询会展示该次小程序启动过程的所有页面的日志。
         */
        private String traceid;

        /**
         * 微信用户OpenID
         */
        private String filterMsg;


        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public String getLibraryVersion() {
            return libraryVersion;
        }

        public void setLibraryVersion(String libraryVersion) {
            this.libraryVersion = libraryVersion;
        }

        public String getClientVersion() {
            return clientVersion;
        }

        public void setClientVersion(String clientVersion) {
            this.clientVersion = clientVersion;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }

        public int getPlatform() {
            return platform;
        }

        public void setPlatform(int platform) {
            this.platform = platform;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Msg> getMsg() {
            return msg;
        }

        public void setMsg(List<Msg> msg) {
            this.msg = msg;
        }

        public String getTraceid() {
            return traceid;
        }

        public void setTraceid(String traceid) {
            this.traceid = traceid;
        }

        public String getFilterMsg() {
            return filterMsg;
        }

        public void setFilterMsg(String filterMsg) {
            this.filterMsg = filterMsg;
        }

        @Override
        public String toString() {
            return "LogData{" +
                    "level=" + level +
                    ", libraryVersion='" + libraryVersion + '\'' +
                    ", clientVersion='" + clientVersion + '\'' +
                    ", id='" + id + '\'' +
                    ", timeStamp=" + timeStamp +
                    ", platform=" + platform +
                    ", url='" + url + '\'' +
                    ", msg=" + msg +
                    ", traceid='" + traceid + '\'' +
                    ", filterMsg='" + filterMsg + '\'' +
                    '}';
        }
    }

    private static class Msg implements Serializable {
        /**
         * log.info调用的时间
         */
        private long time;
        /**
         * log.info调用的内容，每个参数分别是数组的一项
         */
        private Integer level;
        /**
         * log.info调用的日志等级
         */
        private List<String> msg;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public List<String> getMsg() {
            return msg;
        }

        public void setMsg(List<String> msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "Msg{" +
                    "time=" + time +
                    ", level=" + level +
                    ", msg=" + msg +
                    '}';
        }
    }

}
