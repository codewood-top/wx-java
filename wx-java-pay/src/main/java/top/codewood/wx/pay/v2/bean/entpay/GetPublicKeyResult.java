package top.codewood.wx.pay.v2.bean.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

@XStreamAlias("xml")
public class GetPublicKeyResult extends WxPayBaseResult {

    /**
     * 商户号
     */
    @XStreamAlias("mch_id")
    private String mchid;

    /**
     * 密钥
     */
    @XStreamAlias("pub_key")
    private String pubKey;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    @Override
    public String toString() {
        return "GetPublicKeyResult{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", mchid='" + mchid + '\'' +
                ", pubKey='" + pubKey + '\'' +
                '}';
    }
}
