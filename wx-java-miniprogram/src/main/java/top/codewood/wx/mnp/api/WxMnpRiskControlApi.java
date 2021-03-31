package top.codewood.wx.mnp.api;

import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.util.bean.BeanUtils;
import top.codewood.wx.mnp.bean.riskcontrol.WxMnpUserRiskRankRequest;
import top.codewood.wx.mnp.bean.riskcontrol.WxMnpUserRiskRankResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpRiskControlApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpRiskControlApi INSTANCE = new WxMnpRiskControlApi();
    }

    public static WxMnpRiskControlApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * riskControl.getUserRiskRank
     * 根据提交的用户信息数据获取用户的安全等级 risk_rank，无需用户授权。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/safety-control-capability/riskControl.getUserRiskRank.html">参考文档</a>
     *
     */
    public WxMnpUserRiskRankResult getUserRishRank(String accessToken, WxMnpUserRiskRankRequest userRiskRankRequest) {
        assert accessToken != null && userRiskRankRequest != null;
        BeanUtils.checkRequiredFields(userRiskRankRequest);
        String url = String.format("https://api.weixin.qq.com/wxa/getuserriskrank?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(userRiskRankRequest));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpUserRiskRankResult.class);
    }

}
