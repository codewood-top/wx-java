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
}