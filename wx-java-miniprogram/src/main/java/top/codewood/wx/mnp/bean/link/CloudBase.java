package top.codewood.wx.mnp.bean.link;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CloudBase implements Serializable {
    /**
     * 必填：是
     * <p>
     * 云开发环境
     */
    private String env;
    /**
     * 必填：否
     * <p>
     * 静态网站自定义域名，不填则使用默认域名
     */
    private String domain;
    /**
     * 必填：否
     * default: /
     * <p>
     * 云开发静态网站 H5 页面路径，不可携带 query
     */
    private String path;
    /**
     * 必填：否
     * <p>
     * 云开发静态网站 H5 页面 query 参数，
     * 最大 1024 个字符，只支持数字，
     * 大小写英文以及部分特殊字符：`!#$&'()*+,/:;=?@-._~%``
     */
    private String query;
    /**
     * 必填：否
     * <p>
     * 第三方批量代云开发时必填，表示创建该 env 的 appid （小程序/第三方平台）
     * 返回值
     */
    @SerializedName("resource_appid")
    private String resourceAppid;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    public String getResourceAppid() {
        return resourceAppid;
    }

    public void setResourceAppid(String resourceAppid) {
        this.resourceAppid = resourceAppid;
    }

    @Override
    public String toString() {
        return "CloudBase{" +
                "env='" + env + '\'' +
                ", domain='" + domain + '\'' +
                ", path='" + path + '\'' +
                ", query='" + query + '\'' +
                ", resourceAppid='" + resourceAppid + '\'' +
                '}';
    }
}
