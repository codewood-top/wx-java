package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import org.apache.commons.codec.digest.DigestUtils;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.bean.WxAccessToken;
import top.codewood.wx.mnp.bean.auth.WxMnpCheckEncryptedDataResult;
import top.codewood.wx.mnp.bean.auth.WxMnpCode2SessionResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;


public class WxMnpAuthApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpAuthApi INSTANCE = new WxMnpAuthApi();
    }

    public static WxMnpAuthApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * auth.code2Session
     * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html">参考文档</a>
     *
     * @param appid
     * @param secret
     * @param jscode
     * @return WxMnpCode2SessionResult
     */
    public WxMnpCode2SessionResult code2Session(String appid, String secret, String jscode) {
        assert appid != null && secret != null && jscode != null;
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code", appid, secret, jscode);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpCode2SessionResult.class);
    }

    /**
     * auth.checkEncryptedData
     * 检查加密信息是否由微信生成（当前只支持手机号加密数据），只能检测最近3天生成的加密数据
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/user-info/auth.checkEncryptedData.html">参考文档</a>
     *
     * @param accessToken
     * @param encryptedData
     * @return
     */
    public WxMnpCheckEncryptedDataResult checkEncryptedData(String accessToken, String encryptedData) {
        assert accessToken != null && encryptedData != null;
        String url = String.format("https://api.weixin.qq.com/wxa/business/checkencryptedmsg?access_token=%s", accessToken);
        String encryptedMsgHash = DigestUtils.sha256Hex(encryptedData);
        JsonObject json = new JsonObject();
        json.addProperty("encrypted_msg_hash", encryptedMsgHash);
        String respStr = post(url, json.toString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpCheckEncryptedDataResult.class);
    }


    /**
     * auth.getPaidUnionId
     * 用户支付完成后，获取该用户的 UnionId，无需用户授权。本接口支持第三方平台代理查询。
     * 注意：调用前需要用户完成支付，且在支付后的五分钟内有效。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/user-info/auth.getPaidUnionId.html">参考文档</a>
     *
     * @param accessToken
     * @param openid
     * @param transactionId 微信支付订单号
     * @return unionId
     *
     */
    public String getPaidUnionId(String accessToken, String openid, String transactionId) {
        assert accessToken != null && openid != null && transactionId != null;
        String url = String.format("https://api.weixin.qq.com/wxa/getpaidunionid?access_token=%s&openid=%s&transaction_id=%s", accessToken, openid, transactionId);
        String respStr = get(url);
        JsonObject json = WxGsonBuilder.instance().toJsonTree(respStr).getAsJsonObject();
        return json.get("unionid").getAsString();
    }

    /**
     * auth.getPaidUnionId
     * 用户支付完成后，获取该用户的 UnionId，无需用户授权。本接口支持第三方平台代理查询。
     * 注意：调用前需要用户完成支付，且在支付后的五分钟内有效。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/user-info/auth.getPaidUnionId.html">参考文档</a>
     *
     * @param accessToken
     * @param openid
     * @param mchid 微信支付分配的商户号，和商户订单号配合使用
     * @param outTradeNo 微信支付商户订单号，和商户号配合使用
     * @return unionId
     *
     */
    public String getPaidUnionId(String accessToken, String openid, String mchid, String outTradeNo) {
        assert accessToken != null && openid != null && mchid != null && outTradeNo != null;
        String url = String.format("https://api.weixin.qq.com/wxa/getpaidunionid?access_token=%s&openid=%s&mch_id=%s&out_trade_no=%s", accessToken, openid, mchid, outTradeNo);
        String respStr = get(url);
        JsonObject json = WxGsonBuilder.instance().toJsonTree(respStr).getAsJsonObject();
        return json.get("unionid").getAsString();
    }


    /**
     * auth.getPluginOpenPId
     * 通过 wx.pluginLogin 接口获得插件用户标志凭证 code 后传到开发者服务器，开发者服务器调用此接口换取插件用户的唯一标识 openpid。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/user-info/auth.getPluginOpenPId.html">参考文档</a>
     *
     * @param accessToken
     * @param code 通过 wx.pluginLogin 获得的插件用户标志凭证 code，有效时间为5分钟，一个 code 只能获取一次 openpid。
     * @return
     */
    public String getPluginOpenPId(String accessToken, String code) {
        assert accessToken != null && code != null;
        String url = String.format("https://api.weixin.qq.com/wxa/getpluginopenpid?access_token=%s", accessToken);
        String postStr = String.format("{\"code\": \"%s\"}", code);
        String respStr = post(url, postStr);
        return WxGsonBuilder.instance().toJsonTree(respStr).getAsJsonObject().get("openpid").getAsString();
    }

    /**
     * auth.getAccessToken
     * 获取小程序全局唯一后台接口调用凭据（access_token）。调用绝大多数后台接口时都需使用 access_token，开发者需要进行妥善保存。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/access-token/auth.getAccessToken.html">参考文档</a>
     *
     * @param appid
     * @param secret
     * @return
     */
    public WxAccessToken getAccessToken(String appid, String secret) {
        assert appid != null && secret != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appid, secret);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxAccessToken.class);
    }

}
