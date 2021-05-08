package top.codewood.wx.mnp.bean.live;

import java.io.Serializable;

public class WxMnpLiveRoomCreateResult implements Serializable {

    /**
     * 房间ID
     */
    private Integer roomId;
    /**
     * "小程序直播" 小程序码
     */
    private String qrcodeUrl;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }
}
