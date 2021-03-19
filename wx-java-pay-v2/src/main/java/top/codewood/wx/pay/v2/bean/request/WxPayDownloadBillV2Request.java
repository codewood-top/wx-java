package top.codewood.wx.pay.v2.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

@XStreamAlias("xml")
public class WxPayDownloadBillV2Request extends WxPayBaseRequest {

    /**
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @XStreamAlias("sign_type")
    private String signType = WxPayConstants.SignType.MD5;

    /**
     * 对账单日期
     * 下载对账单的日期，格式：20140603
     */
    @Required
    @XStreamAlias("bill_date")
    private String billDate;

    /**
     * 账单类型
     * ALL（默认值），返回当日所有订单信息（不含充值退款订单）
     * SUCCESS，返回当日成功支付的订单（不含充值退款订单）
     * REFUND，返回当日退款订单（不含充值退款订单）
     * RECHARGE_REFUND，返回当日充值退款订单
     */
    @XStreamAlias("bill_type")
    private String billType = "ALL";

    /**
     * 压缩账单
     * 非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     */
    @XStreamAlias("tar_type")
    private String tarType;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getTarType() {
        return tarType;
    }

    public void setTarType(String tarType) {
        this.tarType = tarType;
    }

    @Override
    public String toString() {
        return "WxPayDownloadBillV2Request{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", billDate='" + billDate + '\'' +
                ", billType='" + billType + '\'' +
                ", tarType='" + tarType + '\'' +
                '}';
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {
        private String signType;
        private String billDate;
        private String billType;
        private String tarType;

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public Builder billDate(String billDate) {
            this.billDate = billDate;
            return this;
        }

        public Builder billType(String billType) {
            this.billType = billType;
            return this;
        }

        public Builder tarType(String tarType) {
            this.tarType = tarType;
            return this;
        }

        public WxPayDownloadBillV2Request build() {
            WxPayDownloadBillV2Request downloadBillV2Request = new WxPayDownloadBillV2Request();
            downloadBillV2Request.setAppid(this.appid);
            downloadBillV2Request.setMchid(this.mchid);
            downloadBillV2Request.setNonceStr(this.nonceStr);
            downloadBillV2Request.setBillDate(this.billDate);
            if (this.billType != null) {
                downloadBillV2Request.setBillType(this.billType);
            }
            if (this.tarType != null) {
                downloadBillV2Request.setTarType(this.tarType);
            }
            if (tarType != null) {
                downloadBillV2Request.setSignType(this.signType);
            }

            return downloadBillV2Request;
        }
    }

}
