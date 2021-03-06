package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_2">参考文档</a>
 */
@XStreamAlias("xml")
public class EntPayBankRequest extends WxPayBaseRequest {

    /**
     * 商户企业付款单号
     * 商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]，最短8位，最长32位）
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 收款方银行卡号
     * 收款方银行卡号（采用标准RSA算法，公钥由微信侧提供）,详见<a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7">获取RSA加密公钥API</a>
     */
    @Required
    @XStreamAlias("enc_bank_no")
    private String encBankNo;

    /**
     * 收款方用户名
     * 收款方用户名（采用标准RSA算法，公钥由微信侧提供）详见<a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7">获取RSA加密公钥API</a>
     */
    @Required
    @XStreamAlias("enc_true_name")
    private String encTrueName;

    /**
     * 收款方开户行
     * 银行卡所在开户行编号,详见<a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_4">银行编号列表</a>
     */
    @Required
    @XStreamAlias("bank_code")
    private String bankCode;

    /**
     * 付款金额
     * 付款金额：RMB分（支付总额，不含手续费）
     * 注：大于0的整数
     */
    @Required
    private int amount;

    /**
     * 付款说明
     * 企业付款到银行卡付款说明,即订单备注（UTF8编码，允许100个字符以内）
     */
    private String desc;

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getEncBankNo() {
        return encBankNo;
    }

    public void setEncBankNo(String encBankNo) {
        this.encBankNo = encBankNo;
    }

    public String getEncTrueName() {
        return encTrueName;
    }

    public void setEncTrueName(String encTrueName) {
        this.encTrueName = encTrueName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "EntPayBankRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", partnerTradeNo='" + partnerTradeNo + '\'' +
                ", encBankNo='" + encBankNo + '\'' +
                ", encTrueName='" + encTrueName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", amount=" + amount +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {
        private String partnerTradeNo;
        private String encBankNo;
        private String encTrueName;
        private String bankCode;
        private int amount;
        private String desc;

        public Builder partnerTradeNo(String partnerTradeNo) {
            this.partnerTradeNo = partnerTradeNo;
            return this;
        }

        public Builder encBankNo(String encBankNo) {
            this.encBankNo = encBankNo;
            return this;
        }

        public Builder encTrueName(String encTrueName) {
            this.encTrueName = encTrueName;
            return this;
        }

        public Builder bankCode(String bankCode) {
            this.bankCode = bankCode;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public EntPayBankRequest build() {
            EntPayBankRequest request = new EntPayBankRequest();
            request.setMchid(this.mchid);
            request.setPartnerTradeNo(this.partnerTradeNo);
            request.setNonceStr(this.nonceStr);
            request.setEncBankNo(this.encBankNo);
            request.setEncTrueName(this.encTrueName);
            request.setBankCode(this.bankCode);
            request.setAmount(this.amount);
            request.setDesc(this.desc);
            request.setSignType(null);
            return request;
        }

    }

}