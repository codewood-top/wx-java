package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

/**
 * 查询企业付款银行卡
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_3">开发文档</a>
 */
@XStreamAlias("xml")
public class EntPayBankQueryResult extends WxPayBaseResult {

    /**
     * 商户号
     */
    private String mchid;

    /**
     * 商户企业付款单号
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 微信企业付款单号
     * 即为微信内部业务单号
     */
    @XStreamAlias("payment_no")
    private String paymentNo;

    /**
     * 银行卡号
     * 收款用户银行卡号(MD5加密)
     */
    @XStreamAlias("bank_no_md5")
    private String bankNoMd5;

    /**
     * 用户真实姓名
     * 收款人真实姓名（MD5加密）
     */
    @XStreamAlias("true_name_md5")
    private String trueNameMd5;

    /**
     * 代付金额
     * 代付订单金额RMB：分
     */
    private int amount;

    /**
     * 代付单状态
     * 代付订单状态：
     * PROCESSING（处理中，如有明确失败，则返回额外失败原因；否则没有错误原因）
     * SUCCESS（付款成功）
     * FAILED（付款失败,需要替换付款单号重新发起付款）
     * BANK_FAIL（银行退票，订单状态由付款成功流转至退票,退票时付款金额和手续费会自动退还
     */
    private String status;

    /**
     * 手续费金额
     * 手续费订单金额 RMB：分
     */
    @XStreamAlias("cmms_amt")
    private int cmmsAmt;

    /**
     * 商户下单时间
     * 	微信侧订单创建时间
     */
    @XStreamAlias("create_time")
    private String createTime;

    /**
     * 成功付款时间
     * 微信侧付款成功时间（依赖银行的处理进度，可能出现延迟返回，甚至被银行退票的情况）
     */
    @XStreamAlias("pay_success_time")
    private String paySuccessTime;

    /**
     * 失败原因
     * 订单失败原因（如：余额不足）
     */
    private String reason;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getBankNoMd5() {
        return bankNoMd5;
    }

    public void setBankNoMd5(String bankNoMd5) {
        this.bankNoMd5 = bankNoMd5;
    }

    public String getTrueNameMd5() {
        return trueNameMd5;
    }

    public void setTrueNameMd5(String trueNameMd5) {
        this.trueNameMd5 = trueNameMd5;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCmmsAmt() {
        return cmmsAmt;
    }

    public void setCmmsAmt(int cmmsAmt) {
        this.cmmsAmt = cmmsAmt;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(String paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
