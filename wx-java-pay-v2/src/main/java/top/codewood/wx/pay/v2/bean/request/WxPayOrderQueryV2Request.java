package top.codewood.wx.pay.v2.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * transaction_id || out_trade_no 二选一
 */
@XStreamAlias("xml")
public class WxPayOrderQueryV2Request extends WxPayBaseRequest {

    /**
     * 微信的订单号，建议优先使用
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @XStreamAlias("sign_type")
    private String signType = WxPayConstants.SignType.MD5;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    @Override
    public String toString() {
        return "WxPayOrderQueryV2Request{" +
                "appid='" + appid + '\'' +
                ", mchid='" + mchid + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }
}
