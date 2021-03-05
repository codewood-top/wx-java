package top.codewood.wx.mp.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import top.codewood.wx.mp.bean.template.WxMpTemplate;
import top.codewood.wx.mp.bean.template.WxMpTemplateIndustry;
import top.codewood.wx.mp.bean.template.WxMpTemplateMessage;
import top.codewood.wx.mp.util.json.WxGsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class WxMpTemplateApi extends WxMpApi {

    private static final class Holder {
        private static final WxMpTemplateApi INSTANCE = new WxMpTemplateApi();
    }

    public static final WxMpTemplateApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 设置行业可在微信公众平台后台完成，每月可修改行业1次，帐号仅可使用所属行业中相关的模板，为方便第三方开发者，提供通过接口调用的方式来修改账号所属行业
     * @param accessToken
     * @param industryId1 @ses WxMpTemplateIndustryEnum
     * @param industryId2 @ses WxMpTemplateIndustryEnum
     */
    public void setIndustry(String accessToken, int industryId1, int industryId2) {
        assert accessToken != null;
        String postStr = String.format("{\"industry_id1\": %s, \"industry_id2\": %s}", industryId1, industryId2);
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=%s", accessToken);
        post(url, postStr);
    }

    /**
     * 获取设置的行业信息
     * 获取帐号设置的行业信息。可登录微信公众平台，在公众号后台中查看行业信息。为方便第三方开发者，提供通过接口调用的方式来获取帐号所设置的行业信息
     * @param accessToken
     * @return
     */
    public WxMpTemplateIndustry getIndustry(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=%s", accessToken);
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxMpTemplateIndustry.class);
    }

    /**
     * 获得模板ID
     * 从行业模板库选择模板到帐号后台，获得模板ID的过程可在微信公众平台后台完成。为方便第三方开发者，提供通过接口调用的方式来获取模板ID
     * @param accessToken
     * @param templateIdShort  模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return template_id
     */
    public String addTemplate(String accessToken, String templateIdShort) {
        assert accessToken != null && templateIdShort != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=%s", accessToken);
        String postStr = String.format("{\"template_id_short\": \"%s\"}", templateIdShort);
        String respStr = post(url, postStr);
        return WxGsonBuilder.create().fromJson(respStr, JsonObject.class).get("template_id").getAsString();
    }

    /**
     * 获取模板列表
     * 获取已添加至帐号下所有模板列表，可在微信公众平台后台中查看模板列表信息。为方便第三方开发者，提供通过接口调用的方式来获取帐号下所有模板信息
     * @param accessToken
     * @return
     */
    public List<WxMpTemplate> listPrivateTemplate(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=%s", accessToken);
        String respStr = get(url);

        List<WxMpTemplate> wxMpTemplates = new ArrayList<>();
        Gson gson = WxGsonBuilder.create();
        JsonArray templateArr = gson.fromJson(respStr, JsonObject.class).get("template_list").getAsJsonArray();
        templateArr.forEach(templateJson -> wxMpTemplates.add(gson.fromJson(templateJson, WxMpTemplate.class)));
        return wxMpTemplates;
    }

    /**
     * 删除模板
     * 删除模板可在微信公众平台后台完成，为方便第三方开发者，提供通过接口调用的方式来删除某帐号下的模板
     * @param accessToken
     * @param templateId    公众帐号下模板消息ID
     */
    public void delPrivateTemplate(String accessToken, String templateId) {
        assert accessToken != null && templateId != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=%s", accessToken);
        String postStr = String.format("{\"template_id\": \"%s\"}", templateId);
        post(url, postStr);
    }

    /**
     * 发送模板消息
     * 注：url和miniprogram都是非必填字段，若都不传则模板无跳转；若都传，会优先跳转至小程序。开发者可根据实际需要选择其中一种跳转方式即可。当用户的微信客户端版本不支持跳小程序时，将会跳转至url。
     * @param accessToken
     * @param mpTemplateMessage
     * @return msgid
     */
    public String sendTemplateMessage(String accessToken, WxMpTemplateMessage mpTemplateMessage) {
        assert accessToken != null && mpTemplateMessage != null;

        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s", accessToken);
        Gson gson = WxGsonBuilder.create();
        String respStr = post(url, gson.toJson(mpTemplateMessage));

        JsonObject json = gson.fromJson(respStr, JsonObject.class);
        return json.get("msgid").getAsString();

    }

}
