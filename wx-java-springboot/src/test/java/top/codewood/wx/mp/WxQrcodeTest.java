package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.mp.api.WxMpQrcodeApi;
import top.codewood.wx.mp.bean.result.WxMpQrcodeTicket;

public class WxQrcodeTest {

    String accessToken = "42_YRQ3992rycGdxVqqLSrvfS0Gxn2w4Of0hc8r5Wn9FKYZCeHqd0EptrJzCf0PgHPma8tnlpx05JyEZSMJjKDdQBMMRl49OBZeTqXzAWhFdq9XuzkOtE4yWjXvbwJ-xyv7wk1EXEZbypDlWZlqMUMjAFAWEW";

    @Test
    public void createTmpTicketTest() {
        WxMpQrcodeTicket mpQrcodeTicket = WxMpQrcodeApi.createTmpTicket(accessToken, 1, 600);
        System.out.println(mpQrcodeTicket);
    }

}
