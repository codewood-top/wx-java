package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.express.delivery.WxMnpExpressGetContactResult;
import top.codewood.wx.mnp.bean.express.delivery.WxMnpExpressPreviewTemplateRequest;
import top.codewood.wx.mnp.bean.express.delivery.WxMnpExpressPreviewTemplateResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpExpressDeliveryApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpExpressDeliveryApi INSTANCE = new WxMnpExpressDeliveryApi();
    }

    public static WxMnpExpressDeliveryApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * logistics.getContact
     * 获取面单联系人信息
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.getContact.html">参考文档</a>
     *
     * @param accessToken
     * @param token    必填，商户侧下单事件中推送的 Token 字段
     * @param waybillId 必填，运单 ID
     */
    public WxMnpExpressGetContactResult getContact(String accessToken, String token, String waybillId) {
        assert accessToken != null && token != null && waybillId != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/delivery/contact/get?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("token", token);
        json.addProperty("waybill_id", waybillId);

        String respStr = post(url, json.getAsString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressGetContactResult.class);
    }

    /**
     * logistics.previewTemplate
     * 预览面单模板。用于调试面单模板使用。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.previewTemplate.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public WxMnpExpressPreviewTemplateResult previewTemplate(String accessToken, WxMnpExpressPreviewTemplateRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/delivery/template/preview?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressPreviewTemplateResult.class);
    }

    /**
     * logistics.updateBusiness
     * 更新商户审核结果
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.updateBusiness.html">参考文档</a>
     *
     * @param accessToken
     * @param shopAppId 必填，商户的小程序AppID，即审核商户事件中的 ShopAppID
     * @param bizId 必填，商户账户
     * @param resultCode 必填，审核结果，0 表示审核通过，其他表示审核失败
     * @param resultMsg  审核错误原因，仅 result_code 不等于 0 时需要设置
     */
    public void updateBusiness(String accessToken, String shopAppId, String bizId, String resultCode, String resultMsg) {
        assert accessToken != null && shopAppId != null && bizId != null && resultCode != null && resultMsg != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/delivery/service/business/update?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("shop_app_id", shopAppId);
        json.addProperty("biz_id", bizId);
        json.addProperty("result_code", resultCode);
        json.addProperty("result_msg", resultMsg);

        post(url, json.getAsString());
    }

    /**
     * logistics.updatePath
     * 更新运单轨迹
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.updatePath.html">参考文档</a>
     *
     * @param accessToken
     * @param token 必填，商户侧下单事件中推送的 Token 字段
     * @param waybillId 必填，运单ID
     * @param actionTime 必填，轨迹变化 Unix 时间戳
     * @param actionType 必填，轨迹变化类型
     * @param actionMsg 必填，轨迹变化具体信息说明，展示在快递轨迹详情页中。若有手机号码，则直接写11位手机号码。使用UTF-8编码。
     */
    public void updatePath(String accessToken, String token, String waybillId, Integer actionTime, Integer actionType, String actionMsg) {
        assert accessToken != null && token != null && waybillId != null && actionTime != null && actionType != null && actionMsg != null;

        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/delivery/path/update?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("token", token);
        json.addProperty("waybill_id", waybillId);
        json.addProperty("action_time", actionTime);
        json.addProperty("action_type", actionType);
        json.addProperty("action_msg", actionMsg);

        post(url, json.getAsString());
    }

}