package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.mp.api.WxMpUtilApi;
import top.codewood.wx.util.Strings;

public class WxUtilTest {

    String accessToken = "42_YRQ3992rycGdxVqqLSrvfS0Gxn2w4Of0hc8r5Wn9FKYZCeHqd0EptrJzCf0PgHPma8tnlpx05JyEZSMJjKDdQBMMRl49OBZeTqXzAWhFdq9XuzkOtE4yWjXvbwJ-xyv7wk1EXEZbypDlWZlqMUMjAFAWEW";

    @Test
    public void urlLong2ShortTest() {
        String respStr = WxMpUtilApi.long2Short(accessToken, "http://www.codewood.top");
        System.out.println(respStr);
    }

    @Test
    public void genShortenTest() {
        String respStr = WxMpUtilApi.genShorten(accessToken, Strings.randomString(36), 60);
        System.out.println(respStr);
    }

    @Test
    public void fetchShorten() {
        String respStr = WxMpUtilApi.fetchShorten(accessToken, "lSlybKD7otCnfgz");
        System.out.println(respStr);
    }
}
