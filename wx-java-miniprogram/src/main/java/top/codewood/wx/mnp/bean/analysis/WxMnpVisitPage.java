package top.codewood.wx.mnp.bean.analysis;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpVisitPage implements Serializable {

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
        return "WxMnpVisitPage{" +
                "refDate='" + refDate + '\'' +
                ", list=" + list +
                '}';
    }

    public static class ListItem {

        /**
         * 页面路径
         */
        @SerializedName("page_path")
        private String pagePath;

        /**
         * 访问次数
         */
        @SerializedName("page_visit_pv")
        private Integer pageVisitPv;

        /**
         * 访问人数
         */
        @SerializedName("page_visit_uv")
        private Integer pageVisitUv;

        /**
         * 次均停留时长
         */
        @SerializedName("page_staytime_pv")
        private Double pageStayTimePv;

        /**
         * 进入页次数
         */
        @SerializedName("entrypage_pv")
        private Integer entryPagePv;

        /**
         * 退出页次数
         */
        @SerializedName("exitpage_pv")
        private Integer exitPagePv;

        /**
         * 转发次数
         */
        @SerializedName("page_share_pv")
        private Integer pageSharePv;

        /**
         * 转发人数
         */
        @SerializedName("page_share_uv")
        private Integer pageShareUv;

        public String getPagePath() {
            return pagePath;
        }

        public void setPagePath(String pagePath) {
            this.pagePath = pagePath;
        }

        public Integer getPageVisitPv() {
            return pageVisitPv;
        }

        public void setPageVisitPv(Integer pageVisitPv) {
            this.pageVisitPv = pageVisitPv;
        }

        public Integer getPageVisitUv() {
            return pageVisitUv;
        }

        public void setPageVisitUv(Integer pageVisitUv) {
            this.pageVisitUv = pageVisitUv;
        }

        public Double getPageStayTimePv() {
            return pageStayTimePv;
        }

        public void setPageStayTimePv(Double pageStayTimePv) {
            this.pageStayTimePv = pageStayTimePv;
        }

        public Integer getEntryPagePv() {
            return entryPagePv;
        }

        public void setEntryPagePv(Integer entryPagePv) {
            this.entryPagePv = entryPagePv;
        }

        public Integer getExitPagePv() {
            return exitPagePv;
        }

        public void setExitPagePv(Integer exitPagePv) {
            this.exitPagePv = exitPagePv;
        }

        public Integer getPageSharePv() {
            return pageSharePv;
        }

        public void setPageSharePv(Integer pageSharePv) {
            this.pageSharePv = pageSharePv;
        }

        public Integer getPageShareUv() {
            return pageShareUv;
        }

        public void setPageShareUv(Integer pageShareUv) {
            this.pageShareUv = pageShareUv;
        }

        @Override
        public String toString() {
            return "ListItem{" +
                    "pagePath='" + pagePath + '\'' +
                    ", pageVisitPv=" + pageVisitPv +
                    ", pageVisitUv=" + pageVisitUv +
                    ", pageStayTimePv=" + pageStayTimePv +
                    ", entryPagePv=" + entryPagePv +
                    ", exitPagePv=" + exitPagePv +
                    ", pageSharePv=" + pageSharePv +
                    ", pageShareUv=" + pageShareUv +
                    '}';
        }
    }

}
