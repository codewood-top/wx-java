package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpJsErrSearchResult implements Serializable {

    public List<Result> results;

    private int total;
    private int errcode;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    @Override
    public String toString() {
        return "WxMnpJsErrSearchResult{" +
                "results=" + results +
                ", total=" + total +
                ", errcode=" + errcode +
                '}';
    }

    public static class Result implements Serializable {
        private Long time;
        @SerializedName("client_version")
        private String clientVersion;
        @SerializedName("app_version")
        private String appVersion;
        @SerializedName("version_error_cnt")
        private int versionErrorCnt;
        @SerializedName("total_error_cnt")
        private int totalErrorCnt;
        private String errmsg;

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public String getClientVersion() {
            return clientVersion;
        }

        public void setClientVersion(String clientVersion) {
            this.clientVersion = clientVersion;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public int getVersionErrorCnt() {
            return versionErrorCnt;
        }

        public void setVersionErrorCnt(int versionErrorCnt) {
            this.versionErrorCnt = versionErrorCnt;
        }

        public int getTotalErrorCnt() {
            return totalErrorCnt;
        }

        public void setTotalErrorCnt(int totalErrorCnt) {
            this.totalErrorCnt = totalErrorCnt;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "time=" + time +
                    ", clientVersion='" + clientVersion + '\'' +
                    ", appVersion='" + appVersion + '\'' +
                    ", versionErrorCnt=" + versionErrorCnt +
                    ", totalErrorCnt=" + totalErrorCnt +
                    ", errmsg='" + errmsg + '\'' +
                    '}';
        }
    }

}
