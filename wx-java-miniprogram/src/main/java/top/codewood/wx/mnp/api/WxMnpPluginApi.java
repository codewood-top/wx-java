package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.plugin.WxMnpPluginDevApplyListResult;
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
     * @param reason      申请使用理由
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


    /**
     * pluginManager.getPluginDevApplyList
     * 获取当前所有插件使用方（供插件开发者调用）
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginDevApplyList.html">参考文档</a>
     *
     * @param accessToken
     * @param action      此接口下填写 "dev_apply_list"
     * @param page        要拉取第几页的数据
     * @param num         每页的记录数
     *                    返回值
     * @return
     */
    public WxMnpPluginDevApplyListResult getPluginDevApplyList(String accessToken, String action, int page, int num) {
        assert accessToken != null;
        assert action == null || "dev_apply_list".equals(action);
        String url = String.format("https://api.weixin.qq.com/wxa/devplugin?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("action", action);
        json.addProperty("page", page);
        json.addProperty("num", num);

        String respStr = post(url, json.toString());

        return WxGsonBuilder.instance().fromJson(respStr, WxMnpPluginDevApplyListResult.class);
    }

    /**
     * pluginManager.getPluginDevApplyList
     * 获取当前所有插件使用方（供插件开发者调用）
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginDevApplyList.html">参考文档</a>
     *
     * action = "dev_apply_list"
     *
     * @param accessToken
     * @param page        要拉取第几页的数据
     * @param num         每页的记录数
     *                    返回值
     * @return
     */
    public WxMnpPluginDevApplyListResult getPluginDevApplyList(String accessToken, int page, int num) {
        return getPluginDevApplyList(accessToken, "dev_apply_list", page, num);
    }

    /**
     * pluginManager.setDevPluginApplyStatus
     * 修改插件使用申请的状态（供插件开发者调用）
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.setDevPluginApplyStatus.html">参考文档</a>
     *
     * @param accessToken
     * @param action 修改操作, dev_agree: 同意申请, dev_refuse: 拒绝申请,  dev_delete: 删除已拒绝的申请者
     * @param appid 使用者的 appid。同意申请时填写。
     * @param reason 拒绝理由。拒绝申请时填写。
     */
    public void setDevPluginApplyStatus(String accessToken, String action, String appid, String reason) {
        assert accessToken != null && action != null;

        String url = String.format("https://api.weixin.qq.com/wxa/devplugin?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        if (action != null) {
            json.addProperty("action", action);
        }
        if (appid != null) {
            json.addProperty("appid", appid);
        }
        if (reason != null) {
            json.addProperty("reason", reason);
        }

        post(url, json.toString());

    }

}
