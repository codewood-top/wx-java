package top.codewood.wx.mp.util.json;

import com.google.gson.*;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.mp.bean.menu.WxMenuButton;
import top.codewood.wx.mp.bean.menu.WxMenuRule;

import java.lang.reflect.Type;

public class WxMpMenuGsonAdapter implements JsonSerializer<WxMenu>, JsonDeserializer<WxMenu> {

    @Override
    public JsonElement serialize(WxMenu wxMenu, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject json = new JsonObject();

        JsonArray buttonArr = new JsonArray();

        for (WxMenuButton button: wxMenu.getButtons()) {
            JsonObject buttonJson = convertToJson(button);
            buttonArr.add(buttonJson);
        }

        json.add("button", buttonArr);

        if (wxMenu.getMatchRule() != null) {
            json.add("matchrule", convertToJson(wxMenu.getMatchRule()));
        }

        return json;
    }

    protected JsonObject convertToJson(WxMenuButton button) {
        JsonObject buttonJson = new JsonObject();

        buttonJson.addProperty("type", button.getType());
        buttonJson.addProperty("name", button.getName());
        buttonJson.addProperty("key", button.getKey());
        buttonJson.addProperty("url", button.getUrl());
        buttonJson.addProperty("media_id", button.getMediaId());
        buttonJson.addProperty("appid", button.getAppid());
        buttonJson.addProperty("pagepath", button.getPagePath());
        if (button.getSubButtons() != null && button.getSubButtons().size() > 0) {
            JsonArray buttonArr = new JsonArray();
            for (WxMenuButton sub_button: button.getSubButtons()) {
                buttonArr.add(convertToJson(sub_button));
            }
            buttonJson.add("sub_button", buttonArr);
        }

        return buttonJson;
    }

    protected JsonObject convertToJson(WxMenuRule menuRule) {
        JsonObject menuRuleJson = new JsonObject();

        menuRuleJson.addProperty("tag_id", menuRule.getTagId());
        menuRuleJson.addProperty("sex", menuRule.getSex());
        menuRuleJson.addProperty("country", menuRule.getCountry());
        menuRuleJson.addProperty("province", menuRule.getProvince());
        menuRuleJson.addProperty("city", menuRule.getCity());
        menuRuleJson.addProperty("client_platform_type", menuRule.getClientPlatformType());
        menuRuleJson.addProperty("language", menuRule.getLanguage());

        return menuRuleJson;
    }

    @Override
    public WxMenu deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray buttonArr = json.getAsJsonObject().get("button").getAsJsonArray();
        return buildMenuFromJson(buttonArr);
    }

    protected WxMenu buildMenuFromJson(JsonArray buttonArr) {
        WxMenu wxMenu = new WxMenu();
        for (int i = 0; i < buttonArr.size(); i++) {
            JsonObject buttonJson = buttonArr.get(i).getAsJsonObject();
            WxMenuButton button = convertFromJson(buttonJson);
            wxMenu.getButtons().add(button);

            if (buttonJson.get("sub_button") == null || buttonJson.get("sub_button").isJsonNull()) continue;

            JsonArray subButtonArr = buttonJson.get("sub_button").getAsJsonObject().get("list").getAsJsonArray();
            for (int j = 0; j < subButtonArr.size(); j++) {
                JsonObject subButtonJson = subButtonArr.get(j).getAsJsonObject();
                button.getSubButtons().add(convertFromJson(subButtonJson));
            }

        }
        return wxMenu;
    }

    protected WxMenuButton convertFromJson(JsonObject json) {
        WxMenuButton button = new WxMenuButton();

        button.setName(json.get("name").getAsString());
        if (json.has("type")) {
            button.setType(json.get("type").getAsString());
        }
        if (json.has("key")) {
            button.setKey(json.get("key").getAsString());
        }
        if (json.has("url")) {
            button.setUrl(json.get("url").getAsString());
        }
        if (json.has("media_id")) {
            button.setMediaId(json.get("media_id").getAsString());
        }
        if (json.has("appid")) {
            button.setAppid(json.get("appid").getAsString());
        }
        if (json.has("pagepath")) {
            button.setPagePath(json.get("pagepath").getAsString());
        }

        return button;
    }

}
