package top.codewood.wx.mp.bean.template;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMpTemplateIndustry implements Serializable {

    @SerializedName("primary_industry")
    private Industry primaryIndustry;

    @SerializedName("secondary_industry")
    private Industry secondaryIndustry;

    public Industry getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(Industry primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Industry getSecondaryIndustry() {
        return secondaryIndustry;
    }

    public void setSecondaryIndustry(Industry secondaryIndustry) {
        this.secondaryIndustry = secondaryIndustry;
    }

    public static class Industry {

        @SerializedName("first_class")
        private String firstClass;
        @SerializedName("second_class")
        private String secondClass;

        public String getFirstClass() {
            return firstClass;
        }

        public void setFirstClass(String firstClass) {
            this.firstClass = firstClass;
        }

        public String getSecondClass() {
            return secondClass;
        }

        public void setSecondClass(String secondClass) {
            this.secondClass = secondClass;
        }

        @Override
        public String toString() {
            return "Industry{" +
                    "firstClass='" + firstClass + '\'' +
                    ", secondClass='" + secondClass + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WxTemplateIndustry{" +
                "primaryIndustry=" + primaryIndustry +
                ", secondaryIndustry=" + secondaryIndustry +
                '}';
    }
}
