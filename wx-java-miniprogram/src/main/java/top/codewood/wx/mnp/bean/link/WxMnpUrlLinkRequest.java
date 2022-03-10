package top.codewood.wx.mnp.bean.link;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpUrlLinkRequest implements Serializable {

    /**
     * 必填：否
     *
     * 通过 URL Link 进入的小程序页面路径，
     * 必须是已经发布的小程序存在的页面，
     * 不可携带 query 。path 为空时会跳转小程序主页
     */
    private String path;
    /**
     * 必填：否
     *
     * 通过 URL Link 进入小程序时的query，最大1024个字符，
     * 只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~%
     */
    private String query;
    /**
     * 必填：否
     * default: "release"
     *
     * 	要打开的小程序版本。正式版为 "release"，体验版为"trial"，开发版为"develop"，
     * 	仅在微信外打开时生效。体验版和开发版仅在iOS上支持，Android将在近期支持。
     */
    @SerializedName("evn_version")
    private String envVersion;
    /**
     * 必填：否
     * default: false
     * 生成的 URL Link 类型，到期失效：true，永久有效：false。注意，
     * 永久有效 Link 和有效时间超过180天的到期失效 Link 的总数上限为10万个，
     * 详见获取 <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/url-link.html">URL Link</a>，生成 Link 前请仔细确认。
     */
    @SerializedName("is_expire")
    private boolean expire;
    /**
     * 必填: 否
     * default: 0
     *
     * 小程序 URL Link 失效类型，失效时间：0，失效间隔天数：1
     */
    @SerializedName("expire_type")
    private int expireType;
    /**
     * 必填： 否
     *
     * 到期失效的 URL Link 的失效时间，为 Unix 时间戳。
     * 生成的到期失效 URL Link 在该时间前有效。
     * 最长有效期为1年。expire_type 为 0 必填
     */
    @SerializedName("expire_time")
    private int expireTime;
    /**
     * 必填： 否
     *
     * 到期失效的URL Link的失效间隔天数。
     * 生成的到期失效URL Link在该间隔时间到达前有效。
     * 最长间隔天数为365天。expire_type 为 1 必填
     */
    @SerializedName("expire_interval")
    private int expireInterval;

    /**
     * 必填：否
     *
     * 云开发静态网站自定义 H5 配置参数，可配置中转的云开发 H5 页面。不填默认用官方 H5 页面
     */
    @SerializedName("cloud_base")
    private CloudBase cloudBase;

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

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    public int getExpireInterval() {
        return expireInterval;
    }

    public void setExpireInterval(int expireInterval) {
        this.expireInterval = expireInterval;
    }

    public CloudBase getCloudBase() {
        return cloudBase;
    }

    public void setCloudBase(CloudBase cloudBase) {
        this.cloudBase = cloudBase;
    }

    @Override
    public String toString() {
        return "WxMnpUrlLinkRequest{" +
                "path='" + path + '\'' +
                ", query='" + query + '\'' +
                ", envVersion='" + envVersion + '\'' +
                ", expire=" + expire +
                ", expireType=" + expireType +
                ", expireTime=" + expireTime +
                ", expireInterval=" + expireInterval +
                ", cloudBase=" + cloudBase +
                '}';
    }


}
