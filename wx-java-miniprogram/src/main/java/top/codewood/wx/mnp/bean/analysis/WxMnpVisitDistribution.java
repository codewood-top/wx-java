package top.codewood.wx.mnp.bean.analysis;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpVisitDistribution implements Serializable {

    /**
     * 日期，格式为 yyyymmdd
     */
    @SerializedName("ref_date")
    private String refDate;

    /**
     * 数据列表
     */
    private List<ListItem> list;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public List<ListItem> getList() {
        return list;
    }

    public void setList(List<ListItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "WxMnpVisitDistribution{" +
                "refDate='" + refDate + '\'' +
                ", list=" + list +
                '}';
    }

    public static class ListItem {

        /**
         * 分布类型
         * access_source_session_cnt: 访问来源分布
         * access_staytime_info: 访问时长分布
         * access_depth_info: 访问深度的分布
         */
        private String index;

        /**
         * 分布数据列表
         */
        @SerializedName("item_list")
        private List<ItemProp> itemList;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public List<ItemProp> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemProp> itemList) {
            this.itemList = itemList;
        }

        @Override
        public String toString() {
            return "ListItem{" +
                    "index='" + index + '\'' +
                    ", itemList=" + itemList +
                    '}';
        }
    }

    /**
     * key: value 具体定义参考<a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getVisitDistribution.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     */
    public static class ItemProp {

        /**
         * 场景 id，定义在各个 index 下不同，具体参见下方表格
         */
        private Integer key;
        /**
         * 该场景 id 访问 pv
         */
        private Integer value;
        /**
         * 该场景 id 访问 uv
         */
        @SerializedName("access_source_visit_uv")
        private Integer accessSourceVisitUv;

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getAccessSourceVisitUv() {
            return accessSourceVisitUv;
        }

        public void setAccessSourceVisitUv(Integer accessSourceVisitUv) {
            this.accessSourceVisitUv = accessSourceVisitUv;
        }

        @Override
        public String toString() {
            return "ItemProp{" +
                    "key=" + key +
                    ", value=" + value +
                    ", accessSourceVisitUv=" + accessSourceVisitUv +
                    '}';
        }
    }

}
