package top.codewood.wx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.bean.WxAccessToken;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.config.property.WxAppProperties;
import top.codewood.wx.config.property.WxAppProperty;
import top.codewood.wx.mnp.api.WxMnpApi;
import top.codewood.wx.mnp.bean.result.WxMnpCode2SessionResult;
import top.codewood.wx.service.WxMnpService;
import top.codewood.wx.util.Strings;

import java.time.LocalDateTime;

@Service("wxMnpService")
public class WxMnpServiceImpl implements WxMnpService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMnpServiceImpl.class);

    private WxAccessToken2 wxAccessToken = null;

    @Autowired
    private WxAppProperties wxAppProperties;

    @Override
    public WxMnpCode2SessionResult code2Session(String code) {
        WxAppProperty wxAppProperty = wxAppProperties.getAppPropertyByType(WxConstants.AppType.MINIPROGRAM);
        return WxMnpApi.getInstance().code2Session(wxAppProperty.getAppid(), wxAppProperty.getSecret(), code);
    }

    @Override
    public String getAccessToken() {

        if (wxAccessToken == null || wxAccessToken.expiredTime.isBefore(LocalDateTime.now())) {
            synchronized (this) {
                if (wxAccessToken != null && wxAccessToken.expiredTime.isAfter(LocalDateTime.now())) {
                    return wxAccessToken.accessToken;
                }
                updateAccessToken();
            }
        }
        return wxAccessToken != null ? wxAccessToken.accessToken : Strings.EMPTY;

    }

    private void updateAccessToken() {
        WxAppProperty wxAppProperty = wxAppProperties.getAppPropertyByType(WxConstants.AppType.MINIPROGRAM);
        LOGGER.debug("正在请求更新小程序 access_token");
        try {
            WxAccessToken accessToken = WxMnpApi.getInstance().getAccessToken(wxAppProperty.getAppid(), wxAppProperty.getSecret());
            WxAccessToken2 wxAccessToken2 = new WxAccessToken2();
            wxAccessToken2.accessToken = accessToken.getAccessToken();
            wxAccessToken2.expiresIn = accessToken.getExpiresIn();
            wxAccessToken2.expiredTime = LocalDateTime.now().plusSeconds(wxAccessToken2.expiresIn - 200);
            wxAccessToken = wxAccessToken2;
        } catch (WxErrorException e) {
            LOGGER.error("请求更新小程序 access_token 失败：{}", e.getMessage());
        }
    }

    class WxAccessToken2 {

        String accessToken;
        Integer expiresIn;
        LocalDateTime expiredTime;

    }
}
