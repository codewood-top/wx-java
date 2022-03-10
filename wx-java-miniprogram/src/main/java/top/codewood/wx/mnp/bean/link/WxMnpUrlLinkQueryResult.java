package top.codewood.wx.mnp.bean.link;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpUrlLinkQueryResult implements Serializable {

    /**
     * url_link 配置
     */
    @SerializedName("url_link_info")
    private UrlLinkInfo urlLinkInfo;
    /**
     * quota 配置
     */
    @SerializedName("url_link_quota")
    private UrlLinkQuota urlLinkQuota;

    public UrlLinkInfo getUrlLinkInfo() {
        return urlLinkInfo;
    }

    public void setUrlLinkInfo(UrlLinkInfo urlLinkInfo) {
        this.urlLinkInfo = urlLinkInfo;
    }

    public UrlLinkQuota getUrlLinkQuota() {
        return urlLinkQuota;
    }

    public void setUrlLinkQuota(UrlLinkQuota urlLinkQuota) {
        this.urlLinkQuota = urlLinkQuota;
    }

    @Override
    public String toString() {
        return "WxMnpUrlLinkQueryResult{" +
                "urlLinkInfo=" + urlLinkInfo +
                ", urlLinkQuota=" + urlLinkQuota +
                '}';
    }

    public static class UrlLinkInfo implements Serializable {

        /**
         * 小程序 appid
         */
        private String appid;
        /**
         * 小程序页面路径
         */
        private String path;
        /**小程序页面query
         *
         */
        private String query;
        /**
         * 创建时间，为 Unix 时间戳
         */
        @SerializedName("create_time")
        private int createTime;
        /**
         * 到期失效时间，为 Unix 时间戳，0 表示永久生效
         */
        @SerializedName("expire_time")
        private int expireTime;

        /**
         * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"
         */
        @SerializedName("env_version")
        private String envVersion;

        /**
         * 云开发配置
         */
        @SerializedName("cloud_base")
        private CloudBase cloudBase;


        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public int getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(int expireTime) {
            this.expireTime = expireTime;
        }

        public String getEnvVersion() {
            return envVersion;
        }

        public void setEnvVersion(String envVersion) {
            this.envVersion = envVersion;
        }

        public CloudBase getCloudBase() {
            return cloudBase;
        }

        public void setCloudBase(CloudBase cloudBase) {
            this.cloudBase = cloudBase;
        }

        @Override
        public String toString() {
            return "UrlLinkInfo{" +
                    "appid='" + appid + '\'' +
                    ", path='" + path + '\'' +
                    ", query='" + query + '\'' +
                    ", createTime=" + createTime +
                    ", expireTime=" + expireTime +
                    ", envVersion='" + envVersion + '\'' +
                    ", cloudBase=" + cloudBase +
                    '}';
        }

    }

    public static class UrlLinkQuota implements Serializable {
        /**
         * 长期有效 url_link 已生成次数
         */
        @SerializedName("long_time_used")
        private int longTimeUsed;
        /**
         * 长期有效 url_link 生成次数上限
         */
        @SerializedName("long_time_limit")
        private int longTimeLimit;

        public int getLongTimeUsed() {
            return longTimeUsed;
        }

        public void setLongTimeUsed(int longTimeUsed) {
            this.longTimeUsed = longTimeUsed;
        }

        public int getLongTimeLimit() {
            return longTimeLimit;
        }

        public void setLongTimeLimit(int longTimeLimit) {
            this.longTimeLimit = longTimeLimit;
        }

        @Override
        public String toString() {
            return "UrlLinkQuota{" +
                    "longTimeUsed=" + longTimeUsed +
                    ", longTimeLimit=" + longTimeLimit +
                    '}';
        }
    }


}
