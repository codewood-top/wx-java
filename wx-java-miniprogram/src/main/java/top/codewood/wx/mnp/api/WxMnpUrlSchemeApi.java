package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.scheme.WxMnpUrlSchemeQueryResult;
import top.codewood.wx.mnp.bean.scheme.WxMnpUrlSchemeRequest;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpUrlSchemeApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpUrlSchemeApi INSTANCE = new WxMnpUrlSchemeApi();
    }

    public static WxMnpUrlSchemeApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * urlscheme.generate
     * 获取小程序scheme码，适用于短信、邮件、外部网页等拉起小程序的业务场景。
     * 通过该接口，可以选择生成到期失效和永久有效的小程序码，目前仅针对国内非个人主体的小程序开放，详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/url-scheme.html">获取URL scheme码</a>。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/url-scheme/urlscheme.generate.html">参考文档</a>
     *
     * @param accessToken
     * @param schemeRequest
     * @return
     */
    public String generate(String accessToken, WxMnpUrlSchemeRequest schemeRequest) {
        assert accessToken != null && schemeRequest != null;
        String url = String.format("https://api.weixin.qq.com/wxa/generatescheme?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(schemeRequest));
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return respJson.get("openlink").getAsString();
    }

    /**
     * urlscheme.query
     * 查询小程序 scheme 码，及长期有效 quota。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/url-scheme/urlscheme.query.html">参考文档</a>
     *
     * @param accessToken
     * @param scheme 小程序 scheme 码
     * @return
     */
    public WxMnpUrlSchemeQueryResult query(String accessToken, String scheme) {
        assert accessToken != null && scheme != null;
        String url = String.format("https://api.weixin.qq.com/wxa/queryscheme?access_token=%s", accessToken);
        String postStr = String.format("{\"scheme\":\"%s\"}", scheme);
        String respStr = post(url, postStr);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpUrlSchemeQueryResult.class);
    }

}
