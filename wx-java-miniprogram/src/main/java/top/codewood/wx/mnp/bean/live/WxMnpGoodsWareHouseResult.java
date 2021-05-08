package top.codewood.wx.mnp.bean.live;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html#6">参考文档</a>
 */
public class WxMnpGoodsWareHouseResult implements Serializable {

    /**
     * 商品信息
     */
    private List<Goods> goods;

    /**
     * 商品个数
     */
    private Integer total;

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static class Goods implements Serializable {

        /**
         *  商品ID
         */
        @SerializedName("goods_id")
        private Integer goodsId;

        /**
         * 商品名称
         */
        private String name;

        /**
         * 商品图片url
         */
        @SerializedName("cover_img_url")
        private String coverImgUrl;

        /**
         * 商品详情页的小程序路径
         */
        private String url;

        /**
         * 1:一口价，此时读price字段; 2:价格区间，此时price字段为左边界，price2字段为右边界; 3:折扣价，此时price字段为原价，price2字段为现价；
         */
        private Integer priceType;

        /**
         * 价格左区间，单位“元”
         */
        private Double price;

        /**
         * 价格右区间，单位“元”
         */
        private Double price2;

        /**
         * 0：未审核，1：审核中，2:审核通过，3审核失败
         */
        @SerializedName("audit_status")
        private Integer auditStatus;

        /**
         * 1、2：表示是为 API 添加商品，否则是直播控制台添加的商品
         */
        @SerializedName("third_party_tag")
        private Integer thirdPartyTag;

        /**
         * 当商品为第三方小程序的商品则为对应第三方小程序的appid，自身小程序商品则为''
         */
        private String thirdPartyAppid;

        public Integer getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Integer goodsId) {
            this.goodsId = goodsId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getPriceType() {
            return priceType;
        }

        public void setPriceType(Integer priceType) {
            this.priceType = priceType;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getPrice2() {
            return price2;
        }

        public void setPrice2(Double price2) {
            this.price2 = price2;
        }

        public Integer getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(Integer auditStatus) {
            this.auditStatus = auditStatus;
        }

        public Integer getThirdPartyTag() {
            return thirdPartyTag;
        }

        public void setThirdPartyTag(Integer thirdPartyTag) {
            this.thirdPartyTag = thirdPartyTag;
        }

        public String getThirdPartyAppid() {
            return thirdPartyAppid;
        }

        public void setThirdPartyAppid(String thirdPartyAppid) {
            this.thirdPartyAppid = thirdPartyAppid;
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "goodsId=" + goodsId +
                    ", name='" + name + '\'' +
                    ", coverImgUrl='" + coverImgUrl + '\'' +
                    ", url='" + url + '\'' +
                    ", priceType=" + priceType +
                    ", price=" + price +
                    ", price2=" + price2 +
                    ", auditStatus=" + auditStatus +
                    ", thirdPartyTag=" + thirdPartyTag +
                    ", thirdPartyAppid='" + thirdPartyAppid + '\'' +
                    '}';
        }
    }

}
