package top.codewood.wx.pay.v2.api;

import top.codewood.wx.pay.common.WxPayConfig;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.request.*;
import top.codewood.wx.pay.v2.bean.result.WxPayOrderCloseV2Result;
import top.codewood.wx.pay.v2.bean.result.WxPayRefundV2Result;
import top.codewood.wx.pay.v2.bean.result.WxPayUnifiedOrderV2Result;

import java.util.Map;

public class WxPayV2Service extends WxPayV2BaseService {


    private WxPayConfig wxPayConfig;

    public WxPayV2Service(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
    }


    /**
     * 统一下单
     * 除付款码支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再按Native、JSAPI、APP等不同场景生成交易串调起支付。
     *
     * @param unifiedOrderV2Request
     * @return
     */
    public WxPayUnifiedOrderV2Result unifiedOrder(WxPayUnifiedOrderV2Request unifiedOrderV2Request) {
        assert unifiedOrderV2Request != null && wxPayConfig != null;
        checkAndSign(unifiedOrderV2Request, wxPayConfig.getKey());
        return request(wxPayConfig, WxPayConstants.V2PayUrl.UNIFIED_ORDER_URL, unifiedOrderV2Request.toXml(), WxPayUnifiedOrderV2Result.class);
    }

    /**
     * 查询订单
     * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
     * 需要调用查询接口的情况：
     * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
     * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
     * ◆ 调用付款码支付API，返回USERPAYING的状态；
     * ◆ 调用关单或撤销接口API之前，需确认支付状态；
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2">参考文档</a>
     *
     * @param orderQueryV2Request
     * @return
     */
    public WxPayOrderCloseV2Result orderQuery(WxPayOrderQueryV2Request orderQueryV2Request) {
        assert orderQueryV2Request != null && wxPayConfig != null;
        checkAndSign(orderQueryV2Request, wxPayConfig.getKey());
        return request(wxPayConfig, WxPayConstants.V2PayUrl.ORDER_QUERY_URL, orderQueryV2Request.toXml(), WxPayOrderCloseV2Result.class);

    }

    /**
     * 关闭订单
     * 以下情况需要调用关单接口：商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
     * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_3">参考文档</a>
     *
     * @param orderCloseV2Request
     * @return
     */
    public WxPayOrderCloseV2Result closeOrder(WxPayOrderCloseV2Request orderCloseV2Request) {
        assert orderCloseV2Request != null && wxPayConfig != null;
        checkAndSign(orderCloseV2Request, wxPayConfig.getKey());
        return request(wxPayConfig, WxPayConstants.V2PayUrl.ORDER_CLOSE_URL, orderCloseV2Request.toXml(), WxPayOrderCloseV2Result.class);

    }

    /**
     * 申请退款
     * 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。
     *
     * 注意：
     * 1、交易时间超过一年的订单无法提交退款
     * 2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。申请退款总金额不能超过订单金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号
     * 3、请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次
     *     错误或无效请求频率限制：6qps，即每秒钟异常或错误的退款申请请求不超过6次
     * 4、每个支付订单的部分退款次数不能超过50次
     * 5、如果同一个用户有多笔退款，建议分不同批次进行退款，避免并发退款导致退款失败
     * 6、申请退款接口的返回仅代表业务的受理情况，具体退款是否成功，需要通过退款查询接口获取结果。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4">参考文档</a>
     *
     * @param refundV2Request
     * @return
     */
    public WxPayRefundV2Result refund(WxPayRefundV2Request refundV2Request) {
        assert refundV2Request != null && wxPayConfig != null;
        checkAndSign(refundV2Request, wxPayConfig.getKey());
        return requestWithCert(wxPayConfig, WxPayConstants.V2PayUrl.REFUND_URL, refundV2Request.toXml(), WxPayRefundV2Result.class);
    }

    /**
     * 查询退款
     * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
     *
     * 注意：如果单个支付订单部分退款次数超过20次请使用退款单号查询
     *
     * 分页查询
     * 当一个订单部分退款超过10笔后，商户用微信订单号或商户订单号调退款查询API查询退款时，默认返回前10笔和total_refund_count（订单总退款次数）。商户需要查询同一订单下超过10笔的退款单时，可传入订单号及offset来查询，微信支付会返回offset及后面的10笔，以此类推。当商户传入的offset超过total_refund_count，则系统会返回报错PARAM_ERROR。
     * 举例：
     * 一笔订单下的退款单有36笔，当商户想查询第25笔时，可传入订单号及offset=24，微信支付平台会返回第25笔到第35笔的退款单信息，或商户可直接传入退款单号查询退款
     *
     * @param refundQueryV2Request
     * @return
     */
    public WxPayRefundV2Result refundQuery(WxPayRefundQueryV2Request refundQueryV2Request) {
        assert refundQueryV2Request != null && wxPayConfig != null;
        checkAndSign(refundQueryV2Request, wxPayConfig.getKey());
        return request(wxPayConfig, WxPayConstants.V2PayUrl.REFUND_URL, refundQueryV2Request.toXml(), WxPayRefundV2Result.class);
    }

    public String sign(Map map) {
        return sign(map, wxPayConfig.getKey());
    }

    public String sign(Object object) {
        return sign(object, wxPayConfig.getKey());
    }
}
