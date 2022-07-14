package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressCancelOrderResult implements Serializable {

    /**
     * 运力返回的错误码
     */
    @SerializedName("delivery_resultcode")
    private Integer deliveryResultCode;
    /**
     * 运力返回的错误信息
     */
    @SerializedName("delivery_resultmsg")
    private String deliveryResultMsg;

    public Integer getDeliveryResultCode() {
        return deliveryResultCode;
    }

    public void setDeliveryResultCode(Integer deliveryResultCode) {
        this.deliveryResultCode = deliveryResultCode;
    }

    public String getDeliveryResultMsg() {
        return deliveryResultMsg;
    }

    public void setDeliveryResultMsg(String deliveryResultMsg) {
        this.deliveryResultMsg = deliveryResultMsg;
    }

    @Override
    public String toString() {
        return "WxMnpExpressCancelOrderResult{" +
                "deliveryResultCode=" + deliveryResultCode +
                ", deliveryResultMsg='" + deliveryResultMsg + '\'' +
                '}';
    }
}
