package top.codewood.wx.mp.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codewood.wx.config.property.WxPayProperties;
import top.codewood.wx.mp.api.WxPayService;
import top.codewood.wx.pay.v2.api.WxPayV2Service;
import top.codewood.wx.pay.v2.bean.request.WxPayUnifiedOrderV2Request;
import top.codewood.wx.pay.v2.bean.result.WxPayUnifiedOrderV2Result;
import top.codewood.wx.pay.v3.api.WxPayV3Service;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service("wxPayService")
public class WxPayServiceImpl implements WxPayService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpServiceImpl.class);

    private WxPayV2Service wxPayV2Service;
    private WxPayV3Service wxPayV3Service;

    @Autowired(required = false)
    private WxPayProperties wxPayProperties;

    @Override
    public Map<String, String> getPayInfo(String payType, WxPayRequest wxPayRequest) {
        assert wxPayRequest != null;
        return getWxPayV3Service().unifiedOrder(payType, wxPayRequest);
    }

    @Override
    public WxPayUnifiedOrderV2Result unifiedOrder(WxPayUnifiedOrderV2Request unifiedOrderV2Request) {
        assert unifiedOrderV2Request != null;
        WxPayUnifiedOrderV2Result unifiedOrderV2Result = getWxPayV2Service().unifiedOrder(unifiedOrderV2Request);
        return unifiedOrderV2Result;
    }

    @Override
    public String v2Sign(Object object) {
        if (object instanceof Map) {
            return getWxPayV2Service().sign((Map) object);
        } else {
            return getWxPayV2Service().sign(object);

        }
    }

    @Override
    public WxRefundResult refund(WxRefundRequest wxRefundRequest) {
        assert wxRefundRequest != null;
        return getWxPayV3Service().refund(wxRefundRequest);
    }

    @Override
    public WxRefundResult queryRefund(String outTradeNo) {
        assert outTradeNo != null;
        return getWxPayV3Service().queryRefund(outTradeNo);
    }

    @Override
    public WxPayTransaction query(String transactionId, String outTradeNo) {
        if (transactionId == null && outTradeNo == null) {
            throw new RuntimeException("transactionId,outTradeNo不能都为空！");
        }
        if (transactionId != null) {
            return getWxPayV3Service().queryWithTransactionId(transactionId);
        } else {
            return getWxPayV3Service().queryWithOutTradeNo(outTradeNo);
        }

    }

    @Override
    public void closeTransaction(String outTradeNo) {
        wxPayV3Service.closeTransaction(outTradeNo);
    }

    private WxPayV3Service getWxPayV3Service() {
        if (wxPayV3Service == null) throw new RuntimeException("wxPayV3Service 未配置!");
        return wxPayV3Service;
    }

    private WxPayV2Service getWxPayV2Service() {
        if (wxPayV2Service == null) throw new RuntimeException("wxPayV2Service 未配置!");
        return wxPayV2Service;
    }

    @PostConstruct
    public void postConstruct() {

        if (wxPayProperties == null || wxPayProperties.getV2() == null) {
            LOGGER.debug("wxpay-v2 参数未配置");
        } else {
            wxPayV2Service = new WxPayV2Service(wxPayProperties.getV2());
        }

        if (wxPayProperties == null || wxPayProperties.getV3() == null) {
            LOGGER.debug("wxpay-v3 参数未配置");
        } else {
            wxPayV3Service = new WxPayV3Service(wxPayProperties.getV3());
        }
    }

}
