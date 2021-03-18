package top.codewood.wx.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import top.codewood.wx.pay.v3.api.WxPayV3Api;
import top.codewood.wx.pay.v3.cert.CertificateItem;

import java.util.List;

@Component
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartedListener.class);

    @Autowired(required = false)
    private WxPayProperties wxPayProperties;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {

        if (wxPayProperties != null && wxPayProperties.getV3() != null) {
            if (StringUtils.hasText(wxPayProperties.getV3().getMchid()) && StringUtils.hasText(wxPayProperties.getV3().getSerialNo())
                    && StringUtils.hasText(wxPayProperties.getV3().getCertPath()) && StringUtils.hasText(wxPayProperties.getV3().getKey())) {
                WxPayV3Api.loadPrivateKey(wxPayProperties.getV3().getMchid(), this.getClass().getResourceAsStream(wxPayProperties.getV3().getCertPath()));
                LOGGER.info("已加载私钥");

                List<CertificateItem> certificates = WxPayV3Api.certificates(wxPayProperties.getV3().getMchid(), wxPayProperties.getV3().getSerialNo());
                WxPayV3Api.loadCertificates(wxPayProperties.getV3().getKey(), certificates);
                LOGGER.info("已加载证书");
            }
        }

    }
}
