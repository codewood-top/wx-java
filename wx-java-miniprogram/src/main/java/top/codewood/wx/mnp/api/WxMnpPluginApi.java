package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.plugin.WxMnpPluginListResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpPluginApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpPluginApi INSTANCE = new WxMnpPluginApi();
    }

    public static WxMnpPluginApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * pluginManager.getPluginList
     * 查询已添加的插件
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginList.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public WxMnpPluginListResult getPluginList(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/wxa/plugin?access_token=%s", accessToken);
        String postData = "{\"action\":\"list\"}";
        String respStr = post(url, postData);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpPluginListResult.class);
    }

    /**
     * pluginManager.applyPlugin
     * 向插件开发者发起使用插件的申请
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.applyPlugin.html">参考文档</a>
     *
     * @param accessToken
     * @param pluginAppid 插件 appId
     * @param reason 申请使用理由
     */
    public void applyPlugin(String accessToken, String pluginAppid, String reason) {
        assert accessToken != null && pluginAppid != null;
        String url = String.format("https://api.weixin.qq.com/wxa/plugin?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("action", "apply");
        json.addProperty("plugin_appid", pluginAppid);
        if (reason != null) json.addProperty("reason", reason);
        post(url, json.toString());
    }

    /**
     * pluginManager.unbindPlugin
     * 删除已添加的插件
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.unbindPlugin.html">参考文档</a>
     *
     * @param accessToken
     * @param pluginAppid 插件 appId
     */
    public void unbindPlugin(String accessToken, String pluginAppid) {
        assert accessToken != null && pluginAppid != null;
        String url = String.format("https://api.weixin.qq.com/wxa/plugin?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("action", "unbind");
        json.addProperty("plugin_appid", pluginAppid);
        post(url, json.toString());
    }

}
