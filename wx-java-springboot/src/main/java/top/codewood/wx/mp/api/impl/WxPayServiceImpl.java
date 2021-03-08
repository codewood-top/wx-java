package top.codewood.wx.mp.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.codewood.wx.mp.api.WxPayService;
import top.codewood.wx.mp.property.WxPayProperty;
import top.codewood.wx.pay.v3.api.WxPayApi;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;

import java.util.Map;

@Service("wxPayService")
public class WxPayServiceImpl implements WxPayService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpServiceImpl.class);

    @Override
    public Map<String, String> getPayInfo(String payType, WxPayRequest wxPayRequest) {
        assert wxPayRequest != null;
        return WxPayApi.unifiedOrder(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, payType, wxPayRequest);
    }

    @Override
    public WxRefundResult refund(WxRefundRequest wxRefundRequest) {
        assert wxRefundRequest != null;
        return WxPayApi.refund(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, wxRefundRequest);
    }

    @Override
    public WxRefundResult queryRefund(String outTradeNo) {
        assert outTradeNo != null;
        return WxPayApi.queryRefund(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, outTradeNo);
    }

    @Override
    public WxPayTransaction query( String transactionId, String outTradeNo) {
        if (transactionId == null && outTradeNo == null) {
            throw new RuntimeException("transactionId,outTradeNo不能都为空！");
        }
        if (transactionId != null) {
            return WxPayApi.queryWithTransactionId(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, transactionId);
        } else {
            return WxPayApi.queryWithOutTradeNo(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, outTradeNo);
        }

    }

    @Override
    public void closeTransaction(String outTradeNo) {
        assert outTradeNo != null;
        WxPayApi.closeTransaction(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO, outTradeNo);
    }

}
