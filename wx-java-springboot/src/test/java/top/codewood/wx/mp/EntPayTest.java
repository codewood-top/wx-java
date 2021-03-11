package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.common.util.xml.XStreamConverter;
import top.codewood.wx.pay.v2.api.WxPayV2Api;
import top.codewood.wx.pay.v2.bean.entpay.EntPayRequest;
import top.codewood.wx.util.Strings;

public class EntPayTest {

    //@Test
    public void entPayRequestTest() {

        EntPayRequest entPayRequest = new EntPayRequest();
        entPayRequest.setMchAppid("wx8888888888888888");
        entPayRequest.setMchid("1900000109");
        entPayRequest.setNonceStr(Strings.randomString(32));
        entPayRequest.setPartnerTradeNo("10000098201411111234567890");
        entPayRequest.setOpenid("oxTWIuGaIt6gTKsQRLau2M0yL16E");
        entPayRequest.setAmount(1);
        entPayRequest.setDesc("测试企业付款");

        entPayRequest.setSign(WxPayV2Api.sign(entPayRequest, "12312313"));
        String xml = XStreamConverter.toXml(entPayRequest);
        System.out.println("xml: " + xml);

    }

}
