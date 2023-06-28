package top.codewood.wx.mnp.api;

import org.apache.commons.codec.digest.DigestUtils;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.user.WxMnpUserInfo;
import top.codewood.wx.mnp.util.crypt.WxMnpCryptUtils;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpUserApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpUserApi INSTANCE = new WxMnpUserApi();
    }

    public static WxMnpUserApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息
     *
     * @param sessionKey
     * @param rawData
     * @param signature
     * @return
     */
    public boolean checkUserInfo(String sessionKey, String rawData, String signature) {
        String generatedSignature = DigestUtils.sha1Hex(rawData + sessionKey);
        return generatedSignature.equals(signature);
    }

    /**
     * 解密小程序侧 wx.login.encryptedData 包括敏感数据在内的完整用户信息的加密数据
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api/open-api/user-info/wx.getUserInfo.html">参考文档</a>
     *
     * @param sessionKey
     * @param encryptedData
     * @param iv
     * @return
     */
    public WxMnpUserInfo getUserInfo(String sessionKey, String encryptedData, String iv) {
        String decryptedData = WxMnpCryptUtils.decrypt(sessionKey, encryptedData, iv);
        return WxGsonBuilder.instance().fromJson(decryptedData, WxMnpUserInfo.class);
    }


}