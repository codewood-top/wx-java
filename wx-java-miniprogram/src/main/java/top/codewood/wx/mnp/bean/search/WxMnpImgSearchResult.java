package top.codewood.wx.mnp.bean.search;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpImgSearchResult implements Serializable {

    /**
     * 搜索结果列表
     */
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "WxMnpImgSearchResult{" +
                "items=" + items +
                '}';
    }

    public static class Item implements Serializable {

        /**
         * 小程序商品页面标题
         */
        private String title;
        /**
         * 小程序商品页面主图url
         */
        @SerializedName("img_url")
        private String imgUrl;
        /**
         * 小程序商品页面价格
         */
        private String price;
        /**
         * 小程序商品页面地址
         */
        private String path;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "title='" + title + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", price='" + price + '\'' +
                    ", path='" + path + '\'' +
                    '}';
        }
    }

}
