package top.codewood.wx.pay.response.cert;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EncryptCertificateItem implements Serializable {

    private String algorithm;

    @SerializedName("associated_data")
    private String associatedData;

    @SerializedName("ciphertext")
    private String cipherText;

    private String nonce;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAssociatedData() {
        return associatedData;
    }

    public void setAssociatedData(String associatedData) {
        this.associatedData = associatedData;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "EncryptCertificateItem{" +
                "algorithm='" + algorithm + '\'' +
                ", associatedData='" + associatedData + '\'' +
                ", cipherText='" + cipherText + '\'' +
                ", nonce='" + nonce + '\'' +
                '}';
    }
}
