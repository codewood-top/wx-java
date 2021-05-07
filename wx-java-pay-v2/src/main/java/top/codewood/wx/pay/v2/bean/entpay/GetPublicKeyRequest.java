package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

@XStreamAlias("xml")
public class GetPublicKeyRequest extends WxPayBaseRequest {

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        public GetPublicKeyRequest build() {
            GetPublicKeyRequest getPublicKeyRequest = new GetPublicKeyRequest();
            getPublicKeyRequest.setAppid(this.appid);
            getPublicKeyRequest.setMchid(this.mchid);
            getPublicKeyRequest.setNonceStr(this.nonceStr);
            if (this.signType != null) {
                getPublicKeyRequest.setSignType(this.signType);
            }
            return getPublicKeyRequest;
        }

    }

    @Override
    public String toString() {
        return "GetPublicKeyRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }
}
