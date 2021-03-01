package top.codewood.wx.mp.util.json;

import com.google.gson.*;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.bean.error.WxRuntimeException;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

import java.lang.reflect.Type;

public class WxMpKfMessageGsonAdapter implements JsonSerializer<WxMpKfMessage> {
    @Override
    public JsonElement serialize(WxMpKfMessage kfMessage, Type type, JsonSerializationContext context) {
        JsonObject msgJson = new JsonObject();
        msgJson.addProperty("touser", kfMessage.getToUser());
        msgJson.addProperty("msgtype", kfMessage.getMsgType());

        switch (kfMessage.getMsgType()) {
            case WxConstants.KefuMsgType
                    .TEXT:
                JsonObject textJson = new JsonObject();
                textJson.addProperty("content", kfMessage.getContent());
                msgJson.add("text", textJson);
                break;
            case WxConstants.KefuMsgType.IMAGE:
                JsonObject imageJson = new JsonObject();
                imageJson.addProperty("media_id", kfMessage.getMediaId());
                msgJson.add("image", imageJson);
                break;
            case WxConstants.KefuMsgType.VOICE:
                JsonObject voiceJson = new JsonObject();
                voiceJson.addProperty("media_id", kfMessage.getMediaId());
                msgJson.add("voice", voiceJson);
                break;
            case WxConstants.KefuMsgType.VIDEO:
                JsonObject videoJson = new JsonObject();
                videoJson.addProperty("media_id", kfMessage.getMediaId());
                videoJson.addProperty("thumb_media_id", kfMessage.getThumbMediaId());
                videoJson.addProperty("title", kfMessage.getTitle());
                videoJson.addProperty("description", kfMessage.getDescription());
                msgJson.add("video", videoJson);
                break;
            case WxConstants.KefuMsgType.MUSIC:
                JsonObject musicJson = new JsonObject();
                musicJson.addProperty("title", kfMessage.getTitle());
                musicJson.addProperty("description", kfMessage.getDescription());
                musicJson.addProperty("musicurl", kfMessage.getMusicUrl());
                musicJson.addProperty("hqmusicurl", kfMessage.getHqMusicUrl());
                musicJson.addProperty("thumb_media_id", kfMessage.getThumbMediaId());
                msgJson.add("music", musicJson);
                break;
            case WxConstants.KefuMsgType.NEWS:
                JsonObject newsJson = new JsonObject();
                JsonArray articleArr = new JsonArray();
                for (WxMpKfMessage.WxArticle article : kfMessage.getArticles()) {
                    JsonObject articleJson = new JsonObject();
                    articleJson.addProperty("title", article.getTitle());
                    articleJson.addProperty("description", article.getDescription());
                    articleJson.addProperty("url", article.getUrl());
                    articleJson.addProperty("picurl", article.getPicUrl());
                    articleArr.add(articleJson);
                }
                newsJson.add("articles", articleArr);
                msgJson.add("news", newsJson);
                break;
            case WxConstants.KefuMsgType.MPNEWS:
                JsonObject mpnewsJson = new JsonObject();
                mpnewsJson.addProperty("media_id", kfMessage.getMediaId());
                msgJson.add("mpnews", mpnewsJson);
                break;
            case WxConstants.KefuMsgType.MSGMENU:
                JsonObject msgMenuJson = new JsonObject();
                msgMenuJson.addProperty("head_content", kfMessage.getHeadContent());
                msgMenuJson.addProperty("tail_content", kfMessage.getTailContent());
                JsonArray menuArr = new JsonArray();
                for (WxMpKfMessage.MsgMenu msgMenu : kfMessage.getMsgMenus()) {
                    JsonObject menuJson = new JsonObject();
                    menuJson.addProperty("id", msgMenu.getId());
                    menuJson.addProperty("content", msgMenu.getContent());
                    menuArr.add(menuJson);
                }
                msgMenuJson.add("list", menuArr);
                msgJson.add("msgmenu", msgMenuJson);
                break;
            case WxConstants.KefuMsgType.WXCARD:
                JsonObject wxCardJson = new JsonObject();
                wxCardJson.addProperty("card_id", kfMessage.getCardId());
                msgJson.add("wxcard", wxCardJson);
                break;
            case WxConstants.KefuMsgType.MINIPROGRAMPAGE:
                JsonObject miniprogrampageJson = new JsonObject();
                miniprogrampageJson.addProperty("title", kfMessage.getTitle());
                miniprogrampageJson.addProperty("appid", kfMessage.getAppid());
                miniprogrampageJson.addProperty("pagepath", kfMessage.getPagePath());
                miniprogrampageJson.addProperty("thumb_media_id", kfMessage.getThumbMediaId());
                msgJson.add("miniprogrampage", miniprogrampageJson);
                break;
            default: {
                throw new WxRuntimeException("非法消息类型！");
            }
        }

        return msgJson;
    }
}
