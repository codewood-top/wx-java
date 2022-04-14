package top.codewood.wx.mnp.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.internet.WxMnpUserEncryptKey;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.util.List;

public class WxMnpInternetApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpInternetApi INSTANCE = new WxMnpInternetApi();
    }

    public static WxMnpInternetApi getInstance() { return Holder.INSTANCE; }

    /**
     * internet.getUserEncryptKey
     * 获取用户encryptKey。 会获取用户最近3次的key，每个key的存活时间为3600s。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/internet/internet.getUserEncryptKey.html">参考文档</a>
     *
     * @param accessToken
     * @param openid    用户的openid
     * @param signature 用 <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html">sessionkey</a> 对空字符串签名得到的结果
     * @param sigMethod 签名方法，只支持 hmac_sha256
     * @return 用户最近3次的key
     */
    public List<WxMnpUserEncryptKey> getUserEncryptKey(String accessToken, String openid, String signature, String sigMethod) {
        assert accessToken != null && openid != null && signature != null && sigMethod != null;

        String url = String.format("https://api.weixin.qq.com/wxa/business/getuserencryptkey?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("openid", openid);
        json.addProperty("signature", signature);
        json.addProperty("sig_method", sigMethod);

        String respStr = post(url, json.getAsString());

        Gson gson = WxGsonBuilder.instance();
        JsonObject respJson = gson.fromJson(respStr, JsonObject.class);
        return gson.fromJson(respJson.get("key_info_list"), List.class);
    }

}
