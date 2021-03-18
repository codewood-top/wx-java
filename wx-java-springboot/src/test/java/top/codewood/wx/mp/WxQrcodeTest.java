package top.codewood.wx.mp;

import top.codewood.wx.service.WxMpQrcodeApi;
import top.codewood.wx.mp.bean.result.WxMpQrcodeTicket;

public class WxQrcodeTest {

    String accessToken = "";

    //@Test
    public void createTmpTicketTest() {
        WxMpQrcodeTicket mpQrcodeTicket = WxMpQrcodeApi.getInstance().createTmpTicket(accessToken, 1, 600);
        System.out.println(mpQrcodeTicket);
    }

}
