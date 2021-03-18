package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.service.WxMpOAuth2Api;
import top.codewood.wx.mp.bean.oauth2.WxOAuth2UserInfo;

public class WxMpOAuth2Test {

    /**
     * 有趣的是，只要accessToken正确，返回的userInfo是正确的，即使openid不正确，但不能为空
     */
    @Test
    public void getUserInfo() {
        String accessToken = "";
        String openid = "";
        WxOAuth2UserInfo userInfo = WxMpOAuth2Api.getInstance().getUserInfo(accessToken, openid);
        System.out.println(userInfo);
    }

}
