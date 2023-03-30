package top.codewood.wx.pay.v3.bean.transfer;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class BillReceiptV3Result implements Serializable {

    /**
     * 【商家批次单号】 商户系统内部的商家批次单号，在商户系统内部唯一。需要电子回单的批次单号
     */
    @SerializedName("out_batch_no")
    private String outBatchNo;

    /**
     * 【电子回单申请单号】 电子回单申请单号，申请单据的唯一标识
     */
    @SerializedName("signature_no")
    private String signatureNo;

    /**
     * 【电子回单状态】 ACCEPTED:已受理，电子签章已受理成功 FINISHED:已完成。电子签章已处理完成
     */
    @SerializedName("signature_status")
    private String signatureStatus;

    /**
     * 【电子回单文件的hash方法】 电子回单文件的hash方法
     */
    @SerializedName("hash_type")
    private String hashType;

    /**
     * 【电子回单文件的下载地址】 电子回单文件的下载地址
     */
    @SerializedName("download_url")
    private String downloadUrl;

    /**
     * 【创建时间】 电子签章单创建时间，按照使用rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE
     */
    @SerializedName("create_time")
    private OffsetDateTime createTime;

    /**
     * 【更新时间】 电子签章单最近一次状态变更的时间，按照使用rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE
     */
    @SerializedName("update_time")
    private OffsetDateTime updateTime;

    public String getOutBatchNo() {
        return outBatchNo;
    }

    public void setOutBatchNo(String outBatchNo) {
        this.outBatchNo = outBatchNo;
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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
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

}
