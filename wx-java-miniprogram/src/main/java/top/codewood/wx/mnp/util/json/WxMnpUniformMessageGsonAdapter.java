package top.codewood.wx.mnp.util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import top.codewood.wx.mnp.bean.WxMnpTemplateData;
import top.codewood.wx.mnp.bean.msg.WxMnpUniformMessage;

import java.lang.reflect.Type;
import java.util.List;

public class WxMnpUniformMessageGsonAdapter implements JsonSerializer<WxMnpUniformMessage> {

    @Override
    public JsonElement serialize(WxMnpUniformMessage uniformMessage, Type type, JsonSerializationContext context) {

        JsonObject uniformMsgJson = new JsonObject();

        uniformMsgJson.addProperty("touser", uniformMessage.getToUser());
        if (uniformMessage.getWeAppTemplateMsg() != null) {

            JsonObject weappJson = new JsonObject();
            weappJson.addProperty("template_id", uniformMessage.getWeAppTemplateMsg().getTemplateId());
            weappJson.addProperty("page", uniformMessage.getWeAppTemplateMsg().getPage());
            weappJson.addProperty("form_id", uniformMessage.getWeAppTemplateMsg().getFormId());
            weappJson.addProperty("emphasis_keyword", uniformMessage.getWeAppTemplateMsg().getEmphasisKeyword());
            weappJson.add("data", templateDatasToJson(uniformMessage.getWeAppTemplateMsg().getData()));

            uniformMsgJson.add("weapp_template_msg", weappJson);
        }

        if (uniformMessage.getMpTempalte() != null) {

            JsonObject mpJson = new JsonObject();
            mpJson.addProperty("appid", uniformMessage.getMpTempalte().getAppid());
            mpJson.addProperty("template_id", uniformMessage.getMpTempalte().getTemplateId());
            mpJson.addProperty("url", uniformMessage.getMpTempalte().getUrl());
            mpJson.addProperty("miniprogram", uniformMessage.getMpTempalte().getMiniprogram());
            mpJson.add("data", templateDatasToJson(uniformMessage.getMpTempalte().getData()));

            uniformMsgJson.add("mp_template_msg", mpJson);
        }

        return uniformMsgJson;
    }

    public static JsonObject templateDatasToJson(List<WxMnpTemplateData> templateDatas) {
        JsonObject dataJson = new JsonObject();

        if (templateDatas == null || templateDatas.size() == 0) return dataJson;

        for (WxMnpTemplateData templateData : templateDatas) {
            JsonObject templateDataJson = new JsonObject();
            templateDataJson.addProperty("value", templateData.getValue());
            if (templateData.getColor() != null) {
                templateDataJson.addProperty("color", templateData.getColor());
            }
            dataJson.add(templateData.getName(), templateDataJson);
        }
        return dataJson;
    }

}
