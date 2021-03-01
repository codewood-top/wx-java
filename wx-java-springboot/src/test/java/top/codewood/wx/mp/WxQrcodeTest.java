package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.mp.api.WxMpQrcodeApi;
import top.codewood.wx.mp.bean.result.WxMpQrcodeTicket;

public class WxQrcodeTest {

    String accessToken = "";

    //@Test
    public void createTmpTicketTest() {
        WxMpQrcodeTicket mpQrcodeTicket = WxMpQrcodeApi.getInstance().createTmpTicket(accessToken, 1, 600);
        System.out.println(mpQrcodeTicket);
    }

}
