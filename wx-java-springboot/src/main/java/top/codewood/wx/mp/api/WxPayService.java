package top.codewood.wx.mp.api;

import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;

import java.util.Map;

public interface WxPayService {

    Map<String, String> getPayInfo(String payType, WxPayRequest wxPayRequest);

    WxRefundResult refund(WxRefundRequest wxRefundRequest);

    WxRefundResult queryRefund(String outTradeNo);

    /**
     * transactionId || outTradeNo 二传一即可
     * @param transactionId
     * @param outTradeNo
     * @return
     */
    WxPayTransaction query(String transactionId, String outTradeNo);

    void closeTransaction(String outTradeNo);

}
