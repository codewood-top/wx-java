package top.codewood.wx.mnp.bean.scheme;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpUrlSchemeQueryResult implements Serializable {

    /**
     * scheme 配置
     */
    @SerializedName("scheme_info")
    private SchemeInfo schemeInfo;
    /**
     * quota 配置
     */
    @SerializedName("scheme_quota")
    private SchemeQuota schemeQuota;

    public SchemeInfo getSchemeInfo() {
        return schemeInfo;
    }

    public void setSchemeInfo(SchemeInfo schemeInfo) {
        this.schemeInfo = schemeInfo;
    }

    public SchemeQuota getSchemeQuota() {
        return schemeQuota;
    }

    public void setSchemeQuota(SchemeQuota schemeQuota) {
        this.schemeQuota = schemeQuota;
    }

    @Override
    public String toString() {
        return "WxMnpUrlSchemeQueryResult{" +
                "schemeInfo=" + schemeInfo +
                ", schemeQuota=" + schemeQuota +
                '}';
    }

    public static class SchemeInfo implements Serializable {
        /**
         * 小程序 appid
         */
        private String appid;
        /**
         * 小程序页面路径
         */
        private String path;
        /**
         * 小程序页面query
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

        @Override
        public String toString() {
            return "SchemeInfo{" +
                    "appid='" + appid + '\'' +
                    ", path='" + path + '\'' +
                    ", query='" + query + '\'' +
                    ", createTime=" + createTime +
                    ", expireTime=" + expireTime +
                    ", envVersion='" + envVersion + '\'' +
                    '}';
        }
    }

    public static class SchemeQuota implements Serializable {

        /**
         * 长期有效 scheme 已生成次数
         */
        @SerializedName("long_time_used")
        private int longTimeUsed;
        /**
         * 长期有效 scheme 生成次数上限
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
            return "SchemeQuota{" +
                    "longTimeUsed=" + longTimeUsed +
                    ", longTimeLimit=" + longTimeLimit +
                    '}';
        }
    }


}
