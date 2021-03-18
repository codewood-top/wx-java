package top.codewood.wx.mp;

import top.codewood.wx.service.WxMpTemplateApi;
import top.codewood.wx.mp.bean.template.*;

import java.util.List;

public class WxTemplateTest {

    String accessToken = "";

    //@Test
    public void setIndustryTest() {
        WxMpTemplateApi.getInstance().setIndustry(accessToken, WxMpTemplateIndustryEnum.E_COMMERCE.getCode(), WxMpTemplateIndustryEnum.IT_SOFTWARE_AND_SERVICES.getCode());
    }

    //@Test
    public void getIndustryTest() {
        WxMpTemplateIndustry templateIndustry = WxMpTemplateApi.getInstance().getIndustry(accessToken);
        System.out.println(templateIndustry);
    }

    //@Test
    public void addTemplateTest() {
        String templateIdShort = "TM00351";
        String templateId = WxMpTemplateApi.getInstance().addTemplate(accessToken, templateIdShort);
        System.out.println("template_id: " + templateId);
    }

    //@Test
    public void listPrivateTemplateTest() {
        List<WxMpTemplate> templates = WxMpTemplateApi.getInstance().listPrivateTemplate(accessToken);
        templates.forEach(template -> System.out.println(template));
    }

    //@Test
    public void delPrivateTemplateTest() {
        String templateId = "_VKKVbgKwoUVnppUoW26ToGxsEkvDs1BSjOdu8Edjdc";
        WxMpTemplateApi.getInstance().delPrivateTemplate(accessToken, templateId);
    }

    //@Test
    public void sendTemplateTest() {
        String openid = "o_OzS5uSJf1Br8H9gLQ66NjfwluM", templateId = "6g9aLzkCaImn5f02dqnDczh0r_W_IdztRweNSE9vh9U";
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(templateId);
        templateMessage.setToUser(openid);
        templateMessage.setUrl("http://codewood.top");
        templateMessage
                .addData(new WxMpTemplateData("first", "新订单通知"))
                .addData(new WxMpTemplateData("tradeDateTime", "2021-03-02 22:30"))
                .addData(new WxMpTemplateData("orderType", "商品订单"))
                .addData(new WxMpTemplateData("customerInfo", "小张 134****1234"))
                .addData(new WxMpTemplateData("orderItemName", "购买商品"))
                .addData(new WxMpTemplateData("orderItemData", "开发案例1"))
                .addData(new WxMpTemplateData("remark", "来自微信公众号"));
        String msgid = WxMpTemplateApi.getInstance().sendTemplateMessage(accessToken, templateMessage);
        System.out.println("msgid: " + msgid);
    }

}