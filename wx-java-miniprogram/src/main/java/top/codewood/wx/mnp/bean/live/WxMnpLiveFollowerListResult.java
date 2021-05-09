package top.codewood.wx.mnp.bean.live;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpLiveFollowerListResult implements Serializable {

    /**
     * 长期订阅用户列表
     */
    private List<Follower> followers;

    /**
     * 翻页标记，获取下一页时带上该值
     */
    @SerializedName("page_breaker")
    private Integer pageBreaker;

    public static class Follower implements Serializable {

        /**
         * 长期订阅用户OpenId
         */
        private String openid;

        /**
         * 长期订阅用户订阅时间
         */
        @SerializedName("subscribe_time")
        private Integer subscribeTime;

        /**
         * 用户订阅时房间状态
         */
        @SerializedName("room_status")
        private Integer roomStatus;

        /**
         * 用户订阅时所处房间
         */
        @SerializedName("room_id")
        private Integer roomId;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public Integer getSubscribeTime() {
            return subscribeTime;
        }

        public void setSubscribeTime(Integer subscribeTime) {
            this.subscribeTime = subscribeTime;
        }

        public Integer getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(Integer roomStatus) {
            this.roomStatus = roomStatus;
        }

        public Integer getRoomId() {
            return roomId;
        }

        public void setRoomId(Integer roomId) {
            this.roomId = roomId;
        }
    }

}
