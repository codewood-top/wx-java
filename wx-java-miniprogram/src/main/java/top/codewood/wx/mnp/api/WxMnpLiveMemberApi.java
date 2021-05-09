package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.live.WxMnpLiveRoleListResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

public class WxMnpLiveMemberApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpLiveMemberApi INSTANCE = new WxMnpLiveMemberApi();
    }

    public static WxMnpLiveMemberApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 设置成员角色
     * 调用此接口设置小程序直播成员的管理员、运营者和主播角色
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/role-manage.html#1">参考文档</a>
     *
     * @param accessToken
     * @param username  用户的微信号
     * @param role      设置用户的角色 取值[1-管理员，2-主播，3-运营者]，设置超级管理员将无效
     */
    public void addRole(String accessToken, String username, Integer role) {
        assert accessToken != null && username != null && role != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/role/addrole?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("username", username);
        json.addProperty("role", role);

        post(url, json.toString());
    }

    /**
     * 解除成员角色
     * 调用此接口移除小程序直播成员的管理员、运营者和主播角色
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/role-manage.html#2">参考文档</a>
     *
     * @param accessToken
     * @param username  用户的微信号
     * @param role  删除用户的角色 取值[1-管理员，2-主播，3-运营者]，删除超级管理员将无效
     */
    public void deleteRole(String accessToken, String username, Integer role) {
        assert accessToken != null && username != null && role != null;
    }

    /**
     * 查询成员列表
     * 调用此接口查询小程序直播成员列表
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/role-manage.html#3">参考文档</a>
     *
     * @param accessToken
     * @param role  查询的用户角色，取值 [-1-所有成员， 0-超级管理员，1-管理员，2-主播，3-运营者]，默认-1
     * @param offset    起始偏移量, 默认0
     * @param limit     查询个数，最大30，默认10
     * @param keyword   搜索的微信号或昵称，不传则返回全部
     */
    public WxMnpLiveRoleListResult list(String accessToken, Integer role, Integer offset, Integer limit, String keyword) {
        assert accessToken != null;

        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/role/getrolelist?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        if (role != null) {
            json.addProperty("role", role);
        }
        if (offset != null) {
            json.addProperty("offset", offset);
        }
        if (limit != null) {
            json.addProperty("keyword", keyword);
        }

        String respStr = post(url, json.toString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveRoleListResult.class);
    }

}
