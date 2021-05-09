package top.codewood.wx.mnp.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.live.*;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小程序直播-直播间接口
 *
 * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html">参考文档</a>
 *
 */
public class WxMnpLiveApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpLiveApi INSTANCE = new WxMnpLiveApi();
    }

    public static WxMnpLiveApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 创建直播间
     * 调用此接口创建直播间，创建成功后将在直播间列表展
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#1">参考文档</a>
     *
     * @param request
     * @return
     */
    public WxMnpLiveRoomCreateResult createRoom(String accessToken, WxMnpLiveRoomCreateRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/create?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveRoomCreateResult.class);
    }

    /**
     * 获取直播间列表
     * 调用此接口获取直播间列表及直播间信息
     * 调用额度：100000次/一天（与获取回放接口共用次数）
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#2">参考文档</a>
     *
     * @param accessToken
     * @param start 起始房间，0表示从第1个房间开始拉取
     * @param limit 每次拉取的房间数量，建议100以内
     * @return
     */
    public WxMnpLiveRoomListResult listRooms(String accessToken, Integer start, Integer limit) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/wxa/business/getliveinfo?access_token=%s", accessToken);
        String postStr = String.format("{\"start\": %s, \"limit\": %s}", start, limit);
        String respStr = post(url, postStr);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveRoomListResult.class);
    }

    /**
     * 获取直播间回放
     * 调用接口获取已结束直播间的回放源视频（一般在直播结束后10分钟内生成，源视频无评论等内容）
     * 调用额度：100000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#3">参考文档</a>
     *
     * @param accessToken
     * @param roomId 直播间ID
     * @param start 起始拉取视频，0表示从第一个视频片段开始拉取
     * @param limit 每次拉取的数量，建议100以内
     * @return
     */
    public WxMnpLiveRoomReplayResult getRoomReplay(String accessToken, Integer roomId, Integer start, Integer limit) {
        assert accessToken != null && roomId != null;

        String url = String.format("https://api.weixin.qq.com/wxa/business/getliveinfo?access_token=%s", accessToken);
        JsonObject json  = new JsonObject();
        json.addProperty("action", "get_replay");
        json.addProperty("room_id", roomId);
        json.addProperty("start", start);
        json.addProperty("limit", limit);

        String respStr = post(url, json.toString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveRoomReplayResult.class);
    }

    /**
     * 直播间导入商品
     * 调用接口往指定直播间导入已入库的商品
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#4">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param goodsIds  数组列表，可传入多个，里面填写 商品 ID
     */
    public void addGoodsToRoom(String accessToken, Integer roomId, List<Integer> goodsIds) {
        assert accessToken != null && goodsIds != null && goodsIds.size() > 0;

        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/addgoods?access_token=%s", accessToken);

        Map<String, Object> map = new HashMap<>();
        map.put("ids", goodsIds);
        map.put("roomId", roomId);
        post(url, WxGsonBuilder.instance().toJson(map));
    }

    /**
     * 删除直播间
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#5">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     */
    public void deleteRoom(String accessToken, Integer roomId) {
        assert accessToken != null && roomId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/deleteroom?access_token=%s", accessToken);
        String postStr = String.format("{\"id\": %s}", roomId);
        post(url, postStr);
    }

    /**
     * 编辑直播间
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#6">参考文档</a>
     *
     * @param accessToken
     * @param request
     */
    public void editRoom(String accessToken, WxMnpLiveRoomCreateRequest request)  {
        assert accessToken != null && request != null;
        if (request.getId() == null) throw new RuntimeException("直播间ID不能为空!");
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/editroom?access_token=%s", accessToken);
        post(url, WxGsonBuilder.instance().toJson(request));
    }

    /**
     * 获取直播间推流地址
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#7">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @return  直播间推流地址
     */
    public String getPushUrl(String accessToken, Integer roomId) {
        assert accessToken != null && roomId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/getpushurl?access_token=%s", accessToken);
        String postStr = String.format("{\"roomId\": %s}", roomId);

        String respStr = post(url, postStr);
        return WxGsonBuilder.instance().fromJson(respStr, JsonObject.class).get("pushAddr").getAsString();
    }

    /**
     *  获取直播间分享二维码
     *  调用额度：10000次/一天
     *
     *  <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#8">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param customParams    自定义参数, 可以为null
     * @return
     */
    public WxMnpLiveGetShareCodeResult getShareCode(String accessToken, Integer roomId, Map<String, Object> customParams) {
        assert accessToken != null  && roomId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/getsharedcode?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);

        if (customParams != null) {
            try {
                json.addProperty("params", URLEncoder.encode(WxGsonBuilder.instance().toJson(customParams), StandardCharsets.UTF_8.name()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        String respStr = post(url, json.toString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveGetShareCodeResult.class);
    }

    /**
     * 添加管理直播间小助手
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#9">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param users     用户数组 ex: "users": [{"username":"testwechat","nickname":"testnick"}]
     */
    public void addAssistant(String accessToken, Integer roomId, List<WxMnpLiveAssistant> users) {
        assert accessToken != null && roomId != null && users != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/addassistant?access_token=%s", accessToken);

        Map<String, Object> map = new HashMap<>();
        map.put("roomId", roomId);
        map.put("users", users);
        post(url, WxGsonBuilder.instance().toJson(map));
    }

    /**
     * 修改管理直播间小助手
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#10">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param username  用户微信号
     * @param nickname  用户微信昵称
     */
    public void modifyAssistant(String accessToken, Integer roomId, String username, String nickname) {
        assert accessToken != null && roomId != null && username != null && nickname != null;

        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/modifyassistant?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("username", username);
        json.addProperty("nickname", nickname);

        post(url, json.toString());
    }

    /**
     * 删除管理直播间小助手
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#11">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param username  用户微信号
     */
    public void removeAssistant(String accessToken, Integer roomId, String username) {
        assert accessToken != null && roomId != null && username != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/removeassistant?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("username", username);

        post(url, json.toString());
    }

    /**
     * 查询管理直播间小助手
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#12">参考文档</a>
     *
     * @param accessToken
     * @param roomId
     */
    public WxMnpLiveAssistantListResult listAssistants(String accessToken, Integer roomId) {
        assert accessToken != null && roomId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/getassistantlist?access_token=%s", accessToken);
        String postStr = String.format("{\"roomId\": %s}", roomId);

        String respStr = post(url, postStr);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveAssistantListResult.class);
    }

    /**
     *  添加主播副号
     *  调用额度：10000次/一天
     *
     *  <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#13">参考文档</a>
     *
     * @param accessToken
     * @param roomId
     * @param username
     */
    public void addSubAnchor(String accessToken, Integer roomId, String username) {
        assert accessToken != null && roomId != null && username != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/addsubanchor?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("username", username);

        post(url, json.toString());
    }

    /**
     * 修改主播副号
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#14">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param username  微信号
     */
    public void modifySubAnchor(String accessToken, Integer roomId, String username) {
        assert accessToken != null && roomId != null && username != null;

        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/modifysubanchor?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("username", username);

        post(url, json.toString());
    }

    /**
     * 删除主播副号
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#15">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     */
    public void deleteSubAnchor(String accessToken, Integer roomId) {
        assert accessToken != null && roomId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/deletesubanchor?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);

        post(url, json.toString());
    }

    /**
     * 获取主播副号
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#16">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @return 主播副号微信号
     */
    public String getSubAnchor(String accessToken, Integer roomId) {
        assert accessToken != null && roomId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/getsubanchor?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);

        String respStr = post(url, json.toString());
        return WxGsonBuilder.instance().fromJson(respStr, JsonObject.class).get("username").getAsString();
    }

    /**
     * 开启/关闭直播间官方收录
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#17">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param isFeedsPublic 是否开启官方收录 【1: 开启，0：关闭】
     */
    public void updateFeedPublic(String accessToken, Integer roomId, Integer isFeedsPublic) {
        assert accessToken != null && roomId != null && isFeedsPublic != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/updatefeedpublic?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("isFeedsPublic", isFeedsPublic);

        post(url, json.toString());
    }

    /**
     *  开启/关闭回放功能
     *  调用额度：10000次/一天
     *
     *  <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#18">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param closeReplay   是否关闭回放 【0：开启，1：关闭】
     */
    public void updateReplay(String accessToken, Integer roomId, Integer closeReplay) {
        assert accessToken != null && roomId != null && closeReplay != null;

        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/updatereplay?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("closeReplay", closeReplay);

        post(url, json.toString());
    }

    /**
     * 开启/关闭客服功能
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#19">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param closeKf   是否关闭客服 【0：开启，1：关闭】
     */
    public void updateKf(String accessToken, Integer roomId, Integer closeKf) {
        assert  accessToken != null && roomId != null && closeKf != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/updatekf?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("closeKf", closeKf);

        post(url, json.toString());
    }

    /**
     *  开启/关闭直播间全局禁言
     *  调用额度：10000次/一天
     *
     *  <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#20">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param banComment    1-禁言，0-取消禁言
     */
    public void updateComment(String accessToken, Integer roomId, Integer banComment) {
        assert  accessToken != null && roomId != null && banComment != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/room/updatecomment?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("banComment", banComment);

        post(url, json.toString());
    }

    /**
     * 上下架商品
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#21">参考文档</a>
     *
     * @param accessToken
     * @param roomId
     * @param goodsId
     * @param onSale
     */
    public void goodsOnSale(String accessToken, Integer roomId, Integer goodsId, Integer onSale) {
        assert accessToken != null && roomId != null && goodsId != null && onSale != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/onsale?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("goodsId", goodsId);
        json.addProperty("onSale", onSale);

        post(url, json.toString());
    }

    /**
     * 删除直播间商品
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#22">参考文档</a>
     *
     * @param accessToken
     * @param roomId
     * @param goodsId
     */
    public void goodsDeleteInRoom(String accessToken, Integer roomId, Integer goodsId) {
        assert accessToken != null && roomId != null && goodsId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/deleteInRoom?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("goodsId", goodsId);

        post(url, json.toString());
    }

    /**
     * 推送商品
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#23">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param goodsId   商品ID
     */
    public void goodsPush(String accessToken, Integer roomId, Integer goodsId) {
        assert accessToken != null && roomId != null && goodsId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/push?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("goodsId", goodsId);

        post(url, json.toString());
    }

    /**
     * 直播间商品排序
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#24">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param goodsIds  商品ID列表
     */
    public void goodsSort(String accessToken, Integer roomId, List<Integer> goodsIds) {
        assert accessToken != null && roomId != null && goodsIds != null;


        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/sort?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);

        JsonArray goodsIdArr = new JsonArray();
        for (Integer goodsId : goodsIds) {
            JsonObject goodsIdJson = new JsonObject();
            goodsIdJson.addProperty("goodsId", goodsId);
            goodsIdArr.add(goodsIdJson);
        }
        json.add("goods", goodsIdArr);

        post(url, json.toString());
    }

    /**
     * 下载商品讲解视频
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#25">参考文档</a>
     *
     * @param accessToken
     * @param roomId    房间ID
     * @param goodsId   商品ID
     * @return  讲解链接
     */
    public String goodsVideo(String accessToken, Integer roomId, Integer goodsId) {
        assert accessToken != null && roomId != null && goodsId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/getVideo?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("roomId", roomId);
        json.addProperty("goodsId", goodsId);

        String respStr = post(url, json.toString());

        return WxGsonBuilder.instance().fromJson(respStr, JsonObject.class).get("url").getAsString();

    }


}
