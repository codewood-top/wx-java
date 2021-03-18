package top.codewood.wx.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.codewood.wx.mnp.bean.result.WxMnpCode2SessionResult;
import top.codewood.wx.service.WxMnpService;

@RestController
@RequestMapping("/wx/mnp/rest")
public class WxMnpRestController {

    @Autowired
    private WxMnpService wxMnpService;

    @RequestMapping("/code2session")
    public String code2Session(
            @RequestParam("appid") String appid,
            @RequestParam("code") String code) {
        WxMnpCode2SessionResult result = wxMnpService.code2Session(appid, code);
        System.out.println(result);
        return result.getOpenid();
    }

}
