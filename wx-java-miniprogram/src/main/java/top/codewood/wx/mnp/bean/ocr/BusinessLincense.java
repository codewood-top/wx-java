package top.codewood.wx.mnp.bean.ocr;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 营业执照
 */
public class BusinessLincense implements Serializable {

    /**
     * 注册号
     */
    @SerializedName("reg_num")
    private String regNum;

    /**
     * 编号
     */
    @SerializedName("serial")
    private String serial;

    /**
     * 法定代表人姓名
     */
    @SerializedName("legal_representative")
    private String legalRepresentative;

    /**
     * 企业名称
     */
    @SerializedName("enterprise_name")
    private String enterpriseName;

    /**
     * 组成形式
     */
    @SerializedName("type_of_organization")
    private String typeOfOrganization;

    /**
     * 经营场所/企业住所
     */
    private String address;

    /**
     * 公司类型
     */
    @SerializedName("type_of_enterprise")
    private String typeOfEnterprise;

    /**
     * 经营范围
     */
    @SerializedName("business_scope")
    private String businessScope;

    /**
     * 注册资本
     */
    @SerializedName("registered_capital")
    private String registeredCapital;

    /**
     * 实收资本
     */
    @SerializedName("paid_in_capital")
    private String paidInCapital;

    /**
     * 营业期限
     */
    @SerializedName("valid_period")
    private String validPeriod;

    /**
     * 注册日期/成立日期
     */
    @SerializedName("registered_date")
    private String registeredDate;

    /**
     * 营业执照位置
     */
    @SerializedName("cert_position")
    private String certPosition;

    /**
     * 图片大小
     */
    @SerializedName("img_size")
    private String imgSize;

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getTypeOfOrganization() {
        return typeOfOrganization;
    }

    public void setTypeOfOrganization(String typeOfOrganization) {
        this.typeOfOrganization = typeOfOrganization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeOfEnterprise() {
        return typeOfEnterprise;
    }

    public void setTypeOfEnterprise(String typeOfEnterprise) {
        this.typeOfEnterprise = typeOfEnterprise;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getPaidInCapital() {
        return paidInCapital;
    }

    public void setPaidInCapital(String paidInCapital) {
        this.paidInCapital = paidInCapital;
    }

    public String getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getCertPosition() {
        return certPosition;
    }

    public void setCertPosition(String certPosition) {
        this.certPosition = certPosition;
    }

    public String getImgSize() {
        return imgSize;
    }

    public void setImgSize(String imgSize) {
        this.imgSize = imgSize;
    }
}
