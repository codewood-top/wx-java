package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.mp.api.WxMpApi;
import top.codewood.wx.mp.api.WxMpUserApi;

import java.util.Arrays;

public class WxUserTest {

    String accessToken = "";

    //@Test
    public void tagCreateTest() {
        String respStr = WxMpUserApi.getInstance().tagCreate(accessToken, "开发");
        System.out.println(respStr);
    }

    //@Test
    public void tagsGetTest() {
        String respStr = WxMpUserApi.getInstance().tagsGet(accessToken);
        System.out.println(respStr);
    }

    //@Test
    public void tagUpdateTest() {
        String respStr = WxMpUserApi.getInstance().tagUpdate(accessToken, 100, "研发&测试");
        System.out.println(respStr);
    }

    //@Test
    public void tagUsersTest() {
        String respStr = WxMpUserApi.getInstance().tagUsers(accessToken, 100, Arrays.asList(""));
        System.out.println(respStr);
    }

    //@Test
    public void userTagsTest() {
        String respStr = WxMpUserApi.getInstance().userTags(accessToken, "");
        System.out.println(respStr);
    }

    //@Test
    public void untagUsersTest() {
        String respStr = WxMpUserApi.getInstance().unTagUsers(accessToken, 100, Arrays.asList(""));
        System.out.println(respStr);
    }

    //@Test
    public void tagUsersGetTest() {
        String respStr = WxMpUserApi.getInstance().tagUsersGet(accessToken, 100, "");
        System.out.println(respStr);
    }

    //@Test
    public void remarkUserTest() {
        String respStr = WxMpUserApi.getInstance().remarkUser(accessToken, "", "有点菜");
        System.out.println(respStr);
    }

    //@Test
    public void userInfoTest(){
        String respStr = WxMpUserApi.getInstance().userInfo(accessToken, "");
        System.out.println(respStr);
    }

    //@Test
    public void userInfoBatchGetTest(){
        String respStr = WxMpUserApi.getInstance().userInfoBatchGet(accessToken, Arrays.asList(""));
        System.out.println(respStr);
    }

    //@Test
    public void userOpenidListTest() {
        String respStr = WxMpUserApi.getInstance().userOpenidList(accessToken, null);
        System.out.println(respStr);
    }

}
