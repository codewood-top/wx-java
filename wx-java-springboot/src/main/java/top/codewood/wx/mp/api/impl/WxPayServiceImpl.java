package top.codewood.wx.mp.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.MapUtils;
import top.codewood.wx.mp.api.WxPayService;
import top.codewood.wx.mp.property.WxPayProperty;
import top.codewood.wx.pay.v2.api.WxPayV2Api;
import top.codewood.wx.pay.v2.bean.request.WxPayUnifiedOrderV2Request;
import top.codewood.wx.pay.v2.bean.result.WxPayUnifiedOrderV2Result;
import top.codewood.wx.pay.v3.api.WxPayV3Api;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service("wxPayService")
public class WxPayServiceImpl implements WxPayService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpServiceImpl.class);

    @Override
    public Map<String, String> getPayInfo(String payType, WxPayRequest wxPayRequest) {
        assert wxPayRequest != null;
        return WxPayV3Api.unifiedOrder(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, payType, wxPayRequest);
    }

    @Override
    public WxPayUnifiedOrderV2Result unifiedOrder(WxPayUnifiedOrderV2Request unifiedOrderV2Request) {
        assert unifiedOrderV2Request != null;

        WxPayUnifiedOrderV2Result unifiedOrderV2Result = WxPayV2Api.unifiedOrder(unifiedOrderV2Request);
        return unifiedOrderV2Result;
    }

    @Override
    public WxRefundResult refund(WxRefundRequest wxRefundRequest) {
        assert wxRefundRequest != null;
        return WxPayV3Api.refund(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, wxRefundRequest);
    }

    @Override
    public WxRefundResult queryRefund(String outTradeNo) {
        assert outTradeNo != null;
        return WxPayV3Api.queryRefund(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, outTradeNo);
    }

    @Override
    public WxPayTransaction query( String transactionId, String outTradeNo) {
        if (transactionId == null && outTradeNo == null) {
            throw new RuntimeException("transactionId,outTradeNo不能都为空！");
        }
        if (transactionId != null) {
            return WxPayV3Api.queryWithTransactionId(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, transactionId);
        } else {
            return WxPayV3Api.queryWithOutTradeNo(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, outTradeNo);
        }

    }

    @Override
    public void closeTransaction(String outTradeNo) {
        assert outTradeNo != null;
        WxPayV3Api.closeTransaction(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, outTradeNo);
    }

}
