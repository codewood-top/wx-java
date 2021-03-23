package top.codewood.wx.mnp.bean.subscribemsg;

import java.io.Serializable;
import java.util.List;

public class WxMnpPubTemplateTitleList implements Serializable {

    /**
     * 模版标题列表总数
     */
    private int count;

    /**
     * 模板标题列表
     */
    private List<PubTemplateTitle> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PubTemplateTitle> getData() {
        return data;
    }

    public void setData(List<PubTemplateTitle> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxMnpPubTemplateTitleList{" +
                "count=" + count +
                ", data=" + data +
                '}';
    }

    public static class PubTemplateTitle implements Serializable {

        /**
         * 模版标题 id
         */
        private int tid;

        /**
         * 模版标题
         */
        private String title;

        /**
         * 	模版类型，2 为一次性订阅，3 为长期订阅
         */
        private int type;

        /**
         * 模版所属类目 id
         */
        private int categoryId;

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        @Override
        public String toString() {
            return "PubTemplateTitle{" +
                    "tid=" + tid +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", categoryId=" + categoryId +
                    '}';
        }
    }

}
