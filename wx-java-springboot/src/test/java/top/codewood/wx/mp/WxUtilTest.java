package top.codewood.wx.mp;

import top.codewood.wx.mp.api.WxMpUtilApi;
import top.codewood.wx.util.Strings;

public class WxUtilTest {

    String accessToken = "";

    //@Test
    public void urlLong2ShortTest() {
        String respStr = WxMpUtilApi.getInstance().long2Short(accessToken, "http://www.codewood.top");
        System.out.println(respStr);
    }

    //@Test
    public void genShortenTest() {
        String respStr = WxMpUtilApi.getInstance().genShorten(accessToken, Strings.randomString(36), 60);
        System.out.println(respStr);
    }

    //@Test
    public void fetchShorten() {
        String respStr = WxMpUtilApi.getInstance().fetchShorten(accessToken, "");
        System.out.println(respStr);
    }

}