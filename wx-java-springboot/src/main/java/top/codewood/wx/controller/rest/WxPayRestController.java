package top.codewood.wx.controller.rest;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.util.net.NetUtils;
import top.codewood.wx.common.util.xml.XStreamConverter;
import top.codewood.wx.config.property.WxPayProperties;
import top.codewood.wx.mp.api.WxPayService;
import top.codewood.wx.pay.common.WxPayConfig;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.notify.WxPayV2Notify;
import top.codewood.wx.pay.v2.bean.request.WxPayUnifiedOrderV2Request;
import top.codewood.wx.pay.v2.bean.result.WxPayUnifiedOrderV2Result;
import top.codewood.wx.pay.v3.api.WxPayV3Api;
import top.codewood.wx.pay.v3.bean.notify.WxPayNotify;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.notify.WxRefundTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
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
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx/pay/rest")
public class WxPayRestController {

    static Logger LOGGER = LoggerFactory.getLogger(WxPayRestController.class);

    @Autowired
    private WxPayService wxPayService;

    @Autowired
    private WxPayProperties wxPayProperties;

    @RequestMapping("/getPayInfo")
    public Map<String, String> getPayInfo(
            @RequestParam("version") String version,
            @RequestParam("payType") String payType,
            @RequestParam("tradeNo") String tradeNo,
            @RequestParam("description") String description,
            @RequestParam("amount") double amount,
            @RequestParam(value = "openid", required = false) String openid,
            @RequestParam("timeStamp") String timeStamp,
            @RequestParam("nonceStr") String nonceStr,
            @RequestParam(value = "profitSharing", required = false, defaultValue = "false") boolean profitSharing) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        WxPayConfig wxPayConfig = getWxPayConfig(version);

        Map<String, String> map = new HashMap<>();
        map.put("appId", wxPayConfig.getAppid());
        map.put("timeStamp", timeStamp);
        map.put("nonceStr", nonceStr);

        Double total = amount * 100;

        if (WxPayConstants.Version.V2.equals(version.toLowerCase())) {
            WxPayUnifiedOrderV2Request.Builder builder = new WxPayUnifiedOrderV2Request.Builder();
            builder.appid(wxPayConfig.getAppid())
                    .mchid(wxPayConfig.getMchid())
                    .nonceStr(nonceStr)
                    .body(description)
                    .outTradeNo(tradeNo)
                    .totalFee(total.intValue())
                    .spbillCreateIp(NetUtils.localAddress())
                    .openid(openid)
                    .notifyUrl(wxPayConfig.getNotifyUrl())
                    .tradeType(payType)
                    .profitSharing(profitSharing?"Y":"N");
            WxPayUnifiedOrderV2Request unifiedOrderV2Request = builder.build();
            WxPayUnifiedOrderV2Result unifiedOrderV2Result = wxPayService.unifiedOrder(unifiedOrderV2Request);

            map.put("signType", WxPayConstants.SignType.MD5);
            map.put("package", "prepay_id=" + unifiedOrderV2Result.getPrepayId());
            map.put("paySign", wxPayService.v2Sign(map));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
            String expireTimeStr = sdf.format(Date.from(LocalDateTime.now().plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant()));

            WxPayRequest payRequest = new WxPayRequest();
            payRequest.setAppid(wxPayConfig.getAppid());
            payRequest.setMchid(wxPayConfig.getMchid());
            payRequest.setDescription(description);
            payRequest.setOutTradeNo(tradeNo);
            payRequest.setExpireTime(expireTimeStr);
            payRequest.setNotifyUrl(wxPayConfig.getNotifyUrl());
            payRequest.setAmount(total.intValue());
            payRequest.setPayer(openid);

            if (profitSharing) {
                payRequest.setSettleInfo(profitSharing);
            }

            Map<String, String> payInfoMap = wxPayService.getPayInfo(payType, payRequest);

            map.put("signType", "RSA");
            map.put("package", "prepay_id=" + payInfoMap.get("prepay_id"));
            String message = wxPayConfig.getAppid() + "\n" + timeStamp + "\n" + nonceStr + "\nprepay_id=" + payInfoMap.get("prepay_id") + "\n";
            String sign = WxPayV3Api.sign(wxPayConfig.getMchid(), message.getBytes(StandardCharsets.UTF_8));
            map.put("paySign", sign);
        }

        return map;
    }


    @RequestMapping("/refund")
    public String refund(
            @RequestParam("version") String version,
            @RequestParam("tradeNo") String tradeNo,
                         @RequestParam(value = "reason", required = false) String reason,
                         @RequestParam("amount") double amount) {

        WxPayConfig wxPayConfig = getWxPayConfig(version);

        Double total = amount * 100;

        WxRefundRequest refundRequest = new WxRefundRequest();
        refundRequest.setAmount(total.intValue(), total.intValue());
        refundRequest.setOutRefundNo(tradeNo);
        refundRequest.setOutTradeNo(tradeNo);
        refundRequest.setNotifyUrl(wxPayConfig.getRefundNotifyUrl());
        if (reason != null) {
            refundRequest.setReason(reason);
        }

        WxRefundResult refundResult = wxPayService.refund(refundRequest);

        LOGGER.debug("refund result: {}", refundResult);

        return WxConstants.SUCCESS;
    }

    @RequestMapping("/notify/{version}")
    public String notifyVersion(
            @PathVariable("version") String version,
            @RequestBody String notifyBody) {

        WxPayConfig wxPayConfig = getWxPayConfig(version);

        try {
            if (WxPayConstants.Version.V2.equals(version)) {
                WxPayV2Notify wxPayNotify = XStreamConverter.fromXml(WxPayV2Notify.class, notifyBody);
                LOGGER.debug("wxPayNotify: {}", wxPayNotify);
            } else if (WxPayConstants.Version.V3.equals(version)) {
                if (wxPayConfig.getKey() == null) {
                    throw new RuntimeException("api-v3-key未配置");
                }
                Gson gson = WxGsonBuilder.create();
                WxPayNotify wxPayNotify = gson.fromJson(notifyBody, WxPayNotify.class);
                AesUtil aesUtil = new AesUtil(wxPayConfig.getKey().getBytes(StandardCharsets.UTF_8));
                String result = aesUtil.decryptToString(wxPayNotify.getResource().getAssociatedData().getBytes(StandardCharsets.UTF_8), wxPayNotify.getResource().getNonce().getBytes(StandardCharsets.UTF_8), wxPayNotify.getResource().getCipherText());
                WxPayTransaction wxPayTransaction = gson.fromJson(result, WxPayTransaction.class);
                LOGGER.debug("wxPayTransaction: {}", wxPayTransaction.toString());
            }
        } catch (Exception e) {
            LOGGER.info("微信支付 {} 通知结果：{}", version, notifyBody);
            e.printStackTrace();
        }

        return notifyCallbackStr(version, WxConstants.SUCCESS.toUpperCase(), "成功");
    }


    @RequestMapping("/refundnotify/{version}")
    public String refundNotify(
            @PathVariable("version") String version,
            @RequestBody String notifyBody) {

        WxPayConfig wxPayConfig = getWxPayConfig(version);
        try {
            if (wxPayConfig.getKey() == null) {
                throw new RuntimeException("api-v3-key未配置");
            }
            Gson gson = WxGsonBuilder.create();
            WxPayNotify wxPayNotify = gson.fromJson(notifyBody, WxPayNotify.class);
            AesUtil aesUtil = new AesUtil(wxPayConfig.getKey().getBytes(StandardCharsets.UTF_8));
            String result = aesUtil.decryptToString(wxPayNotify.getResource().getAssociatedData().getBytes(StandardCharsets.UTF_8), wxPayNotify.getResource().getNonce().getBytes(StandardCharsets.UTF_8), wxPayNotify.getResource().getCipherText());
            WxRefundTransaction wxRefundTransaction = gson.fromJson(result, WxRefundTransaction.class);
            LOGGER.debug("wxRefundTransaction: {}", wxRefundTransaction);
        } catch (Exception e) {
            LOGGER.info("微信支付退款通知结果：{}", notifyBody);
            e.printStackTrace();
        }

        return notifyCallbackStr(WxPayConstants.Version.V3, WxConstants.SUCCESS.toUpperCase(), "成功");
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

    private WxPayConfig getWxPayConfig(String version) {
        return WxPayConstants.Version.V2.equals(version.toLowerCase()) ? wxPayProperties.getV2() : wxPayProperties.getV3();
    }

    private String notifyCallbackStr(String version, String code, String message) {
        if (WxPayConstants.Version.V2.equals(version.toLowerCase())) {
            return String.format("<xml>\n" +
                    "  <return_code><![CDATA[%s]]></return_code>\n" +
                    "  <return_msg><![CDATA[%s]]></return_msg>\n" +
                    "</xml>", code, message);
        }
        return String.format("{\"code\": \"%s\", \"message\": \"%s\"}", code, message);
    }

}
