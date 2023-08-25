package top.codewood.wx.pay.v3.api;

import com.google.gson.JsonObject;
import top.codewood.wx.pay.v3.bean.profitsharing.*;
import top.codewood.wx.pay.v3.common.WxPayConfig;
import top.codewood.wx.pay.v3.util.json.WxV3GsonBuilder;

public class ProfitSharingV3Service {

    private WxPayConfig wxPayConfig;
    public ProfitSharingV3Service(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
    }

    /**
     * 请求分账API
     * 微信订单支付成功后，商户发起分账请求，将结算后的资金分到分账接收方
     *
     * 注意：
     * • 对同一笔订单最多能发起50次分账请求，每次请求最多分给50个接收方
     * • 此接口采用异步处理模式，即在接收到商户请求后，优先受理请求再异步处理，最终的分账结果可以通过查询分账接口获取
     * • 商户需确保向微信支付传输用户身份信息和账号标识信息做一致性校验已合法征得用户授权
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_1.shtml">开发文档</a>
     * @param request
     * @return
     */
    public ProfitSharingV3Result request(ProfitSharingV3Request request) {
        assert wxPayConfig != null && request != null;
        String url = "https://api.mch.weixin.qq.com/v3/profitsharing/orders";
        return WxPayV3Api.postForResult(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, WxV3GsonBuilder.getInstance().toJson(request), ProfitSharingV3Result.class);
    }

    /**
     * 查询分账结果API
     * 发起分账请求后，可调用此接口查询分账结果
     *
     * 注意：
     * • 发起解冻剩余资金请求后，可调用此接口查询解冻剩余资金的结果
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_2.shtml">开发文档</a>
     *
     * @param transactionId 微信订单号
     * @param outOrderNo 商户分账单号 查询分账结果，输入申请分账时的商户分账单号； 查询分账完结执行的结果，输入发起分账完结时的商户分账单号。
     * @return
     */
    public ProfitSharingV3Result query(String transactionId, String outOrderNo) {
        assert wxPayConfig != null && transactionId != null && outOrderNo != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/profitsharing/orders/%s?transation_id=%s", outOrderNo, transactionId);
        return WxPayV3Api.getForResult(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, ProfitSharingV3Result.class);
    }

    /**
     * 请求分账回退API
     * 如果订单已经分账，在退款时，可以先调此接口，将已分账的资金从分账接收方的账户回退给分账方，再发起退款。
     *
     * 注意：
     * • 分账回退以原分账单为依据，支持多次回退，申请回退总金额不能超过原分账单分给该接收方的金额。
     * • 此接口采用同步处理模式，即在接收到商户请求后，会实时返回处理结果。
     * • 对同一个分账接收方最多能发起20次分账回退请求。
     * • 退款和分账回退没有耦合，分账回退可以先于退款请求，也可以后于退款请求。
     * • 此功能需要接收方访问商户平台-交易中心-分账-分账接收设置，开启同意分账回退后，才能使用。
     * • 不支持针对“分账到零钱”的分账单发起分账回退。
     * • 分账回退的时限是180天。
     *
     * @param request
     * @return
     */
    public ProfitSharingReturnV3Result returnRequest(ProfitSharingReturnV3Request request) {
        assert wxPayConfig != null && request != null;
        String url = "https://api.mch.weixin.qq.com/v3/profitsharing/return-orders";
        return WxPayV3Api.postForResult(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, WxV3GsonBuilder.getInstance().toJson(request), ProfitSharingReturnV3Result.class);
    }

    /**
     * 查询分账回退结果API
     * 商户需要核实回退结果，可调用此接口查询回退结果
     *
     * 注意：
     * • 如果分账回退接口返回状态为处理中，可调用此接口查询回退结果
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_4.shtml">开发文档</a>
     *
     * @param outOrderNo 商户分账单号 原发起分账请求时使用的商户系统内部的分账单号
     * @param outReturnNo 商户回退单号 调用回退接口提供的商户系统内部的回退单号
     * @return
     */
    public ProfitSharingReturnV3Result returnQuery(String outOrderNo, String outReturnNo) {
        assert wxPayConfig != null && outOrderNo != null && outReturnNo != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/profitsharing/return-orders/%s?out_order_no=%s");
        return WxPayV3Api.getForResult(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, ProfitSharingReturnV3Result.class);
    }

    /**
     * 解冻剩余资金API
     * 不需要进行分账的订单，可直接调用本接口将订单的金额全部解冻给本商户
     *
     * 注意：
     * • 调用分账接口后，需要解冻剩余资金时，调用本接口将剩余的分账金额全部解冻给本商户
     * • 此接口采用异步处理模式，即在接收到商户请求后，优先受理请求再异步处理，最终的分账结果可以通过查询分账接口获取
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_5.shtml">开发文档</a>
     *
     * @param transactionId 必填 微信订单号
     * @param outOrderNo 必填 商户分账单号 商户系统内部的分账单号，在商户系统内部唯一，同一分账单号多次请求等同一次。只能是数字、大小写字母_-|*@
     * @param description 比填 分账描述 分账的原因描述，分账账单中需要体现
     * @return
     */
    public ProfitSharingV3Result unfreeze(String transactionId, String outOrderNo, String description) {
        assert wxPayConfig != null && transactionId != null && outOrderNo != null && description != null;

        JsonObject paramJson = new JsonObject();
        paramJson.addProperty("transaction_id", transactionId);
        paramJson.addProperty("out_order_no", outOrderNo);
        paramJson.addProperty("description", description);

        String url = "https://api.mch.weixin.qq.com/v3/profitsharing/orders/unfreeze";

        return WxPayV3Api.postForResult(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, paramJson.toString(), ProfitSharingV3Result.class);
    }

    /**
     * 查询剩余待分金额API
     * 可调用此接口查询订单剩余待分金额
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_6.shtml">开发文档</a>
     *
     * @param transactionId 微信支付订单号
     * @return 订单剩余待分金额 整数，单元为分
     */
    public Integer queryUnSplitAmount(String transactionId) {
        assert wxPayConfig != null && transactionId != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/profitsharing/transactions/%s/amounts", transactionId);

        JsonObject retJson = WxPayV3Api.getForResult(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, JsonObject.class);
        return retJson.get("unsplit_amount").getAsInt();
    }

    /**
     * 添加分账接收方API
     * 商户发起添加分账接收方请求，建立分账接收方列表。后续可通过发起分账请求，将分账方商户结算后的资金，分到该分账接收方
     *
     * 注意：
     * • 商户需确保向微信支付传输用户身份信息和账号标识信息做一致性校验已合法征得用户授权
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_8.shtml">开发文档</a>
     *
     * @param request
     */
    public void addReceiver(ProfitSharingReceiverAddV3Request request) {
        assert wxPayConfig != null && request != null;
        String url = "https://api.mch.weixin.qq.com/v3/profitsharing/receivers/add";
        WxPayV3Api.post(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, WxV3GsonBuilder.getInstance().toJson(request));
    }

    /**
     * 删除分账接收方API
     * 商户发起删除分账接收方请求。删除后，不支持将分账方商户结算后的资金，分到该分账接收方
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_9.shtml">开发文档</a>
     *
     * @param appid 微信分配的公众账号ID
     * @param type 分账接收方类型 枚举值：
     * MERCHANT_ID：商户ID
     * PERSONAL_OPENID：个人openid（由父商户APPID转换得到）
     * @param account 分账接收方账号 类型是MERCHANT_ID时，是商户号
     * 类型是PERSONAL_OPENID时，是个人openid
     */
    public void delReceiver(String appid, String type, String account) {
        assert wxPayConfig != null && type != null && account != null;

        JsonObject paramJson = new JsonObject();
        paramJson.addProperty("appid", appid);
        paramJson.addProperty("type", type);
        paramJson.addProperty("account", account);

        String url = "https://api.mch.weixin.qq.com/v3/profitsharing/receivers/delete";

        WxPayV3Api.post(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, paramJson.toString());
    }


}
