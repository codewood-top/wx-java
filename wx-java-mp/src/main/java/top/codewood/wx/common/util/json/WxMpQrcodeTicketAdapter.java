package top.codewood.wx.common.util.json;

import com.google.gson.*;
import top.codewood.wx.mp.bean.result.WxMpQrcodeTicket;

import java.lang.reflect.Type;

public class WxMpQrcodeTicketAdapter implements JsonDeserializer<WxMpQrcodeTicket> {

    @Override
    public WxMpQrcodeTicket deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        WxMpQrcodeTicket ticket = new WxMpQrcodeTicket();

        JsonObject ticketJson = json.getAsJsonObject();

        if (ticketJson.has("ticket")) {
            ticket.setTicket(ticketJson.get("ticket").getAsString());
        }
        if (ticketJson.has("expire_seconds")) {
            ticket.setExpireSeconds(ticketJson.get("expire_seconds").getAsInt());
        }
        if (ticketJson.has("url")) {
            ticket.setUrl(ticketJson.get("url").getAsString());
        }

        return ticket;
    }

}
