package top.codewood.wx.pay.v2.bean.profitsharing;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

/**
 * order_id & out_order_no 二选一
 */
@XStreamAlias("xml")
public class ProfitSharingReturnQueryRequest extends WxPayBaseRequest {

    /**
     * 签名类型，目前只支持HMAC-SHA256
     */
    @XStreamAlias("sign_type")
    private String signType = WxPayConstants.SignType.HMAC_SHA256;

    /**
     * 微信分账订单号
     * 原发起分账请求时，微信返回的微信分账单号，与商户分账单号一一对应。
     * 微信分账单号与商户分账单号二选一填写
     */
    @XStreamAlias("order_id")
    private String orderId;

    /**
     * 商户分账单号
     * 原发起分账请求时使用的商户系统内部的分账单号。
     * 微信分账单号与商户分账单号二选一填写
     */
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    /**
     * 商户回退单号
     * 调用回退接口提供的商户系统内部的回退单号
     */
    @Required
    @XStreamAlias("out_return_no")
    private String outReturnNo;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOutReturnNo() {
        return outReturnNo;
    }

    public void setOutReturnNo(String outReturnNo) {
        this.outReturnNo = outReturnNo;
    }
}
