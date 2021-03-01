package top.codewood.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.codewood.wx.mp.property.WxMpProperty;

@Controller
@RequestMapping("/wx/mp")
public class MpController {

    @GetMapping("/js_sdk")
    public String jsSdk(@RequestParam(value="debug", required = false, defaultValue = "false") boolean debug, Model model) {
        model.addAttribute("debug", debug);
        model.addAttribute("appid", WxMpProperty.APP_ID);
        return "mp/js_sdk";
    }

}
