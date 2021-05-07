package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * 注意：企业付款查询api
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_3">参考文档</a>
 */
@XStreamAlias("xml")
public class EntPayQueryRequest extends WxPayBaseRequest {

    /**
     * 商户订单号
     * 商户调用企业付款API时使用的商户订单号
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    @Override
    public String toString() {
        return "EntPayQueryRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", partnerTradeNo='" + partnerTradeNo + '\'' +
                '}';
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {
        private String partnerTradeNo;

        public Builder partnerTradeNo(String partnerTradeNo) {
            this.partnerTradeNo = partnerTradeNo;
            return this;
        }

        public EntPayQueryRequest build() {
            EntPayQueryRequest request = new EntPayQueryRequest();
            request.setAppid(this.appid);
            request.setMchid(this.mchid);
            request.setNonceStr(this.nonceStr);
            request.setPartnerTradeNo(this.partnerTradeNo);
            return request;
        }

    }


}
