package top.codewood.wx.mnp.bean.operation;

import top.codewood.wx.annotation.Required;

import java.io.Serializable;

public class WxMnpJsErrListRequest implements Serializable {

    /**
     * 小程序版本："0"代表全部, 例如："2.0.18"
     */
    @Required
    private String appVersion = "0";

    /**
     * 错误类型: "0": 全部, "1": 业务代码错误, "2": "插件错误", "3": "系统框架错误"
     */
    private String errType = "0";

    /**
     * 开始时间， 格式"xxxx-xx-xx"
     */
    @Required
    private String startTime;

    /**
     * 结束时间, 格式"xxxx-xx-xx"
     */
    @Required
    private String endTime;

    /**
     * 从错误中搜索关键词，关键词过滤
     */
    @Required
    private String keyword;

    /**
     * 发生错误的用户openId
     */
    @Required
    private String openid;

    /**
     * 排序字段"uv", "pv" 二选一
     */
    private String orderby;

    /**
     * 排序规则 "1" orderby字段降序，"2" orderby字段升序
     */
    private String desc = "1";

    /**
     * 分页起始值
     */
    private int offset;

    /**
     * 一次拉取最大值，最大 30
     */
    private int limit;


    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "WxMnpJsErrListRequest{" +
                "appVersion='" + appVersion + '\'' +
                ", errType=" + errType +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", keyword='" + keyword + '\'' +
                ", openid='" + openid + '\'' +
                ", orderby='" + orderby + '\'' +
                ", desc=" + desc +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }

    public static class Builder {
        private String appVersion = "0";
        private String errType = "0";
        private String startTime;
        private String endTime;
        private String keyword;
        private String openid;
        private String orderby;
        private String desc = "1";
        private int offset;
        private int limit;

        public Builder appVersion(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        public Builder errType(String errType) {
            this.errType = errType;
            return this;
        }

        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public Builder openid(String openid) {
            this.openid = openid;
            return this;
        }

        public Builder orderby(String orderby) {
            this.orderby = orderby;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder offset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public WxMnpJsErrListRequest build() {
            WxMnpJsErrListRequest jsErrListRequest = new WxMnpJsErrListRequest();
            jsErrListRequest.setAppVersion(this.appVersion);
            jsErrListRequest.setErrType(this.errType);
            jsErrListRequest.setStartTime(this.startTime);
            jsErrListRequest.setEndTime(this.endTime);
            jsErrListRequest.setKeyword(this.keyword);
            jsErrListRequest.setOpenid(this.openid);
            jsErrListRequest.setOrderby(this.orderby);
            jsErrListRequest.setDesc(this.desc);
            jsErrListRequest.setOffset(this.offset);
            jsErrListRequest.setLimit(this.limit);
            return jsErrListRequest;
        }

    }
}
