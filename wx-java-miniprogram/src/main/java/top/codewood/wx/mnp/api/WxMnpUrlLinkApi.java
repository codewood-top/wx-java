package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.link.WxMnpUrlLinkQueryResult;
import top.codewood.wx.mnp.bean.link.WxMnpUrlLinkRequest;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpUrlLinkApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpUrlLinkApi INSTANCE = new WxMnpUrlLinkApi();
    }

    public static WxMnpUrlLinkApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * urllink.generate
     *
     * 获取小程序 URL Link，适用于短信、邮件、网页、微信内等拉起小程序的业务场景。
     * 通过该接口，可以选择生成到期失效和永久有效的小程序链接，有数量限制，
     * 目前仅针对国内非个人主体的小程序开放，详见获取 URL Link
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/url-link/urllink.generate.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public String generate(String accessToken, WxMnpUrlLinkRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/wxa/query_urllink?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return respJson.get("url_link").getAsString();

    }

    /**
     * urllink.query
     *
     * 查询小程序 url_link 配置，及长期有效 quota
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/url-link/urllink.query.html">参考文档</a>
     *
     * @param accessToken
     * @param urlLink
     * @return
     */
    public WxMnpUrlLinkQueryResult query(String accessToken, String urlLink) {
        assert accessToken != null && urlLink != null;
        String url = String.format("https://api.weixin.qq.com/wxa/query_urllink?access_token=%s", accessToken);
        String postStr = String.format("{\"url_link\":\"%s\"}", urlLink);
        String respStr = post(url, postStr);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpUrlLinkQueryResult.class);
    }

}
