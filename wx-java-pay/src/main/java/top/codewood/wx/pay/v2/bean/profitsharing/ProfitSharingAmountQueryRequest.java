package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * 此request不需要传appid
 */
@XStreamAlias("xml")
public class ProfitSharingAmountQueryRequest extends WxPayBaseRequest {

    /**
     * 微信订单号
     */
    @Required
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 签名类型
     * 签名类型，目前只支持HMAC-SHA256
     */
    @Required
    @XStreamAlias("sign_type")
    private String signType = WxPayConstants.SignType.HMAC_SHA256;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
