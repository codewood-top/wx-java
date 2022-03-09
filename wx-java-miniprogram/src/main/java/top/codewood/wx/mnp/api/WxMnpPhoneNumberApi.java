package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.user.WxMnpPhoneInfo;
import top.codewood.wx.mnp.util.crypt.WxMnpCryptUtils;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpPhoneNumberApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpPhoneNumberApi INSTANCE = new WxMnpPhoneNumberApi();
    }

    public static WxMnpPhoneNumberApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * phonenumber.getPhoneNumber
     * code换取用户手机号。 每个code只能使用一次，code的有效期为5min
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/getPhoneNumber.html">参考文档</a>
     *
     * @param accessToken
     * @param code        手机号获取凭证
     * @return
     */
    public WxMnpPhoneInfo getPhoneInfo(String accessToken, String code) {
        assert accessToken != null && code != null;
        String url = String.format("https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=%s", accessToken);
        String postStr = String.format("{\"code\": \"%s\"}", code);
        String respStr = post(url, postStr);
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return WxGsonBuilder.instance().fromJson(respJson.get("phone_info"), WxMnpPhoneInfo.class);
    }

    /**
     * 解密小程序侧 wx.getPhoneNumber.encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * 从基础库2.21.2版本起，回调参数中增加code参数，开发者获取code参数后，通过服务端auth.getPhoneNumber接口，使用code换取encryptedData，用于解密手机号。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/getPhoneNumber.html">参考文档</a>
     *
     * @param sessionKey
     * @param encryptedData
     * @param iv
     * @return
     */
    public WxMnpPhoneInfo getPhoneInfo(String sessionKey, String encryptedData, String iv) {
        String decryptedData = WxMnpCryptUtils.decrypt(sessionKey, encryptedData, iv);
        return WxGsonBuilder.instance().fromJson(decryptedData, WxMnpPhoneInfo.class);
    }

}
