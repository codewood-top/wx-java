package top.codewood.wx.mp.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import top.codewood.wx.common.util.json.WxGsonBuilder;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.mp.property.WxMpProperty;
import top.codewood.wx.mp.service.WxMpService;
import top.codewood.wx.util.Strings;

import java.time.LocalDateTime;
import java.util.Map;

@Service("wxMpService")
public class WxMpServiceImpl implements WxMpService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpServiceImpl.class);

    private static WxAcessToken WX_ACCESS_TOKEN = null;

    @Autowired
    private RestTemplate restTemplate;

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

        String create_menu_url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", getAccessToken());
        Gson gson = WxGsonBuilder.create();
        String jsonStr = gson.toJson(wxMenu);
        LOGGER.debug("wxmenu json str: {}", jsonStr);
        ResponseEntity<Map> resp = restTemplate.postForEntity(create_menu_url, jsonStr, Map.class);
        LOGGER.debug("resp: {}", resp.getBody());

    }

    private void updateAccessToken() {
        if (!StringUtils.hasText(WxMpProperty.APP_ID) || !StringUtils.hasText(WxMpProperty.APP_SECRET)) {
            throw new RuntimeException("appid & appsecret 未配置 ");
        }
        LOGGER.debug("正在请求更新 access_token");
        Map<String, Object> respMap = restTemplate.getForObject(String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", WxMpProperty.APP_ID, WxMpProperty.APP_SECRET), Map.class);
        if (respMap.containsKey("access_token")) {
            WxAcessToken wxAcessToken = new WxAcessToken();
            wxAcessToken.accessToken = (String) respMap.get("access_token");
            wxAcessToken.expiresIn = (Integer) respMap.get("expires_in");
            wxAcessToken.expiredTime = LocalDateTime.now().plusSeconds(wxAcessToken.expiresIn - 200);
            WX_ACCESS_TOKEN = wxAcessToken;
        } else {
            LOGGER.error("请求更新 access_token 失败：{}", respMap.get("errmsg"));
        }
    }

    class WxAcessToken {
        String accessToken;
        Integer expiresIn;
        LocalDateTime expiredTime;

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

        public void setExpiredTime(LocalDateTime expiredTime) {
            this.expiredTime = expiredTime;
        }
    }

}
