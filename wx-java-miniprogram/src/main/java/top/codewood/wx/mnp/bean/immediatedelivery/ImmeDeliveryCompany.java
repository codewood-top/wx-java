package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeDeliveryCompany implements Serializable {

    /**
     * 配送公司Id
     */
    @SerializedName("delivery_id")
    private String deliveryId;
    /**
     * 配送公司名称
     */
    @SerializedName("delivery_name")
    private String deliveryName;

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    @Override
    public String toString() {
        return "ImmeDeliveryCompany{" +
                "deliveryId='" + deliveryId + '\'' +
                ", deliveryName='" + deliveryName + '\'' +
                '}';
    }
}
