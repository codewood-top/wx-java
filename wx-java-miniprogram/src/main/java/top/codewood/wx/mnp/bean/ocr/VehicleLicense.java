package top.codewood.wx.mnp.bean.ocr;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 行驶证
 */
public class VehicleLicense implements Serializable {

    /**
     * 车辆类型
     */
    @SerializedName("vehicle_type")
    private String vehicleType;

    /**
     * 所有人
     */
    private String owner;

    /**
     * 住址
     */
    private String addr;

    /**
     * 使用性质
     */
    @SerializedName("use_character")
    private String useCharacter;

    /**
     * 品牌型号
     */
    private String model;

    /**
     * 车辆识别代码
     */
    private String vin;

    /**
     * 发动机号码
     */
    @SerializedName("engin_num")
    private String engineNum;

    /**
     * 注册日期
     */
    @SerializedName("register_date")
    private String registerDate;

    /**
     * 发证日期
     */
    @SerializedName("issue_date")
    private String issueDate;

    /**
     * 车牌号码
     */
    @SerializedName("plate_num_b")
    private String plateNumb;

    /**
     * 号牌
     */
    private String record;

    /**
     * 核定载人数
     */
    @SerializedName("passengers_num")
    private String passengersNum;

    /**
     * 总质量
     */
    @SerializedName("total_quality")
    private String totalQuality;

    /**
     * 整备质量
     */
    @SerializedName("totalprepare_quality_quality")
    private String totalPrepareQualityQuality;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getUseCharacter() {
        return useCharacter;
    }

    public void setUseCharacter(String useCharacter) {
        this.useCharacter = useCharacter;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getPlateNumb() {
        return plateNumb;
    }

    public void setPlateNumb(String plateNumb) {
        this.plateNumb = plateNumb;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getPassengersNum() {
        return passengersNum;
    }

    public void setPassengersNum(String passengersNum) {
        this.passengersNum = passengersNum;
    }

    public String getTotalQuality() {
        return totalQuality;
    }

    public void setTotalQuality(String totalQuality) {
        this.totalQuality = totalQuality;
    }

    public String getTotalPrepareQualityQuality() {
        return totalPrepareQualityQuality;
    }

    public void setTotalPrepareQualityQuality(String totalPrepareQualityQuality) {
        this.totalPrepareQualityQuality = totalPrepareQualityQuality;
    }

    @Override
    public String toString() {
        return "VehicleLicense{" +
                "vehicleType='" + vehicleType + '\'' +
                ", owner='" + owner + '\'' +
                ", addr='" + addr + '\'' +
                ", useCharacter='" + useCharacter + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", engineNum='" + engineNum + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", plateNumb='" + plateNumb + '\'' +
                ", record='" + record + '\'' +
                ", passengersNum='" + passengersNum + '\'' +
                ", totalQuality='" + totalQuality + '\'' +
                ", totalPrepareQualityQuality='" + totalPrepareQualityQuality + '\'' +
                '}';
    }
}
