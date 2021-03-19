package top.codewood.wx.pay.v2.bean.redpack;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

import java.io.Serializable;
import java.util.List;

@XStreamAlias("xml")
public class WxPayRedPackQueryResult extends WxPayBaseResult {


    /**
     * 商户订单号
     * 商户使用查询API填写的商户单号的原路返回
     */
    @XStreamAlias("mch_billno")
    private String mchBillno;

    /**
     * 商户号
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * 红包单号
     * 使用API发放现金红包时返回的红包单号
     */
    @XStreamAlias("detail_id")
    private String detailId;

    /**
     * 红包状态
     * SENDING:发放中
     * SENT:已发放待领取
     * FAILED：发放失败
     * RECEIVED:已领取
     * RFUND_ING:退款中
     * REFUND:已退款
     */
    private String status;

    /**
     * 红包类型
     * GROUP:裂变红包
     * NORMAL:普通红包
     */
    @XStreamAlias("hb_type")
    private String hbType;

    /**
     * 红包个数
     */
    @XStreamAlias("total_num")
    private int totalNum;

    /**
     * 红包金额
     * 红包总金额（单位分）
     */
    @XStreamAlias("total_amount")
    private int totalAmount;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 红包发送时间
     */
    @XStreamAlias("send_time")
    private String sendTime;

    /**
     * 红包退款时间
     * 红包的退款时间（如果其未领取的退款）
     */
    @XStreamAlias("refund_time")
    private String refundTime;

    /**
     * 红包退款金额
     */
    @XStreamAlias("refund_amount")
    private int refundAmount;

    /**
     * 祝福语
     */
    private String wishing;

    /**
     *
     * 活动描述
     * 活动描述，低版本微信可见
     */
    private String remark;

    /**
     * 活动名称
     * 发红包的活动名称
     */
    @XStreamAlias("act_name")
    private String actName;

    /**
     * 裂变红包领取列表
     */
    @XStreamAlias("hblist")
    private List<HbInfo> hbList;

    public String getMchBillno() {
        return mchBillno;
    }

    public void setMchBillno(String mchBillno) {
        this.mchBillno = mchBillno;
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

    public String getHbType() {
        return hbType;
    }

    public void setHbType(String hbType) {
        this.hbType = hbType;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public int getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public List<HbInfo> getHbList() {
        return hbList;
    }

    public void setHbList(List<HbInfo> hbList) {
        this.hbList = hbList;
    }

    @XStreamAlias("hbinfo")
    public static class HbInfo implements Serializable {

        /**
         * 领取红包的Openid
         */
        private String openid;

        /**
         * 金额
         * 领取金额
         */
        private int amount;
        /**
         * 接收时间
         * 领取红包的时间
         */
        @XStreamAlias("rcv_time")
        private String rcvTime;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getRcvTime() {
            return rcvTime;
        }

        public void setRcvTime(String rcvTime) {
            this.rcvTime = rcvTime;
        }
    }

    @Override
    public String toString() {
        return "WxPayRedPackQueryResult{" +
                "mchBillno='" + mchBillno + '\'' +
                ", mchId='" + mchId + '\'' +
                ", detailId='" + detailId + '\'' +
                ", status='" + status + '\'' +
                ", hbType='" + hbType + '\'' +
                ", totalNum=" + totalNum +
                ", totalAmount=" + totalAmount +
                ", reason='" + reason + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", refundTime='" + refundTime + '\'' +
                ", refundAmount=" + refundAmount +
                ", wishing='" + wishing + '\'' +
                ", remark='" + remark + '\'' +
                ", actName='" + actName + '\'' +
                ", hbList=" + hbList +
                '}';
    }
}
