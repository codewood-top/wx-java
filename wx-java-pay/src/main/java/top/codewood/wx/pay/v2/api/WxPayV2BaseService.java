package top.codewood.wx.pay.v2.api;

import org.apache.commons.codec.digest.DigestUtils;
import top.codewood.wx.pay.common.WxPayConfig;
import top.codewood.wx.pay.common.WxPayHttpClient;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.common.util.SignUtils;
import top.codewood.wx.common.util.bean.BeanUtils;
import top.codewood.wx.common.util.xml.XStreamConverter;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class WxPayV2BaseService {

    abstract WxPayConfig getWxPayConfig();

    /**
     * 对微信支付相关的bean进行签名
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3">签名算法</a>
     * @param map
     * @param signKey 微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     * @return
     */
    protected String sign(Map map, String signKey) {
        assert map != null && signKey != null;
        String signType = (String) map.getOrDefault("sign_type", WxPayConstants.SignType.MD5);
        SortedMap<String, Object> sortedMap = new TreeMap<>(map);
        StringBuilder signBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            signBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        signBuilder.append("key=").append(signKey);

        if (WxPayConstants.SignType.HMAC_SHA256.equals(signType)) {
            return SignUtils.createHmacSha256Sign(signBuilder.toString(), signKey).toUpperCase();
        } else {
            return DigestUtils.md5Hex(signBuilder.toString()).toUpperCase();
        }
    }

    /**
     * 对微信支付相关的bean进行签名
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3">签名算法</a>
     * @param object
     * @param signKey 微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     * @return
     */
    protected String sign(Object object, String signKey) {
        assert object != null;
        Map map = BeanUtils.xmlBean2Map(object);
        return sign(map, signKey);
    }

    public String sign(Object object) {
        return sign(object, getWxPayConfig().getKey());
    }

    public String sign(Map map) {
        return sign(map, getWxPayConfig().getKey());
    }

    /**
     * 对微信支付相关的bean进行签名
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3">签名算法</a>
     * @param t extends WxPayBaseRequest
     * @param signKey 微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     * @return
     */
    public <T extends WxPayBaseRequest> void checkAndSign(T t, String signKey) {
        if (t.getSign() != null) return;
        t.checkRequiredFields();
        String sign = sign(t, signKey);
        t.setSign(sign);
    }

    protected <T extends WxPayBaseResult> T requestWithCert(WxPayConfig wxPayConfig, String url, String data, Class<T> clz) {
        try {
            String respStr = new WxPayHttpClient(wxPayConfig).requestWithCert(url, data);
            T t = XStreamConverter.fromXml(clz, respStr);
            t.checkResult();
            return t;
        } catch (WxErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    protected <T extends WxPayBaseResult> T request(WxPayConfig wxPayConfig, String url, String data, Class<T> clz) {
        try {
            String respStr = new WxPayHttpClient(wxPayConfig).requestWithoutCert(url, data);
            T t = XStreamConverter.fromXml(clz, respStr);
            t.checkResult();
            return t;
        } catch (WxErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
