package top.codewood.wx.pay.v3.api;

import top.codewood.wx.pay.v3.common.WxPayConfig;

public interface WxPayStorageService {

    void setPrivateKey(String mchid, String privateKeyStr);

    /**
     *
     * @param mchid 微信支付商户号
     * @return PrivateKey.str
     */
    String getPrivateKey(String mchid);


    void setCertificateSerialPublicKey(String serialNo, String publicKey);

    /**
     *
     * @param serialNo 证书系列号
     * @return Certificate.publicKey
     */
     String getCertificatePublicKey(String serialNo);

     void setWxPayConfig(WxPayConfig wxPayConfig);

     WxPayConfig getWxPayConfig(String mchid);

}
