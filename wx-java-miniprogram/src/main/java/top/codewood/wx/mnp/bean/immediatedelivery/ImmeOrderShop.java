package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeOrderShop implements Serializable {

    /**
     * 必填
     * 商家小程序的路径，建议为订单页面
     */
    @SerializedName("wxa_path")
    private String wxaPath;

    /**
     * 必填
     * 商品缩略图 url
     */
    @SerializedName("img_url")
    private String imgUrl;

    /**
     * 必填
     * 商品名称
     */
    @SerializedName("goods_name")
    private String goodsName;

    /**
     * 必填
     * 商品数量
     */
    @SerializedName("goods_count")
    private Integer goodsCount;

    /**
     * 非必填
     * 若结算方式为：第三方向配送公司统一结算，商户后续和第三方结算，则该参数必填；在该结算模式下，第三方用自己的开发小程序替授权商户发起下单，并将授权小程序的appid给平台，后续配送通知中可回流授权商户小程序。
     */
    @SerializedName("wxa_appid")
    private String wxaAppid;

    public String getWxaPath() {
        return wxaPath;
    }

    public void setWxaPath(String wxaPath) {
        this.wxaPath = wxaPath;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getWxaAppid() {
        return wxaAppid;
    }

    public void setWxaAppid(String wxaAppid) {
        this.wxaAppid = wxaAppid;
    }

    @Override
    public String toString() {
        return "ImmeOrderShop{" +
                "wxaPath='" + wxaPath + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCount=" + goodsCount +
                ", wxaAppid='" + wxaAppid + '\'' +
                '}';
    }
}
