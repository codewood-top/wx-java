package top.codewood.wx.pay.v3.bean.transfer;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DetailElectronicReceiptV3Result implements Serializable {

    /**
     * 【受理类型】 电子回单受理类型：BATCH_TRANSFER：批量转账明细电子回单 TRANSFER_TO_POCKET：企业付款至零钱电子回单 TRANSFER_TO_BANK：企业付款至银行卡电子回单
     * 可选取值：
     * BATCH_TRANSFER: 批量转账明细电子回单
     * TRANSFER_TO_POCKET: 企业付款至零钱电子回单
     * TRANSFER_TO_BANK: 企业付款至银行卡电子回单
     */
    @SerializedName("access_type")
    private String accessType;

    /**
     * 【商家转账批次单号】 需要电子回单的批量转账明细单所在的转账批次的单号，该单号为商户申请转账时生成的商户单号。受理类型为BATCH_TRANSFER时该单号必填，否则该单号留空。
     */
    @SerializedName("out_batch_no")
    private String outBatchNo;

    /**
     * 【商家转账明细单号】 该单号为商户申请转账时生成的商家转账明细单号。 1.受理类型为BATCH_TRANSFER时填写商家批量转账明细单号。2. 受理类型为TRANSFER_TO_POCKET或TRANSFER_TO_BANK时填写商家转账单号。
     */
    @SerializedName("out_detail_no")
    private String outDetailNo;

    /**
     * 【电子回单受理单号】 电子回单受理单号，受理单据的唯一标识
     */
    @SerializedName("signature_no")
    private String signatureNo;

    /**
     * 【电子回单状态】 枚举值： ACCEPTED:已受理，电子签章已受理成功 FINISHED:已完成。电子签章已处理完成
     */
    @SerializedName("signature_status")
    private String signatureStatus;

    /**
     * 【电子回单文件的hash方法】 电子回单文件的hash方法，回单状态为：FINISHED时返回
     */
    @SerializedName("hash_type")
    private String hashType;

    /**
     * 【电子回单文件的hash值】 电子回单文件的hash值，用于下载之后验证文件的完整、正确性，回单状态为：FINISHED时返回
     */
    @SerializedName("hash_value")
    private String hashValue;

    /**
     * 【电子回单文件的下载地址】 电子回单文件的下载地址，回单状态为：FINISHED时返回。URL有效时长为10分钟，10分钟后需要重新去获取下载地址（但不需要走受理）
     */
    @SerializedName("download_url")
    private String downloadUrl;

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getOutBatchNo() {
        return outBatchNo;
    }

    public void setOutBatchNo(String outBatchNo) {
        this.outBatchNo = outBatchNo;
    }

    public String getOutDetailNo() {
        return outDetailNo;
    }

    public void setOutDetailNo(String outDetailNo) {
        this.outDetailNo = outDetailNo;
    }

    public String getSignatureNo() {
        return signatureNo;
    }

    public void setSignatureNo(String signatureNo) {
        this.signatureNo = signatureNo;
    }

    public String getSignatureStatus() {
        return signatureStatus;
    }

    public void setSignatureStatus(String signatureStatus) {
        this.signatureStatus = signatureStatus;
    }

    public String getHashType() {
        return hashType;
    }

    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}