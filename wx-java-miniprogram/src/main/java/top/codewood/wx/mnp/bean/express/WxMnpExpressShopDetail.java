package top.codewood.wx.mnp.bean.express;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressShopDetail implements Serializable {

    /**
     * 必填：否
     * 商品名称, 最多40汉字
     */
    @SerializedName("goods_name")
    private String goodsName;
    /**
     * 必填：否
     * 商品图片url
     */
    @SerializedName("goods_img_url")
    private String goodsImgUrl;
    /**
     * 必填：否
     * 商品详情描述, 最多40汉字
     */
    @SerializedName("goods_desc")
    private String goodsDesc;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    @Override
    public String toString() {
        return "WxMnpExpressShopDetail{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsImgUrl='" + goodsImgUrl + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                '}';
    }
}
