package top.codewood.wx.mp.api.impl;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import top.codewood.wx.mp.util.json.WxGsonBuilder;
import top.codewood.wx.mp.api.WxMpApi;
import top.codewood.wx.mp.api.WxMpMenuApi;
import top.codewood.wx.mp.api.WxMpService;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.mp.property.WxMpProperty;
import top.codewood.wx.util.Strings;

import java.time.LocalDateTime;

@Service("wxMpService")
public class WxMpServiceImpl implements WxMpService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpServiceImpl.class);

    private static WxAcessToken WX_ACCESS_TOKEN = null;

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
        String respStr = WxMpMenuApi.create(getAccessToken(), wxMenu);
        LOGGER.debug("resp: {}", respStr);

    }

    @Override
    public WxMenu queryMenu() {
        String respStr = WxMpMenuApi.query(getAccessToken());

        return null;
    }

    private void updateAccessToken() {
        if (!StringUtils.hasText(WxMpProperty.APP_ID) || !StringUtils.hasText(WxMpProperty.APP_SECRET)) {
            throw new RuntimeException("appid & appsecret 未配置 ");
        }
        LOGGER.debug("正在请求更新 access_token");
        String respStr = WxMpApi.getAccessToken(WxMpProperty.APP_ID, WxMpProperty.APP_SECRET);
        JsonObject json = WxGsonBuilder.create().fromJson(respStr, JsonObject.class);
        if (json.has("access_token")) {
            WxAcessToken wxAcessToken = new WxAcessToken();
            wxAcessToken.accessToken = json.get("access_token").getAsString();
            wxAcessToken.expiresIn = json.get("expires_in").getAsInt();
            wxAcessToken.expiredTime = LocalDateTime.now().plusSeconds(wxAcessToken.expiresIn - 200);
            WX_ACCESS_TOKEN = wxAcessToken;
        } else {
            LOGGER.error("请求更新 access_token 失败：{}", json.get("errmsg"));
        }
    }

    class WxAcessToken {

        String accessToken;
        Integer expiresIn;
        LocalDateTime expiredTime;

    }

}
