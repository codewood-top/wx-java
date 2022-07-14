package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressGetPathResult implements Serializable {

    private String openid;
    @SerializedName("delivery_id")
    private String deliveryId;
    @SerializedName("waybill_id")
    private String waybillId;
    @SerializedName("path_item_num")
    private Integer pathItemNum;


    public static class PathItem implements Serializable {
        /**
         * 轨迹节点 Unix 时间戳
         */
        @SerializedName("action_time")
        private Integer actionTime;
        /**
         * 轨迹节点类型
         */
        @SerializedName("action_type")
        private Integer actionType;
        /**
         * 轨迹节点详情
         */
        @SerializedName("action_msg")
        private String actionMsg;

        public Integer getActionTime() {
            return actionTime;
        }

        public void setActionTime(Integer actionTime) {
            this.actionTime = actionTime;
        }

        public Integer getActionType() {
            return actionType;
        }

        public void setActionType(Integer actionType) {
            this.actionType = actionType;
        }

        public String getActionMsg() {
            return actionMsg;
        }

        public void setActionMsg(String actionMsg) {
            this.actionMsg = actionMsg;
        }
    }

}
