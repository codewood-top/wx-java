package top.codewood.wx.controller.rest;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.api.WxPayService;
import top.codewood.wx.mp.property.WxMpProperty;
import top.codewood.wx.mp.property.WxPayProperty;
import top.codewood.wx.pay.v3.api.WxPayApi;
import top.codewood.wx.pay.v3.bean.notify.WxRefundTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.notify.WxPayNotify;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;
import top.codewood.wx.pay.v3.util.cert.AesUtil;
import top.codewood.wx.pay.v3.util.json.WxGsonBuilder;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/wx/pay/rest")
public class WxPayRestController {

    static Logger LOGGER = LoggerFactory.getLogger(WxPayRestController.class);

    @Autowired
    private WxPayService wxPayService;

    @RequestMapping("/getPayInfo")
    public Map<String, String> getPayInfo(@RequestParam("payType") String payType,
                                          @RequestParam("tradeNo") String tradeNo,
                                          @RequestParam("description") String description,
                                          @RequestParam("amount") double amount,
                                          @RequestParam(value = "openid", required = false) String openid,
                                          @RequestParam("timeStamp") String timeStamp,
                                          @RequestParam("nonceStr") String nonceStr
                           ) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        Double total = amount * 100;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String expireTimeStr = sdf.format(Date.from(LocalDateTime.now().plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant()));

        WxPayRequest payRequest = new WxPayRequest();
        payRequest.setAppid(WxMpProperty.APP_ID);
        payRequest.setMchid(WxPayProperty.MCHID);
        payRequest.setDescription(description);
        payRequest.setOutTradeNo(tradeNo);
        payRequest.setExpireTime(expireTimeStr);
        payRequest.setNotifyUrl(WxPayProperty.NOTIFY_URL);
        payRequest.setAmount(total.intValue());
        payRequest.setPayer(openid);

        Map<String, String> map = wxPayService.getPayInfo(payType, payRequest);

        map.put("appid", WxMpProperty.APP_ID);
        map.put("timeStamp", timeStamp);
        map.put("nonceStr", nonceStr);
        map.put("package", "prepay_id=" + map.get("prepay_id"));
        String message = WxMpProperty.APP_ID + "\n" + timeStamp + "\n" + nonceStr + "\nprepay_id=" + map.get("prepay_id") + "\n";
        String sign = WxPayApi.sign(WxPayProperty.MCHID, message.getBytes(StandardCharsets.UTF_8));
        map.put("paySign", sign);
        return map;
    }

    @RequestMapping("/refund")
    public String refund(@RequestParam("tradeNo") String tradeNo,
                         @RequestParam(value = "reason", required = false) String reason,
                         @RequestParam("amount") double amount) {

        Double total = amount * 100;

        WxRefundRequest refundRequest = new WxRefundRequest();
        refundRequest.setAmount(total.intValue(), total.intValue());
        refundRequest.setOutRefundNo(tradeNo);
        refundRequest.setOutTradeNo(tradeNo);
        refundRequest.setNotifyUrl(WxPayProperty.REFUND_NOTIFY_URL);
        if (reason != null) {
            refundRequest.setReason(reason);
        }

        WxRefundResult refundResult = wxPayService.refund(refundRequest);

        LOGGER.debug("refund result: {}", refundResult);

        return WxConstants.SUCCESS;
    }

    @RequestMapping("/notify")
    public String notify(@RequestBody String notifyBody) {

        try {
            if (WxPayProperty.API_V3_KEY == null) {
                throw new RuntimeException("api-v3-key未配置");
            }
            Gson gson = WxGsonBuilder.create();
            WxPayNotify wxPayNotify = gson.fromJson(notifyBody, WxPayNotify.class);
            AesUtil aesUtil = new AesUtil(WxPayProperty.API_V3_KEY.getBytes(StandardCharsets.UTF_8));
            String result = aesUtil.decryptToString(wxPayNotify.getResource().getAssociatedData().getBytes(StandardCharsets.UTF_8), wxPayNotify.getResource().getNonce().getBytes(StandardCharsets.UTF_8), wxPayNotify.getResource().getCipherText());
            WxPayTransaction wxPayTransaction = gson.fromJson(result, WxPayTransaction.class);
            LOGGER.debug("wxPayTransaction: {}", wxPayTransaction.toString());
        } catch (Exception e) {
            LOGGER.info("微信支付通知结果：{}", notifyBody);
            e.printStackTrace();
        }

        return notifyCallbackStr(WxConstants.SUCCESS.toUpperCase(), "成功");
    }

    @RequestMapping("/refundNotify")
    public String refundNotify(@RequestBody String notifyBody) {

        try {
            if (WxPayProperty.API_V3_KEY == null) {
                throw new RuntimeException("api-v3-key未配置");
            }
            Gson gson = WxGsonBuilder.create();
            WxPayNotify wxPayNotify = gson.fromJson(notifyBody, WxPayNotify.class);
            AesUtil aesUtil = new AesUtil(WxPayProperty.API_V3_KEY.getBytes(StandardCharsets.UTF_8));
            String result = aesUtil.decryptToString(wxPayNotify.getResource().getAssociatedData().getBytes(StandardCharsets.UTF_8), wxPayNotify.getResource().getNonce().getBytes(StandardCharsets.UTF_8), wxPayNotify.getResource().getCipherText());
            WxRefundTransaction wxRefundTransaction = gson.fromJson(result, WxRefundTransaction.class);
            LOGGER.debug("wxRefundTransaction: {}", wxRefundTransaction);
        } catch (Exception e) {
            LOGGER.info("微信支付退款通知结果：{}", notifyBody);
            e.printStackTrace();
        }

        return notifyCallbackStr(WxConstants.SUCCESS.toUpperCase(), "成功");
    }

    @RequestMapping("/query")
    public String query(@RequestParam(value = "transactionId", required = false) String transactionId,
                        @RequestParam(value = "tradeNo", required = false) String outTradeNo) {
        if (transactionId == null && outTradeNo == null) {
            throw new RuntimeException("transactionId,outTradeNo不能都为空！");
        }
        WxPayTransaction wxPayTransaction = wxPayService.query(transactionId, outTradeNo);
        LOGGER.debug("wxPayTransaction: {}", wxPayTransaction);
        return WxConstants.SUCCESS;
    }

    @RequestMapping("/queryRefund")
    public String queryRefund(@RequestParam(value = "tradeNo") String outTradeNo) {
        WxRefundResult wxRefundResult = wxPayService.queryRefund(outTradeNo);
        LOGGER.debug("wxRefundResult: {}", wxRefundResult);
        return WxConstants.SUCCESS;
    }

    @RequestMapping("/close")
    public String close(@RequestParam("tradeNo") String outTradeNo) {
        wxPayService.closeTransaction(outTradeNo);
        return WxConstants.SUCCESS;
    }

    private String notifyCallbackStr(String code, String message) {
        return String.format("{\"code\": \"%s\", \"message\": \"%s\"}", code, message);
    }

}
