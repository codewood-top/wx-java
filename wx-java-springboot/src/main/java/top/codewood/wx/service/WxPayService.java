package top.codewood.wx.service;

import top.codewood.wx.pay.v2.bean.request.WxPayUnifiedOrderV2Request;
import top.codewood.wx.pay.v2.bean.result.WxPayUnifiedOrderV2Result;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;

import java.util.Map;

public interface WxPayService {

    Map<String, String> getPayInfo(String appid, String payType, WxPayRequest wxPayRequest);

    WxPayUnifiedOrderV2Result unifiedOrder(String appid, WxPayUnifiedOrderV2Request unifiedOrderV2Request);

    String v2Sign(String appid, Object object);

    WxRefundResult refund(String appid, WxRefundRequest wxRefundRequest);

    WxRefundResult queryRefund(String appid, String outTradeNo);

    /**
     * transactionId || outTradeNo 二传一即可
     * @param transactionId
     * @param outTradeNo
     * @return
     */
    WxPayTransaction query(String appid, String transactionId, String outTradeNo);

    void closeTransaction(String appid, String outTradeNo);


}
