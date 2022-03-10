package top.codewood.wx.mnp.bean.security;

import java.io.Serializable;

public class WxMnpSecurityBaseRequest implements Serializable {

    /**
     * 必填
     * 接口版本号，2.0版本为固定值2
     */
    protected Integer version = 2;

    /**
     * 必填
     * 用户的openid（用户需在近两小时访问过小程序）
     */
    protected String openid;

    /**
     * 必填
     * 场景枚举值（1 资料；2 评论；3 论坛；4 社交日志）
     */
    protected Integer scene;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getScene() {
        return scene;
    }

    public void setScene(Integer scene) {
        this.scene = scene;
    }
}
