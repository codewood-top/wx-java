package top.codewood.wx.mp.api;

import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.mp.bean.oauth2.WxOAuth2AccessToken;
import top.codewood.wx.mp.bean.oauth2.WxOAuth2UserInfo;
import top.codewood.wx.mp.util.json.WxGsonBuilder;

public class WxMpOAuth2Api extends WxMpApi {

    private static class Holder {
        private static final WxMpOAuth2Api INSTANCE = new WxMpOAuth2Api();
    }

    public static WxMpOAuth2Api getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 通过code换取网页授权access_token
     * 首先请注意，这里通过code换取的是一个特殊的网页授权access_token,与基础支持中的access_token（该access_token用于调用其他接口）不同。公众号可通过下述接口来获取网页授权access_token。如果网页授权的作用域为snsapi_base，则本步骤中获取到网页授权access_token的同时，也获取到了openid，snsapi_base式的网页授权流程即到此为止。
     * @param appid
     * @param secret
     * @param code
     * @return
     */
    public WxOAuth2AccessToken getOAuth2AccessToken(String appid, String secret, String code) {
        assert appid != null && secret != null && code != null;
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", appid, secret, code);
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxOAuth2AccessToken.class);
    }

    /**
     *  刷新access_token
     *  由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，refresh_token有效期为30天，当refresh_token失效之后，需要用户重新授权
     * @param appid 公众号的唯一标识
     * @param refreshToken 	填写通过access_token获取到的refresh_token参数
     * @return
     */
    public WxOAuth2AccessToken refreshOAuth2AccessToken(String appid, String refreshToken) {
        assert appid != null && refreshToken != null;
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s", appid, refreshToken);
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxOAuth2AccessToken.class);
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid 用户的唯一标识
     * @return
     */
    public WxOAuth2UserInfo getUserInfo(String accessToken, String openid) {
        assert accessToken != null && openid != null;
        String url = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", accessToken, openid);
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxOAuth2UserInfo.class);
    }

    /**
     * 附：检验授权凭证（access_token）是否有效
     * @param accessToken   网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid    用户的唯一标识
     * @return
     */
    public boolean checkAccessToken(String accessToken, String openid) {
        assert accessToken != null && openid != null;

        try {
            String url = String.format("https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s", accessToken, openid);
            String respStr = get(url);
            WxError wxError = WxGsonBuilder.create().fromJson(respStr, WxError.class);

            return wxError.getErrorCode() == 0;
        } catch (WxErrorException e) {
            return false;
        }
    }

}
