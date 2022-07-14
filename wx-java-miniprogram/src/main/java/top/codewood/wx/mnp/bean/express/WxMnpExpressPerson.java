package top.codewood.wx.mnp.bean.express;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressPerson implements Serializable {

    /**
     * 必填：是
     * 收发件人姓名，不超过64字节
     */
    private String name;
    /**
     * 必填： 否
     * 收发件人座机号码，若不填写则必须填写 mobile，不超过32字节
     */
    private String tel;
    /**
     * 必填： 否
     * 收发件人手机号码，若不填写则必须填写 tel，不超过32字节
     */
    private String mobile;
    /**
     * 必填： 否
     * 收发件人公司名称，不超过64字节
     */
    private String company;
    /**
     * 必填：否
     * 收发件人邮编，不超过10字节
     */
    @SerializedName("post_code")
    private String postCode;
    /**
     * 必填：否
     * 收发件人国家，不超过64字节
     */
    private String country;
    /**
     * 必填：是
     * 收发件人省份，比如："广东省"，不超过64字节
     */
    private String province;
    /**
     * 必填：是
     * 收发件人市/地区，比如："广州市"，不超过64字节
     */
    private String city;
    /**
     * 必填： 是
     * 收发件人区/县，比如："海珠区"，不超过64字节
     */
    private String area;
    /**
     * 必填： 是
     * 收发件人详细地址，比如："XX路 XX 号XX大厦XX"，不超过512字节
     */
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "WxMnpExpressPerson{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", mobile='" + mobile + '\'' +
                ", company='" + company + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String tel;
        private String mobile;
        private String company;
        private String postCode;
        private String country;
        private String province;
        private String city;
        private String area;
        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder tel(String tel) {
            this.tel = tel;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder postCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder province(String province) {
            this.province = province;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder area(String area) {
            this.area = area;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public WxMnpExpressPerson build() {
            WxMnpExpressPerson person = new WxMnpExpressPerson();
            person.setName(this.name);
            person.setTel(this.tel);
            person.setMobile(this.mobile);
            person.setCompany(this.company);
            person.setPostCode(this.postCode);
            person.setCountry(this.country);
            person.setProvince(this.province);
            person.setCity(this.city);
            person.setArea(this.area);
            person.setAddress(this.address);
            return person;
        }

    }

}
