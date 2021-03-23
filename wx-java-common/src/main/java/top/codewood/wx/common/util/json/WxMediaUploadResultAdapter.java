package top.codewood.wx.common.util.json;

import com.google.gson.*;
import top.codewood.wx.common.bean.media.WxMediaUploadResult;

import java.lang.reflect.Type;

public class WxMediaUploadResultAdapter implements JsonDeserializer<WxMediaUploadResult> {

    @Override
    public WxMediaUploadResult deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        WxMediaUploadResult result = new WxMediaUploadResult();
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.get("url") != null && !jsonObject.get("url").isJsonNull()) {
            result.setUrl(jsonObject.get("url").getAsString());
        }

        if (jsonObject.get("type") != null && !jsonObject.get("type").isJsonNull()) {
            result.setType(jsonObject.get("type").getAsString());
        }

        if (jsonObject.get("media_id") != null && !jsonObject.get("media_id").isJsonNull()) {
            result.setMediaId(jsonObject.get("media_id").getAsString());
        }

        if (jsonObject.get("created_at") != null && !jsonObject.get("created_at").isJsonNull()) {
            result.setCreatedAt(jsonObject.get("created_at").getAsLong());
        }

        return result;
    }

}
