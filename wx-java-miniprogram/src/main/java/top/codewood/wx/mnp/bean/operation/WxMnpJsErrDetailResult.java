package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpJsErrDetailResult implements Serializable {

    private boolean success;
    private String openid;
    private List<WxMnpJsErrStack> data;
    private int totalCount;
    private int errcode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List<WxMnpJsErrStack> getData() {
        return data;
    }

    public void setData(List<WxMnpJsErrStack> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    @Override
    public String toString() {
        return "WxMnpJsErrDetailResult{" +
                "success=" + success +
                ", openid='" + openid + '\'' +
                ", data=" + data +
                ", totalCount=" + totalCount +
                ", errcode=" + errcode +
                '}';
    }

    public static class WxMnpJsErrStack implements Serializable {
        @SerializedName("Count")
        private String count;
        private String sdkVersion;
        @SerializedName("ClientVersion")
        private String clientVersion;
        private String errorStackMd5;
        @SerializedName("TimeStamp")
        private String timeStamp;
        private String appVersion;
        private String errorMsgMd5;
        private String errorMsg;
        @SerializedName("Ds")
        private String ds;
        @SerializedName("OsName")
        private String osName;
        @SerializedName("openId")
        private String openid;
        @SerializedName("pluginversion")
        private String pluginVersion;
        @SerializedName("appId")
        private String appid;
        @SerializedName("DeviceModel")
        private String deviceModel;
        private String source;
        private String route;
        @SerializedName("Uin")
        private String uin;
        private String nickname;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getSdkVersion() {
            return sdkVersion;
        }

        public void setSdkVersion(String sdkVersion) {
            this.sdkVersion = sdkVersion;
        }

        public String getClientVersion() {
            return clientVersion;
        }

        public void setClientVersion(String clientVersion) {
            this.clientVersion = clientVersion;
        }

        public String getErrorStackMd5() {
            return errorStackMd5;
        }

        public void setErrorStackMd5(String errorStackMd5) {
            this.errorStackMd5 = errorStackMd5;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public String getErrorMsgMd5() {
            return errorMsgMd5;
        }

        public void setErrorMsgMd5(String errorMsgMd5) {
            this.errorMsgMd5 = errorMsgMd5;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getDs() {
            return ds;
        }

        public void setDs(String ds) {
            this.ds = ds;
        }

        public String getOsName() {
            return osName;
        }

        public void setOsName(String osName) {
            this.osName = osName;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getPluginVersion() {
            return pluginVersion;
        }

        public void setPluginVersion(String pluginVersion) {
            this.pluginVersion = pluginVersion;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getDeviceModel() {
            return deviceModel;
        }

        public void setDeviceModel(String deviceModel) {
            this.deviceModel = deviceModel;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getRoute() {
            return route;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public String getUin() {
            return uin;
        }

        public void setUin(String uin) {
            this.uin = uin;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "JsErrStack{" +
                    "count='" + count + '\'' +
                    ", sdkVersion='" + sdkVersion + '\'' +
                    ", clientVersion='" + clientVersion + '\'' +
                    ", errorStackMd5='" + errorStackMd5 + '\'' +
                    ", timeStamp='" + timeStamp + '\'' +
                    ", appVersion='" + appVersion + '\'' +
                    ", errorMsgMd5='" + errorMsgMd5 + '\'' +
                    ", errorMsg='" + errorMsg + '\'' +
                    ", ds='" + ds + '\'' +
                    ", osName='" + osName + '\'' +
                    ", openid='" + openid + '\'' +
                    ", pluginVersion='" + pluginVersion + '\'' +
                    ", appid='" + appid + '\'' +
                    ", deviceModel='" + deviceModel + '\'' +
                    ", source='" + source + '\'' +
                    ", route='" + route + '\'' +
                    ", uin='" + uin + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }

}
