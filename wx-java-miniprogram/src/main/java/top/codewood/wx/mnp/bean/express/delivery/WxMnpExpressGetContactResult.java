package top.codewood.wx.mnp.bean.express.delivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressGetContactResult implements Serializable {

    /**
     * 运单 ID
     */
    @SerializedName("waybill_id")
    private String waybillId;

    /**
     * 发件人信息
     */
    private Contact sender;
    /**
     * 收件人信息
     */
    private Contact receiver;

    public static class Contact implements Serializable {
        /**
         * 用户姓名
         */
        private String name;
        /**
         * 	座机号码
         */
        private String tel;
        /**
         * 手机号码
         */
        private String mobile;
        /**
         * 地址，已经将省市区信息合并
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "name='" + name + '\'' +
                    ", tel='" + tel + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

}