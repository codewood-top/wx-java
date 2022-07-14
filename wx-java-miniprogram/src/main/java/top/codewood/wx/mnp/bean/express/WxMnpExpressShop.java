package top.codewood.wx.mnp.bean.express;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpExpressShop implements Serializable {

    /**
     * 必填：是
     * 商家小程序的路径，建议为订单页面
     */
    @SerializedName("wxa_path")
    private String wxaPath;
    /**
     * 必填：否
     * 商品缩略图 url；shop.detail_list为空则必传，shop.detail_list非空可不传。
     */
    @SerializedName("img_url")
    private String imgUrl;
    /**
     * 必填：否
     * 商品名称, 不超过128字节；shop.detail_list为空则必传，shop.detail_list非空可不传。
     */
    @SerializedName("goods_name")
    private String goodsName;
    /**
     * 必填：否
     * 商品数量；shop.detail_list为空则必传。shop.detail_list非空可不传，默认取shop.detail_list的size
     */
    @SerializedName("goods_count")
    private Integer goodsCount;
    /**
     * 必填：否
     * 商品详情列表，适配多商品场景，用以消息落地页展示。（新规范，新接入商家建议用此字段）
     */
    @SerializedName("detail_list")
    private List<WxMnpExpressShopDetail> detailList;

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

    public List<WxMnpExpressShopDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<WxMnpExpressShopDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return "WxMnpExpressShop{" +
                "wxaPath='" + wxaPath + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCount=" + goodsCount +
                ", detailList=" + detailList +
                '}';
    }
}
