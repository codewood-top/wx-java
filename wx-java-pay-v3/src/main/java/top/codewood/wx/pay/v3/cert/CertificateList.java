package top.codewood.wx.pay.v3.cert;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CertificateList implements Serializable {

    @SerializedName("data")
    private List<CertificateItem> certs = new ArrayList<>();

    public List<CertificateItem> getCerts() {
        return certs;
    }

    public void setCerts(List<CertificateItem> certs) {
        this.certs = certs;
    }

    @Override
    public String toString() {
        return "CertificateList{" +
                "certs=" + certs +
                '}';
    }
}
