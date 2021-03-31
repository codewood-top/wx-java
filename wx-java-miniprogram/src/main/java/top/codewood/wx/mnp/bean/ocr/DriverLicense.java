package top.codewood.wx.mnp.bean.ocr;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 驾驶证识别
 */
public class DriverLicense implements Serializable {

    /**
     * 证号
     */
    @SerializedName("id_num")
    private String idNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 出生日期
     */
    @SerializedName("birth_date")
    private String birthDate;

    /**
     * 初次领证日期
     */
    @SerializedName("issue_date")
    private String issueDate;

    /**
     * 准驾车型
     */
    @SerializedName("car_class")
    private String carClass;

    /**
     * 有效期限起始日
     */
    @SerializedName("valid_from")
    private String validFrom;

    /**
     * 有效期限终止日
     */
    @SerializedName("valid_to")
    private String validTo;

    /**
     * 印章文构
     */
    @SerializedName("official_seal")
    private String officialSeal;

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getOfficialSeal() {
        return officialSeal;
    }

    public void setOfficialSeal(String officialSeal) {
        this.officialSeal = officialSeal;
    }
}
