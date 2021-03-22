package top.codewood.wx.mnp.util.json;

import com.google.gson.*;
import top.codewood.wx.mnp.bean.analysis.WxMnpRetainInfo;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class WxMnpRetainInfoGsonAdapter implements JsonDeserializer<WxMnpRetainInfo> {

    @Override
    public WxMnpRetainInfo deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        WxMnpRetainInfo retainInfo = new WxMnpRetainInfo();
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.has("ref_date")) {
            retainInfo.setRefDate(jsonObject.get("ref_date").getAsString());
        }
        retainInfo.setVisitUvNew(getVisitUvMap(jsonObject.get("visit_uv_new").getAsJsonArray()));
        retainInfo.setVisitUv(getVisitUvMap(jsonObject.get("visit_uv").getAsJsonArray()));
        return retainInfo;
    }

    private Map<Integer, Integer> getVisitUvMap(JsonArray jsonArray) {
        if (jsonArray == null) return null;

        Map<Integer, Integer> map = new LinkedHashMap<>(jsonArray.size());
        for (JsonElement jsonEle : jsonArray) {
            JsonObject jsonObj = jsonEle.getAsJsonObject();
            if (!jsonObj.get("key").isJsonNull()) {
                Integer key = jsonObj.get("key").getAsInt();
                Integer value = jsonObj.get("value").getAsInt();
                map.put(key, value);
            }
        }
        return map;
    }
}
