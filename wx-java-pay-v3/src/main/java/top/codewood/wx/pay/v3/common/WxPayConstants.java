package top.codewood.wx.pay.v3.common;

public class WxPayConstants {

    public interface HttpMethod {
        String POST = "POST";
        String GET = "GET";
        String PUT = "PUT";
    }


    public enum PayType {
        /**
         * JSAPI/小程序下单
         */
        JSAPI("JSAPI", V3PayUrl.WX_PAY_JSAPI_URL),

        APP("APP", V3PayUrl.WX_PAY_APP_URL),

        NATIVE("NATIVE", V3PayUrl.WX_PAY_NATIVE_URL),

        H5("H5", V3PayUrl.WX_PAY_H5_URL);

        private String type;
        private String payUrl;

        PayType(String type, String payUrl) {
            this.type = type;
            this.payUrl = payUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPayUrl() {
            return payUrl;
        }

        public void setPayUrl(String payUrl) {
            this.payUrl = payUrl;
        }
    }


    public interface V3PayUrl {

        /**
         * 获取平台证书列表
         */
        String CERTIFICATE_LIST_URL = "https://api.mch.weixin.qq.com/v3/certificates";

        /**
         * JSAPI/小程序下单API
         */
        String WX_PAY_JSAPI_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi";
        /**
         * APP支付
         */
        String WX_PAY_APP_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/app";
        /**
         *  Native支付
         */
        String WX_PAY_NATIVE_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/native";
        /**
         * 小程序支付
         */
        String WX_PAY_H5_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/h5";

        /**
         * 退款URL
         */
        String REFUND_URL = "https://api.mch.weixin.qq.com/v3/refund/domestic/refunds";
    }

    public interface SignType {

        String HMAC_SHA256 = "HMAC-SHA256";
        String MD5 = "MD5";

    }

    public enum Bank {
        BANK_1002(1002, "工商银行"),
        BANK_1005(1005, "农业银行"),
        BANK_1003(1003, "建设银行"),
        BANK_1026(1026, "中国银行"),
        BANK_1020(1020, "交通银行"),
        BANK_1001(1001, "招商银行"),
        BANK_1066(1066, "邮储银行"),
        BANK_1006(1006, "民生银行"),
        BANK_1010(1010, "平安银行"),
        BANK_1021(1021, "中信银行"),
        BANK_1004(1004, "浦发银行"),
        BANK_1009(1009, "兴业银行"),
        BANK_1022(1022, "光大银行"),
        BANK_1027(1027, "广发银行"),
        BANK_1025(1025, "华夏银行"),
        BANK_1056(1056, "宁波银行"),
        BANK_4836(4836, "北京银行"),
        BANK_1024(1024, "上海银行"),
        BANK_1054(1054, "南京银行"),
        BANK_4755(4755, "长子县融汇村镇银行"),
        BANK_4216(4216, "长沙银行"),
        BANK_4051(4051, "浙江泰隆商业银行"),
        BANK_4753(4753, "中原银行"),
        BANK_4761(4761, "企业银行（中国）"),
        BANK_4036(4036, "顺德农商银行"),
        BANK_4752(4752, "衡水银行"),
        BANK_4756(4756, "长治银行"),
        BANK_4767(4767, "大同银行"),
        BANK_4115(4115, "河南省农村信用社"),
        BANK_4150(4150, "宁夏黄河农村商业银行"),
        BANK_4156(4156, "山西省农村信用社"),
        BANK_4166(4166, "安徽省农村信用社"),
        BANK_4157(4157, "甘肃省农村信用社"),
        BANK_4153(4153, "天津农村商业银行"),
        BANK_4113(4113, "广西壮族自治区农村信用社"),
        BANK_4108(4108, "陕西省农村信用社"),
        BANK_4076(4076, "深圳农村商业银行"),
        BANK_4052(4052, "宁波鄞州农村商业银行"),
        BANK_4764(4764, "浙江省农村信用社联合社"),
        BANK_4217(4217, "江苏省农村信用社联合社"),
        BANK_4072(4072, "江苏紫金农村商业银行股份有限公司"),
        BANK_4769(4769, "北京中关村银行股份有限公司"),
        BANK_4778(4778, "星展银行（中国）有限公司"),
        BANK_4766(4766, "枣庄银行股份有限公司"),
        BANK_4758(4758, "海口联合农村商业银行股份有限公司"),
        BANK_4763(4763, "南洋商业银行（中国）有限公司");

        int id;
        String name;
        Bank(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Bank getBank(int id) {
            for (Bank bank : Bank.values()) {
                if (bank.id == id) return bank;
            }
            return null;
        }
    }

}
