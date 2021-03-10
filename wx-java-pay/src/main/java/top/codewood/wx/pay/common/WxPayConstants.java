package top.codewood.wx.pay.common;

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
        JSAPI("jsapi", V3PayUrl.WX_PAY_JSAPI_URL),

        APP("app", V3PayUrl.WX_PAY_APP_URL),

        NATIVE("native", V3PayUrl.WX_PAY_NATIVE_URL),

        H5("h5", V3PayUrl.WX_PAY_H5_URL);

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

    public interface V2PayUrl {

        /**
         * 发放红包接口
         * 需要证书
         */
        String SEND_REDPACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

        /**
         * 发放裂变红包
         * 需要证书
         */
        String SEND_GROUP_REDPACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";

        /**
         * 查询红包记录
         * 需要证书
         */
        String QUERY_REDPACK_INFO_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";

    }


    public interface V3PayUrl {

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

}
