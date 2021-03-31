package top.codewood.wx.mnp.bean.ocr;

import java.io.Serializable;

/**
 *
 * 身份证识别
 *
 * 正面返回
 * {
 *   "errcode": "0",
 *   "errmsg": "ok",
 *   "type": "Front",
 *   "name": "张三",
 *   "id": "123456789012345678",
 *   "addr": "广东省广州市",
 *   "gender": "男",
 *   "nationality": "汉"
 * }
 * 背面返回
 * {
 *  "errcode": 0,
 *  "errmsg": "ok",
 *  "type": "Back",
 *  "valid_date": "20070105-20270105"
 * }
 */
public class IdCard implements Serializable {

    /**
     * 正面或背面，Front / Back
     */
    private String type;
    /**
     * 有效期
     */
    private String validDate;
    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String id;

    /**
     * 住址
     */
    private String addr;

    /**
     * 性别
     */
    private String gender;

    /**
     * 民族
     */
    private String nationality;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "type='" + type + '\'' +
                ", validDate='" + validDate + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", addr='" + addr + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
