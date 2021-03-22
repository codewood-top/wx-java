package top.codewood.wx.mnp.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.analysis.*;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WxMnpAnalysisApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpAnalysisApi INSTANCE = new WxMnpAnalysisApi();
    }

    public static WxMnpAnalysisApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * analysis.getDailyRetain
     * 获取用户访问小程序日留存
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/visit-retain/analysis.getDailyRetain.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken 接口调用凭证
     * @param date 开始日期 = 结束日期，限定查询1天数据，允许设置的最大值为昨日。
     * @return
     */
    public WxMnpRetainInfo getDailyRetainInfo(String accessToken, LocalDate date) {
        assert accessToken != null && date != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappiddailyretaininfo?access_token=%s", accessToken);
        return getRetainInfo(url, date, date);
    }

    /**
     * analysis.getMonthlyRetain
     * 获取用户访问小程序月留存
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/visit-retain/analysis.getMonthlyRetain.html">参考文档</a>
     *
     * @param accessToken
     * @param beginDate 开始日期，为自然月第一天。
     * @param endDate 结束日期，为自然月最后一天，限定查询一个月数据。
     * @return
     */
    public WxMnpRetainInfo getMonthlyRetainInfo(String accessToken, LocalDate beginDate, LocalDate endDate) {
        assert accessToken != null && beginDate != null && endDate != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappidmonthlyretaininfo?access_token=%s", accessToken);
        return getRetainInfo(url, beginDate, endDate);
    }

    /**
     * analysis.getWeeklylyRetain
     * 获取用户访问小程序周留存
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/visit-retain/analysis.getWeeklylyRetain.html">参考文档</a>
     *
     * @param accessToken
     * @param beginDate 开始日期，为周一日期。
     * @param endDate 结束日期，为周日日期，限定查询一周数据。
     * @return
     */
    public WxMnpRetainInfo getWeeklyRetainInfo(String accessToken, LocalDate beginDate, LocalDate endDate) {
        assert accessToken != null && beginDate != null && endDate != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappidweeklyretaininfo?access_token=%s", accessToken);
        return getRetainInfo(url, beginDate, endDate);
    }

    /**
     * analysis.getDailySummary
     * 获取用户访问小程序数据概况
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getDailySummary.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param beginDate 开始日期。
     * @param endDate 结束日期，限定查询1天数据，允许设置的最大值为昨日。
     * @return
     */
    public List<WxMnpSummaryTrend> getSummaryThrend(String accessToken, LocalDate beginDate, LocalDate endDate) {
        assert accessToken != null && beginDate != null && endDate != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappiddailysummarytrend?access_token=%s", accessToken);
        return getAnalysisResultAsList(url, beginDate, endDate);
    }

    /**
     * analysis.getDailyVisitTrend
     * 获取用户访问小程序数据日趋势
     *
     * @param accessToken
     * @param date 开始日期 = 结束日期，限定查询1天数据，允许设置的最大值为昨日。
     * @return
     */
    public List<WxMnpVisitTrend> getDailyVisitTrend(String accessToken, LocalDate date) {
        assert accessToken != null && date != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappiddailyvisittrend?access_token=%s", accessToken);
        return getAnalysisResultAsList(url, date, date);
    }

    /**
     * analysis.getMonthlyVisitTrend
     * 获取用户访问小程序数据月趋势(能查询到的最新数据为上一个自然月的数据)
     *
     * @param accessToken
     * @param beginDate 开始日期，为自然月第一天。
     * @param endDate 结束日期，为自然月最后一天，限定查询一个月的数据
     * @return
     */
    public List<WxMnpVisitTrend> getMonthlyVisitTrend(String accessToken, LocalDate beginDate, LocalDate endDate) {
        assert accessToken != null && beginDate != null && endDate != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappidmonthlyvisittrend?access_token=%s", accessToken);
        return getAnalysisResultAsList(url, beginDate, endDate);
    }

    /**
     * analysis.getWeeklyVisitTrend
     * 获取用户访问小程序数据周趋势
     *
     * @param accessToken
     * @param beginDate 开始日期，为周一日期。
     * @param endDate 结束日期，为周日日期，限定查询一周数据。
     * @return
     */
    public List<WxMnpVisitTrend> getWeeklyVisitTrend(String accessToken, LocalDate beginDate, LocalDate endDate) {
        assert accessToken != null && beginDate != null && endDate != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappidweeklyvisittrend?access_token=%s", accessToken);
        return getAnalysisResultAsList(url, beginDate, endDate);
    }

    /**
     * analysis.getPerformanceData
     * 获取小程序启动性能，运行性能等数据。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getPerformanceData.html">参考文档</a>
     *
     * @param accessToken
     * @param performanceRequest
     * @return
     */
    public WxMnpPerformanceResult getPerformanceData(String accessToken, WxMnpPerformanceRequest performanceRequest) {
        assert accessToken != null && performanceRequest != null;
        String url = String.format("https://api.weixin.qq.com/wxa/business/performance/boot?access_token=%s", accessToken);
        Gson gson = WxGsonBuilder.create();
        String postData = gson.toJson(performanceRequest);
        String respStr = post(url, postData);
        return gson.fromJson(respStr, WxMnpPerformanceResult.class);
    }

    /**
     * analysis.getUserPortrait
     * 获取小程序新增或活跃用户的画像分布数据。时间范围支持昨天、最近7天、最近30天。其中，新增用户数为时间范围内首次访问小程序的去重用户数，活跃用户数为时间范围内访问过小程序的去重用户数。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getUserPortrait.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate 结束日期，开始日期与结束日期相差的天数限定为0/6/29，分别表示查询最近1/7/30天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return
     */
    public WxMnpUserPortrait getUserPortrait(String accessToken, LocalDate beginDate, LocalDate endDate) {
        assert accessToken != null && beginDate != null && endDate != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappiduserportrait?access_token=%s", accessToken);
        return getAnalysisData(url, beginDate, endDate, WxMnpUserPortrait.class);
    }

    /**
     * analysis.getVisitDistribution
     * 获取用户小程序访问分布数据
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getVisitDistribution.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param date 开始日期 = 结束日期，限定查询 1 天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return
     */
    public WxMnpVisitDistribution getVisitDistribution(String accessToken, LocalDate date) {
        assert accessToken != null && date != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappidvisitdistribution?access_token=%s", accessToken);
        return getAnalysisData(url, date, date, WxMnpVisitDistribution.class);
    }

    /**
     * analysis.getVisitPage
     * 访问页面。目前只提供按 page_visit_pv 排序的 top200。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getVisitPage.html">参考文档</a>
     *
     * @param accessToken
     * @param beginDate
     * @param endDate
     * @return
     */
    public WxMnpVisitPage getVisitPage(String accessToken, LocalDate beginDate, LocalDate endDate) {
        assert accessToken != null && beginDate != null && endDate != null;
        String url = String.format("https://api.weixin.qq.com/datacube/getweanalysisappidvisitpage?access_token=%s", accessToken);
        return getAnalysisData(url, beginDate, endDate, WxMnpVisitPage.class);
    }


    private WxMnpRetainInfo getRetainInfo(String url, LocalDate beginDate, LocalDate endDate) {
        return getAnalysisData(url, beginDate, endDate, WxMnpRetainInfo.class);
    }

    private <T> T getAnalysisData(String url, LocalDate beginDate, LocalDate endDate,Class<T> clz) {
        String respStr = post(url, dateToJson(beginDate, endDate).toString());
        return WxGsonBuilder.create().fromJson(respStr, clz);
    }

    private <T> List<T> getAnalysisResultAsList(String url, LocalDate beginDate, LocalDate endDate) {
        String respStr = post(url, dateToJson(beginDate, endDate).toString());
        JsonObject jsonObject = WxGsonBuilder.create().fromJson(respStr, JsonObject.class);
        if (jsonObject.has("list")) {
            return WxGsonBuilder.create().fromJson(jsonObject.get("list").getAsJsonArray(), new TypeToken<List<T>>(){}.getType());
        }
        return null;
    }

    private JsonObject dateToJson(LocalDate beginDate, LocalDate endDate) {
        JsonObject json = new JsonObject();
        json.addProperty("begin_date", DateTimeFormatter.ofPattern("yyyyMMdd").format(beginDate));
        json.addProperty("end_date", DateTimeFormatter.ofPattern("yyyyMMdd").format(endDate));
        return json;
    }

}
