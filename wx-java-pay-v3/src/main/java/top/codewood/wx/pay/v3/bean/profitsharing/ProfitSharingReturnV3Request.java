package top.codewood.wx.pay.v3.bean.profitsharing;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProfitSharingReturnV3Request implements Serializable {

    /**
     * 微信分账单号
     * 微信分账单号，微信支付系统返回的唯一标识。
     */
    @SerializedName("order_id")
    private String orderId;
    /**
     * 商户分账单号
     * 原发起分账请求时使用的商户系统内部的分账单号。微信分账单号与商户分账单号二选一填写
     */
    @SerializedName("out_order_no")
    private String outOrderNo;
    /**
     * 商户回退单号
     * 此回退单号是商户在自己后台生成的一个新的回退单号，在商户后台唯一
     */
    @SerializedName("out_return_no")
    private String outReturnNo;
    /**
     * 回退商户号
     * 分账接口中的分账接收方商户号
     */
    @SerializedName("return_mchid")
    private String returnMchid;
    /**
     * 回退金额
     * 需要从分账接收方回退的金额，单位为分，只能为整数，不能超过原始分账单分出给该接收方的金额
     */
    private Integer amount;
    /**
     * 回退描述
     * 分账回退的原因描述
     */
    private String description;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOutReturnNo() {
        return outReturnNo;
    }

    public void setOutReturnNo(String outReturnNo) {
        this.outReturnNo = outReturnNo;
    }

    public String getReturnMchid() {
        return returnMchid;
    }

    public void setReturnMchid(String returnMchid) {
        this.returnMchid = returnMchid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProfitSharingReturnV3Request{" +
                "orderId='" + orderId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", outReturnNo='" + outReturnNo + '\'' +
                ", returnMchid='" + returnMchid + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
