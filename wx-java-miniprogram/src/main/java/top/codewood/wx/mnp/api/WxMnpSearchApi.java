package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.mnp.bean.search.WxMnpImgSearchResult;
import top.codewood.wx.mnp.bean.search.WxMnpSearchSubmitPage;
import top.codewood.wx.mnp.bean.search.WxMnpSiteSearchResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class WxMnpSearchApi extends WxBaseHttpApi {

    private static String UPLOAD_FILE_NAME = "img";

    private static class Holder {
        private static final WxMnpSearchApi INSTANCE = new WxMnpSearchApi();
    }

    public static WxMnpSearchApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * search.imageSearch
     * 本接口提供基于小程序的站内搜商品图片搜索能力
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/search/search.imageSearch.html">参考文档</a>
     *
     * @param accessToken
     * @param file
     * @return
     */
    public WxMnpImgSearchResult imgSearch(String accessToken, File file) {
        assert accessToken != null && file != null;
        String url = String.format("https://api.weixin.qq.com/wxa/imagesearch?access_token=%s", accessToken);
        String respStr = upload(url, file, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpImgSearchResult.class);
    }

    /**
     * search.imageSearch
     * 本接口提供基于小程序的站内搜商品图片搜索能力
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/search/search.imageSearch.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @return
     */
    public WxMnpImgSearchResult imgSearch(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        String url = String.format("https://api.weixin.qq.com/wxa/imagesearch?access_token=%s", accessToken);
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        String respStr = upload(url, tmpFile, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpImgSearchResult.class);
    }

    /**
     * search.siteSearch
     * 小程序内部搜索API提供针对页面的查询能力，小程序开发者输入搜索词后，将返回自身小程序和搜索词相关的页面。因此，利用该接口，开发者可以查看指定内容的页面被微信平台的收录情况；同时，该接口也可供开发者在小程序内应用，给小程序用户提供搜索能力。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/search/search.siteSearch.html">参考文档</a>
     *
     * @param accessToken
     * @param keyword 关键词
     * @param nextPageInfo 请求下一页的参数，开发者无需理解。为空时查询的是第一页内容，如需查询下一页，把返回参数的next_page_info填充到这里即可
     * @return
     */
    public WxMnpSiteSearchResult siteSearch(String accessToken, String keyword, String nextPageInfo) {
        assert accessToken != null && keyword != null;
        String url = String.format("https://api.weixin.qq.com/wxa/sitesearch?access_token=%s", accessToken);
        JsonObject paramJson = new JsonObject();
        paramJson.addProperty("keyword", keyword);
        paramJson.addProperty("next_page_info", nextPageInfo == null ? "" : nextPageInfo);

        String respStr = post(url, paramJson.toString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpSiteSearchResult.class);
    }

    /**
     * search.submitPages
     * 小程序开发者可以通过本接口提交小程序页面url及参数信息(不要推送webview页面)，让微信可以更及时的收录到小程序的页面信息，开发者提交的页面信息将可能被用于小程序搜索结果展示。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/search/search.submitPages.html">参考文档</a>
     *
     * @param accessToken
     * @param pages
     */
    public void submitPages(String accessToken, WxMnpSearchSubmitPage... pages) {
        assert accessToken != null && pages != null && pages.length > 0;
        String url = String.format("https://api.weixin.qq.com/wxa/search/wxaapi_submitpages?access_token=%s", accessToken);
        post(url, WxGsonBuilder.instance().toJson(pages));
    }

}
