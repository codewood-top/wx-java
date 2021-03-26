package top.codewood.wx.mnp.bean.user;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.mnp.bean.WaterMark;

import java.io.Serializable;

public class WxMnpUserInfo implements Serializable {

    @SerializedName("openId")
    private String openid;
    @SerializedName("nickName")
    private String nickname;
    private String gender;
    private String province;
    private String city;
    private String avatarUrl;
    private String unionId;

    @SerializedName("watermark")
    private WaterMark waterMark;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public WaterMark getWaterMark() {
        return waterMark;
    }

    public void setWaterMark(WaterMark waterMark) {
        this.waterMark = waterMark;
    }

    @Override
    public String toString() {
        return "WxMnpUserInfo{" +
                "openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", unionId='" + unionId + '\'' +
                ", waterMark=" + waterMark +
                '}';
    }
}
