package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.mnp.bean.immediatedelivery.*;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.util.List;

public class WxMnpImmediateDeliveryApi extends WxBaseHttpApi {

    private static class Holder {
        private static WxMnpImmediateDeliveryApi INSTANCE = new WxMnpImmediateDeliveryApi();
    }

    public static WxMnpImmediateDeliveryApi getInstance() { return Holder.INSTANCE; }

    private void handleResponse(String respStr) {
        JsonObject json = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        if (json.get("resultcode").getAsInt() != 0) {
            throw new WxErrorException(json.get("resultmsg").getAsString());
        }
    }

    /**
     * immediateDelivery.abnormalConfirm
     * 异常件退回商家商家确认收货接口
     *
     * 当订单配送异常，骑手把货物退还给商家，商家收货以后调用本接口返回确认收货。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.abnormalConfirm.html">参考文档</a>
     *
     * @param accessToken
     * @param immeAbnormalConfirmRequest
     */
    public void abnormalConfirm(String accessToken, ImmeAbnormalConfirmRequest immeAbnormalConfirmRequest) {
        assert accessToken != null && immeAbnormalConfirmRequest != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/order/confirm_return?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(immeAbnormalConfirmRequest));
        handleResponse(respStr);
    }

    /**
     * immediateDelivery.addOrder
     * 下配送单接口
     *
     * 商家可调用本接口向配送公司请求下配送单，配送公司会返回这一单的配送单号、配送费、预计骑手接单时间等信息。
     * 如遇下单错误，请先确认一下编码方式，python建议 json.dumps(b, ensure_ascii=False)，php建议 json_encode($arr, JSON_UNESCAPED_UNICODE) 可预约时间：达达：72小时内，闪送2小时以后，48小时以内
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.addOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param immeAddOrderRequest
     * @return
     */
    public ImmeAddOrderResult addOrder(String accessToken, ImmeAddOrderRequest immeAddOrderRequest) {
        assert accessToken != null && immeAddOrderRequest != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/order/add?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(immeAddOrderRequest));
        handleResponse(respStr);
        return WxGsonBuilder.instance().fromJson(respStr, ImmeAddOrderResult.class);
    }

    /**
     * immediateDelivery.addTip
     * 可以对待接单状态的订单增加小费。需要注意：订单的小费，以最新一次加小费动作的金额为准，故下一次增加小费额必须大于上一次小费额
     *
     * 调用本接口，可以给待接单状态的订单增加小费，各家配送公司增加消费的规则如下：
     *
     * 配送公司	加小费规则
     * 顺丰同城急送	支持加小费，小费规则：骑手接单前可加小费，上限10次，200元封顶
     * 闪送	支持加小费，小费规则：骑手接单前可加小费，需按固定档位加小费，档位为2、3、5、10、15、20、50、100
     * 美团配送	不支持加小费
     * 达达配送	支持加小费，小费规则：骑手接单前可加小费，小费金额以最新一次为准，同一单新增的小费额须大于上一次的小费额，小费不可以超过货值，上限30元
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.addTip.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     */
    public void addTip(String accessToken, ImmeAddTipRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/order/addtips?access_token=%s", accessToken);

        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        handleResponse(respStr);
    }

    /**
     * immediateDelivery.bindAccount
     * 第三方代商户发起绑定配送公司帐号的请求
     *
     * 只能由第三方服务商调用此接口
     * 服务商可通过本接口代开发的小程序发起绑定配送公司帐号的操作，当调用成功，小程序管理员将收到模版消息，点击详情进入配送公司网站进行绑定操作
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.bindAccount.html">参考文档</a>
     *
     * @param accessToken
     * @param deliveryId 配送公司ID
     *
     */
    public void bindAccount(String accessToken, String deliveryId) {
        assert accessToken != null && deliveryId != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/shop/add?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("delivery_id", deliveryId);

        String respStr = post(url, json.getAsString());
        handleResponse(respStr);
    }

    /**
     * immediateDelivery.cancelOrder
     * 取消配送单接口
     *
     * 调用本接口可向配送公司请求取消配送单，各家取消规则如下：
     *
     * 顺丰同城急送: 配送完成前任意节点可取消配送单;
     * 闪送: 配送完成前任意节点可取消配送单;
     * 美团配送: 配送完成前任意节点可取消配送单;
     * 达达: 骑手取货之前可取消配送单;
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.cancelOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public ImmeCancelOrderResult cancelOrder(String accessToken, ImmeCancelOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/order/cancel?access_token=%s", accessToken);

        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        handleResponse(respStr);

        return WxGsonBuilder.instance().fromJson(respStr, ImmeCancelOrderResult.class);
    }

    /**
     * immediateDelivery.getAllImmeDelivery
     * 获取已支持的配送公司列表接口
     *
     * 查询即时配送接口已支持的配送公司和delivery_id
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.getAllImmeDelivery.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public List<ImmeDeliveryCompany> getAllImmeDelivery(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/delivery/getall?access_token=%s", accessToken);

        String respStr = get(url);
        handleResponse(respStr);

        JsonObject json = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return WxGsonBuilder.instance().fromJson(json.getAsJsonArray("list"), List.class);
    }

    /**
     * immediateDelivery.getBindAccount
     * 拉取已绑定账号
     *
     * 使用场景
     * 1、商家可通过本接口查询自己已经在小程序后台绑定的和配送公司签约的账号；
     * 2、服务商可通过本接口查询代开发的小程序在小程序后台绑定的和配送公司签约的账号，为其完成后续的接口代开发业务。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.getBindAccount.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public List<ImmeShop> getBindAccount(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/shop/get?access_token=%s", accessToken);
        String respStr = post(url, "");
        handleResponse(respStr);

        JsonObject json = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return WxGsonBuilder.instance().fromJson(json.getAsJsonArray("shop_list"), List.class);
    }

    /**
     * immediateDelivery.getOrder
     * 拉取配送单信息
     * 商家可使用本接口查询某一配送单的配送状态，便于商家掌握配送情况。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.getOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public ImmeGetOrderResult getOrder(String accessToken, ImmeGetOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/order/get?access_token=%s", accessToken);

        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        handleResponse(respStr);

        return WxGsonBuilder.instance().fromJson(respStr, ImmeGetOrderResult.class);
    }

    /**
     * immediateDelivery.mockUpdateOrder
     * 该接口只能用于测试
     *
     * 模拟配送公司更新配送单状态, 该接口只用于沙盒环境，即订单并没有真实流转到运力方
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.mockUpdateOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     */
    public void mockUpdateOrder(String accessToken, ImmeMockUpdateOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/test_update_order?access_token=%s", accessToken);

        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        handleResponse(respStr);
    }

    /**
     * immediateDelivery.openDelivery
     * 第三方代商户发起开通即时配送权限
     *
     * 使用场景
     * 1、只能由第三方服务商调用此接口
     * 2、服务商可通过本接口代开发的小程序发起开通即时配送接口权限的操作，当调用成功，小程序管理员将收到模版消息，进行开通操作
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.openDelivery.html">参考文档</a>
     *
     * @param accessToken
     */
    public void openDelivery(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/open?access_token=%s", accessToken);

        String respStr = post(url, "");
        handleResponse(respStr);
    }


    /**
     * immediateDelivery.preAddOrder
     * 预下配送单接口
     *
     * 使用场景
     * 1、在用户提交外卖订单时，商家可调用本接口查询配送公司是否可接单、预计多久接单、运费预估等。预估运费可作为展示给用户的运费参考值。
     * 2、举个例子：商家通过预下配送单接口返回的预估运费是8元，商家可决定前端顾客下外卖单时展示给顾客看的运费是真实的8元，还是其他商家指定的金额。
     * 3、说明：本接口非必须调用接口，若不需要获取配送公司是否可接单、预计多久接单、运费预估等，也可不调用本接口，直接下配送单。
     * 4、顺丰同城可返回配送费用、配送距离、预计骑手接单时间，不支持返回delivery_token。
     * 5、闪送可返回配送费用、配送距离、预计骑手接单时间，不支持返回delivery_token。
     * 6、美团配送返回0时表示校验通过，不支持返回配送费用、配送距离、预计骑手接单时间和delivery_token。
     * 7、达达支持预下单查询配送费用、配送距离、预计骑手接单时间和delivery_token(有效期3分钟)。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.preAddOrder.html">参考文档</a>
     *
     * @param accessToken
     * @return
     */
    public ImmePreAddOrderResult preAddOrder(String accessToken, ImmeAddOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/order/pre_add?access_token=%s", accessToken);

        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        handleResponse(respStr);
        return WxGsonBuilder.instance().fromJson(respStr, ImmePreAddOrderResult.class);
    }

    /**
     * immediateDelivery.preCancelOrder
     * 预取消配送单接口
     *
     * 使用场景：
     * 在正式取消配送单前，商家可调用本接口查询该订单是否可以取消，取消订单配送公司需要扣除的费用是多少。各家取消规则如下：
     * 顺丰同城急送: 配送完成前任意节点可取消配送单;
     * 闪送: 配送完成前任意节点可取消配送单;
     * 美团配送: 配送完成前任意节点可取消配送单;
     * 达达: 骑手取货之前可取消配送单;
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.preCancelOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     */
    public ImmeCancelOrderResult preCancelOrder(String accessToken, ImmeCancelOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/order/precancel?access_token=%s", accessToken);

        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        handleResponse(respStr);
        return WxGsonBuilder.instance().fromJson(respStr, ImmeCancelOrderResult.class);

    }

    /**
     * immediateDelivery.realMockUpdateOrder
     * 模拟配送公司更新配送单状态, 该接口用于测试账户下的单，将请求转发到运力测试环境
     *
     * 使用场景
     * 该接口只能用于测试,请求会转发到运力测试环境, 目前支持顺丰同城和达达:
     * 1、顺丰同城测试号
     *  - shopid: 1534713176,
     *  - appsecret: d80400f91e156f63b38886e616d84590
     *  - shopno: 3243279847393
     *  - 支持变更状态: 102 202 202 302
     * 2、达达测试号
     *  - shopid: dadaaee18818d97e236,
     *  - appsecret: 1c6f40492d6d89caaad80b85f7d31670
     *  - shopno: 77071-47913
     *  - 支持变更状态: 102 201 202 301 302 304 30
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.realMockUpdateOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     */
    public void realMockUpdateOrder(String accessToken, ImmeMockUpdateOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/realmock_update_order?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        handleResponse(respStr);
    }

    /**
     * immediateDelivery.reOrder
     * 重新下单
     * 在调用下配送单接口、订单被取消、过期或者投递异常的情况下，可调用此接口，重新下单，需要保持orderid一致。 备注：美团不支持重新下单接口，如果订单被取消商家需要重新下单，请修改orderid之后，调用下配送单接口下单。
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/immediate-delivery/by-business/immediateDelivery.reOrder.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     */
    public ImmeAddOrderResult reOrder(String accessToken, ImmeAddOrderRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/express/local/business/order/readd?access_token=%s", accessToken);

        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        handleResponse(respStr);

        return WxGsonBuilder.instance().fromJson(respStr, ImmeAddOrderResult.class);
    }

}
