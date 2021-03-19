package top.codewood.wx.pay.v2.api;

import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.common.util.xml.XStreamConverter;
import top.codewood.wx.pay.v2.common.WxPayConfig;
import top.codewood.wx.pay.v2.common.WxPayConstants;
import top.codewood.wx.pay.v2.common.WxPayHttpClient;
import top.codewood.wx.pay.v2.bean.profitsharing.*;

public class ProfitSharingV2Service extends WxPayV2BaseService {

    private WxPayConfig wxPayConfig;

    public ProfitSharingV2Service(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
    }

    @Override
    WxPayConfig getWxPayConfig() {
        return wxPayConfig;
    }

    /**
     * 请求单次分账
     * 单次分账请求按照传入的分账接收方账号和资金进行分账，同时会将订单剩余的待分账金额解冻给本商户。故操作成功后，订单不能再进行分账，也不能进行分账完结。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_1&index=1">开发文档</a>
     *
     * @param profitSharingRequest
     * @return
     */
    public ProfitSharingResult request(ProfitSharingRequest profitSharingRequest) {
        assert profitSharingRequest != null;
        checkAndSign(profitSharingRequest, wxPayConfig.getKey());
        return requestWithCert(wxPayConfig, WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_URL, profitSharingRequest.toXml(), ProfitSharingResult.class);
    }

    /**
     * 请求多次分账
     * ● 微信订单支付成功后，商户发起分账请求，将结算后的钱分到分账接收方。多次分账请求仅会按照传入的分账接收方进行分账，不会对剩余的金额进行任何操作。故操作成功后，在待分账金额不等于零时，订单依旧能够再次进行分账。
     * ● 多次分账，可以将本商户作为分账接收方直接传入，实现释放资金给本商户的功能
     * ● 对同一笔订单最多能发起20次多次分账请求
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_6&index=2">开发文档</a>
     *
     * @param profitSharingRequest
     * @return
     */
    public ProfitSharingResult multiRequest(ProfitSharingRequest profitSharingRequest) {
        assert profitSharingRequest != null;
        checkAndSign(profitSharingRequest, wxPayConfig.getKey());
        return requestWithCert(wxPayConfig, WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_MULTI_URL, profitSharingRequest.toXml(), ProfitSharingResult.class);
    }

    /**
     * 查询分账结果
     * 发起分账请求后，可调用此接口查询分账结果；发起分账完结请求后，可调用此接口查询分账完结的执行结果。
     * 接口频率：80QPS
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_2&index=3">开发文档</a>
     *
     * @param queryRequest
     * @return
     */
    public ProfitSharingQueryResult query(ProfitSharingQueryRequest queryRequest) {
        assert queryRequest != null;
        checkAndSign(queryRequest, wxPayConfig.getKey());
        return request(wxPayConfig, WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_QUERY_URL, queryRequest.toXml(), ProfitSharingQueryResult.class);
    }

    /**
     * 添加分账接收方
     * 商户发起添加分账接收方请求，后续可通过发起分账请求将结算后的钱分到该分账接收方。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_3&index=4">参考文档</a>
     *
     * @param receiverRequest
     * @return
     */
    public ProfitSharingReceiverResult addReceiver(ProfitSharingReceiverRequest receiverRequest) {
        assert receiverRequest != null;
        checkAndSign(receiverRequest, wxPayConfig.getKey());
        return request(wxPayConfig, WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_ADD_RECEIVER_URL, receiverRequest.toXml(), ProfitSharingReceiverResult.class);
    }

    /**
     * 删除分账接收方
     * 商户发起删除分账接收方请求，删除后不支持将结算后的钱分到该分账接收方。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_4&index=5">参考文档</a>
     *
     * @param receiverRequest
     * @return
     */
    public ProfitSharingReceiverResult removeReceiver(ProfitSharingReceiverRequest receiverRequest) {
        assert receiverRequest != null;
        checkAndSign(receiverRequest, wxPayConfig.getKey());
        return request(wxPayConfig, WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_REMOVE_RECEIVER_URL, receiverRequest.toXml(), ProfitSharingReceiverResult.class);
    }

    /**
     * 完结分账
     * 1、不需要进行分账的订单，可直接调用本接口将订单的金额全部解冻给本商户
     * 2、调用多次分账接口后，需要解冻剩余资金时，调用本接口将剩余的分账金额全部解冻给特约商户
     * 3、已调用请求单次分账后，剩余待分账金额为零，不需要再调用此接口。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_5&index=6">参考文档</a>
     *
     * @param finishRequest
     * @return
     */
    public ProfitSharingResult finish(ProfitSharingFinishRequest finishRequest) {
        assert finishRequest != null;
        checkAndSign(finishRequest, wxPayConfig.getKey());
        return requestWithCert(wxPayConfig, WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_FINISH_URL, finishRequest.toXml(), ProfitSharingResult.class);
    }

    /**
     * 查询订单待分账金额
     * 商户可通过调用此接口查询订单剩余待分金额。
     * 接口频率：30QPS
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_10&index=7">开发文档</a>
     *
     * @param amountQueryRequest
     * @return
     */
    public ProfitSharingAmountQueryResult orderAmountQuery(ProfitSharingAmountQueryRequest amountQueryRequest) {
        assert amountQueryRequest != null;
        try {
            checkAndSign(amountQueryRequest, wxPayConfig.getKey());
            String respStr = new WxPayHttpClient(wxPayConfig).requestWithoutCert(WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_ORDER_AMOUNT_QUERY_URL, amountQueryRequest.toXml());
            ProfitSharingAmountQueryResult amountQueryResult = XStreamConverter.fromXml(ProfitSharingAmountQueryResult.class, respStr);
            return amountQueryResult;
        } catch (WxErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 分账回退
     * ● 对订单进行退款时，如果订单已经分账，可以先调用此接口将指定的金额从分账接收方（仅限商户类型的分账接收方）回退给本商户，然后再退款。
     * ● 回退以原分账请求为依据，可以对分给分账接收方的金额进行多次回退，只要满足累计回退不超过该请求中分给接收方的金额。
     * ● 此接口采用同步处理模式，即在接收到商户请求后，会实时返回处理结果
     * ● 此功能需要接收方在商户平台-交易中心-分账-分账接收设置下，开启同意分账回退后，才能使用。
     * 接口频率：30QPS
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_7&index=8">开发文档</a>
     *
     * @param resultRequest
     * @return
     */
    public ProfitSharingReturnResult returnRequest(ProfitSharingReturnRequest resultRequest) {
        assert resultRequest != null;
        try {
            checkAndSign(resultRequest, wxPayConfig.getKey());
            String respStr = new WxPayHttpClient(wxPayConfig).requestWithCert(WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_RETURN_URL, resultRequest.toXml());
            ProfitSharingReturnResult returnResult = XStreamConverter.fromXml(ProfitSharingReturnResult.class, respStr);
            return returnResult;
        } catch (WxErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 回退结果查询
     * ● 商户需要核实回退结果，可调用此接口查询回退结果。
     * ● 如果分账回退接口返回状态为处理中，可调用此接口查询回退结果
     * 接口频率：30QPS
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_8&index=9">开发文档</a>
     *
     * @param returnQueryRequest
     * @return
     */
    public ProfitSharingReturnResult returnQuery(ProfitSharingReturnQueryRequest returnQueryRequest) {
        assert returnQueryRequest != null;
        try {
            checkAndSign(returnQueryRequest, wxPayConfig.getKey());
            String respStr = new WxPayHttpClient(wxPayConfig).requestWithoutCert(WxPayConstants.ProfitSharingUrl.PROFIT_SHARING_RETURN_QUERY_URL, returnQueryRequest.toXml());
            ProfitSharingReturnResult returnResult = XStreamConverter.fromXml(ProfitSharingReturnResult.class, respStr);
            return returnResult;
        } catch (WxErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
