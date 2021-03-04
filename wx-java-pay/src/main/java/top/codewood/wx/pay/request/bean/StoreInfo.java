package top.codewood.wx.pay.request.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 商户门店信息
 */
public class StoreInfo {
    /**
     * 门店编号
     * 	商户侧门店编号
     */
    private String id;
    /**
     * 门店名称
     * 商户侧门店名称
     */
    private String name;
    /**
     * 地区编码
     * 地区编码，详细请见<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/ecommerce/applyments/chapter4_1.shtml">省市区编号对照表</a>
     */
    @SerializedName("area_code")
    private String areaCode;
    /**
     * 详细地址
     * 详细的商户门店地址
     */
    @SerializedName("address")
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}