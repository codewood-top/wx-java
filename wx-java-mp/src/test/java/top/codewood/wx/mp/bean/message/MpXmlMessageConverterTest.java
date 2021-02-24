package top.codewood.wx.mp.bean.message;

import org.junit.Test;
import top.codewood.wx.mp.bean.util.XStreamConverter;

public class MpXmlMessageConverterTest {

    @Test
    public void convertXmlToMessageBean() {
        String XML_STR = "<xml>\n" +
                " <ToUserName><![CDATA[粉丝号]]></ToUserName>\n" +
                " <FromUserName><![CDATA[公众号]]></FromUserName>\n" +
                " <CreateTime>1460541339</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[test]]></Content>\n" +
                "</xml>";
        MpXmlMessage mpXmlMessage = XStreamConverter.fromXml(MpXmlMessage.class, XML_STR);
        System.out.println("message bean: " + mpXmlMessage);
    }

}
