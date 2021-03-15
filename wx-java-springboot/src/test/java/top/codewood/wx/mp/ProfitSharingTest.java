package top.codewood.wx.mp;

import com.google.gson.Gson;
import org.junit.Test;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.api.ProfitSharingApi;
import top.codewood.wx.pay.v2.api.WxPayV2Api;
import top.codewood.wx.pay.v2.bean.profitsharing.*;
import top.codewood.wx.util.Strings;

import java.util.Arrays;
import java.util.List;

public class ProfitSharingTest {

    @Test
    public void addReceiverTest() {
        Receiver receiver = new Receiver("PERSONAL_OPENID", "", "", "STAFF", "");
        ProfitSharingReceiverRequest receiverRequest = new ProfitSharingReceiverRequest();
        receiverRequest.setReceiver(new Gson().toJson(receiver));
        receiverRequest.setMchid("");
        receiverRequest.setAppid("");
        receiverRequest.setNonceStr(Strings.randomString(32));

        receiverRequest.setSign(WxPayV2Api.sign(receiverRequest, "", receiverRequest.getSignType()));

        ProfitSharingReceiverResult result = ProfitSharingApi.getInstance().addReceiver(receiverRequest);
        System.out.println(result);

    }

    @Test
    public void profitSharingTest() {
        ProfitSharingRequest request = new ProfitSharingRequest();
        request.setOutOrderNo("");
        request.setMchid("");
        request.setAppid("");
        request.setTransactionId("");
        request.setNonceStr(Strings.randomString(32));

        Receiver receiver = new Receiver("PERSONAL_OPENID", "", 11, "测试分账");
        List<Receiver> receivers = Arrays.asList(receiver);

        request.setReceivers(new Gson().toJson(receivers));
        request.setSign(WxPayV2Api.sign(request, "", request.getSignType()));

        ProfitSharingResult result = ProfitSharingApi.getInstance().request(request, "", this.getClass().getResourceAsStream(""));
        System.out.println(result);


    }

    @Test
    public void profitSharingAmountQueryTest() {
        ProfitSharingAmountQueryRequest amountQueryRequest = new ProfitSharingAmountQueryRequest();
        amountQueryRequest.setTransactionId("");
        amountQueryRequest.setMchid("");
        amountQueryRequest.setNonceStr(Strings.randomString(32));

        amountQueryRequest.setSign(WxPayV2Api.sign(amountQueryRequest, "", amountQueryRequest.getSignType()));

        ProfitSharingAmountQueryResult result = ProfitSharingApi.getInstance().orderAmountQuery(amountQueryRequest);
        System.out.println(result);

    }


    @Test
    public void profitSharingQueryTest() {
        ProfitSharingQueryRequest queryRequest = new ProfitSharingQueryRequest();
        queryRequest.setOutOrderNo("");
        queryRequest.setMchid("");
        queryRequest.setNonceStr(Strings.randomString(32));
        queryRequest.setTransactionId("");

        queryRequest.setSign(WxPayV2Api.sign(queryRequest, "", WxPayConstants.SignType.HMAC_SHA256));

        ProfitSharingQueryResult queryResult = ProfitSharingApi.getInstance().query(queryRequest);
        System.out.println(queryResult);

    }

}