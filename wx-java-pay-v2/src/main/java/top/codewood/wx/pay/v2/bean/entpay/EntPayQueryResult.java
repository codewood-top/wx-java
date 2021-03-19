package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

@XStreamAlias("xml")
public class EntPayQueryResult extends WxPayBaseResult {

    /**
     * 商户单号
     * 商户使用查询API填写的单号的原路返回.
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 商户号的appid
     */
    @XStreamAlias("appid")
    private String appid;

    /**
     * 商户号
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * 付款单号
     * 调用企业付款API时，微信系统内部产生的单号
     */
    @XStreamAlias("detail_id")
    private String detailId;

    /**
     * 转账状态
     * SUCCESS:转账成功
     * FAILED:转账失败
     * PROCESSING:处理中
     */
    private String status;

    /**
     * 失败原因
     * 如果失败则有失败原因
     */
    private String reason;

    /**
     * 收款用户openid
     * 转账的openid
     */
    private String openid;

    /**
     * 收款用户姓名
     */
    @XStreamAlias("transfer_name")
    private String transferName;

    /**
     * 付款金额
     * 付款金额单位为“分”
     */
    @XStreamAlias("payment_amount")
    private int paymentAmount;

    /**
     * 转账时间
     * ex: 2015-04-21 20:00:00
     */
    @XStreamAlias("transfer_time")
    private String transferTime;

    /**
     * 付款成功时间
     * ex: 2015-04-21 20:00:00
     */
    @XStreamAlias("payment_time")
    private String paymentTime;

    /**
     * 企业付款备注
     */
    private String desc;

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTransferName() {
        return transferName;
    }

    public void setTransferName(String transferName) {
        this.transferName = transferName;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "EntPayQueryResult{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", partnerTradeNo='" + partnerTradeNo + '\'' +
                ", appid='" + appid + '\'' +
                ", mchId='" + mchId + '\'' +
                ", detailId='" + detailId + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", openid='" + openid + '\'' +
                ", transferName='" + transferName + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", transferTime='" + transferTime + '\'' +
                ", paymentTime='" + paymentTime + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
