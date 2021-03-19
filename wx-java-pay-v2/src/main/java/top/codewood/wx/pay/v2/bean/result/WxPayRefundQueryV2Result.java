package top.codewood.wx.pay.v2.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("xml")
public class WxPayRefundQueryV2Result extends WxPayBaseResult {

    /**
     * 微信支付分配的公众账号ID（企业号corpid即为此appId）
     */
    private String appid;

    /**
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private String mchid;

    /**
     * 随机字符串，不长于32位。
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    private String sign;

    /**
     * 订单总退款次数
     * 订单总共已发生的部分退款次数，当请求参数传入offset后有返回
     */
    @XStreamAlias("total_refund_count")
    private int totalRefundCount;

    /**
     * 微信订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 订单金额
     * 订单总金额，单位为分，只能为整数
     */
    @XStreamAlias("total_fee")
    private int totalFee;

    /**
     * 应结订单金额
     * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    @XStreamAlias("settlement_total_fee")
    private int settlementTotalFee;

    /**
     * 货币种类
     * 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * 现金支付金额，单位为分，只能为整数
     */
    @XStreamAlias("cash_fee")
    private String cashFee;

    /**
     * 当前返回退款笔数
     */
    @XStreamAlias("refund_count")
    private int refundCount;

    private List<RefundRecord> refundRecords;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getTotalRefundCount() {
        return totalRefundCount;
    }

    public void setTotalRefundCount(int totalRefundCount) {
        this.totalRefundCount = totalRefundCount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(int settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public int getRefundCount() {
        return refundCount;
    }

    public void setRefundCount(int refundCount) {
        this.refundCount = refundCount;
    }

    public List<RefundRecord> getRefundRecords() {
        return refundRecords;
    }

    public void setRefundRecords(List<RefundRecord> refundRecords) {
        this.refundRecords = refundRecords;
    }

    public void setRefundRecordsFromXml(String xml) {
        try {
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            String refundCountStr = root.elementText("retund_count");
            if (refundCountStr == null) return;
            int refundCount = Integer.valueOf(refundCountStr);
            if (refundCount == 0) return;
            List<RefundRecord> refundRecords = new ArrayList<>();

            for (int i = 0; i < refundCount; i++) {
                RefundRecord refundRecord = new RefundRecord();
                refundRecord.setOutRefundNo(root.elementText("out_refund_no_" + i));
                refundRecord.setRefundId(root.elementText("refund_id_" + i));
                refundRecord.setRefundChannel(root.elementText("refund_channel_" + i));
                refundRecord.setRefundFee(root.elementText("refund_fee"));
                refundRecord.setSettlementRefundFee(root.elementText("settlement_refund_fee"));
                refundRecord.setCouponRefundFee(Integer.valueOf(root.elementText("coupon_refund_fee")));
                refundRecord.setCouponRefundCount(Integer.valueOf(root.elementText("coupon_refund_count")));
                refundRecord.setRefundStatus(root.elementText("refund_status_" + i));
                refundRecord.setRefundRecvAccount(root.elementText("refund_recv_account_" + i));
                refundRecord.setRefundSuccessTime(root.elementText("refund_success_time_" + i));

                if (refundRecord.getCouponRefundCount() != null || refundRecord.getCouponRefundCount() > 0) {
                    List<CouponRefundInfo> couponRefundInfos = new ArrayList<>();
                    for (int j = 0; j < refundRecord.getCouponRefundCount(); j++) {
                        CouponRefundInfo couponRefundInfo = new CouponRefundInfo();
                        couponRefundInfo.setCouponRefundId(root.elementText(String.format("coupon_refund_id_%s_%s", i, j)));
                        couponRefundInfo.setCouponRefundFee(Integer.valueOf(root.elementText(String.format("coupon_refund_fee_%s_s", i, j))));
                        couponRefundInfo.setCouponType(root.elementText(String.format("coupon_type_%s_%s", i, j)));
                        couponRefundInfos.add(couponRefundInfo);
                    }
                    refundRecord.setCouponRefundInfos(couponRefundInfos);
                }
                refundRecords.add(refundRecord);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static class RefundRecord implements Serializable {

        /**
         * 商户退款单号
         * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
         */
        @XStreamAlias("out_refund_no")
        private String outRefundNo;

        /**
         * 微信退款单号
         */
        @XStreamAlias("refund_id")
        private String refundId;

        /**
         * 退款渠道
         * ORIGINAL—原路退款
         * BALANCE—退回到余额
         * OTHER_BALANCE—原账户异常退到其他余额账户
         * OTHER_BANKCARD—原银行卡异常退到其他银行卡
         */
        @XStreamAlias("refund_channel")
        private String refundChannel;

        /**
         * 申请退款金额
         * 退款总金额,单位为分,可以做部分退款
         */
        @XStreamAlias("refund_fee")
        private String refundFee;
        /**
         * 退款金额
         * 退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
         */
        @XStreamAlias("settlement_refund_fee")
        private String settlementRefundFee;

        /**
         * 总代金券退款金额
         * 代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金
         */
        @XStreamAlias("coupon_refund_fee")
        private Integer couponRefundFee;

        /**
         * 退款代金券使用数量
         * 退款代金券使用数量 ,$n为下标,从0开始编号
         */
        @XStreamAlias("coupon_refund_count")
        private Integer couponRefundCount;

        /**
         * 退款状态：
         * SUCCESS—退款成功
         * REFUNDCLOSE—退款关闭。
         * PROCESSING—退款处理中
         * CHANGE—退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。
         */
        @XStreamAlias("refund_status")
        private String refundStatus;

        /**
         * 退款资金来源
         * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户
         * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
         */
        @XStreamAlias("refund_account")
        private String refundAccount;

        /**
         * 退款入账账户
         * 取当前退款单的退款入账方
         * 1）退回银行卡：
         * {银行名称}{卡类型}{卡尾号}
         * 2）退回支付用户零钱:
         * 支付用户零钱
         * 3）退还商户:
         * 商户基本账户
         * 商户结算银行账户
         * 4）退回支付用户零钱通:
         * 支付用户零钱通
         */
        @XStreamAlias("refund_recv_account")
        private String refundRecvAccount;

        /**
         * 退款成功时间
         * 退款成功时间，当退款状态为退款成功时有返回
         */
        @XStreamAlias("refund_success_time")
        private String refundSuccessTime;

        private List<CouponRefundInfo> couponRefundInfos;


        public String getOutRefundNo() {
            return outRefundNo;
        }

        public void setOutRefundNo(String outRefundNo) {
            this.outRefundNo = outRefundNo;
        }

        public String getRefundId() {
            return refundId;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }

        public String getRefundChannel() {
            return refundChannel;
        }

        public void setRefundChannel(String refundChannel) {
            this.refundChannel = refundChannel;
        }

        public String getRefundFee() {
            return refundFee;
        }

        public void setRefundFee(String refundFee) {
            this.refundFee = refundFee;
        }

        public String getSettlementRefundFee() {
            return settlementRefundFee;
        }

        public void setSettlementRefundFee(String settlementRefundFee) {
            this.settlementRefundFee = settlementRefundFee;
        }

        public Integer getCouponRefundFee() {
            return couponRefundFee;
        }

        public void setCouponRefundFee(Integer couponRefundFee) {
            this.couponRefundFee = couponRefundFee;
        }

        public Integer getCouponRefundCount() {
            return couponRefundCount;
        }

        public void setCouponRefundCount(Integer couponRefundCount) {
            this.couponRefundCount = couponRefundCount;
        }

        public String getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(String refundStatus) {
            this.refundStatus = refundStatus;
        }

        public String getRefundAccount() {
            return refundAccount;
        }

        public void setRefundAccount(String refundAccount) {
            this.refundAccount = refundAccount;
        }

        public String getRefundRecvAccount() {
            return refundRecvAccount;
        }

        public void setRefundRecvAccount(String refundRecvAccount) {
            this.refundRecvAccount = refundRecvAccount;
        }

        public String getRefundSuccessTime() {
            return refundSuccessTime;
        }

        public void setRefundSuccessTime(String refundSuccessTime) {
            this.refundSuccessTime = refundSuccessTime;
        }

        public List<CouponRefundInfo> getCouponRefundInfos() {
            return couponRefundInfos;
        }

        public void setCouponRefundInfos(List<CouponRefundInfo> couponRefundInfos) {
            this.couponRefundInfos = couponRefundInfos;
        }
    }

    public static class CouponRefundInfo implements Serializable {

        /**
         * 代金券类型
         * CASH--充值代金券
         * NO_CASH---非充值优惠券
         * 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）
         */
        @XStreamAlias("coupon_type")
        private String couponType;
        /**
         * 退款代金券ID
         *
         */
        @XStreamAlias("coupon_refund_id")
        private String couponRefundId;
        /**
         * 单个代金券退款金额
         */
        @XStreamAlias("coupon_refund_fee")
        private Integer couponRefundFee;

        public String getCouponType() {
            return couponType;
        }

        public void setCouponType(String couponType) {
            this.couponType = couponType;
        }

        public String getCouponRefundId() {
            return couponRefundId;
        }

        public void setCouponRefundId(String couponRefundId) {
            this.couponRefundId = couponRefundId;
        }

        public Integer getCouponRefundFee() {
            return couponRefundFee;
        }

        public void setCouponRefundFee(Integer couponRefundFee) {
            this.couponRefundFee = couponRefundFee;
        }
    }


    @Override
    public String toString() {
        return "WxPayRefundQueryV2Result{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", totalRefundCount=" + totalRefundCount +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", totalFee=" + totalFee +
                ", settlementTotalFee=" + settlementTotalFee +
                ", feeType='" + feeType + '\'' +
                ", cashFee='" + cashFee + '\'' +
                ", refundCount=" + refundCount +
                ", refundRecords=" + refundRecords +
                '}';
    }
}
