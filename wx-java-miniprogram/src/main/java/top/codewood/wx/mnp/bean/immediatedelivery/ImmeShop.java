package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeShop implements Serializable {

    /**
     * 商家id
     */
    @SerializedName("shopid")
    private String shopId;
    /**
     * 配送公司Id
     */
    @SerializedName("delivery_id")
    private String deliveryId;
    /**
     * 审核状态
     * 0: 审核通过;
     * 1: 审核中;
     * 2: 审核不通过;
     */
    @SerializedName("audit_result")
    private int auditResult;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(int auditResult) {
        this.auditResult = auditResult;
    }

    @Override
    public String toString() {
        return "ImmeShop{" +
                "shopId='" + shopId + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", auditResult=" + auditResult +
                '}';
    }
}
