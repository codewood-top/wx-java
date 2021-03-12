package top.codewood.wx.pay.v2.api;

import org.apache.commons.codec.digest.DigestUtils;
import top.codewood.util.http.AppHttpClient;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.common.util.SignUtils;
import top.codewood.wx.common.util.bean.BeanUtils;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class WxPayV2Api {

    public static String get(String url) {
        try {
            return AppHttpClient.getInstance().get(url);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String post(String url, String postData) {
        try {
            return AppHttpClient.getInstance().post(url, postData);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String sslPost(String url, String postData, String certPassword, InputStream certFileInputStream) {
        try {
            return AppHttpClient.getInstance().sslPost(url, postData, certPassword, certFileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 对微信支付相关的bean进行签名
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3">签名算法</a>
     * @param bean
     * @param signKey   微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     * @param signType MD5 | sha256
     * @return
     */
    public static String sign(Object bean, String signKey, String signType) {
        assert bean != null && signKey != null && signType != null;
        SortedMap<String, Object> sortedMap = new TreeMap<>(BeanUtils.xmlBean2Map(bean));

        StringBuilder signBuilder = new StringBuilder();

        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            signBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        signBuilder.append("key=").append(signKey);
        if (WxPayConstants.SignType.HMAC_SHA256.equals(signType)) {
            return SignUtils.createHmacSha256Sign(signBuilder.toString(), signKey);
        } else  {
            return DigestUtils.md5Hex(signBuilder.toString());
        }
    }

    /**
     * 对微信支付相关的bean进行MD5签名
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3">签名算法</a>
     * @param bean
     * @param signKey   微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     * @return
     */
    public static String sign(Object bean, String signKey) {
        return sign(bean, signKey, "MD5");
    }


    public static  <T extends WxPayBaseResult> void  checkResult(T t) {
        if (!WxConstants.SUCCESS.equals(t.getReturnCode())) {
            throw new WxErrorException(t.getReturnMsg());
        }
        if (!WxConstants.SUCCESS.equals(t.getResultCode())) {
            throw new WxErrorException(t.getErrCodeDes());
        }
    }

}
