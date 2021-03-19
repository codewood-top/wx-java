package top.codewood.wx.pay.v2.bean.redpack;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

@XStreamAlias("xml")
public class WxPayRedPackResult extends WxPayBaseResult {

    /**
     * 商户订单号
     * 商户订单号（每个订单号必须唯一）
     * 组成：mch_id+yyyymmdd+10位一天内不能重复的数字
     */
    @XStreamAlias("mch_billno")
    private String mchBillNo;

    /**
     * 商户号
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * 公众账号appid
     * 商户appid，接口传入的所有appid应该为公众号的appid
     */
    @XStreamAlias("wxappid")
    private String wxAppid;

    /**
     * 用户openid
     * 接受收红包的用户
     * 用户在wxappid下的openid
     */
    @XStreamAlias("re_openid")
    private String reOpenid;

    /**
     * 付款金额
     * 付款金额，单位分
     */
    @XStreamAlias("total_amount")
    private int totalAmount;

    /**
     * 微信单号
     * 红包订单的微信单号
     */
    @XStreamAlias("send_listid")
    private String sendListId;

    public String getMchBillNo() {
        return mchBillNo;
    }

    public void setMchBillNo(String mchBillNo) {
        this.mchBillNo = mchBillNo;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }

    public String getReOpenid() {
        return reOpenid;
    }

    public void setReOpenid(String reOpenid) {
        this.reOpenid = reOpenid;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSendListId() {
        return sendListId;
    }

    public void setSendListId(String sendListId) {
        this.sendListId = sendListId;
    }

    @Override
    public String toString() {
        return "WxPayRedPackResult{" +
                "mchBillNo='" + mchBillNo + '\'' +
                ", mchId='" + mchId + '\'' +
                ", wxAppid='" + wxAppid + '\'' +
                ", reOpenid='" + reOpenid + '\'' +
                ", totalAmount=" + totalAmount +
                ", sendListId='" + sendListId + '\'' +
                '}';
    }
}