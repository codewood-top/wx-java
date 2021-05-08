package top.codewood.wx.mnp.bean.live;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 直播间列表及直播间信息
 */
public class WxMnpLiveRoomListResult implements Serializable {

    /**
     * 拉取房间总数
     */
    private Integer total;

    @SerializedName("room_info")
    private List<WxMnpLiveRoomInfo> roomInfo;


}
