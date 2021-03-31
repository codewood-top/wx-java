package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.annotation.Required;

import java.io.Serializable;

public class WxMnpJsErrSearchRequest implements Serializable {

    /**
     * 错误关键字
     */
    @Required
    @SerializedName("errmsg_keyword")
    private String errmsgKeyword;

    /**
     * 查询类型，1 为客户端， 2为服务直达
     */
    private String type = "1";

    /**
     * 客户端版本，可以通过 getVersionList 接口拉取, 不传或者传空代表所有版本
     */
    @SerializedName("client_version")
    private String clientVersion = "";

    /**
     * 开始时间
     */
    @Required
    private Long startTime;

    /**
     * 结束时间
     */
    @Required
    private Long endTime;

    /**
     * 分页起始值
     */
    private int start = 1;

    /**
     * 一次拉取最大值
     */
    private int limit = 30;

    public String getErrmsgKeyword() {
        return errmsgKeyword;
    }

    public void setErrmsgKeyword(String errmsgKeyword) {
        this.errmsgKeyword = errmsgKeyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
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

    @Override
    public String toString() {
        return "WxMnpJsErrSearchRequest{" +
                "errmsgKeyword='" + errmsgKeyword + '\'' +
                ", type='" + type + '\'' +
                ", clientVersion='" + clientVersion + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", start=" + start +
                ", limit=" + limit +
                '}';
    }

    public static class Builder {

        private String errmsgKeyword;
        private String type;
        private String clientVersion;
        private Long startTime;
        private Long endTime;
        private int start = 1;
        private int limit = 30;

        public Builder errmsgKeyword(String errmsgKeyword) {
            this.errmsgKeyword = errmsgKeyword;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder clientVersion(String clientVersion) {
            this.clientVersion = clientVersion;
            return this;
        }

        public Builder startTime(long startTime) {
            this.startTime = startTime;
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

        public WxMnpJsErrSearchRequest build() {
            WxMnpJsErrSearchRequest jsErrSearchRequest = new WxMnpJsErrSearchRequest();
            jsErrSearchRequest.setErrmsgKeyword(this.errmsgKeyword);
            jsErrSearchRequest.setType(this.type);
            jsErrSearchRequest.setClientVersion(this.clientVersion);
            jsErrSearchRequest.setStartTime(this.startTime);
            jsErrSearchRequest.setEndTime(this.endTime);
            jsErrSearchRequest.setStart(this.start);
            jsErrSearchRequest.setLimit(this.limit);
            return jsErrSearchRequest;
        }


    }

}
