package top.codewood.wx.pay.v3.bean.profitsharing;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProfitSharingReceiverAddV3Request implements Serializable {

    /**
     * 微信分配的公众账号ID
     */
    private String appid;
    /**
     * 分账接收方类型
     * 枚举值：
     * MERCHANT_ID：商户ID
     * PERSONAL_OPENID：个人openid（由父商户APPID转换得到）
     */
    private String type;
    /**
     * 分账接收方账号
     * 类型是MERCHANT_ID时，是商户号
     * 类型是PERSONAL_OPENID时，是个人openid
     */
    private String account;
    /**
     * 分账个人接收方姓名
     * 分账接收方类型是MERCHANT_ID时，是商户全称（必传），当商户是小微商户或个体户时，是开户人姓名 分账接收方类型是PERSONAL_OPENID时，是个人姓名（选传，传则校验）
     * 1、此字段需要加密，加密方法详见：敏感信息加密说明
     * 2、使用微信支付平台证书中的公钥：获取平台证书
     * 3、使用RSAES-OAEP算法进行加密
     * 4、将请求中HTTP头部的Wechatpay-Serial设置为证书序列号
     */
    private String name;
    /**
     * 与分账方的关系类型
     * 子商户与接收方的关系。 本字段值为枚举：
     * STORE：门店
     * STAFF：员工
     * STORE_OWNER：店主
     * PARTNER：合作伙伴
     * HEADQUARTER：总部
     * BRAND：品牌方
     * DISTRIBUTOR：分销商
     * USER：用户
     * SUPPLIER： 供应商
     * CUSTOM：自定义
     */
    @SerializedName("relation_type")
    private String relationType;
    /**
     * 自定义的分账关系
     * 子商户与接收方具体的关系，本字段最多10个字。
     * 当字段relation_type的值为CUSTOM时，本字段必填;
     * 当字段relation_type的值不为CUSTOM时，本字段无需填写。
     */
    @SerializedName("custom_relation")
    private String customRelation;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getCustomRelation() {
        return customRelation;
    }

    public void setCustomRelation(String customRelation) {
        this.customRelation = customRelation;
    }
}
