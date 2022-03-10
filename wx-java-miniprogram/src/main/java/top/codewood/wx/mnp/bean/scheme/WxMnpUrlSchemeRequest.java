package top.codewood.wx.mnp.bean.scheme;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpUrlSchemeRequest implements Serializable {

    /**
     * 跳转到的目标小程序信息。
     */
    @SerializedName("jump_wxa")
    private JumpWxa jumpWxa;

    /**
     * 生成的scheme码类型，到期失效：true，永久有效：false。
     */
    @SerializedName("is_expire")
    private boolean expire;

    /**
     * default: 0
     * 到期失效的 scheme 码失效类型，失效时间：0，失效间隔天数：1
     */
    @SerializedName("expire_type")
    private int expireType;

    /**
     * 到期失效的 scheme 码的失效时间，为 Unix 时间戳。
     * 生成的到期失效 scheme 码在该时间前有效。最长有效期为1年。
     * is_expire 为 true 且 expire_type 为 0 时必填
     */
    @SerializedName("expire_time")
    private Long expireTime;

    /**
     * 到期失效的 scheme 码的失效间隔天数。
     * 生成的到期失效 scheme 码在该间隔时间到达前有效。
     * 最长间隔天数为365天。is_expire 为 true 且 expire_type 为 1 时必填
     */
    @SerializedName("expire_interval")
    private int expireInterval;

    public JumpWxa getJumpWxa() {
        return jumpWxa;
    }

    public void setJumpWxa(JumpWxa jumpWxa) {
        this.jumpWxa = jumpWxa;
    }

    public boolean isExpire() {
        return expire;
    }

    public void setExpire(boolean expire) {
        this.expire = expire;
    }

    public int getExpireType() {
        return expireType;
    }

    public void setExpireType(int expireType) {
        this.expireType = expireType;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public int getExpireInterval() {
        return expireInterval;
    }

    public void setExpireInterval(int expireInterval) {
        this.expireInterval = expireInterval;
    }

    @Override
    public String toString() {
        return "WxMnpSchemeRequest{" +
                "jumpWxa=" + jumpWxa +
                ", expire=" + expire +
                ", expireType=" + expireType +
                ", expireTime=" + expireTime +
                ", expireInterval=" + expireInterval +
                '}';
    }

    public static class JumpWxa implements Serializable {

        /**
         * 通过scheme码进入的小程序页面路径，必须是已经发布的小程序存在的页面，不可携带query。path为空时会跳转小程序主页。
         */
        private String path;

        /**
         * 通过scheme码进入小程序时的query，最大1024个字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~
         */
        private String query;

        /**
         * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"，仅在微信外打开时生效。体验版和开发版仅在iOS上支持，Android将在近期支持。
         */
        @SerializedName("env_version")
        private String envVersion;

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

        public String getEnvVersion() {
            return envVersion;
        }

        public void setEnvVersion(String envVersion) {
            this.envVersion = envVersion;
        }

        @Override
        public String toString() {
            return "JumpWxa{" +
                    "path='" + path + '\'' +
                    ", query='" + query + '\'' +
                    ", envVersion='" + envVersion + '\'' +
                    '}';
        }
    }


}
