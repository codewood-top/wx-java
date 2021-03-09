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
        JSAPI("jsapi", PayUrl.WX_PAY_JSAPI_URL),

        APP("app", PayUrl.WX_PAY_APP_URL),

        NATIVE("native", PayUrl.WX_PAY_NATIVE_URL),

        H5("h5", PayUrl.WX_PAY_H5_URL);

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


    public interface PayUrl {

        /**
         * JSAPI/小程序下单API
         */
        String WX_PAY_JSAPI_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi";
        String WX_PAY_APP_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/app";
        String WX_PAY_NATIVE_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/native";
        String WX_PAY_H5_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/h5";

        /**
         * 退款URL
         */
        String REFUND_URL = "https://api.mch.weixin.qq.com/v3/refund/domestic/refunds";
    }

}
