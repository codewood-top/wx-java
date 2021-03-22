package top.codewood.wx.mnp.bean.analysis;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpPerformanceResult implements Serializable {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxMnpPerformanceResult{" +
                "data=" + data +
                '}';
    }

    public static class Data {
        private Body body;

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }

        @Override
        public String toString() {
            return "data{" +
                    "body=" + body +
                    '}';
        }
    }

    public static class Body {

        /**
         * 返回的数据数组
         */
        private List<Table> tables;
        /**
         * 数组大小
         */
        private int count;

        public List<Table> getTables() {
            return tables;
        }

        public void setTables(List<Table> tables) {
            this.tables = tables;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Body{" +
                    "tables=" + tables +
                    ", count=" + count +
                    '}';
        }
    }

    public static class Table {

        /**
         * 性能数据指标id
         */
        private String id;

        /**
         * 按时间排列的性能数据
         */
        private List<Line> lines;

        /**
         * 性能数据指标中文名
         */
        private String zh;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Line> getLines() {
            return lines;
        }

        public void setLines(List<Line> lines) {
            this.lines = lines;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        @Override
        public String toString() {
            return "Table{" +
                    "id='" + id + '\'' +
                    ", lines=" + lines +
                    ", zh='" + zh + '\'' +
                    '}';
        }
    }

    public static class Line {

        /**
         * 单天的性能数据
         */
        private List<Field> fields;

        public List<Field> getFields() {
            return fields;
        }

        public void setFields(List<Field> fields) {
            this.fields = fields;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "fields=" + fields +
                    '}';
        }
    }


    public static class Field {
        /**
         * 日期
         */
        @SerializedName("refdate")
        private String refDate;
        /**
         * 性能数据值
         */
        private String value;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Field{" +
                    "refDate='" + refDate + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

}
