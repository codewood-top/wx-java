package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.mp.api.WxMpApi;
import top.codewood.wx.mp.api.WxMpUserApi;

import java.util.Arrays;

public class WxUserTest {

    String accessToken = "";

    //@Test
    public void tagCreateTest() {
        String respStr = WxMpUserApi.tagCreate(accessToken, "开发");
        System.out.println(respStr);
    }

    //@Test
    public void tagsGetTest() {
        String respStr = WxMpUserApi.tagsGet(accessToken);
        System.out.println(respStr);
    }

    //@Test
    public void tagUpdateTest() {
        String respStr = WxMpUserApi.tagUpdate(accessToken, 100, "研发&测试");
        System.out.println(respStr);
    }

    //@Test
    public void tagUsersTest() {
        String respStr = WxMpUserApi.tagUsers(accessToken, 100, Arrays.asList(""));
        System.out.println(respStr);
    }

    //@Test
    public void userTagsTest() {
        String respStr = WxMpUserApi.userTags(accessToken, "");
        System.out.println(respStr);
    }

    //@Test
    public void untagUsersTest() {
        String respStr = WxMpUserApi.unTagUsers(accessToken, 100, Arrays.asList(""));
        System.out.println(respStr);
    }

    //@Test
    public void tagUsersGetTest() {
        String respStr = WxMpUserApi.tagUsersGet(accessToken, 100, "");
        System.out.println(respStr);
    }

    //@Test
    public void remarkUserTest() {
        String respStr = WxMpUserApi.remarkUser(accessToken, "", "有点菜");
        System.out.println(respStr);
    }

    //@Test
    public void userInfoTest(){
        String respStr = WxMpUserApi.userInfo(accessToken, "");
        System.out.println(respStr);
    }

    //@Test
    public void userInfoBatchGetTest(){
        String respStr = WxMpUserApi.userInfoBatchGet(accessToken, Arrays.asList(""));
        System.out.println(respStr);
    }

    //@Test
    public void userOpenidListTest() {
        String respStr = WxMpUserApi.userOpenidList(accessToken, null);
        System.out.println(respStr);
    }

}
