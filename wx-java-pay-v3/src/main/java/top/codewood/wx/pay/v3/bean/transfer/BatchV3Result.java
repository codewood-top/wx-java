package top.codewood.wx.pay.v3.bean.transfer;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class BatchV3Result implements Serializable {

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
     * 【批次创建时间】 批次受理成功时返回，按照使用rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE
     */
    @SerializedName("create_time")
    private OffsetDateTime createTime;

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

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BatchesV3Result{" +
                "outBatchNo='" + outBatchNo + '\'' +
                ", batchId='" + batchId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
