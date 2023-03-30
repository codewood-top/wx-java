package top.codewood.wx.pay.v3.bean.transfer;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

public class GetBatchV3Result implements Serializable {

    /**
     * 【转账批次单】 转账批次单基本信息
     */
    @SerializedName("transfer_batch")
    private TransferBatchGet transferBatch;

    /**
     * 【转账明细单列表】 当批次状态为“FINISHED”（已完成），且成功查询到转账明细单时返回。包括微信明细单号、明细状态信息
     */
    @SerializedName("transfer_detail_list")
    private List<TransferDetailCompact> transferDetailList;


    public TransferBatchGet getTransferBatch() {
        return transferBatch;
    }

    public void setTransferBatch(TransferBatchGet transferBatch) {
        this.transferBatch = transferBatch;
    }

    public List<TransferDetailCompact> getTransferDetailList() {
        return transferDetailList;
    }

    public void setTransferDetailList(List<TransferDetailCompact> transferDetailList) {
        this.transferDetailList = transferDetailList;
    }

    public static class TransferBatchGet implements Serializable {

        /**
         *【商户号】 微信支付分配的商户号
         */
        private String mchid;

        /**
         * 【商家批次单号】 商户系统内部的商家批次单号，在商户系统内部唯一
         */
        @SerializedName("out_batch_no")
        private String outBatchNo;

        /**
         * 【微信批次单号】 微信批次单号，微信商家转账系统返回的唯一标识
         */
        @SerializedName("batch_id")
        private String batchId;

        /**
         * 【商户appid】 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appid）
         */
        private String appid;

        /**
         *  【批次状态】 WAIT_PAY: 待付款确认。需要付款出资商户在商家助手小程序或服务商助手小程序进行付款确认
         * ACCEPTED:已受理。批次已受理成功，若发起批量转账的30分钟后，转账批次单仍处于该状态，可能原因是商户账户余额不足等。商户可查询账户资金流水，若该笔转账批次单的扣款已经发生，则表示批次已经进入转账中，请再次查单确认
         * PROCESSING:转账中。已开始处理批次内的转账明细单
         * FINISHED:已完成。批次内的所有转账明细单都已处理完成
         * CLOSED:已关闭。可查询具体的批次关闭原因确认
         */
        @SerializedName("batch_status")
        private String batchStatus;

        /**
         * 【批次类型】 API:API方式发起
         * WEB:页面方式发起
         */
        @SerializedName("batch_type")
        private String batchType;

        /**
         * 【批次名称】 该笔批量转账的名称
         */
        @SerializedName("batch_name")
        private String batchName;

        /**
         * 【批次备注】 转账说明，UTF8编码，最多允许32个字符
         */
        @SerializedName("batch_remark")
        private String batchRemark;

        /**
         * 【批次关闭原因】 如果批次单状态为“CLOSED”（已关闭），则有关闭原因
         * 可选取值：
         * OVERDUE_CLOSE: 系统超时关闭，可能原因账户余额不足或其他错误
         * TRANSFER_SCENE_INVALID: 付款确认时，转账场景已不可用，系统做关单处理
         */
        @SerializedName("close_reason")
        private String closeReason;

        /**
         * 【转账总金额】 转账金额单位为“分”
         */
        @SerializedName("total_amount")
        private Integer totalAmount;

        /**
         * 【转账总笔数】 一个转账批次单最多发起三千笔转账
         */
        @SerializedName("total_num")
        private Integer totalNum;

        /**
         * 【批次创建时间】 批次受理成功时返回，按照使用rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE
         */
        @SerializedName("create_time")
        private OffsetDateTime createTime;

        /**
         * 【批次更新时间】 批次最近一次状态变更的时间，按照使用rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE
         */
        @SerializedName("update_time")
        private OffsetDateTime updateTime;

        /**
         * 【转账成功金额】 转账成功的金额，单位为“分”。当批次状态为“PROCESSING”（转账中）时，转账成功金额随时可能变化
         */
        @SerializedName("success_amount")
        private Integer successAmount;

        /**
         * 【转账成功笔数】 转账成功的笔数。当批次状态为“PROCESSING”（转账中）时，转账成功笔数随时可能变化
         */
        @SerializedName("success_num")
        private Integer successNum;

        /**
         * 【转账失败金额】 转账失败的金额，单位为“分”
         */
        @SerializedName("fail_amount")
        private Integer failAmount;

        /**
         * 【转账失败笔数】 转账失败的笔数
         */
        @SerializedName("fail_num")
        private Integer failNum;

        /**
         * 【转账场景ID】 指定的转账场景ID
         */
        @SerializedName("transfer_scene_id")
        private String transferSceneId;

        public String getMchid() {
            return mchid;
        }

        public void setMchid(String mchid) {
            this.mchid = mchid;
        }

        public String getOutBatchNo() {
            return outBatchNo;
        }

        public void setOutBatchNo(String outBatchNo) {
            this.outBatchNo = outBatchNo;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getBatchStatus() {
            return batchStatus;
        }

        public void setBatchStatus(String batchStatus) {
            this.batchStatus = batchStatus;
        }

        public String getBatchType() {
            return batchType;
        }

        public void setBatchType(String batchType) {
            this.batchType = batchType;
        }

        public String getBatchName() {
            return batchName;
        }

        public void setBatchName(String batchName) {
            this.batchName = batchName;
        }

        public String getBatchRemark() {
            return batchRemark;
        }

        public void setBatchRemark(String batchRemark) {
            this.batchRemark = batchRemark;
        }

        public String getCloseReason() {
            return closeReason;
        }

        public void setCloseReason(String closeReason) {
            this.closeReason = closeReason;
        }

        public Integer getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Integer totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Integer getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(Integer totalNum) {
            this.totalNum = totalNum;
        }

        public OffsetDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(OffsetDateTime createTime) {
            this.createTime = createTime;
        }

        public OffsetDateTime getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(OffsetDateTime updateTime) {
            this.updateTime = updateTime;
        }

        public Integer getSuccessAmount() {
            return successAmount;
        }

        public void setSuccessAmount(Integer successAmount) {
            this.successAmount = successAmount;
        }

        public Integer getSuccessNum() {
            return successNum;
        }

        public void setSuccessNum(Integer successNum) {
            this.successNum = successNum;
        }

        public Integer getFailAmount() {
            return failAmount;
        }

        public void setFailAmount(Integer failAmount) {
            this.failAmount = failAmount;
        }

        public Integer getFailNum() {
            return failNum;
        }

        public void setFailNum(Integer failNum) {
            this.failNum = failNum;
        }

        public String getTransferSceneId() {
            return transferSceneId;
        }

        public void setTransferSceneId(String transferSceneId) {
            this.transferSceneId = transferSceneId;
        }

        @Override
        public String toString() {
            return "TransferBatchGet{" +
                    "mchid='" + mchid + '\'' +
                    ", outBatchNo='" + outBatchNo + '\'' +
                    ", batchId='" + batchId + '\'' +
                    ", appid='" + appid + '\'' +
                    ", batchStatus='" + batchStatus + '\'' +
                    ", batchType='" + batchType + '\'' +
                    ", batchName='" + batchName + '\'' +
                    ", batchRemark='" + batchRemark + '\'' +
                    ", closeReason='" + closeReason + '\'' +
                    ", totalAmount=" + totalAmount +
                    ", totalNum=" + totalNum +
                    ", createTime=" + createTime +
                    ", updateTime=" + updateTime +
                    ", successAmount=" + successAmount +
                    ", successNum=" + successNum +
                    ", failAmount=" + failAmount +
                    ", failNum=" + failNum +
                    ", transferSceneId='" + transferSceneId + '\'' +
                    '}';
        }
    }

    public static class TransferDetailCompact implements Serializable {
        /**
         * 【微信明细单号】 微信支付系统内部区分转账批次单下不同转账明细单的唯一标识
         */
        @SerializedName("detail_id")
        private String detailId;

        /**
         * 【商家明细单号】 商户系统内部区分转账批次单下不同转账明细单的唯一标识
         */
        @SerializedName("out_detail_no")
        private String outDetailNo;

        /**
         * 【明细状态】 INIT: 初始态。 系统转账校验中
         * WAIT_PAY: 待确认。待商户确认, 符合免密条件时, 系统会自动扭转为转账中
         * PROCESSING:转账中。正在处理中，转账结果尚未明确
         * SUCCESS:转账成功
         * FAIL:转账失败。需要确认失败原因后，再决定是否重新发起对该笔明细单的转账（并非整个转账批次单）
         */
        @SerializedName("detail_status")
        private String detailStatus;

        public String getDetailId() {
            return detailId;
        }

        public void setDetailId(String detailId) {
            this.detailId = detailId;
        }

        public String getOutDetailNo() {
            return outDetailNo;
        }

        public void setOutDetailNo(String outDetailNo) {
            this.outDetailNo = outDetailNo;
        }

        public String getDetailStatus() {
            return detailStatus;
        }

        public void setDetailStatus(String detailStatus) {
            this.detailStatus = detailStatus;
        }
    }

}
