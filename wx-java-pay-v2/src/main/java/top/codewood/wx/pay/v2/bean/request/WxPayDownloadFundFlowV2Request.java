package top.codewood.wx.pay.v2.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

@XStreamAlias("xml")
public class WxPayDownloadFundFlowV2Request extends WxPayBaseRequest {

    /**
     * 资金账单日期
     * 下载对账单的日期，格式：20140603
     */
    @Required
    @XStreamAlias("bill_date")
    private String billDate;

    /**
     * 资金账户类型
     * 账单的资金来源账户：
     * Basic  基本账户
     * Operation 运营账户
     * Fees 手续费账户
     */
    @Required
    @XStreamAlias("account_type")
    private String accountType;

    /**
     * 压缩账单
     * 非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     */
    @XStreamAlias("tar_type")
    private String tarType;

    public WxPayDownloadFundFlowV2Request() {
        signType = WxPayConstants.SignType.HMAC_SHA256;
    }

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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getTarType() {
        return tarType;
    }

    public void setTarType(String tarType) {
        this.tarType = tarType;
    }

    @Override
    public String toString() {
        return "WxPayDownloadFundFlowV2Request{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", billDate='" + billDate + '\'' +
                ", accountType='" + accountType + '\'' +
                ", tarType='" + tarType + '\'' +
                '}';
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {
        private String signType = WxPayConstants.SignType.HMAC_SHA256;
        private String billDate;
        private String accountType;
        private String tarType;

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public Builder billDate(String billDate) {
            this.billDate = billDate;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder tarType(String tarType) {
            this.tarType = tarType;
            return this;
        }

        public WxPayDownloadFundFlowV2Request build() {

            WxPayDownloadFundFlowV2Request fundFlowV2Request = new WxPayDownloadFundFlowV2Request();

            fundFlowV2Request.setAppid(this.appid);
            fundFlowV2Request.setMchid(this.mchid);
            fundFlowV2Request.setNonceStr(this.nonceStr);
            fundFlowV2Request.setBillDate(this.billDate);
            fundFlowV2Request.setAccountType(this.accountType);
            fundFlowV2Request.setTarType(this.tarType);

            if (this.signType != null) {
                fundFlowV2Request.setSignType(this.signType);
            }

            return fundFlowV2Request;
        }
    }
}
