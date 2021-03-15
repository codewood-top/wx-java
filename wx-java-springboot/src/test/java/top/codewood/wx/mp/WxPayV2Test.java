package top.codewood.wx.mp;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import top.codewood.wx.common.util.xml.XStreamConverter;
import top.codewood.wx.pay.v2.api.EntPayApi;
import top.codewood.wx.pay.v2.api.WxPayV2Api;
import top.codewood.wx.pay.v2.bean.notify.WxPayV2Notify;
import top.codewood.wx.pay.v2.bean.redpack.WxPayRedPackQueryRequest;
import top.codewood.wx.pay.v2.bean.redpack.WxPayRedPackQueryResult;
import top.codewood.wx.pay.v2.bean.request.WxPayOrderCloseV2Request;
import top.codewood.wx.pay.v2.bean.request.WxPayOrderQueryV2Request;
import top.codewood.wx.pay.v2.bean.result.WxPayOrderCloseV2Result;
import top.codewood.wx.pay.v2.bean.result.WxPayOrderQueryV2Result;
import top.codewood.wx.util.Strings;

import java.io.InputStream;

public class WxPayV2Test {

    //@Test
    public void redPackQueryTest() {
        String appid = "", mchid = "", tradeNo = "", key= "", certFilePath = "";
        WxPayRedPackQueryRequest redPackQueryRequest = new WxPayRedPackQueryRequest();
        redPackQueryRequest.setAppid(appid);
        redPackQueryRequest.setMchBillNo(tradeNo);
        redPackQueryRequest.setMchid(mchid);
        redPackQueryRequest.setNonceStr(Strings.randomString(32));
        redPackQueryRequest.setSign(WxPayV2Api.sign(redPackQueryRequest, key));
        InputStream certFileInputStream = this.getClass().getResourceAsStream(certFilePath);
        WxPayRedPackQueryResult redPackQueryResult = EntPayApi.getInstance().queryRedPack(redPackQueryRequest, mchid, certFileInputStream);
        System.out.println(redPackQueryResult);
    }


    //@Test
    public void xmlPathValueTest() throws DocumentException {
        String xml = "<xml>\n" +
                "    <coupon_type_0><![CDATA[CASH]]></coupon_type_0>\n" +
                "    <coupon_id_0><![CDATA[10000]]></coupon_id_0>\n" +
                "    <coupon_fee_0><![CDATA[100]]></coupon_fee_0>\n" +
                "    <coupon_type_1><![CDATA[NO_CASH]]></coupon_type_1>\n" +
                "    <coupon_id_1><![CDATA[10001]]></coupon_id_1>\n" +
                "    <coupon_fee_1><![CDATA[101]]></coupon_fee_1>\n" +
                "</xml>";

        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        String val = root.elementText("coupon_type_1");
        System.out.println(val);

    }

    //@Test
    public void xmlToResultTest() {
        String xml = "<xml>\n" +
                "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "  <attach><![CDATA[支付测试]]></attach>\n" +
                "  <bank_type><![CDATA[CFT]]></bank_type>\n" +
                "  <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "  <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
                "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
                "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
                "  <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n" +
                "  <time_end><![CDATA[20140903131540]]></time_end>\n" +
                "  <total_fee>1</total_fee>\n" +
                "  <coupon_fee><![CDATA[10]]></coupon_fee>\n" +
                "  <coupon_count><![CDATA[1]]></coupon_count>\n" +
                "  <coupon_type><![CDATA[CASH]]></coupon_type>\n" +
                "  <coupon_id><![CDATA[10000]]></coupon_id>\n" +
                "  <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
                "</xml>";

        WxPayV2Notify wxPayV2Notify = XStreamConverter.fromXml(WxPayV2Notify.class, xml);
        System.out.println(wxPayV2Notify);

    }

}
