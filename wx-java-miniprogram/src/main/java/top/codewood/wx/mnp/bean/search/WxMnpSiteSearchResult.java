package top.codewood.wx.mnp.bean.search;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpSiteSearchResult implements Serializable {

    /**
     * 搜索结果列表
     */
    private List<Item> items;
    /**
     * 是否有下一页
     */
    @SerializedName("has_next_page")
    private boolean hasNextPage;
    /**
     * 请求下一页的参数，开发者无需理解，如需查询下一页结果，把该参数填充到下页请求参数中的next_page_info即可
     */
    @SerializedName("next_page_info")
    private String nextPageInfo;
    /**
     * 估算索引文档数
     */
    @SerializedName("hit_count")
    private int hitCount;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String getNextPageInfo() {
        return nextPageInfo;
    }

    public void setNextPageInfo(String nextPageInfo) {
        this.nextPageInfo = nextPageInfo;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public static class Item implements Serializable {
        /**
         * 小程序页面标题
         */
        private String title;
        /**
         * 小程序页面摘要
         */
        private String description;
        /**
         * 小程序页面代表图
         */
        private String image;
        /**
         * 小程序页面路径
         */
        private String path;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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
                    ", description='" + description + '\'' +
                    ", image='" + image + '\'' +
                    ", path='" + path + '\'' +
                    '}';
        }
    }

}
