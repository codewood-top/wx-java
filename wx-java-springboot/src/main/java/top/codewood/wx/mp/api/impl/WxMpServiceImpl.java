package top.codewood.wx.mp.api.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import top.codewood.wx.common.bean.WxAccessToken;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.mp.api.WxMpApi;
import top.codewood.wx.mp.api.WxMpMenuApi;
import top.codewood.wx.mp.api.WxMpService;
import top.codewood.wx.mp.bean.WxMpJsapiTicket;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.config.property.WxMpProperty;
import top.codewood.wx.util.Strings;

import java.time.LocalDateTime;

@Service("wxMpService")
public class WxMpServiceImpl implements WxMpService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpServiceImpl.class);

    private static WxAccessToken2 WX_ACCESS_TOKEN = null;
    private static WxJsapiTicket2 WX_JSAPI_TICKET = null;

    @Autowired
    private WxMpProperty wxMpProperty;

    @Override
    public String getAccessToken() {
        if (WX_ACCESS_TOKEN == null || WX_ACCESS_TOKEN.expiredTime.isBefore(LocalDateTime.now())) {
            synchronized (this) {
                if (WX_ACCESS_TOKEN != null && WX_ACCESS_TOKEN.expiredTime.isAfter(LocalDateTime.now())) {
                    return WX_ACCESS_TOKEN.accessToken;
                }
                updateAccessToken();
            }
        }
        return WX_ACCESS_TOKEN != null ? WX_ACCESS_TOKEN.accessToken : Strings.EMPTY;
    }

    @Override
    public void createMenu(WxMenu wxMenu) {
        Assert.notNull(wxMenu, "菜单不能为空");
        String respStr = WxMpMenuApi.getInstance().create(getAccessToken(), wxMenu);
        LOGGER.debug("resp: {}", respStr);

    }

    @Override
    public WxMenu queryMenu() {
        return WxMpMenuApi.getInstance().query(getAccessToken());
    }

    @Override
    public String jsSignature(String nonceStr, long timestamp, String url) {
        return DigestUtils.sha1Hex(String.format("jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s", getJsapiTicket(getAccessToken()),
                nonceStr, timestamp, url));
    }

    private String getJsapiTicket(String accessToken) {
        if (WX_JSAPI_TICKET == null || WX_JSAPI_TICKET.expiredTime.isBefore(LocalDateTime.now())) {
            synchronized (this) {
                if (WX_JSAPI_TICKET != null && WX_JSAPI_TICKET.expiredTime.isAfter(LocalDateTime.now())) {
                    return WX_JSAPI_TICKET.ticket;
                }
                WxMpJsapiTicket jsapiTicket = WxMpApi.getJsapiTicket(accessToken);
                LOGGER.debug("正在更新jsapi_ticket: {}", jsapiTicket);
                WxJsapiTicket2 wxJsapiTicket2 = new WxJsapiTicket2();
                wxJsapiTicket2.ticket = jsapiTicket.getTicket();
                wxJsapiTicket2.expiresIn = jsapiTicket.getExpiresIn();
                wxJsapiTicket2.expiredTime = LocalDateTime.now().plusSeconds(wxJsapiTicket2.expiresIn - 200);
                WX_JSAPI_TICKET = wxJsapiTicket2;
            }
        }
        return WX_JSAPI_TICKET != null ? WX_JSAPI_TICKET.ticket : Strings.EMPTY;
    }

    private void updateAccessToken() {
        if (!StringUtils.hasText(wxMpProperty.getAppid()) || !StringUtils.hasText(wxMpProperty.getAppSecret())) {
            throw new RuntimeException("appid & appsecret 未配置 ");
        }
        LOGGER.debug("正在请求更新 access_token");
        try {
            WxAccessToken wxAccessToken = WxMpApi.getAccessToken(wxMpProperty.getAppid(), wxMpProperty.getAppSecret());
            WxAccessToken2 wxAccessToken2 = new WxAccessToken2();
            wxAccessToken2.accessToken = wxAccessToken.getAccessToken();
            wxAccessToken2.expiresIn = wxAccessToken.getExpiresIn();
            wxAccessToken2.expiredTime = LocalDateTime.now().plusSeconds(wxAccessToken2.expiresIn - 200);
            WX_ACCESS_TOKEN = wxAccessToken2;
        } catch (WxErrorException e) {
            LOGGER.error("请求更新 access_token 失败：{}", e.getMessage());
        }

    }

    class WxAccessToken2 {

        String accessToken;
        Integer expiresIn;
        LocalDateTime expiredTime;

    }

    class WxJsapiTicket2 {
        String ticket;
        Integer expiresIn;
        LocalDateTime expiredTime;
    }

}
