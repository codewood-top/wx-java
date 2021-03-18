package top.codewood.wx.mnp.api;

import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.result.WxMnpCode2SessionResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpApi INSTANCE = new WxMnpApi();
    }

    public static WxMnpApi getInstance() {
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
        return WxGsonBuilder.create().fromJson(respStr, WxMnpCode2SessionResult.class);
    }

}
