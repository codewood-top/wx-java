package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImmeReceiver implements Serializable {
    /**
     * 姓名，最长不超过256个字符
     */
    private String name;
    /**
     * 城市名称，如广州市
     */
    private String city;
    /**
     * 地址(街道、小区、大厦等，用于定位)
     */
    private String address;
    /**
     * 地址详情(楼号、单元号、层号)
     */
    @SerializedName("address_detail")
    private String addressDetail;
    /**
     * 电话/手机号，最长不超过64个字符
     */
    private String phone;
    /**
     * 经度（火星坐标或百度坐标，和 coordinate_type 字段配合使用，确到小数点后6位
     */
    private double lng;
    /**
     * 纬度（火星坐标或百度坐标，和 coordinate_type 字段配合使用，精确到小数点后6位）
     */
    private double lat;
    /**
     * 坐标类型，0：火星坐标（高德，腾讯地图均采用火星坐标） 1：百度坐标
     */
    @SerializedName("coordinate_type")
    private int coordinateType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getCoordinateType() {
        return coordinateType;
    }

    public void setCoordinateType(int coordinateType) {
        this.coordinateType = coordinateType;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", phone='" + phone + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", coordinateType=" + coordinateType +
                '}';
    }
}
