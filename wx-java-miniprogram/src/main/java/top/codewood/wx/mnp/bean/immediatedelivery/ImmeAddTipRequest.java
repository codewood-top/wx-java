package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImmeAddTipRequest implements Serializable {

    /**
     * 必填
     * 商家id， 由配送公司分配的appkey
     */
    @SerializedName("shopid")
    private String shopId;
    /**
     * 必填
     * 唯一标识订单的 ID，由商户生成
     */
    @SerializedName("shop_order_id")
    private String shopOrderId;
    /**
     * 必填
     * 商家门店编号，在配送公司登记，如果只有一个门店，闪送shop_no必填，值为店铺id
     */
    @SerializedName("shop_no")
    private String shopNo;
    /**
     * 必填
     * 用配送公司提供的appSecret加密的校验串说明
     */
    @SerializedName("delivery_sign")
    private String deliverySign;
    /**
     * 必填
     * 配送单id
     */
    @SerializedName("waybill_id")
    private String waybillId;
    /**
     * 必填
     * 下单用户的openid
     */
    private String openid;
    /**
     * 必填
     * 费金额(单位：元) 各家配送公司最大值不同
     */
    private BigDecimal tips;
    /**
     * 必填
     * 备注
     */
    private String remark;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopOrderId() {
        return shopOrderId;
    }

    public void setShopOrderId(String shopOrderId) {
        this.shopOrderId = shopOrderId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getDeliverySign() {
        return deliverySign;
    }

    public void setDeliverySign(String deliverySign) {
        this.deliverySign = deliverySign;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public BigDecimal getTips() {
        return tips;
    }

    public void setTips(BigDecimal tips) {
        this.tips = tips;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AddTipRequest{" +
                "shopId='" + shopId + '\'' +
                ", shopOrderId='" + shopOrderId + '\'' +
                ", shopNo='" + shopNo + '\'' +
                ", deliverySign='" + deliverySign + '\'' +
                ", waybillId='" + waybillId + '\'' +
                ", openid='" + openid + '\'' +
                ", tips=" + tips +
                ", remark='" + remark + '\'' +
                '}';
    }
}
