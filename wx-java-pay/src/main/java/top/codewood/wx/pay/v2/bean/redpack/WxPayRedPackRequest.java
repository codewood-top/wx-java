package top.codewood.wx.pay.v2.bean.redpack;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;
import top.codewood.wx.pay.v2.bean.WxPayBaseRequest;

@XStreamAlias("xml")
public class WxPayRedPackRequest extends WxPayBaseRequest {

    /**
     * 公众账号appid
     * 微信分配的公众账号ID（企业号corpid即为此appId）。在微信开放平台（open.weixin.qq.com）申请的移动应用appid无法使用该接口。
     */
    @Required
    @XStreamAlias("wxappid")
    private String wxAppid;



    /**
     * 商户订单号
     * 商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z）
     * 接口根据商户订单号支持重入，如出现超时可再调用。
     */
    @Required
    @XStreamAlias("mch_billno")
    private String mchBillNo;

    /**
     * 商户名称
     * 红包发送者名称
     * 注意：敏感词会被转义成字符*
     */
    @Required
    @XStreamAlias("send_name")
    private String sendName;

    /**
     * 用户openid
     * 接受红包的用户openid
     * openid为用户在wxappid下的唯一标识
     */
    @Required
    @XStreamAlias("re_openid")
    private String reOpenid;

    /**
     * 付款金额
     * 付款金额，单位分
     */
    @Required
    @XStreamAlias("total_amount")
    private int totalAmount;

    /**
     * 红包发放总人数
     * 红包发放总人数
     * total_num=1
     */
    @Required
    @XStreamAlias("total_num")
    private int totalNum;

    /**
     * 红包祝福语
     * 注意：敏感词会被转义成字符*
     */
    @Required
    private String wishing;

    /**
     * Ip地址
     * 调用接口的机器Ip地址
     */
    @Required
    @XStreamAlias("client_ip")
    private String clientIp;

    /**
     * 活动名称
     * 注意：敏感词会被转义成字符*
     */
    @Required
    @XStreamAlias("act_name")
    private String actName;

    /**
     * 备注
     * 备注信息
     */
    @Required
    private String remark;

    /**
     * 场景id
     * 发放红包使用场景，红包金额大于200或者小于1元时必传
     * PRODUCT_1:商品促销
     * PRODUCT_2:抽奖
     * PRODUCT_3:虚拟物品兑奖
     * PRODUCT_4:企业内部福利
     * PRODUCT_5:渠道分润
     * PRODUCT_6:保险回馈
     * PRODUCT_7:彩票派奖
     * PRODUCT_8:税务刮奖
     */
    @XStreamAlias("sceneId")
    private String sceneId;

    /**
     * 活动信息
     * posttime:用户操作的时间戳
     * mobile:业务系统账号的手机号，国家代码-手机号。不需要+号
     * deviceid :mac 地址或者设备唯一标识
     * clientversion :用户操作的客户端版本
     * 把值为非空的信息用key=value进行拼接，再进行urlencode
     * urlencode(posttime=xx& mobile =xx&deviceid=xx)
     */
    @XStreamAlias("rish_info")
    private String riskInfo;

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }

    public String getMchBillNo() {
        return mchBillNo;
    }

    public void setMchBillNo(String mchBillNo) {
        this.mchBillNo = mchBillNo;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getReOpenid() {
        return reOpenid;
    }

    public void setReOpenid(String reOpenid) {
        this.reOpenid = reOpenid;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo;
    }

    public static class Builder<T extends Builder>  {

        protected String wxAppid;
        protected String mchId;
        protected String nonceStr;
        protected String sign;
        protected String mchBillNo;
        protected String sendName;
        protected String reOpenid;
        protected int totalAmount;
        protected int totalNum;
        protected String wishing;
        protected String clientIp;
        protected String actName;
        protected String remark;
        protected String sceneId;
        protected String riskInfo;

        public T wxAppid(String wxAppid) {
            this.wxAppid = wxAppid;
            return (T) this;
        }

        public T mchId(String mchId) {
            this.mchId = mchId;
            return (T) this;
        }

        public T nonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return (T) this;
        }

        public T sign(String sign) {
            this.sign = sign;
            return (T) this;
        }

        public T mchBillNo(String mchBillNo) {
            this.mchBillNo = mchBillNo;
            return (T) this;
        }

        public T sendName(String sendName) {
            this.sendName = sendName;
            return (T) this;
        }

        public T reOpenid(String reOpenid) {
            this.reOpenid = reOpenid;
            return (T) this;
        }

        public T totalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
            return (T) this;
        }

        public T totalNum(int totalNum) {
            this.totalNum = totalNum;
            return (T) this;
        }

        public T wishing(String wishing) {
            this.wishing = wishing;
            return (T) this;
        }

        public T clientIp(String clientIp) {
            this.clientIp = clientIp;
            return (T) this;
        }

        public T actName(String actName) {
            this.actName = actName;
            return (T) this;
        }

        public T remark(String remark) {
            this.remark = remark;
            return (T) this;
        }

        public T sceneId(String sceneId) {
            this.sceneId = sceneId;
            return (T) this;
        }

        public T riskInfo(String riskInfo) {
            this.riskInfo = riskInfo;
            return (T) this;
        }

        public WxPayRedPackRequest build() {
            WxPayRedPackRequest redPackRequest = new WxPayRedPackRequest();
            redPackRequest.setWxAppid(this.wxAppid);
            redPackRequest.setMchid(this.mchId);
            redPackRequest.setNonceStr(this.nonceStr);
            redPackRequest.setSign(sign);
            redPackRequest.setMchBillNo(this.mchBillNo);
            redPackRequest.setSendName(this.sendName);
            redPackRequest.setReOpenid(this.reOpenid);
            redPackRequest.setTotalAmount(this.totalAmount);
            redPackRequest.setTotalNum(this.totalNum);
            redPackRequest.setWishing(this.wishing);
            redPackRequest.setActName(this.actName);
            redPackRequest.setClientIp(this.clientIp);
            redPackRequest.setActName(this.actName);
            redPackRequest.setRemark(this.remark);
            redPackRequest.setSceneId(this.sceneId);
            redPackRequest.setRiskInfo(this.riskInfo);
            return redPackRequest;
        }

    }

}
