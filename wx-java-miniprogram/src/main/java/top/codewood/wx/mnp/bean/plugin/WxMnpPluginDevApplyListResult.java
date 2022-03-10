package top.codewood.wx.mnp.bean.plugin;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpPluginDevApplyListResult implements Serializable {

    @SerializedName("apply_list")
    private List<PluginDevInfo> applyList;

    public List<PluginDevInfo> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<PluginDevInfo> applyList) {
        this.applyList = applyList;
    }

    public static class PluginDevInfo implements Serializable {

        /**
         * 使用者的appid
         */
        private String appid;
        /**
         * 	插件状态
         */
        private int status;
        /**
         * 使用者的昵称
         */
        private String nickname;
        /**
         * 使用者的头像
         */
        @SerializedName("headimgurl")
        private String headImgUrl;

        /**
         * 使用者的类目
         */
        private List<Category> categories;

        /**
         * 使用者的申请时间
         */
        @SerializedName("create_time")
        private String createTime;

        /**
         * 使用者的小程序码
         */
        @SerializedName("apply_url")
        private String applyUrl;

        /**
         * 使用者的申请说明
         */
        private String reason;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getApplyUrl() {
            return applyUrl;
        }

        public void setApplyUrl(String applyUrl) {
            this.applyUrl = applyUrl;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class Category implements Serializable {
        private String first;
        private String second;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }
    }

}
