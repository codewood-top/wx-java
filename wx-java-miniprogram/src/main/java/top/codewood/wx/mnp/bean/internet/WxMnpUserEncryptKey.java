package top.codewood.wx.mnp.bean.internet;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpUserEncryptKey implements Serializable {

    /**
     * 加密key
     */
    @SerializedName("encrypt_key")
    private String encryptKey;

    /**
     * key的版本号
     */
    private int version;
    /**
     * 剩余有效时间
     */
    @SerializedName("expire_in")
    private int expireIn;
    /**
     * 加密iv
     */
    private String iv;

    /**
     * 创建key的时间戳，计数单位：秒
     */
    @SerializedName("create_time")
    private int createTime;

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WxMnpUserEncryptKey{" +
                "encryptKey='" + encryptKey + '\'' +
                ", version=" + version +
                ", expireIn=" + expireIn +
                ", iv='" + iv + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
