package top.codewood.wx.mnp.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.subscribemsg.*;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 小程序订阅消息接口
 */
public class WxMnpSubscribeMessageApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpSubscribeMessageApi INSTANCE = new WxMnpSubscribeMessageApi();
    }

    public static WxMnpSubscribeMessageApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * subscribeMessage.addTemplate
     * 组合模板并添加至帐号下的个人模板库
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.addTemplate.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param tid 模板标题 id，可通过接口获取，也可登录小程序后台查看获取
     * @param kidList 开发者自行组合好的模板关键词列表，关键词顺序可以自由搭配（例如 [3,5,4] 或 [4,5,3]），最多支持5个，最少2个关键词组合
     * @param sceneDesc 服务场景描述，15个字以内
     * @return priTmplId 添加至帐号下的模板id，发送小程序订阅消息时所需
     */
    public String addTemplate(String accessToken, String tid, List<Integer> kidList, String sceneDesc) {
        assert accessToken != null && kidList != null;
        if (kidList.size() > 5 || kidList.size() < 2) {
            throw new RuntimeException("kidList: 最多支持5个，最少2个关键词组合");
        }
        String url = String.format("https://api.weixin.qq.com/wxaapi/newtmpl/addtemplate?access_token=%s", accessToken);

        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("tid", tid));

        for (int i = 0; i < kidList.size(); i++) {
            parameters.add(new BasicNameValuePair(String.format("kidList[%s]", i), String.valueOf(kidList.get(i))));
        }
        if (sceneDesc != null && sceneDesc.trim() != "") {
            parameters.add(new BasicNameValuePair("sceneDesc", sceneDesc));
        }
        String respStr = post(url, parameters);
        JsonObject retJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return retJson.get("priTmplId").getAsString();
    }

    /**
     * subscribeMessage.deleteTemplate
     * @param accessToken
     * @param priTmplId 要删除的模板id
     */
    public void deleteTemplate(String accessToken, String priTmplId) {
        assert accessToken != null && priTmplId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/newtmpl/deltemplate?access_token=%s", accessToken);
        //String postData=  String.format("{\"priTmplId\": \"%s\"}", priTmplId);
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("priTmplId", priTmplId));
        post(url, parameters);
    }

    /**
     * subscribeMessage.getTemplateList
     * 获取当前帐号下的个人模板列表
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getTemplateList.html">参考文档</a>
     *
     * @param accessToken
     */
    public List<WxMnpTemplateInfo> getTemplateList(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/newtmpl/gettemplate?access_token=%s", accessToken);
        return getDataResultAsList(url, WxMnpTemplateInfo.class);
    }

    /**
     * subscribeMessage.getCategory
     * 获取小程序账号的类目
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getCategory.html">参考文档</a>
     *
     * @param accessToken
     */
    public List<WxMnpTemplateCategory> getCategory(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/newtmpl/getcategory?access_token=%s", accessToken);
        return getDataResultAsList(url, WxMnpTemplateCategory.class);
    }

    /**
     * subscribeMessage.getPubTemplateTitleList
     * 获取帐号所属类目下的公共模板标题
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getPubTemplateTitleList.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param ids 类目 id，多个用逗号隔开
     * @param start 用于分页，表示从 start 开始。从 0 开始计数。
     * @param limit 用于分页，表示拉取 limit 条记录。最大为 30。
     * @return
     */
    public WxMnpPubTemplateTitleList getPubTemplateTitleList(String accessToken, String[] ids, int start, int limit) {
        assert accessToken != null && ids != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/newtmpl/getpubtemplatetitles?access_token=%s&ids=%s&start=%s&limit=%s", accessToken, String.join(",", ids), start, limit);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpPubTemplateTitleList.class);
    }

    /**
     * subscribeMessage.getPubTemplateTitleList
     * default: start=0, limit=30
     * 获取帐号所属类目下的公共模板标题
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getPubTemplateTitleList.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param ids 类目 id，多个用逗号隔开
     * @return
     */
    public WxMnpPubTemplateTitleList getPubTemplateTitleList(String accessToken, String[] ids) {
        return getPubTemplateTitleList(accessToken, ids, 0, 30);
    }

    /**
     * subscribeMessage.getPubTemplateKeyWordsById
     * 获取模板标题下的关键词列表
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.getPubTemplateKeyWordsById.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param tid 模板标题 id，可通过接口获取 -> getPubTemplateTitleList
     * @return
     */
    public List<WxMnpPubTemplateKeyword> getPubTemplateKeyWordsById(String accessToken, String tid) {
        assert accessToken != null && tid != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/newtmpl/getpubtemplatekeywords?access_token=%s&tid=%s", accessToken, tid);
        return getDataResultAsList(url, WxMnpPubTemplateKeyword.class);
    }

    /**
     * subscribeMessage.send
     * 发送订阅消息
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.send.html#%E4%BA%91%E8%B0%83%E7%94%A8">参考文档</a>
     *
     * @param accessToken
     * @param subscribeMsg
     */
    public void send(String accessToken, WxMnpSubscribeMsg subscribeMsg) {
        assert accessToken != null && subscribeMsg != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=%s", accessToken);
        post(url, WxGsonBuilder.instance().toJson(subscribeMsg));
    }

    private <T> List<T> getDataResultAsList(String url, Class<T> clz) {
        String respStr = get(url);
        Gson gson = WxGsonBuilder.instance();
        JsonObject jsonObject = gson.fromJson(respStr, JsonObject.class);
        if (jsonObject.has("data")) {
            List<T> list = new ArrayList<>();
            jsonObject.get("data").getAsJsonArray().forEach(jsonEle -> list.add(gson.fromJson(jsonEle, clz)));
            return list;
        }
        return null;
    }

}
