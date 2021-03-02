package top.codewood.wx.mp.util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import top.codewood.wx.mp.bean.template.WxMpTemplate;
import top.codewood.wx.mp.bean.template.WxMpTemplateData;
import top.codewood.wx.mp.bean.template.WxMpTemplateMessage;

import java.lang.reflect.Type;

public class WxMpTemplateMessageGsonAdapter implements JsonSerializer<WxMpTemplateMessage> {
    @Override
    public JsonElement serialize(WxMpTemplateMessage templateMessage, Type type, JsonSerializationContext context) {

        JsonObject msgJson = new JsonObject();
        msgJson.addProperty("touser", templateMessage.getToUser());
        msgJson.addProperty("template_id", templateMessage.getTemplateId());
        if (templateMessage.getUrl() != null) {
            msgJson.addProperty("url", templateMessage.getUrl());
        }

        final WxMpTemplateMessage.MiniProgram miniProgram = templateMessage.getMiniProgram();
        if (miniProgram != null) {
            JsonObject miniProgramJson = new JsonObject();
            miniProgramJson.addProperty("appid", miniProgram.getAppid());
            miniProgramJson.addProperty("pagepath", miniProgram.getPagePath());
            msgJson.add("miniprogram", miniProgramJson);
        }

        JsonObject dataJson = new JsonObject();

        for (WxMpTemplateData tmplData : templateMessage.getData()) {
            JsonObject tmplDataJson = new JsonObject();
            tmplDataJson.addProperty("value", tmplData.getValue());
            if (tmplData.getColor() != null) {
                tmplDataJson.addProperty("color", tmplData.getColor());
            }
            dataJson.add(tmplData.getName(), tmplDataJson);
        }

        msgJson.add("data", dataJson);
        return msgJson;
    }
}
