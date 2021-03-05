package top.codewood.wx.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/pay/rest")
public class WxPayRestController {

    static Logger LOGGER = LoggerFactory.getLogger(WxPayRestController.class);

}
