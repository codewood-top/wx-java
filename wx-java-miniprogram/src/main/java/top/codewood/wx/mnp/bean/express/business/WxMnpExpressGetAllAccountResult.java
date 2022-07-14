package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class WxMnpExpressGetAllAccountResult implements Serializable {

    /**
     * 账号数量
     */
    private Integer count;
    /**
     * 账号列表
     */
    private List<Account>  list;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "WxMnpExpressGetAllAccountResult{" +
                "count=" + count +
                ", list=" + list +
                '}';
    }

    public static class Account implements Serializable {
        /**
         * 快递公司客户编码
         */
        @SerializedName("biz_id")
        private String bizId;
        /**
         * 快递公司ID
         */
        @SerializedName("delivery_id")
        private String deliveryId;
        /**
         * 账号绑定时间
         */
        @SerializedName("create_time")
        private Integer createTime;
        /**
         * 账号更新时间
         */
        @SerializedName("update_time")
        private Integer updateTime;
        /**
         * 绑定状态
         */
        @SerializedName("status_code")
        private Integer statusCode;
        /**
         * 账号别名
         */
        private String alias;
        /**
         * 账号绑定失败的错误信息（EMS审核结果）
         */
        @SerializedName("remark_wrong_msg")
        private String remarkWrongMsg;
        /**
         * 账号绑定时的备注内容（提交 EMS 审核需要）
         */
        @SerializedName("remark_content")
        private String remarkContent;
        /**
         * 电子面单余额
         */
        @SerializedName("quota_num")
        private BigDecimal quotaNum;
        /**
         * 电子面单余额更新时间
         */
        @SerializedName("quota_update_time")
        private Integer quotaUpdateTime;

        public String getBizId() {
            return bizId;
        }

        public void setBizId(String bizId) {
            this.bizId = bizId;
        }

        public String getDeliveryId() {
            return deliveryId;
        }

        public void setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
        }

        public Integer getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Integer createTime) {
            this.createTime = createTime;
        }

        public Integer getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Integer updateTime) {
            this.updateTime = updateTime;
        }

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getRemarkWrongMsg() {
            return remarkWrongMsg;
        }

        public void setRemarkWrongMsg(String remarkWrongMsg) {
            this.remarkWrongMsg = remarkWrongMsg;
        }

        public String getRemarkContent() {
            return remarkContent;
        }

        public void setRemarkContent(String remarkContent) {
            this.remarkContent = remarkContent;
        }

        public BigDecimal getQuotaNum() {
            return quotaNum;
        }

        public void setQuotaNum(BigDecimal quotaNum) {
            this.quotaNum = quotaNum;
        }

        public Integer getQuotaUpdateTime() {
            return quotaUpdateTime;
        }

        public void setQuotaUpdateTime(Integer quotaUpdateTime) {
            this.quotaUpdateTime = quotaUpdateTime;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "bizId='" + bizId + '\'' +
                    ", deliveryId='" + deliveryId + '\'' +
                    ", createTime=" + createTime +
                    ", updateTime=" + updateTime +
                    ", statusCode=" + statusCode +
                    ", alias='" + alias + '\'' +
                    ", remarkWrongMsg='" + remarkWrongMsg + '\'' +
                    ", remarkContent='" + remarkContent + '\'' +
                    ", quotaNum=" + quotaNum +
                    ", quotaUpdateTime=" + quotaUpdateTime +
                    '}';
        }
    }

    public static class ServiceType implements Serializable {
        /**
         * 服务类型ID
         */
        @SerializedName("service_type")
        private String serviceType;
        /**
         * 服务类型名称
         */
        @SerializedName("service_name")
        private String serviceName;

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        @Override
        public String toString() {
            return "ServiceType{" +
                    "serviceType='" + serviceType + '\'' +
                    ", serviceName='" + serviceName + '\'' +
                    '}';
        }
    }

}
