package top.codewood.wx.mnp.bean.live;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpLiveRoleListResult implements Serializable {

    /**
     * 总个数
     */
    private Integer total;

    /**
     * 角色列表
     */
    private List<Role> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Role> getList() {
        return list;
    }

    public void setList(List<Role> list) {
        this.list = list;
    }

    public static class Role implements Serializable {
        /**
         * 微信用户头像url
         */
        @SerializedName("headingimg")
        private String headingImg;

        /**
         * 微信用户昵称
         */
        private String nickname;

        /**
         * openid
         */
        private String openid;

        /**
         * 具有的身份，[0-超级管理员，1-管理员，2-主播，3-运营者]
         */
        private List<Integer> roleList;

        /**
         * 更新时间
         */
        private Integer updateTimestamp;

        /**
         * 微信号
         */
        private String username;

        public String getHeadingImg() {
            return headingImg;
        }

        public void setHeadingImg(String headingImg) {
            this.headingImg = headingImg;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public List<Integer> getRoleList() {
            return roleList;
        }

        public void setRoleList(List<Integer> roleList) {
            this.roleList = roleList;
        }

        public Integer getUpdateTimestamp() {
            return updateTimestamp;
        }

        public void setUpdateTimestamp(Integer updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

}
