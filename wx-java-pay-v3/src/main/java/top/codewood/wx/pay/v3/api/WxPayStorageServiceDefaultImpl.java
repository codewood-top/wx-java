package top.codewood.wx.pay.v3.api;

import top.codewood.wx.pay.v3.common.WxPayConfig;

import java.util.HashMap;
import java.util.Map;

public class WxPayStorageServiceDefaultImpl implements WxPayStorageService {

    private static final Map<String, String> PRIVATE_KEY_MAP = new HashMap<>();
    private static final Map<String, String> CERTIFICATE_MAP = new HashMap<>();

    private static final Map<String, WxPayConfig> WX_PAY_CONFIG_MAP = new HashMap<>();


    @Override
    public void setPrivateKey(String mchid, String privateKeyStr) {
        PRIVATE_KEY_MAP.put(mchid, privateKeyStr);
    }

    @Override
    public String getPrivateKey(String mchid) {

        String privateKey = PRIVATE_KEY_MAP.get(mchid);
        if (privateKey == null) {
            throw new RuntimeException(String.format("商户 %s 私钥未初始化", mchid));
        }
        return privateKey;
    }

    @Override
    public void setCertificateSerialPublicKey(String serialNo, String publicKey) {
        CERTIFICATE_MAP.put(serialNo, publicKey);
    }

    @Override
    public String getCertificatePublicKey(String serialNo) {
        String publicKey = CERTIFICATE_MAP.get(serialNo);
        if (publicKey == null) {
            throw new RuntimeException(String.format("serialNo: %s 证书未配置!", serialNo));
        }
        return publicKey;
    }

    @Override
    public void setWxPayConfig(WxPayConfig wxPayConfig) {
        WX_PAY_CONFIG_MAP.put(wxPayConfig.getMchid(), wxPayConfig);
    }

    @Override
    public WxPayConfig getWxPayConfig(String mchid) {
        WxPayConfig wxPayConfig = WX_PAY_CONFIG_MAP.get(mchid);
        if (wxPayConfig == null) {
            throw new IllegalStateException(String.format("商户号 %s 支付未配置", mchid));
        }
        return wxPayConfig;
    }
}
