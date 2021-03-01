package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.mp.api.WxMpApi;

public class WxApiTest {

    String accessToken = "";

    //@Test
    public void jsapiTicketTest() {
        String ticket = WxMpApi.getJsapiTicket(accessToken);
        System.out.println("ticket: " + ticket);
    }

}
