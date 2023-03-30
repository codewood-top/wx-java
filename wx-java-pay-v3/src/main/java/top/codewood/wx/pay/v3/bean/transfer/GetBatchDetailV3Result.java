package top.codewood.wx.pay.v3.bean.transfer;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class GetBatchDetailV3Result implements Serializable {

    /**
     * 【商户号】 微信支付分配的商户号
     */
    private String mchid;

    /**
     * 【商家批次单号】 商户系统内部的商家批次单号，在商户系统内部唯一
     */
    @SerializedName("out_batch_no")
    private String outBatchNo;

    /**
     * 【微信批次单号】 微信批次单号，微信商家转账系统返回的唯一标识
     */
    @SerializedName("batch_id")
    private String batchId;

    /**
     * 【商户appid】 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appid）
     */
    private String appid;

    /**
     * 【商家明细单号】 商户系统内部区分转账批次单下不同转账明细单的唯一标识
     */
    @SerializedName("out_detail_no")
    private String outDetailNo;

    /**
     * 【微信明细单号】 微信支付系统内部区分转账批次单下不同转账明细单的唯一标识
     */
    @SerializedName("detail_id")
    private String detailId;

    /**
     * 【明细状态】 INIT: 初始态。 系统转账校验中
     * WAIT_PAY: 待确认。待商户确认, 符合免密条件时, 系统会自动扭转为转账中
     * PROCESSING:转账中。正在处理中，转账结果尚未明确
     * SUCCESS:转账成功
     * FAIL:转账失败。需要确认失败原因后，再决定是否重新发起对该笔明细单的转账（并非整个转账批次单）
     */
    @SerializedName("status_status")
    private String detailStatus;

    /**
     * 【转账金额】 转账金额单位为“分”
     */
    @SerializedName("transfer_amount")
    private Integer transferAmount;

    /**
     * 【转账备注】 单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符
     */
    @SerializedName("transfer_remark")
    private String transferRemark;

    /**
     * 【明细失败原因】 如果转账失败则有失败原因
     * 可选取值：
     * ACCOUNT_FROZEN: 该用户账户被冻结
     * REAL_NAME_CHECK_FAIL: 收款人未实名认证，需要用户完成微信实名认证
     * NAME_NOT_CORRECT: 收款人姓名校验不通过，请核实信息
     * OPENID_INVALID: Openid格式错误或者不属于商家公众账号
     * TRANSFER_QUOTA_EXCEED: 超过用户单笔收款额度，核实产品设置是否准确
     * DAY_RECEIVED_QUOTA_EXCEED: 超过用户单日收款额度，核实产品设置是否准确
     * MONTH_RECEIVED_QUOTA_EXCEED: 超过用户单月收款额度，核实产品设置是否准确
     * DAY_RECEIVED_COUNT_EXCEED: 超过用户单日收款次数，核实产品设置是否准确
     * PRODUCT_AUTH_CHECK_FAIL: 未开通该权限或权限被冻结，请核实产品权限状态
     * OVERDUE_CLOSE: 超过系统重试期，系统自动关闭
     * ID_CARD_NOT_CORRECT: 收款人身份证校验不通过，请核实信息
     * ACCOUNT_NOT_EXIST: 该用户账户不存在
     * TRANSFER_RISK: 该笔转账可能存在风险，已被微信拦截
     * OTHER_FAIL_REASON_TYPE: 其它失败原因
     * REALNAME_ACCOUNT_RECEIVED_QUOTA_EXCEED: 请引导用户在微信支付查看详情
     * RECEIVE_ACCOUNT_NOT_PERMMIT: 请在产品设置中调整，添加该用户为收款人
     * PAYEE_ACCOUNT_ABNORMAL: 请联系用户完善其在微信支付的身份信息以继续收款
     * PAYER_ACCOUNT_ABNORMAL: 可前往商户平台获取解除功能限制指引
     * TRANSFER_SCENE_UNAVAILABLE: 该转账场景暂不可用，请确认转账场景ID是否正确
     * TRANSFER_SCENE_INVALID: 你尚未获取该转账场景，请确认转账场景ID是否正确
     * TRANSFER_REMARK_SET_FAIL: 转账备注设置失败， 请调整后重新再试
     * RECEIVE_ACCOUNT_NOT_CONFIGURE: 请前往商户平台-商家转账到零钱-前往功能-转账场景中添加
     * BLOCK_B2C_USERLIMITAMOUNT_BSRULE_MONTH: 超出用户单月转账收款20w限额，本月不支持继续向该用户付款
     * BLOCK_B2C_USERLIMITAMOUNT_MONTH: 用户账户存在风险收款受限，本月不支持继续向该用户付款
     * MERCHANT_REJECT: 商户员工（转账验密人）已驳回转账
     * MERCHANT_NOT_CONFIRM: 商户员工（转账验密人）超时未验密
     */
    @SerializedName("fail_reason")
    private String failReason;

    /**
     * 【收款用户openid】 商户appid下，某用户的openid
     */
    private String openid;

    /**
     * 【收款用户姓名】 收款方姓名。采用标准RSA算法，公钥由微信侧提供
     * 商户转账时传入了收款用户姓名、查询时会返回收款用户姓名
     */
    @SerializedName("user_name")
    private String userName;

    /**
     * 【转账发起时间】 转账发起的时间，按照使用rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE
     */
    @SerializedName("initiate_time")
    private OffsetDateTime initiateTime;

    /**
     * 【明细更新时间】 明细最后一次状态变更的时间，按照使用rfc3339所定义的格式，格式为YYYY-MM-DDThh:mm:ss+TIMEZONE
     */
    @SerializedName("update_time")
    private OffsetDateTime updateTime;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getOutBatchNo() {
        return outBatchNo;
    }

    public void setOutBatchNo(String outBatchNo) {
        this.outBatchNo = outBatchNo;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOutDetailNo() {
        return outDetailNo;
    }

    public void setOutDetailNo(String outDetailNo) {
        this.outDetailNo = outDetailNo;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(String detailStatus) {
        this.detailStatus = detailStatus;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Integer transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getTransferRemark() {
        return transferRemark;
    }

    public void setTransferRemark(String transferRemark) {
        this.transferRemark = transferRemark;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OffsetDateTime getInitiateTime() {
        return initiateTime;
    }

    public void setInitiateTime(OffsetDateTime initiateTime) {
        this.initiateTime = initiateTime;
    }

    public OffsetDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "GetBatchDetailV3Result{" +
                "mchid='" + mchid + '\'' +
                ", outBatchNo='" + outBatchNo + '\'' +
                ", batchId='" + batchId + '\'' +
                ", appid='" + appid + '\'' +
                ", outDetailNo='" + outDetailNo + '\'' +
                ", detailId='" + detailId + '\'' +
                ", detailStatus='" + detailStatus + '\'' +
                ", transferAmount=" + transferAmount +
                ", transferRemark='" + transferRemark + '\'' +
                ", failReason='" + failReason + '\'' +
                ", openid='" + openid + '\'' +
                ", userName='" + userName + '\'' +
                ", initiateTime=" + initiateTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
