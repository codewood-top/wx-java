package top.codewood.wx.pay.v3.bean.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxPayBillDownloadResult implements Serializable {

    /**
     * 哈希类型
     * 原始账单（gzip需要解压缩）的摘要值，用于校验文件的完整性。
     * 示例值：SHA1
     */
    @SerializedName("hash_type")
    private String hashType;

    /**
     * 哈希值
     * 原始账单（gzip需要解压缩）的摘要值，用于校验文件的完整性。
     */
    @SerializedName("hash_value")
    private String hashValue;

    /**
     * 账单下载地址
     * 供下一步请求账单文件的下载地址，该地址30s内有效。
     */
    @SerializedName("download_url")
    private String downloadUrl;

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

    @Override
    public String toString() {
        return "WxPayTradeBill{" +
                "hashType='" + hashType + '\'' +
                ", hashValue='" + hashValue + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
