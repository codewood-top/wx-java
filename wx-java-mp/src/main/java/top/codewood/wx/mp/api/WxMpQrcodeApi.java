package top.codewood.wx.mp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.mp.util.json.WxGsonBuilder;
import top.codewood.wx.mp.bean.result.WxMpQrcodeTicket;

public class WxMpQrcodeApi extends WxMpApi {

    public static WxMpQrcodeTicket createTmpTicket(String accessToken, int sceneId, Integer expireSeconds) {
        if (sceneId == 0) throw new RuntimeException("临时二维码场景值不能为0！");
        return createQrcode(accessToken,"QR_SCENE", null, sceneId, expireSeconds);
    }

    public static WxMpQrcodeTicket createTmpTicket(String accessToken, String sceneStr, Integer expireSeconds) {
        if (sceneStr == null || sceneStr.trim() == "") throw new RuntimeException("临时二维码场景值不能为空！");
        return createQrcode(accessToken, "QR_STR_SCENE", sceneStr, null, expireSeconds);
    }

    public static WxMpQrcodeTicket createTicket(String accessToken, int sceneId) {
        if (sceneId < 1 || sceneId > 100000) throw new RuntimeException("永久二维码时最大值为100000(目前参数只支持1--100000)！");
        return createQrcode(accessToken, "QR_LIMIT_SCENE", null, sceneId, null);
    }

    public static WxMpQrcodeTicket createTicket(String accessToken, String sceneStr) {
        if (sceneStr == null || sceneStr.trim() == "") throw new RuntimeException("二维码场景值不能为空！");
        return createQrcode(accessToken, "QR_LIMIT_STR_SCENE", sceneStr, null, null);
    }

    /**
     *
     * @param actionName 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param sceneStr 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @return
     */
    private static WxMpQrcodeTicket createQrcode(String accessToken, String actionName, String sceneStr, Integer sceneId, Integer expireSeconds) {

        if (expireSeconds != null && expireSeconds > 2592000) throw new RuntimeException("二维码有效时间最大不超过2592000(即30天)！");

        return getQrcodeTicket(accessToken, actionName, sceneStr, sceneId, expireSeconds);
    }

    private static WxMpQrcodeTicket getQrcodeTicket(String accessToken, String actionName, String sceneStr, Integer sceneId, Integer expireSeconds) {
        assert accessToken != null;
        JsonObject json = new JsonObject();
        json.addProperty("action_name", actionName);
        if (expireSeconds != null) {
            json.addProperty("expire_seconds", expireSeconds);
        }

        JsonObject actionInfo = new JsonObject();
        JsonObject scene = new JsonObject();
        if (sceneStr != null) {
            scene.addProperty("scene_str", sceneStr);
        } else if (sceneId != null) {
            scene.addProperty("scene_id", sceneId);
        }

        actionInfo.add("scene", scene);
        json.add("action_info", actionInfo);

        String url = String.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s", accessToken);

        String respStr = post(url, json.toString());

        return WxGsonBuilder.create().fromJson(respStr, WxMpQrcodeTicket.class);
    }


}
