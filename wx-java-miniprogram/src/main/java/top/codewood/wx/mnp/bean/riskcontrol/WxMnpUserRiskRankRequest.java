package top.codewood.wx.mnp.bean.riskcontrol;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.annotation.Required;

import java.io.Serializable;

public class WxMnpUserRiskRankRequest implements Serializable {

    @Required
    private String appid;

    @Required
    private String openid;

    /**
     * 场景值, 0:注册, 1:营销作弊
     */
    @Required
    private int scene;

    /**
     * 用户手机号
     */
    @SerializedName("mobile_no")
    private String mobileNo;

    /**
     * 用户访问源IP
     */
    @Required
    @SerializedName("client_ip")
    private String clientIp;

    /**
     * 用户邮箱地址
     */
    @SerializedName("email_address")
    private String emailAddress;

    /**
     * 额外补充信息
     */
    @SerializedName("extended_info")
    private String extendedInfo;

    /**
     * false: 正式调用, true: 测试调用
     */
    @SerializedName("is_test")
    private boolean test;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getExtendedInfo() {
        return extendedInfo;
    }

    public void setExtendedInfo(String extendedInfo) {
        this.extendedInfo = extendedInfo;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "WxMnpUserRiskRankRequest{" +
                "appid='" + appid + '\'' +
                ", openid='" + openid + '\'' +
                ", scene=" + scene +
                ", mobileNo='" + mobileNo + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", extendedInfo='" + extendedInfo + '\'' +
                ", test=" + test +
                '}';
    }

    public static class Builder {
        private String appid;
        private String openid;
        private int scene;
        private String mobileNo;
        private String clientIp;
        private String emailAddress;
        private String extendedInfo;
        private boolean test;

        public Builder appid(String appid) {
            this.appid = appid;
            return this;
        }

        public Builder openid(String openid) {
            this.openid = openid;
            return this;
        }

        public Builder scene(int scene) {
            this.scene = scene;
            return this;
        }

        public Builder mobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }

        public Builder clientIp(String clientIp) {
            this.clientIp = clientIp;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder extendedInfo(String extendedInfo) {
            this.extendedInfo = extendedInfo;
            return this;
        }

        public Builder test(boolean test) {
            this.test = test;
            return this;
        }

        public WxMnpUserRiskRankRequest build() {
            WxMnpUserRiskRankRequest userRiskRankRequest = new WxMnpUserRiskRankRequest();
            userRiskRankRequest.setOpenid(this.openid);
            userRiskRankRequest.setAppid(this.appid);
            userRiskRankRequest.setScene(this.scene);
            userRiskRankRequest.setMobileNo(this.mobileNo);
            userRiskRankRequest.setClientIp(this.clientIp);
            userRiskRankRequest.setEmailAddress(this.emailAddress);
            userRiskRankRequest.setExtendedInfo(this.extendedInfo);
            userRiskRankRequest.setTest(this.test);
            return userRiskRankRequest;
        }

    }

}
