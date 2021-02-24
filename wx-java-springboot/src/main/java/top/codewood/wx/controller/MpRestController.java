package top.codewood.wx.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.codewood.wx.mp.bean.message.WxMpXmlMessage;
import top.codewood.wx.mp.util.XStreamConverter;
import top.codewood.wx.mp.service.WxMpService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/wx/mp/rest")
public class MpRestController {

    static final Logger LOGGER = LoggerFactory.getLogger(MpRestController.class);

    private static final String WX_MP_TOKEN = "codewoodtoken";

    @Autowired
    private WxMpService wxMpService;

    @RequestMapping("/access_token")
    public String accessToken() {
        return wxMpService.getAccessToken();
    }

    @RequestMapping("/handle")
    public String handle(HttpServletRequest request) {
        String echostr = request.getParameter("echostr");
        if (StringUtils.hasText(echostr)) {
            String signature = request.getParameter("signature"),
                timestamp = request.getParameter("timestamp"),
                nonce = request.getParameter("nonce");
            if (!signature.equals(generateSignature(timestamp, nonce, WX_MP_TOKEN))) {
                LOGGER.debug("check signature failure, signature: {}, timestamp: {}, nonce: {}", signature, timestamp, nonce);
                return "failure";
            }
            return echostr;
        } else {
            try {
                WxMpXmlMessage mpXmlMessage = XStreamConverter.fromXml(WxMpXmlMessage.class, request.getInputStream());
                LOGGER.info("receive msg: {}", mpXmlMessage.toString());
            } catch (IOException e) {
                LOGGER.error("err: {}", e.getMessage());
            }
        }
        return "success";
    }

    private String generateSignature(String timestamp, String nonce, String token) {
        String[] tmpArr = new String[]{ timestamp, nonce, token };
        Arrays.sort(tmpArr);
        StringBuilder sb = new StringBuilder();
        for (String s : tmpArr) {
            sb.append(s);
        }
        return DigestUtils.sha1Hex(sb.toString());
    }


}
