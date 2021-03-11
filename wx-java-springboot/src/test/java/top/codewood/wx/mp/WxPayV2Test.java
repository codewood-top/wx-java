package top.codewood.wx.mp;

import top.codewood.wx.pay.v2.api.EntPayApi;
import top.codewood.wx.pay.v2.api.WxPayV2Api;
import top.codewood.wx.pay.v2.bean.redpack.WxPayRedPackQueryRequest;
import top.codewood.wx.pay.v2.bean.redpack.WxPayRedPackQueryResult;
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


}
