package top.codewood.wx.pay.v2.bean.redpack;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;

@XStreamAlias("xml")
public class WxPayGroupRedPackRequest extends WxPayRedPackRequest {

    /**
     * 红包金额设置方式
     * 红包金额设置方式
     * ALL_RAND—全部随机,商户指定总金额和红包发放总人数，由微信支付随机计算出各红包金额
     */
    @Required
    @XStreamAlias("amt_type")
    private String amtType = "ALL_RAND";

    public String getAmtType() {
        return amtType;
    }

    public void setAmtType(String amtType) {
        this.amtType = amtType;
    }

    public static class Builder extends WxPayRedPackRequest.Builder<Builder> {

        private String amtType;

        public Builder amtType(String amtType) {
            this.amtType = amtType;
            return this;
        }

        public WxPayGroupRedPackRequest build() {
            WxPayGroupRedPackRequest groupRedPackRequest = new WxPayGroupRedPackRequest();
            groupRedPackRequest.setWxAppid(this.wxAppid);
            groupRedPackRequest.setMchid(this.mchId);
            groupRedPackRequest.setNonceStr(this.nonceStr);
            groupRedPackRequest.setSign(this.sign);
            groupRedPackRequest.setMchBillNo(this.mchBillNo);
            groupRedPackRequest.setSendName(this.sendName);
            groupRedPackRequest.setReOpenid(this.reOpenid);
            groupRedPackRequest.setTotalAmount(this.totalAmount);
            groupRedPackRequest.setTotalNum(this.totalNum);
            groupRedPackRequest.setWishing(this.wishing);
            groupRedPackRequest.setActName(this.actName);
            groupRedPackRequest.setClientIp(this.clientIp);
            groupRedPackRequest.setActName(this.actName);
            groupRedPackRequest.setRemark(this.remark);
            groupRedPackRequest.setSceneId(this.sceneId);
            groupRedPackRequest.setRiskInfo(this.riskInfo);

            if (this.amtType != null) {
                groupRedPackRequest.setAmtType(this.amtType);
            }

            return groupRedPackRequest;
        }
    }

}
