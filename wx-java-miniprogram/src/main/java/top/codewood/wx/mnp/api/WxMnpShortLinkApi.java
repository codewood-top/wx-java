package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpShortLinkApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpShortLinkApi INSTANCE = new WxMnpShortLinkApi();
    }

    public static WxMnpShortLinkApi getInstance() { return Holder.INSTANCE; }

    /**
     * shortlink.generate
     * 获取小程序 Short Link，适用于微信内拉起小程序的业务场景。目前只开放给电商类目(具体包含以下一级类目：电商平台、商家自营、跨境电商)。通过该接口，可以选择生成到期失效和永久有效的小程序短链，详见
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/shortlink.html">获取 Short Link</a>。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/short-link/shortlink.generate.html">参考文档</a>
     *
     * @param accessToken
     * @param pageTitle 必填 通过 Short Link 进入的小程序页面路径，必须是已经发布的小程序存在的页面，可携带 query，最大1024个字符
     * @param pageUrl   必填 页面标题，不能包含违法信息，超过20字符会用... 截断代替
     * @param isPermanent 生成的 Short Link 类型，短期有效：false，永久有效：true
     * @return link
     */
    public String generate(String accessToken, String pageTitle, String pageUrl, boolean isPermanent) {
        assert accessToken != null && pageTitle != null && pageUrl != null;
        String url = String.format("https://api.weixin.qq.com/wxa/genwxashortlink?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("page_url", pageUrl);
        json.addProperty("page_title", pageTitle);
        json.addProperty("is_permanent", isPermanent);

        String respStr = post(url, json.getAsString());
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);

        return respJson.get("link").getAsString();
    }



}
