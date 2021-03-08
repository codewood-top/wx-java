package top.codewood.wx.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import top.codewood.wx.mp.property.WxPayProperty;
import top.codewood.wx.pay.v3.api.WxPayApi;
import top.codewood.wx.pay.v3.cert.CertificateItem;

import java.util.List;

@Component
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartedListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        if (WxPayProperty.MCHID != null && WxPayProperty.SERIAL_NO != null
                && WxPayProperty.CERT_PATH != null && WxPayProperty.API_V3_KEY != null) {
            WxPayApi.loadPrivateKey(WxPayProperty.MCHID, this.getClass().getResourceAsStream(WxPayProperty.CERT_PATH));
            LOGGER.info("已加载私钥");

            List<CertificateItem> certificates = WxPayApi.certificates(WxPayProperty.MCHID, WxPayProperty.SERIAL_NO);
            WxPayApi.loadCertificates(WxPayProperty.API_V3_KEY, certificates);
            LOGGER.info("已加载证书");
        }
    }
}
