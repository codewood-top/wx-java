package top.codewood.wx.mp.api;

import com.google.gson.JsonObject;

/**
 * 1、长链接转成短链接
 * 2、短key托管
 */
public class WxMpUtilApi extends WxMpApi {

    private static class Holder {
        private static final WxMpUtilApi INSTANCE = new WxMpUtilApi();
    }

    public static WxMpUtilApi getInstance() {
        return Holder.INSTANCE;
    }

    public String long2Short(String accessToken, String longUrl) {
        assert accessToken != null && longUrl != null;
        JsonObject json = new JsonObject();
        json.addProperty("action", "long2short");
        json.addProperty("long_url", longUrl);

        String url = String.format("https://api.weixin.qq.com/cgi-bin/shorturl?access_token=%s", accessToken);
        return post(url, json.toString());
    }

    /**
     * 通过GenShorten将不超过4KB的长信息转成短key
     * @param accessToken
     * @param longData 需要转换的长信息，不超过4KB
     * @param expireSeconds 过期秒数，最大值为2592000（即30天），默认为2592000
     * @return
     */
    public String genShorten(String accessToken, String longData, Integer expireSeconds) {
        assert accessToken != null && longData != null;

        JsonObject json = new JsonObject();
        json.addProperty("long_data", longData);
        if (expireSeconds != null) {
            json.addProperty("expire_seconds", expireSeconds);
        }

        String url = String.format("https://api.weixin.qq.com/cgi-bin/shorten/gen?access_token=%s", accessToken);
        return post(url, json.toString());
    }

    /**
     * 通过FetchShorten将短key还原为长信息
     * @param accessToken
     * @param shortKey  短key，15字节，base62编码(0-9/a-z/A-Z)
     * @return
     */
    public String fetchShorten(String accessToken, String shortKey) {
        assert accessToken != null && shortKey != null;

        String shortKeyStr = String.format("{\"short_key\": \"%s\"}", shortKey);

        String url = String.format("https://api.weixin.qq.com/cgi-bin/shorten/fetch?access_token=%s", accessToken);
        return post(url, shortKeyStr);
    }

}
