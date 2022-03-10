package top.codewood.wx.mnp.util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import top.codewood.wx.mnp.bean.WxMnpTemplateData;
import top.codewood.wx.mnp.bean.hardwaredevice.WxMnpHardwareDeviceSendRequest;

import java.lang.reflect.Type;
import java.util.List;

public class WxMnpHardwareDeviceSendRequestGsonAdapter implements JsonSerializer<WxMnpHardwareDeviceSendRequest> {


    @Override
    public JsonElement serialize(WxMnpHardwareDeviceSendRequest request, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();

        json.add("to_openid_list", WxGsonBuilder.instance().toJsonTree(request.getToOpenidList()));
        json.addProperty("template_id", request.getTemplateId());
        json.addProperty("sn", request.getSn());
        json.addProperty("modelId", request.getModelId());
        json.addProperty("page", request.getPage());
        json.add("data", templateDatasToJson(request.getData()));

        if (request.getMiniprogramState() != null) {
            json.addProperty("miniprogram_state", request.getMiniprogramState());
        }
        if (request.getLang() != null) {
            json.addProperty("lang", request.getLang());
        }

        return json;
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
