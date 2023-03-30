package top.codewood.wx.pay.v3.bean.transfer;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BatchV3Request implements Serializable {

    /**
     * 必填：是
     * 【商户appid】 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appid）
     */
    private String appid;

    /**
     * 必填：是
     * 【商家批次单号】 商户系统内部的商家批次单号，要求此参数只能由数字、大小写字母组成，在商户系统内部唯一
     */
    @SerializedName("out_batch_no")
    private String outBatchNo;

    /**
     * 必填：是
     * 【批次名称】 该笔批量转账的名称
     */
    @SerializedName("batch_name")
    private String batchName;

    /**
     * 必填：是
     * 【批次备注】 转账说明，UTF8编码，最多允许32个字符
     */
    @SerializedName("batch_remark")
    private String batchRemark;

    /**
     * 必填：是
     * 【转账总金额】 转账金额单位为“分”。转账总金额必须与批次内所有明细转账金额之和保持一致，否则无法发起转账操作
     */
    @SerializedName("total_amount")
    private Integer totalAmount;

    /**
     * 必填：是
     * 【转账总笔数】 一个转账批次单最多发起一千笔转账。转账总笔数必须与批次内所有明细之和保持一致，否则无法发起转账操作
     */
    @SerializedName("total_num")
    private Integer totalNum;

    /**
     * 必填：是
     * 【转账明细列表】 发起批量转账的明细列表，最多一千笔
     */
    @SerializedName("transfer_detail_list")
    private List<TransferDetailInput> transferDetailList;

    /**
     * 必填：否
     * 【转账场景ID】 必填，指定该笔转账使用的转账场景ID
     */
    @SerializedName("transfer_scene_id")
    private String transferSceneId;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOutBatchNo() {
        return outBatchNo;
    }

    public void setOutBatchNo(String outBatchNo) {
        this.outBatchNo = outBatchNo;
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

    public List<TransferDetailInput> getTransferDetailList() {
        return transferDetailList;
    }

    public void setTransferDetailList(List<TransferDetailInput> transferDetailList) {
        this.transferDetailList = transferDetailList;
    }

    public String getTransferSceneId() {
        return transferSceneId;
    }

    public void setTransferSceneId(String transferSceneId) {
        this.transferSceneId = transferSceneId;
    }

    @Override
    public String toString() {
        return "BatchesV3Request{" +
                "appid='" + appid + '\'' +
                ", outBatchNo='" + outBatchNo + '\'' +
                ", batchName='" + batchName + '\'' +
                ", batchRemark='" + batchRemark + '\'' +
                ", totalAmount=" + totalAmount +
                ", totalNum=" + totalNum +
                ", transferDetailList=" + transferDetailList +
                ", transferSceneId='" + transferSceneId + '\'' +
                '}';
    }

    public static class TransferDetailInput implements Serializable {

        /**
         * 必填：是
         *  【商家明细单号】 商户系统内部区分转账批次单下不同转账明细单的唯一标识，要求此参数只能由数字、大小写字母组成
         */
        @SerializedName("out_detail_no")
        private String outDetailNo;

        /**
         * 必填：是
         * 【转账金额】 转账金额单位为“分”
         */
        @SerializedName("transfer_amount")
        private Integer transferAmount;

        /**
         * 必填：是
         * 【转账备注】 单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符
         */
        @SerializedName("transfer_remark")
        private String transferRemark;

        /**
         * 必填：是
         * 【收款用户openid】 商户appid下，某用户的openid
         */
        private String openid;

        /**
         * 必填：否
         * 【收款用户姓名】 收款方真实姓名。支持标准RSA算法和国密算法，公钥由微信侧提供
         * 明细转账金额<0.3元时，不允许填写收款用户姓名
         * 明细转账金额 >= 2,000元时，该笔明细必须填写收款用户姓名
         * 同一批次转账明细中的姓名字段传入规则需保持一致，也即全部填写、或全部不填写
         * 若商户传入收款用户姓名，微信支付会校验用户openID与姓名是否一致，并提供电子回单
         */
        @SerializedName("user_name")
        private String userName;



        public String getOutDetailNo() {
            return outDetailNo;
        }

        public void setOutDetailNo(String outDetailNo) {
            this.outDetailNo = outDetailNo;
        }

        public Integer getTransferAmount() {
            return transferAmount;
        }

        public void setTransferAmount(Integer transferAmount) {
            this.transferAmount = transferAmount;
        }

        public String getTransferRemark() {
            return transferRemark;
        }

        public void setTransferRemark(String transferRemark) {
            this.transferRemark = transferRemark;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }



        @Override
        public String toString() {
            return "TransferDetailInput{" +
                    "outDetailNo='" + outDetailNo + '\'' +
                    ", transferAmount=" + transferAmount +
                    ", transferRemark='" + transferRemark + '\'' +
                    ", openid='" + openid + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }

}
