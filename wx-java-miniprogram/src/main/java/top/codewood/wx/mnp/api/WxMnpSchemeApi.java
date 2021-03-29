package top.codewood.wx.mnp.api;

import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.scheme.WxMnpSchemeRequest;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpSchemeApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpSchemeApi INSTANCE = new WxMnpSchemeApi();
    }

    public static WxMnpSchemeApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * urlscheme.generate
     * 获取小程序scheme码，适用于短信、邮件、外部网页等拉起小程序的业务场景。通过该接口，可以选择生成到期失效和永久有效的小程序码，目前仅针对国内非个人主体的小程序开放，详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/url-scheme.html">获取URL scheme码</a>。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/url-scheme/urlscheme.generate.html">参考文档</a>
     *
     * @param accessToken
     * @param schemeRequest
     * @return
     */
    public String generate(String accessToken, WxMnpSchemeRequest schemeRequest) {
        assert accessToken != null && schemeRequest != null;
        String url = String.format("https://api.weixin.qq.com/wxa/generatescheme?access_token=%s", accessToken);
        return post(url, WxGsonBuilder.instance().toJson(schemeRequest));
    }


}
