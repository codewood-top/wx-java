package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.util.http.AppHttpClient;
import top.codewood.wx.mp.api.WxMpKefuApi;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;
import top.codewood.wx.mp.bean.kefu.result.WxMpKfInfo;
import top.codewood.wx.mp.bean.kefu.result.WxMpKfMsgList;
import top.codewood.wx.mp.bean.kefu.result.WxMpKfSession;
import top.codewood.wx.mp.bean.kefu.result.WxMpKfSessionWaitCaseList;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class WxMpKefuTest {

    String accessToken = "";

    //@Test
    public void addAccountTest() {
        WxMpKefuApi.getInstance().add(accessToken, "", "", null);
    }

    //@Test
    public void updateAccountTest() {
        WxMpKefuApi.getInstance().update(accessToken, "", "", null);
    }

    //@Test
    public void delAccountTest() {
        WxMpKefuApi.getInstance().del(accessToken, "");
    }

    //@Test
    public void updateHeadimg() throws IOException {
        InputStream is = AppHttpClient.getInstance().getStream("http://img1.codewood.top/developer/images/code-logo-large.png");
        WxMpKefuApi.getInstance().updateHeadimg(accessToken, "", is);
    }

    //@Test
    public void updateNickname() {
        WxMpKefuApi.getInstance().updateNickname(accessToken, "", "");
    }

    //@Test
    public void listTest() {
        List<WxMpKfInfo> infoList = WxMpKefuApi.getInstance().list(accessToken);
        System.out.println(infoList);
    }

    //@Test
    public void onlineListTest() {
        List<WxMpKfInfo> infoList = WxMpKefuApi.getInstance().onlineList(accessToken);
        System.out.println(infoList);
    }

    //@Test
    public void sendKfMessageTest() {
        WxMpKfMessage kfMessage = WxMpKfMessage.textBuilder()
                .toUser("")
                .content("Hi, 来自custom server msg")
                .build();
        WxMpKefuApi.getInstance().sendMsg(accessToken, kfMessage);
    }

    //@Test
    public void setTypingStatus() {
        WxMpKefuApi.getInstance().typing(accessToken, "", true);
    }

    //@Test
    public void createSessionTest() {
        WxMpKefuApi.getInstance().createSession(accessToken, "", "");
    }

    //@Test
    public void closeSessionTest() {
        WxMpKefuApi.getInstance().closeSession(accessToken, "", "");
    }

    //@Test
    public void getSessionTest() {
        WxMpKfSession kfSession = WxMpKefuApi.getInstance().getSession(accessToken, "");
        System.out.println(kfSession);
    }

    //@Test
    public void getSessionList() {
        List<WxMpKfSession> kfSessionList = WxMpKefuApi.getInstance().getSessionList(accessToken, "");
        kfSessionList.forEach(System.out::println);
    }

    //@Test
    public void getWaitCaseSessionList() {
        WxMpKfSessionWaitCaseList waitCaseList = WxMpKefuApi.getInstance().getWaitCaseList(accessToken);
        System.out.println(waitCaseList);
    }

    //@Test
    public void getKfMsgList() {
        LocalDateTime startTime = LocalDateTime.now().minusDays(1);
        LocalDateTime endTime = LocalDateTime.now();
        WxMpKfMsgList wxMpKfMsgList = WxMpKefuApi.getInstance().getKfMsgList(accessToken, startTime, endTime);
        System.out.println(wxMpKfMsgList);
    }

}
