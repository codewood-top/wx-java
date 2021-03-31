package top.codewood.wx.mnp.api;

import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.util.bean.BeanUtils;
import top.codewood.wx.mnp.bean.operation.*;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.InputStream;

public class WxMnpOperationApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpOperationApi INSTANCE = new WxMnpOperationApi();
    }

    public static WxMnpOperationApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * operation.getFeedback
     * 获取用户反馈列表
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getFeedback.html">参考文档</a>
     *
     * @param accessToken
     * @param type @see WxMnpFeedbackType
     * @param page 分页的页数，从1开始
     * @param num 分页拉去的数据数量
     * @return
     */
    public WxMnpFeedbackResult getFeedback(String accessToken, Integer type, int page, int num) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/feedback/list?access_token=%s&page=%s&num=%s", accessToken, page, num);
        if (type != null) {
            url += "&type=" + type;
        }
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpFeedbackResult.class);
    }

    /**
     * operation.getFeedbackmedia
     * 获取 mediaId 图片
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getFeedbackmedia.html">参考文档</a>
     *
     * @param accessToken
     * @param recordId
     * @param mediaId
     * @return
     */
    public InputStream getFeedbackMedia(String accessToken, String recordId, String mediaId) {
        assert accessToken != null && recordId != null && mediaId != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/getfeedbackmedia?access_token=%s&record_id=%s&media_id=%s", accessToken, recordId, mediaId);
        return getInputStream(url);
    }

    /**
     * operation.getJsErrList
     * 错误查询列表
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getJsErrList.html">参考文档</a>
     *
     * @param accessToken
     * @param jsErrListRequest
     * @return
     */
    public WxMnpJsErrListResult getJsErrList(String accessToken, WxMnpJsErrListRequest jsErrListRequest) {
        assert accessToken != null && jsErrListRequest != null;
        BeanUtils.checkRequiredFields(jsErrListRequest);
        String url = String.format("https://api.weixin.qq.com/wxaapi/log/jserr_list?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(jsErrListRequest));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpJsErrListResult.class);
    }

    /**
     * operation.getJsErrDetail
     * 错误查询详情
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getJsErrDetail.html">参考文档</a>
     *
     * @param accessToken
     * @param jsErrDetailRequest
     * @return
     */
    public WxMnpJsErrDetailResult getJsErrDetail(String accessToken, WxMnpJsErrDetailRequest jsErrDetailRequest) {
        assert accessToken != null && jsErrDetailRequest != null;
        BeanUtils.checkRequiredFields(jsErrDetailRequest);
        String url = String.format("https://api.weixin.qq.com/wxaapi/log/jserr_detail?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(jsErrDetailRequest));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpJsErrDetailResult.class);
    }

    /**
     * operation.getJsErrSearch
     * 错误查询, 接口即将废弃，请采用新接口 getJsErrList
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getJsErrSearch.html">参考文档</a>
     *
     * @param accessToken
     * @param jsErrSearchRequest
     * @return
     */
    @Deprecated
    public WxMnpJsErrSearchResult getJsErrSearch(String accessToken, WxMnpJsErrSearchRequest jsErrSearchRequest) {
        assert accessToken != null && jsErrSearchRequest != null;
        BeanUtils.checkRequiredFields(jsErrSearchRequest);

        String url = String.format("https://api.weixin.qq.com/wxaapi/log/jserr_search?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(jsErrSearchRequest));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpJsErrSearchResult.class);
    }

    /**
     * operation.getPerformance
     * 性能监控
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getPerformance.html">参考文档</a>
     *
     * @param accessToken
     * @param getPerformanceRequest
     * @return
     */
    public WxMnpGetPerformanceResult getPerformance(String accessToken, WxMnpGetPerformanceRequest getPerformanceRequest) {
        assert accessToken != null && getPerformanceRequest != null;
        BeanUtils.checkRequiredFields(getPerformanceRequest);
        String url = String.format("https://api.weixin.qq.com/wxaapi/log/get_performance?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(getPerformanceRequest));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpGetPerformanceResult.class);
    }

    /**
     * operation.getSceneList
     * 获取访问来源
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getSceneList.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public WxMnpSceneList getSceneList(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/log/get_scene?access_token=%s", accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpSceneList.class);
    }

    /**
     * operation.getVersionList
     * 获取客户端版本
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.getVersionList.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public WxMnpVersionList getVersionList(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/log/get_client_version?access_token=%s", accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpVersionList.class);
    }

    /**
     * operation.realtimelogSearch
     * 实时日志查询
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/operation/operation.realtimelogSearch.html">参考文档</a>
     *
     * @param acccessToken
     * @param realtimeLogSearchRequest
     * @return
     */
    public WxMnpRealtimeLogSearchResult realtimeLogSearchResult(String acccessToken, WxMnpRealtimeLogSearchRequest realtimeLogSearchRequest) {
        assert acccessToken != null && realtimeLogSearchRequest != null;
        BeanUtils.checkRequiredFields(realtimeLogSearchRequest);
        String url = String.format("https://api.weixin.qq.com/wxaapi/userlog/userlog_search?access_token=%s", acccessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(realtimeLogSearchRequest));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpRealtimeLogSearchResult.class);
    }

}
