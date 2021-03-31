package top.codewood.wx.mnp.bean.operation;

import top.codewood.wx.annotation.Required;

import java.io.Serializable;

public class WxMnpJsErrDetailRequest implements Serializable {

    /**
     * 开始时间， 格式 "xxxx-xx-xx"
     */
    @Required
    private String startTime;

    /**
     * 结束时间，格式 “xxxx-xx-xx”
     */
    @Required
    private String ednTime;

    /**
     * getJsErrList 返回的 errorMsgMd5 字段
     */
    @Required
    private String errorMsgMd5;

    /**
     * getJsErrList 返回的 errorStackMd5 字段
     */
    @Required
    private String errorStackMd5;

    /**
     * 小程序版本 "0"代表全部， 例如：“2.0.18”
     */
    @Required
    private String appVersion = "0";

    /**
     * 基础库版本 "0"表示所有版本，例如 "2.14.1"
     */
    @Required
    private String sdkVersion = "0";

    /**
     * 系统类型 "0"【全部】，"1" 【安卓】，"2" 【IOS】，"3"【其他】
     */
    @Required
    public String osName = "0";

    /**
     * 客户端版本 "0"表示所有版本， 例如 "7.0.22"
     */
    @Required
    private String clientVersion = "0";

    /**
     * 发生错误的用户 openId
     */
    @Required
    private String openid;

    /**
     * 排序规则 "0" 升序, "1" 降序
     */
    private String desc = "1";

    /**
     * 分页起始值
     */
    private int offset = 1;

    /**
     * 一次拉取最大值
     */
    private int limit = 30;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEdnTime() {
        return ednTime;
    }

    public void setEdnTime(String ednTime) {
        this.ednTime = ednTime;
    }

    public String getErrorMsgMd5() {
        return errorMsgMd5;
    }

    public void setErrorMsgMd5(String errorMsgMd5) {
        this.errorMsgMd5 = errorMsgMd5;
    }

    public String getErrorStackMd5() {
        return errorStackMd5;
    }

    public void setErrorStackMd5(String errorStackMd5) {
        this.errorStackMd5 = errorStackMd5;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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
        return "WxMnpJsErrDetailRequest{" +
                "startTime='" + startTime + '\'' +
                ", ednTime='" + ednTime + '\'' +
                ", errorMsgMd5='" + errorMsgMd5 + '\'' +
                ", errorStackMd5='" + errorStackMd5 + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", sdkVersion='" + sdkVersion + '\'' +
                ", osName='" + osName + '\'' +
                ", clientVersion='" + clientVersion + '\'' +
                ", openid='" + openid + '\'' +
                ", desc='" + desc + '\'' +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }

    public static class Builder {
        private String startTime;
        private String endTime;
        private String errorMsgMd5;
        private String errorStackMd5;
        private String appVersion = "0";
        private String sdkVersion = "0";
        private String osName = "0";
        private String clientVersion = "0";
        private String openid;
        private String desc = "0";
        private int offset = 1;
        private int limit = 30;

        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder errorMsgMd5(String errorMsgMd5) {
            this.errorMsgMd5 = errorMsgMd5;
            return this;
        }

        public Builder errorStackMd5(String errorStackMd5) {
            this.errorStackMd5 = errorStackMd5;
            return this;
        }

        public Builder appVersion(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        public Builder sdkVersion(String sdkVersion) {
            this.sdkVersion = sdkVersion;
            return this;
        }

        public Builder osName(String osName) {
            this.osName = osName;
            return this;
        }

        public Builder clientVersion(String clientVersion) {
            this.clientVersion = clientVersion;
            return this;
        }

        public Builder openid(String openid) {
            this.openid = openid;
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

        public WxMnpJsErrDetailRequest build() {
            WxMnpJsErrDetailRequest jsErrDetailRequest = new WxMnpJsErrDetailRequest();
            jsErrDetailRequest.setStartTime(this.startTime);
            jsErrDetailRequest.setEdnTime(this.endTime);
            jsErrDetailRequest.setErrorMsgMd5(this.errorMsgMd5);
            jsErrDetailRequest.setErrorStackMd5(this.errorStackMd5);
            jsErrDetailRequest.setAppVersion(this.appVersion);
            jsErrDetailRequest.setSdkVersion(this.sdkVersion);
            jsErrDetailRequest.setOsName(this.osName);
            jsErrDetailRequest.setClientVersion(this.clientVersion);
            jsErrDetailRequest.setOpenid(this.openid);
            jsErrDetailRequest.setDesc(this.desc);
            jsErrDetailRequest.setOffset(this.offset);
            jsErrDetailRequest.setLimit(this.limit);
            return jsErrDetailRequest;
        }

    }

}
