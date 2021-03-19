package top.codewood.wx.pay.v2.bean.profitsharing;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Receiver implements Serializable {

    /**
     * 分账接收方类型
     * MERCHANT_ID：商户号（mch_id或者sub_mch_id）
     * PERSONAL_OPENID：个人openid
     */
    private String type;

    /**
     * 分账接收方帐号
     * 类型是MERCHANT_ID时，是商户号（mch_id或者sub_mch_id）
     * 类型是PERSONAL_OPENID时，是个人openid
     */
    private String account;

    /**
     * 分账金额
     * 分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
     */
    private int amount;

    /**
     * 分账描述
     * 分账的原因描述，分账账单中需要体现
     */
    private String description;

    /**
     * 分账个人接收方姓名
     * 可选项，在接收方类型为个人的时可选填，若有值，会检查与 name 是否实名匹配，不匹配会拒绝分账请求
     * 1、分账接收方类型是PERSONAL_OPENID时，是个人姓名（选传，传则校验）
     */
    private String name;

    /**
     * 与分账方的关系类型
     * 子商户与接收方的关系。
     * 本字段值为枚举：
     * SERVICE_PROVIDER：服务商
     * STORE：门店
     * STAFF：员工
     * STORE_OWNER：店主
     * PARTNER：合作伙伴
     * HEADQUARTER：总部
     * BRAND：品牌方
     * DISTRIBUTOR：分销商
     * USER：用户
     * SUPPLIER：供应商
     * CUSTOM：自定义
     */
    @SerializedName("relation_type")
    private String relationType;

    /**
     * 自定义的分账关系
     * 子商户与接收方具体的关系，本字段最多10个字。
     * 当字段relation_type的值为CUSTOM时，本字段必填
     * 当字段relation_type的值不为CUSTOM时，本字段无需填写
     */
    @SerializedName("custom_relation")
    private String customRelation;

    public Receiver() {}

    /**
     * 单次分账
     * @param type  分账接收方类型
     *              MERCHANT_ID：商户号（mch_id或者sub_mch_id）
     *              PERSONAL_OPENID：个人openid
     * @param account   分账接收方帐号
     *                  类型是MERCHANT_ID时，是商户号（mch_id或者sub_mch_id）
     *                  类型是PERSONAL_OPENID时，是个人openid
     * @param amount    分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
     * @param description     分账的原因描述，分账账单中需要体现
     */
    public Receiver(String type, String account, int amount, String description) {
        this.type = type;
        this.account = account;
        this.amount = amount;
        this.description = description;
    }

    /**
     * 添加分账接收方
     *
     * @param type  分账接收方类型
     *              MERCHANT_ID：商户号（mch_id或者sub_mch_id）
     *              PERSONAL_OPENID：个人openid
     * @param account   分账接收方帐号
     *                  类型是MERCHANT_ID时，是商户号（mch_id或者sub_mch_id）
     *                  类型是PERSONAL_OPENID时，是个人openid
     * @param name
     * @param relationType   与分账方的关系类型
     *                       子商户与接收方的关系。
     *                       本字段值为枚举：
     *                       SERVICE_PROVIDER：服务商
     *                       STORE：门店
     *                       STAFF：员工
     *                       STORE_OWNER：店主
     *                       PARTNER：合作伙伴
     *                       HEADQUARTER：总部
     *                       BRAND：品牌方
     *                       DISTRIBUTOR：分销商
     *                       USER：用户
     *                       SUPPLIER：供应商
     *                       CUSTOM：自定义
     * @param customRelation   自定义的分账关系
     *                         子商户与接收方具体的关系，本字段最多10个字。
     *                         当字段relation_type的值为CUSTOM时，本字段必填
     *                         当字段relation_type的值不为CUSTOM时，本字段无需填写
     */
    public Receiver(String type, String account, String name, String relationType, String customRelation) {
        this.type = type;
        this.account = account;
        this.name = name;
        this.relationType = relationType;
        this.customRelation = customRelation;
    }

    /**
     * 删除分账接收方
     *
     * @param type  分账接收方类型
     *              MERCHANT_ID：商户号（mch_id或者sub_mch_id）
     *              PERSONAL_OPENID：个人openid
     * @param account   分账接收方帐号
     *                  类型是MERCHANT_ID时，是商户号（mch_id或者sub_mch_id）
     *                  类型是PERSONAL_OPENID时，是个人openid
     */
    public Receiver(String type, String account) {
        this.type = type;
        this.account = account;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Receiver{" +
                "type='" + type + '\'' +
                ", account='" + account + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", relationType='" + relationType + '\'' +
                ", customRelation='" + customRelation + '\'' +
                '}';
    }
}
