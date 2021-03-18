package top.codewood.wx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.service.OrderService;
import top.codewood.wx.service.WxMpOAuth2Api;
import top.codewood.wx.mp.bean.oauth2.WxOAuth2AccessToken;
import top.codewood.wx.mp.bean.oauth2.WxOAuth2UserInfo;
import top.codewood.wx.util.Strings;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/wx/mp")
public class WxMpController {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMpController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private WxMpProperty wxMpProperty;

    @GetMapping("/js_sdk")
    public String jsSdk(@RequestParam(value = "debug", required = false, defaultValue = "false") boolean debug, Model model) {
        model.addAttribute("debug", debug);
        model.addAttribute("appid", wxMpProperty.getAppid());
        return "mp/js_sdk";
    }

    /**
     *
     * @param scope base / userinfo
     * @param code
     * @param state
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/authorize/{scope}")
    public String authorize(
            @PathVariable("scope") String scope,
            @RequestParam(required = false, name = "code") String code,
            @RequestParam(required = false, name = "state", defaultValue = "") String state,
            Model model,
            HttpServletRequest request) {
        String scopeVal = null;
        if ("base".equals(scope)) {
            scopeVal = WxConstants.MpAuthorizeScope.BASE;
        } else if ("userinfo".equals(scope)) {
            scopeVal = WxConstants.MpAuthorizeScope.USER_INFO;
        } else {
            throw new RuntimeException("invalid scope: " + scope);
        }

        String currentReqUrl = getCurrentUrl(request);
        LOGGER.info("current req url: {}, code: {}", currentReqUrl, code);
        if (StringUtils.hasText(code)) {
            WxOAuth2AccessToken oAuth2AccessToken = WxMpOAuth2Api.getInstance().getOAuth2AccessToken(wxMpProperty.getAppid(), wxMpProperty.getAppSecret(), code);

            String openid = oAuth2AccessToken.getOpenid();
            WxOAuth2UserInfo wxOAuth2UserInfo = null;
            if (WxConstants.MpAuthorizeScope.USER_INFO.equals(oAuth2AccessToken.getScope())) {
                wxOAuth2UserInfo = WxMpOAuth2Api.getInstance().getUserInfo(oAuth2AccessToken.getAccessToken(), openid);
            }

            model.addAttribute("openid", openid);
            model.addAttribute("accessToken", oAuth2AccessToken.getAccessToken());
            model.addAttribute("userInfo", wxOAuth2UserInfo);

        } else {
            String redirectUrl = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
                    wxMpProperty.getAppid(),
                    Strings.urlEncode(currentReqUrl),
                    scopeVal,
                    state
            );
            return "redirect:" + redirectUrl;
        }
        model.addAttribute("scope", scope);
        model.addAttribute("appid", wxMpProperty.getAppid());
        return "mp/authorize";
    }

    @GetMapping("/pay")
    public String pay(
            @RequestParam(value = "openid", required = false, defaultValue = "") String openid,
            Model model) {
        model.addAttribute("orderNumber", orderService.generateOrderNumber());
        model.addAttribute("description", "代码坞-素材小店-大好河山");
        model.addAttribute("amount", 0.01);
        model.addAttribute("appid", wxMpProperty.getAppid());
        model.addAttribute("mchid", wxMpProperty.getMchid());
        model.addAttribute("openid", openid);
        return "mp/pay";
    }

    private String getCurrentUrl(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        sb.append(request.getScheme())
                .append("://");

        String host = request.getHeader("Host");
        if (StringUtils.hasText(host)) {
            sb.append(host);
        } else {
            sb.append(request.getServerName());
        }

        sb.append(request.getServletPath());

        if (StringUtils.hasText(request.getQueryString())) {
            sb.append("?").append(request.getQueryString());
        }
        return sb.toString();
    }

}
