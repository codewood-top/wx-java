package top.codewood.wx.pay.v3.bean.profitsharing;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProfitSharingV3Request implements Serializable {

    /**
     * 必填：是
     * 应用ID
     * 微信分配的商户appid
     */
    private String appid;
    /**
     * 必填：是
     * 微信订单号
     * 微信支付订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;
    /**
     * 必填：是
     * 商户分账单号
     * 商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次。只能是数字、大小写字母_-|*@
     */
    @SerializedName("out_order_no")
    private String outOrderNo;
    /**
     * 必填：是
     * 是否解冻剩余未分资金
     * 1、如果为true，该笔订单剩余未分账的金额会解冻回分账方商户；
     * 2、如果为false，该笔订单剩余未分账的金额不会解冻回分账方商户，可以对该笔订单再次进行分账。
     */
    @SerializedName("unfreeze_unsplit")
    private boolean unfreezeUnSplit;

    /**
     * 分账接收方列表
     * 分账接收方列表，可以设置出资商户作为分账接受方，最多可有50个分账接收方
     */
    private List<Receiver> receivers;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public boolean isUnfreezeUnSplit() {
        return unfreezeUnSplit;
    }

    public void setUnfreezeUnSplit(boolean unfreezeUnSplit) {
        this.unfreezeUnSplit = unfreezeUnSplit;
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receiver> receivers) {
        this.receivers = receivers;
    }


    public static class Receiver implements Serializable {

        /**
         * 必填：是
         * 分账接收方类型
         * 1、MERCHANT_ID：商户号
         * 2、PERSONAL_OPENID：个人openid（由父商户APPID转换得到）
         */
        private String  type;

        /**
         * 必填：是
         * 分账接收方账号：
         * 1、类型是MERCHANT_ID时，是商户号（mch_id或者sub_mch_id）
         * 2、类型是PERSONAL_OPENID时，是个人openid
         */
        private String account;

        /**
         * 必填：否
         * 分账个人接收方姓名
         * 可选项，在接收方类型为个人的时可选填，若有值，会检查与 name 是否实名匹配，不匹配会拒绝分账请求
         * 1、分账接收方类型是PERSONAL_OPENID，是个人姓名的密文（选传，传则校验） 此字段的加密方法详见：敏感信息加密说明
         * 2、使用微信支付平台证书中的公钥
         * 3、使用RSAES-OAEP算法进行加密
         * 4、将请求中HTTP头部的Wechatpay-Serial设置为证书序列号
         */
        private String name;

        /**
         * 必填：是
         * 分账金额
         * 分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
         */
        private Integer amount;

        /**
         * 必填：是
         * 分账描述
         * 分账的原因描述，分账账单中需要体现
         */
        private String description;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
            return "Receiver{" +
                    "type='" + type + '\'' +
                    ", account='" + account + '\'' +
                    ", name='" + name + '\'' +
                    ", amount=" + amount +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ProfitSharingV3Request{" +
                "appid='" + appid + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", unfreezeUnSplit=" + unfreezeUnSplit +
                ", receivers=" + receivers +
                '}';
    }
}
