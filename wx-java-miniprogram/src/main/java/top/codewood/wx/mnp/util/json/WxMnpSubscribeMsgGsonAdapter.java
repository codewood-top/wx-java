package top.codewood.wx.mnp.util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import top.codewood.wx.mnp.bean.WxMnpTemplateData;
import top.codewood.wx.mnp.bean.subscribemsg.WxMnpSubscribeMsg;

import java.lang.reflect.Type;
import java.util.List;

public class WxMnpSubscribeMsgGsonAdapter implements JsonSerializer<WxMnpSubscribeMsg> {

    @Override
    public JsonElement serialize(WxMnpSubscribeMsg subscribeMsg, Type type, JsonSerializationContext context) {
        JsonObject json = new JsonObject();

        json.addProperty("touser", subscribeMsg.getToUser());
        json.addProperty("template_id", subscribeMsg.getTemplateId());
        json.addProperty("page", subscribeMsg.getPage());
        json.add("data", templateDatasToJson(subscribeMsg.getData()));
        if (subscribeMsg.getMiniprogramState() != null) {
            json.addProperty("miniprogram_state", subscribeMsg.getMiniprogramState());
        }
        if (subscribeMsg.getLang() != null) {
            json.addProperty("lang", subscribeMsg.getLang());
        }

        return json;
    }

    public JsonObject templateDatasToJson(List<WxMnpTemplateData> templateDatas) {
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
