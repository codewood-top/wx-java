package top.codewood.wx.mnp.bean.scheme;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpSchemeRequest implements Serializable {

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
     * 到期失效的scheme码的失效时间，为Unix时间戳。生成的到期失效scheme码在该时间前有效。最长有效期为1年。生成到期失效的scheme时必填。
     */
    @SerializedName("expire_time")
    private Long expireTime;

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

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "WxMnpSchemeRequest{" +
                "jumpWxa=" + jumpWxa +
                ", expire=" + expire +
                ", expireTime=" + expireTime +
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

        @Override
        public String toString() {
            return "JumpWxa{" +
                    "path='" + path + '\'' +
                    ", query='" + query + '\'' +
                    '}';
        }
    }


}
