# xml.msg.demo

```java
public void convertXmlToMessageBean() {
    String XML_STR = "<xml>\n" +
            " <ToUserName><![CDATA[粉丝号]]></ToUserName>\n" +
            " <FromUserName><![CDATA[公众号]]></FromUserName>\n" +
            " <CreateTime>1460541339</CreateTime>\n" +
            " <MsgType><![CDATA[text]]></MsgType>\n" +
            " <Content><![CDATA[test]]></Content>\n" +
            "</xml>";
    WxMpXmlMessage mpXmlMessage = XStreamConverter.fromXml(WxMpXmlMessage.class, XML_STR);
    System.out.println("message bean: " + mpXmlMessage);
}

public void convertMsgToXml() {
    WxMpVideoRespXmlMessage mpRespXmlMessage = new WxMpVideoRespXmlMessage();
    mpRespXmlMessage.setCreateTime(System.currentTimeMillis());
    mpRespXmlMessage.setFromUser("from_user");
    mpRespXmlMessage.setToUser("to_user");
    mpRespXmlMessage.setVideo(new WxMpVideoRespXmlMessage.Video("mediaId001", "标题", "简短描述一下啦"));

    String xml_resp = XStreamConverter.toXml(mpRespXmlMessage);
    System.out.println("xml msg: " + xml_resp);
}

public void convertNewsMsgToXml() {
    WxMpNewsRespXmlMessage mpRespXmlMessage = new WxMpNewsRespXmlMessage();
    mpRespXmlMessage.setCreateTime(System.currentTimeMillis());
    mpRespXmlMessage.setFromUser("from_user");
    mpRespXmlMessage.setToUser("to_user");

    for (int i = 0; i < 3; i++) {
        mpRespXmlMessage.addItem(new WxMpNewsRespXmlMessage.Item("title_" + i, "description_" + i, "picUrl_" + i, "url_" + i));
    }

    String xml_resp = XStreamConverter.toXml(mpRespXmlMessage);
    System.out.println("xml msg: " + xml_resp);
}
```
