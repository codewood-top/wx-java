package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * order_id & out_order_no 二选一
 */
@XStreamAlias("xml")
public class ProfitSharingReturnRequest extends WxPayBaseRequest {

    /**
     * 签名类型
     * 签名类型，目前只支持HMAC-SHA256
     */
    @XStreamAlias("sign_type")
    private String signType = WxPayConstants.SignType.HMAC_SHA256;

    /**
     * 微信分账单号
     * 原发起分账请求时，微信返回的微信分账单号，与商户分账单号一一对应。微信分账单号与商户分账单号二选一填写
     */
    @XStreamAlias("order_id")
    private String orderId;

    /**
     * 商户分账单号
     * 原发起分账请求时使用的商户系统内部的分账单号。微信分账单号与商户分账单号二选一填写
     */
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    /**
     * 商户回退单号
     * 商户系统内部的回退单号，商户系统内部唯一，同一回退单号多次请求等同一次，只能是数字、大小写字母_-|*@ 。
     */
    @Required
    @XStreamAlias("out_return_no")
    private String outReturnNo;

    /**
     * 回退方类型
     * 枚举值：
     * MERCHANT_ID：商户号（mch_id或者sub_mch_id）
     * 暂时只支持从商户接收方回退分账金额
     */
    @Required
    @XStreamAlias("return_account_type")
    private String returnAccountType;

    /**
     * 回退方账号
     * 回退方类型是MERCHANT_ID时，填写商户号（mch_id或者sub_mch_id）
     * 只能对原分账请求中成功分给商户接收方进行回退
     */
    @Required
    @XStreamAlias("return_account")
    private String returnAccount;

    /**
     * 回退金额
     * 需要从分账接收方回退的金额，单位为分，只能为整数，不能超过原始分账单分出给该接收方的金额
     */
    @XStreamAlias("return_amount")
    private int returnAmount;

    /**
     * 分账回退的原因描述
     */
    private String description;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

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

    public String getReturnAccountType() {
        return returnAccountType;
    }

    public void setReturnAccountType(String returnAccountType) {
        this.returnAccountType = returnAccountType;
    }

    public String getReturnAccount() {
        return returnAccount;
    }

    public void setReturnAccount(String returnAccount) {
        this.returnAccount = returnAccount;
    }

    public int getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(int returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder extends WxPayBaseRequest.Builder<Builder> {
        private String signType;
        private String orderId;
        private String outOrderNo;
        private String outReturnNo;
        private String returnAccountType;
        private int returnAmount;
        private String description;

        public Builder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder outOrderNo(String outOrderNo) {
            this.outOrderNo = outOrderNo;
            return this;
        }

        public Builder outReturnNo(String outReturnNo) {
            this.outReturnNo = outReturnNo;
            return this;
        }

        public Builder returnAccountType(String returnAccountType) {
            this.returnAccountType = returnAccountType;
            return this;
        }

        public Builder returnAmount(int returnAmount) {
            this.returnAmount = returnAmount;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ProfitSharingReturnRequest build() {
            ProfitSharingReturnRequest returnRequest = new ProfitSharingReturnRequest();

            returnRequest.setAppid(this.appid);
            returnRequest.setMchid(this.mchid);
            returnRequest.setNonceStr(this.nonceStr);

            returnRequest.setOrderId(this.orderId);
            returnRequest.setOutOrderNo(this.outOrderNo);
            returnRequest.setOutReturnNo(this.outReturnNo);
            returnRequest.setReturnAccountType(this.returnAccountType);
            returnRequest.setReturnAmount(this.returnAmount);
            returnRequest.setDescription(this.description);

            if (this.signType != null) {
                returnRequest.setSignType(this.signType);
            }

            return returnRequest;
        }

    }

    @Override
    public String toString() {
        return "ProfitSharingReturnRequest{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", orderId='" + orderId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", outReturnNo='" + outReturnNo + '\'' +
                ", returnAccountType='" + returnAccountType + '\'' +
                ", returnAccount='" + returnAccount + '\'' +
                ", returnAmount=" + returnAmount +
                ", description='" + description + '\'' +
                '}';
    }
}
