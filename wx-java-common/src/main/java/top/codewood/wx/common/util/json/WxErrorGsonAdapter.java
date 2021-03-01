package top.codewood.wx.common.util.json;

import com.google.gson.*;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.bean.error.WxErrorEnum;

import java.lang.reflect.Type;

public class WxErrorGsonAdapter implements JsonDeserializer<WxError> {
    @Override
    public WxError deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        int errorCode = 0;
        String errorMsg = null;
        JsonObject wxErrJson = json.getAsJsonObject();
        if (wxErrJson.has("errcode")) {
            errorCode = wxErrJson.get("errcode").getAsInt();
            errorMsg = WxErrorEnum.getCodeMsg(errorCode);
        }
        if (errorMsg == null && wxErrJson.has("errmsg")) {
            errorMsg = wxErrJson.get("errmsg").getAsString();
        }

        return new WxError(errorCode, errorMsg);
    }
}
