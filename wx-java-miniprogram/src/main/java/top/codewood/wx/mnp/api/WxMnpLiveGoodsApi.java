package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.live.WxMnpGoodsWareHouseResult;
import top.codewood.wx.mnp.bean.live.WxMnpLiveGoodsAddResult;
import top.codewood.wx.mnp.bean.live.WxMnpLiveGoodsInfo;
import top.codewood.wx.mnp.bean.live.WxMnpLiveGoodsListResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小程序直播-商品管理接口
 *
 * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html">参考文档</a>
 */
public class WxMnpLiveGoodsApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpLiveGoodsApi INSTANCE = new WxMnpLiveGoodsApi();
    }

    public static WxMnpLiveGoodsApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 商品添加并提审
     * 调用此接口上传并提审需要直播的商品信息，审核通过后商品录入【小程序直播】商品库
     * 注意：开发者必须保存【商品ID】与【审核单ID】，如果丢失，则无法调用其他相关接口
     * 调用额度：500次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html#1">参考文档</a>
     *
     * @param accessToken
     * @param goodsInfo
     * @return
     */
    public WxMnpLiveGoodsAddResult add(String accessToken, WxMnpLiveGoodsInfo goodsInfo) {
        assert accessToken != null && goodsInfo != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/add?access_token=%s", accessToken);

        Map<String, Object> map = new HashMap<>();
        map.put("goodsInfo", goodsInfo);

        String respStr = post(url, WxGsonBuilder.instance().toJson(map));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveGoodsAddResult.class);
    }

    /**
     * 撤回审核
     * 调用此接口，可撤回直播商品的提审申请，消耗的提审次数不返还
     * 调用额度：500次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html#2">参考文档</a>
     *
     * @param accessToken
     * @param goodsId     商品ID
     * @param auditId     审核单ID
     */
    public void resetAudit(String accessToken, Integer goodsId, Integer auditId) {
        assert accessToken != null && goodsId != null && auditId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/resetaudit?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("auditId", auditId);
        json.addProperty("goodsId", goodsId);

        post(url, json.toString());
    }

    /**
     * 重新提交审核
     * 调用此接口可以对已撤回提审的商品再次发起提审申请
     * 调用额度：500次/一天（与接口1共用500次限制）
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html#3">参考文档</a>
     *
     * @param accessToken
     * @param goodsId
     * @return 审核单ID
     */
    public String audit(String accessToken, Integer goodsId) {
        assert accessToken != null && goodsId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/audit?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("goodsId", goodsId);

        String respStr = post(url, json.toString());

        return WxGsonBuilder.instance().fromJson(respStr, JsonObject.class).get("auditId").getAsString();
    }

    /**
     * 删除商品
     * 调用此接口，可删除【小程序直播】商品库中的商品，删除后直播间上架的该商品也将被同步删除，不可恢复；
     * 调用额度：1000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html#4">参考文档</a>
     *
     * @param accessToken
     * @param goodsId   商品ID
     */
    public void delete(String accessToken, Integer goodsId) {
        assert accessToken != null && goodsId != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/delete?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("goodsId", goodsId);

        post(url, json.toString());
    }

    /**
     * 更新商品
     * 调用此接口可以更新商品信息，审核通过的商品仅允许更新价格类型与价格，审核中的商品不允许更新，未审核的商品允许更新所有字段， 只传入需要更新的字段。
     * 调用额度：1000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html#5">参考文档</a>
     *
     * @param accessToken
     * @param goodsInfo
     */
    public void update(String accessToken, WxMnpLiveGoodsInfo goodsInfo) {
        assert accessToken != null && goodsInfo != null;
        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/update?access_token=%s", accessToken);

        Map<String, Object> map = new HashMap<>();
        map.put("goodsInfo", goodsInfo);

        post(url, WxGsonBuilder.instance().toJson(map));
    }

    /**
     * 获取商品状态
     * 调用此接口可获取商品的信息与审核状态
     * 调用额度：1000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html#6">参考文档</a>
     *
     * @param accessToken
     * @param goodsIds
     * @return
     */
    public WxMnpGoodsWareHouseResult getGoodsWareHouse(String accessToken, List<Integer> goodsIds) {
        assert accessToken != null && goodsIds != null && goodsIds.size() > 0;

        String url = String.format("https://api.weixin.qq.com/wxa/business/getgoodswarehouse?access_token=%s", accessToken);

        Map<String, Object> map = new HashMap<>();
        map.put("goods_ids", goodsIds);

        String respStr = post(url, WxGsonBuilder.instance().toJson(map));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpGoodsWareHouseResult.class);
    }

    /**
     * 获取商品列表
     * 调用此接口可获取商品列表
     * 调用额度：10000次/一天
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/commodity-api.html#7">参考文档</a>
     *
     * @param accessToken
     * @param offset    分页条数起点
     * @param limit     分页大小，默认30，不超过100
     * @param status    商品状态，0：未审核。1：审核中，2：审核通过，3：审核驳回
     * @return
     */
    public WxMnpLiveGoodsListResult list(String accessToken, Integer offset, Integer limit, Integer status) {
        assert accessToken != null && offset != null && status != null;

        String url = String.format("https://api.weixin.qq.com/wxaapi/broadcast/goods/getapproved?access_token=%s", accessToken);

        Map<String, Object> map = new HashMap<>();
        map.put("offset", offset);
        map.put("limit", limit);
        map.put("status", status);

        String respStr = post(url, WxGsonBuilder.instance().toJson(map));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpLiveGoodsListResult.class);
    }


}
