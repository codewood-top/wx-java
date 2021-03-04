package top.codewood.wx.pay.response.cert;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class CertificateItem implements Serializable {

    @SerializedName("serial_no")
    private String serialNo;

    @SerializedName("effective_time")
    private OffsetDateTime effectiveTime;

    @SerializedName("expire_time")
    private OffsetDateTime expireTime;

    @SerializedName("encrypt_certificate")
    private EncryptCertificateItem encryptCertificateItem;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public OffsetDateTime getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(OffsetDateTime effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public OffsetDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(OffsetDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public EncryptCertificateItem getEncryptCertificateItem() {
        return encryptCertificateItem;
    }

    public void setEncryptCertificateItem(EncryptCertificateItem encryptCertificateItem) {
        this.encryptCertificateItem = encryptCertificateItem;
    }

    @Override
    public String toString() {
        return "CertificateItem{" +
                "serialNo='" + serialNo + '\'' +
                ", effectiveTime=" + effectiveTime +
                ", expireTime=" + expireTime +
                ", encryptCertificateItem=" + encryptCertificateItem +
                '}';
    }
}
