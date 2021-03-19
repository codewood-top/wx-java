package top.codewood.wx.pay.v2.bean.redpack;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

@XStreamAlias("xml")
public class WxPayRedPackQueryRequest extends WxPayBaseRequest {

    /**
     * 商户订单号
     * 商户发放红包的商户订单号
     */
    @Required
    @XStreamAlias("mch_billno")
    private String mchBillNo;

    /**
     * 订单类型
     * MCHT:通过商户订单号获取红包信息。
     */
    @Required
    @XStreamAlias("bill_type")
    private String billType = "MCHT";

    public String getMchBillNo() {
        return mchBillNo;
    }

    public void setMchBillNo(String mchBillNo) {
        this.mchBillNo = mchBillNo;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {

        private String mchBillNo;
        private String billType;

        public WxPayRedPackQueryRequest build() {
            WxPayRedPackQueryRequest queryRequest = new WxPayRedPackQueryRequest();
            queryRequest.setAppid(this.appid);
            queryRequest.setMchid(this.mchid);
            queryRequest.setNonceStr(this.nonceStr);
            queryRequest.setMchBillNo(this.mchBillNo);
            queryRequest.setBillType(this.billType);
            return queryRequest;
        }

    }

    @Override
    public String toString() {
        return "WxPayRedPackQueryRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", mchBillNo='" + mchBillNo + '\'' +
                ", billType='" + billType + '\'' +
                '}';
    }
}