package top.codewood.wx.mnp.bean.live;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpLiveGoodsInfo implements Serializable {

    /**
     * 商品封面图链接
     */
    @SerializedName("cover_img")
    private String coverImg;

    /**
     * 商品小程序路径
     */
    private String url;

    /**
     * 商品价格（分）
     */
    private Integer price;

    /**
     * 商品价格，使用方式看price_type
     */
    private Integer price2;

    /**
     * 价格类型，1：一口价（只需要传入price，price2不传） 2：价格区间（price字段为左边界，price2字段为右边界，price和price2必传） 3：显示折扣价（price字段为原价，price2字段为现价， price和price2必传）
     */
    @SerializedName("price_type")
    private Integer priceType = 1;

    /**
     * 商品id
     */
    @SerializedName("goods_id")
    private Integer goodsId;

    /**
     * 第三方商品appid ,当前小程序商品则为空
     */
    @SerializedName("third_party_appid")
    private String thirdPartyAppid;

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getThirdPartyAppid() {
        return thirdPartyAppid;
    }

    public void setThirdPartyAppid(String thirdPartyAppid) {
        this.thirdPartyAppid = thirdPartyAppid;
    }
}
