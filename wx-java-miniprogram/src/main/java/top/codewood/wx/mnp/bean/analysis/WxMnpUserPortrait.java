package top.codewood.wx.mnp.bean.analysis;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpUserPortrait implements Serializable {

    /**
     * 时间范围，如："20170611-20170617"
     */
    @SerializedName("ref_date")
    private String refDate;

    /**
     * 新用户画像
     */
    @SerializedName("visit_uv_new")
    private Uv visitUvNew;

    /**
     * 活跃用户画像
     */
    @SerializedName("visit_uv")
    private Uv visitUv;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public Uv getVisitUvNew() {
        return visitUvNew;
    }

    public void setVisitUvNew(Uv visitUvNew) {
        this.visitUvNew = visitUvNew;
    }

    public Uv getVisitUv() {
        return visitUv;
    }

    public void setVisitUv(Uv visitUv) {
        this.visitUv = visitUv;
    }

    @Override
    public String toString() {
        return "WxMnpUserPortrait{" +
                "refDate='" + refDate + '\'' +
                ", visitUvNew=" + visitUvNew +
                ", visitUv=" + visitUv +
                '}';
    }

    public static class Uv {
        private Integer index;
        private List<UvProp> province;
        private List<UvProp> city;
        private List<UvProp> genders;
        private List<UvProp> platforms;
        private List<UvProp> devices;
        private List<UvProp> ages;

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public List<UvProp> getProvince() {
            return province;
        }

        public void setProvince(List<UvProp> province) {
            this.province = province;
        }

        public List<UvProp> getCity() {
            return city;
        }

        public void setCity(List<UvProp> city) {
            this.city = city;
        }

        public List<UvProp> getGenders() {
            return genders;
        }

        public void setGenders(List<UvProp> genders) {
            this.genders = genders;
        }

        public List<UvProp> getPlatforms() {
            return platforms;
        }

        public void setPlatforms(List<UvProp> platforms) {
            this.platforms = platforms;
        }

        public List<UvProp> getDevices() {
            return devices;
        }

        public void setDevices(List<UvProp> devices) {
            this.devices = devices;
        }

        public List<UvProp> getAges() {
            return ages;
        }

        public void setAges(List<UvProp> ages) {
            this.ages = ages;
        }

        @Override
        public String toString() {
            return "Uv{" +
                    "index=" + index +
                    ", province=" + province +
                    ", city=" + city +
                    ", genders=" + genders +
                    ", platforms=" + platforms +
                    ", devices=" + devices +
                    ", ages=" + ages +
                    '}';
        }
    }

    public static class UvProp {
        /**
         * 	属性值id
         */
        private Integer id;
        /**
         * 属性值名称，与id对应。如属性为 province 时，返回的属性值名称包括「广东」等。
         */
        private String name;

        /**
         * 该场景访问uv
         */
        @SerializedName("access_source_visit_uv")
        private Integer accessSourceVisitUv;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAccessSourceVisitUv() {
            return accessSourceVisitUv;
        }

        public void setAccessSourceVisitUv(Integer accessSourceVisitUv) {
            this.accessSourceVisitUv = accessSourceVisitUv;
        }
    }

}
