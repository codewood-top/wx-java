package top.codewood.wx.pay.v2.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

@XStreamAlias("xml")
public class WxPayOrderCloseV2Request extends WxPayBaseRequest {

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @XStreamAlias("sign_type")
    private String signType = WxPayConstants.SignType.MD5;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }


    public String toString() {
        return "WxPayOrderCloseV2Request{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {
        private String outTradeNo;
        private String signType;

        public Builder outTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public WxPayOrderCloseV2Request build() {
            WxPayOrderCloseV2Request orderCloseV2Request = new WxPayOrderCloseV2Request();
            orderCloseV2Request.setAppid(this.appid);
            orderCloseV2Request.setMchid(this.mchid);
            orderCloseV2Request.setNonceStr(this.nonceStr);
            orderCloseV2Request.setOutTradeNo(this.outTradeNo);
            if (signType != null) {
                orderCloseV2Request.setSignType(this.signType);
            }
            return orderCloseV2Request;
        }

    }

}
