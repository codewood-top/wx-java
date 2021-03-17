package top.codewood.wx.pay.v2.api;

import top.codewood.wx.common.util.bean.BeanUtils;
import top.codewood.wx.common.util.xml.XStreamConverter;
import top.codewood.wx.pay.common.WxPayConfig;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.entpay.EntPayQueryRequest;
import top.codewood.wx.pay.v2.bean.entpay.EntPayQueryResult;
import top.codewood.wx.pay.v2.bean.entpay.EntPayRequest;
import top.codewood.wx.pay.v2.bean.entpay.EntPayResult;
import top.codewood.wx.pay.v2.bean.redpack.*;

public class EntPayV2Service extends WxPayV2BaseService {

    private WxPayConfig wxPayConfig;

    public EntPayV2Service(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
    }

    @Override
    WxPayConfig getWxPayConfig() {
        return wxPayConfig;
    }

    /**
     * 发放红包接口
     * 1.发送频率限制------默认30/秒
     * 2.发送个数上限------默认30/秒
     * 3.场景金额限制------默认红包金额为1-200元，如有需要，可前往商户平台进行设置和申请
     * 4.其他限制------商户单日出资金额上限--100万元；单用户单日收款金额上限--1000元；单用户单日可领取红包个数上限--10个
     *
     * @param redPackRequest
     * @return
     */
    public WxPayRedPackResult sendRedPack(WxPayRedPackRequest redPackRequest) {
        assert redPackRequest != null && wxPayConfig != null;
        checkAndSign(redPackRequest, wxPayConfig.getKey());
        return requestWithCert(wxPayConfig, WxPayConstants.EntPayUrl.REDPACK_SEND_URL, redPackRequest.toXml(), WxPayRedPackResult.class);
    }

    /**
     * 发放裂变红包
     * 裂变红包：一次可以发放一组红包。首先领取的用户为种子用户，种子用户领取一组红包当中的一个，并可以通过社交分享将剩下的红包给其他用户。裂变红包充分利用了人际传播的优势。
     *
     * @param groupRedPackRequest
     * @return
     */
    public WxPayRedPackResult sendGroupRedPack(WxPayGroupRedPackRequest groupRedPackRequest) {
        assert groupRedPackRequest != null && wxPayConfig != null;
        checkAndSign(groupRedPackRequest, wxPayConfig.getKey());
        return requestWithCert(wxPayConfig, WxPayConstants.EntPayUrl.REDPACK_GROUP_SEND_URL, groupRedPackRequest.toXml(), WxPayRedPackResult.class);
    }

    /**
     * 查询红包记录
     * 用于商户对已发放的红包进行查询红包的具体信息，可支持普通红包和裂变包。
     * <p>
     * 注意事项
     * ◆ 查询红包记录API只支持查询30天内的红包订单，30天之前的红包订单请登录商户平台查询。
     * ◆ 如果查询单号对应的数据不存在，那么数据不存在的原因可能是：（1）发放请求还在处理中；（2）红包发放处理失败导致红包订单没有落地。在上述情况下，商户首先需要检查该商户订单号是否确实是自己发起的，如果商户确认是自己发起的，则请商户不要直接当做红包发放失败处理，请商户隔几分钟再尝试查询，或者商户可以通过相同的商户订单号再次发起发放请求。如果商户误把还在发放中的订单直接当发放失败处理，商户应当自行承担因此产生的所有损失和责任。
     * ◆ XML具有可扩展性，因此返回参数可能会有新增，而且顺序可能不完全遵循此文档规范，如果在解析回包的时候发生错误，请商户务必不要换单重试，请商户联系客服确认红包发放情况。如果有新回包字段，会更新到此API文档中。
     * ◆ 因为错误代码字段err_code的值后续可能会增加，所以商户如果遇到回包返回新的错误码，请商户务必不要换单重试，请商户联系客服确认红包发放情况。如果有新的错误码，会更新到此API文档中。
     * ◆ 错误代码描述字段err_code_des只供人工定位问题时做参考，系统实现时请不要依赖这个字段来做自动化处理。
     *
     * @param redPackQueryRequest
     * @return
     */
    public WxPayRedPackQueryResult queryRedPack(WxPayRedPackQueryRequest redPackQueryRequest) {
        assert redPackQueryRequest != null && wxPayConfig != null;
        checkAndSign(redPackQueryRequest, wxPayConfig.getKey());
        return requestWithCert(wxPayConfig, WxPayConstants.EntPayUrl.REDPACK_QUERY_URL, redPackQueryRequest.toXml(), WxPayRedPackQueryResult.class);
    }

    /**
     * 企业付款
     * 用于企业向微信用户个人付款
     * 目前支持向指定微信用户的openid付款。
     *
     * @param entPayRequest
     * @return
     */
    public EntPayResult entPay(EntPayRequest entPayRequest) {
        assert entPayRequest != null && wxPayConfig != null;
        BeanUtils.checkRequiredFields(entPayRequest);
        if (entPayRequest.getSign() == null) {
            String sign = sign(entPayRequest, wxPayConfig.getKey());
            entPayRequest.setSign(sign);
        }
        return requestWithCert(wxPayConfig, WxPayConstants.EntPayUrl.ENTPAY_URL, XStreamConverter.toXml(entPayRequest), EntPayResult.class);
    }

    /**
     * 查询企业付款
     * 用于商户的企业付款操作进行结果查询，返回付款操作详细结果。
     * 查询企业付款API只支持查询30天内的订单，30天之前的订单请登录商户平台查询。
     *
     * @param entPayQueryRequest
     * @return
     */
    public EntPayQueryResult entPayQuery(EntPayQueryRequest entPayQueryRequest) {
        assert entPayQueryRequest != null && wxPayConfig != null;
        checkAndSign(entPayQueryRequest, wxPayConfig.getKey());
        return requestWithCert(wxPayConfig, WxPayConstants.EntPayUrl.ENTPAY_QUERY_URL, entPayQueryRequest.toXml(), EntPayQueryResult.class);
    }


}
