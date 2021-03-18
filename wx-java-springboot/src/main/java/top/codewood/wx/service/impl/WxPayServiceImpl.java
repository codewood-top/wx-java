package top.codewood.wx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codewood.wx.config.property.WxAppProperty;
import top.codewood.wx.config.property.WxConfigProperties;
import top.codewood.wx.config.property.WxPayProperty;
import top.codewood.wx.pay.common.WxPayConfig;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.api.WxPayV2Service;
import top.codewood.wx.pay.v2.bean.request.WxPayUnifiedOrderV2Request;
import top.codewood.wx.pay.v2.bean.result.WxPayUnifiedOrderV2Result;
import top.codewood.wx.pay.v3.api.WxPayV3Service;
import top.codewood.wx.pay.v3.bean.notify.WxPayTransaction;
import top.codewood.wx.pay.v3.bean.request.WxPayRequest;
import top.codewood.wx.pay.v3.bean.request.WxRefundRequest;
import top.codewood.wx.pay.v3.bean.result.WxRefundResult;
import top.codewood.wx.service.WxPayService;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service("wxPayService")
public class WxPayServiceImpl implements WxPayService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpServiceImpl.class);

    private WxPayV2Service wxPayV2Service;
    private WxPayV3Service wxPayV3Service;

    @Autowired
    private WxConfigProperties wxConfigProperties;

    @Override
    public Map<String, String> getPayInfo(String appid, String payType, WxPayRequest wxPayRequest) {
        assert wxPayRequest != null;
        return wxPayV3Service.unifiedOrder(payType, wxPayRequest);
    }

    @Override
    public WxPayUnifiedOrderV2Result unifiedOrder(String appid, WxPayUnifiedOrderV2Request unifiedOrderV2Request) {
        assert unifiedOrderV2Request != null;
        WxPayUnifiedOrderV2Result unifiedOrderV2Result = wxPayV2Service.unifiedOrder(unifiedOrderV2Request);
        return unifiedOrderV2Result;
    }

    @Override
    public String v2Sign(String appid, Object object) {
        if (object instanceof Map) {
            return wxPayV2Service.sign((Map) object);
        } else {
            return wxPayV2Service.sign(object);

        }
    }

    @Override
    public WxRefundResult refund(String appid, WxRefundRequest wxRefundRequest) {
        assert wxRefundRequest != null;
        return wxPayV3Service.refund(wxRefundRequest);
    }

    @Override
    public WxRefundResult queryRefund(String appid, String outTradeNo) {
        assert outTradeNo != null;
        return wxPayV3Service.queryRefund(outTradeNo);
    }

    @Override
    public WxPayTransaction query(String appid, String transactionId, String outTradeNo) {
        if (transactionId == null && outTradeNo == null) {
            throw new RuntimeException("transactionId,outTradeNo不能都为空！");
        }
        if (transactionId != null) {
            return wxPayV3Service.queryWithTransactionId(transactionId);
        } else {
            return wxPayV3Service.queryWithOutTradeNo(outTradeNo);
        }

    }

    @Override
    public void closeTransaction(String appid, String outTradeNo) {
        wxPayV3Service.closeTransaction(outTradeNo);
    }

    @PostConstruct
    public void postConstruct() {

        WxPayProperty[] wxPayProperties = wxConfigProperties.getPays();

        for (WxPayProperty wxPayProperty : wxPayProperties) {
            WxPayConfig wxPayConfig = new WxPayConfig();
            BeanUtils.copyProperties(wxPayProperty, wxPayConfig);

            if (WxPayConstants.Version.V2.equals(wxPayProperty.getVersion())) {
                wxPayV2Service = new WxPayV2Service(wxPayConfig);
                LOGGER.debug("wxpay-v2 已配置");
            }
            if (WxPayConstants.Version.V3.equals(wxPayProperty.getVersion())) {
                wxPayV3Service = new WxPayV3Service(wxPayConfig);
                LOGGER.debug("wxpay-v3 已配置");
            }
        }
    }

    private WxPayConfig getWxPayConfig(String appid, String version) {
        WxAppProperty wxAppProperty = wxConfigProperties.getAppProperty(appid);
        WxPayProperty wxPayProperty = wxConfigProperties.getPayProperty(wxAppProperty.getMchid(), version);
        WxPayConfig wxPayConfig = new WxPayConfig();
        BeanUtils.copyProperties(wxPayProperty, wxPayConfig);
        return wxPayConfig;
    }

}
