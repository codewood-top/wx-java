package top.codewood.wx.mnp.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.express.business.*;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.math.BigDecimal;

/**
 * 物流助手
 * 小程序端使用
 *
 */
public class WxMnpExpressBusinessApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpExpressBusinessApi INSTANCE = new WxMnpExpressBusinessApi();
    }

    public static WxMnpExpressBusinessApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * logistics.addOrder
     * 生成运单
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.addOrder.html">参考文档</a>
     */
    public WxMnpExpressAddOrderResult addOrder(String accessToken, WxMnpExpressAddOrderRequest request) {
        assert accessToken != null && request != null;
        String url  =String.format("https://api.weixin.qq.com/cgi-bin/express/business/order/add?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressAddOrderResult.class);
    }

    /**
     * logistics.batchGetOrder
     * 批量获取运单数据
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.batchGetOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public WxMnpExpressBatchGetOrderResult batchGetOrder(String accessToken, WxMnpExpressBatchGetOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/order/batchget?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressBatchGetOrderResult.class);
    }


    /**
     * logistics.bindAccount
     * 绑定、解绑物流账号
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.bindAccount.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     */
    public void bindAccount(String accessToken, WxMnpExpressBindAccountRequest request) {
       assert accessToken != null && request != null;
       String url =  String.format("https://api.weixin.qq.com/cgi-bin/express/business/account/bind?access_token=%s", accessToken);
       post(url, WxGsonBuilder.instance().toJson(request));
    }

    /**
     * logistics.cancelOrder
     * 取消运单
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.cancelOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public WxMnpExpressCancelOrderResult cancelOrder(String accessToken, WxMnpExpressCancelOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/order/cancel?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressCancelOrderResult.class);
    }

    /**
     * logistics.getAllAccount
     * 获取所有绑定的物流账号
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getAllAccount.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public WxMnpExpressGetAllAccountResult getAllAccount(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/account/getall?access_token=%s", accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressGetAllAccountResult.class);
    }

    /**
     * logistics.getAllDelivery
     * 获取支持的快递公司列表
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getAllDelivery.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public WxMnpExpressGetAllDeliveryResult getAllDelivery(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/delivery/getall?access_token=%s", accessToken);
        String respStr =  get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressGetAllDeliveryResult.class);
    }

    /**
     * logistics.getOrder
     * 获取运单数据
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public WxMnpExpressGetOrderResult getOrder(String accessToken, WxMnpExpressGetOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/order/get?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressGetOrderResult.class);
    }


    /**
     * logistics.getPath
     * 查询运单轨迹
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getPath.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public WxMnpExpressGetPathResult getPath(String accessToken, WxMnpExpressGetPathRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/path/get?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressGetPathResult.class);
    }


    /**
     * logistics.getPrinter
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getPrinter.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public WxMnpExpressGetPrinterResult getPrinter(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/printer/getall?access_token=%s", accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpExpressGetPrinterResult.class);
    }

    /**
     * logistics.getQuota
     * 获取电子面单余额。仅在使用加盟类快递公司时，才可以调用。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getQuota.html">参考文档</a>
     *
     * @param accessToken
     * @param deliveryId 必填，快递公司ID，参见getAllDelivery
     * @param bizId 必填，快递公司客户编码
     * @return 电子面单余额
     */
    public BigDecimal getQuota(String accessToken, String deliveryId, String bizId) {
        assert accessToken != null && deliveryId != null && bizId != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/quota/get?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("delivery_id", deliveryId);
        json.addProperty("biz_id", bizId);

        String respStr = json.getAsString();

        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);

        return respJson.get("quota_num").getAsBigDecimal();
    }

    /**
     * logistics.updatePrinter
     * 配置面单打印员，可以设置多个，若需要使用微信打单 PC 软件，才需要调用。<br>注：面单打印员不需要为小程序项目成员。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.updatePrinter.html">参考文档</a>
     *
     * @param accessToken
     * @param openid    打印员 openid
     * @param updateType   更新类型：bind -> 绑定，unbind -> 解除绑定
     * @param tagidList     用于平台型小程序设置入驻方的打印员面单打印权限，同一打印员最多支持10个tagid，使用半角逗号分隔，中间不加空格，如填写123,456，表示该打印员可以拉取到 tagid 为123和456的下的单，非平台型小程序无需填写该字段
     */
    public void updatePrinter(String accessToken, String openid, String updateType, String tagidList) {
        assert accessToken != null && openid != null && updateType != null && tagidList != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/business/printer/update?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("openid", openid);
        json.addProperty("update_type", updateType);
        json.addProperty("tagid_list", tagidList);
        post(url, json.getAsString());
    }




}
