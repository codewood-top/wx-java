package top.codewood.wx.pay.v3.bean.notify;

import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.time.OffsetDateTime;

@XStreamAlias("xml")
public class WxPayNotify implements Serializable {

    /**
     * 通知ID
     * 通知的唯一ID
     */
    private String id;

    /**
     * 通知创建时间
     * 通知创建的时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。
     * 例如：2015-05-20T13:29:35+08:00表示北京时间2015年05月20日13点29分35秒。
     */
    @SerializedName("create_time")
    private OffsetDateTime createTime;
    @SerializedName("resource_type")
    private String resourceType;

    /**
     * 通知类型
     * 通知的类型，
     * 支付成功通知的类型为TRANSACTION.SUCCESS
     * 支付失败通知的类型为TRANSACTION.FAIL
     * 还款通知的类型为TRANSACTION.PAY_BACK
     *
     * REFUND.SUCCESS：退款成功通知
     * REFUND.ABNORMAL：退款异常通知
     * REFUND.CLOSED：退款关闭通知
     *
     * 微信支付分支付成功回调通知
     * 授权成功通知的类型为PAYSCORE.USER_OPEN_SERVICE
     * 解除授权成功通知的类型为PAYSCORE.USER_CLOSE_SERVICE
     * 用户确认成功通知的类型为PAYSCORE.USER_CONFIRM
     * 支付成功通知的类型为PAYSCORE.USER_PAID
     *
     * 商圈会员场内退款通知
     * 退款通知的类型为：MALL_REFUND.SUCCESS
     */
    @SerializedName("event_type")
    private String eventType;

    /**
     * 回调摘要
     * 回调摘要
     * 示例值：支付成功
     */
    private String summary;

    /**
     * 通知数据
     * 通知资源数据
     * json格式
     */
    private Resource resource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * 通知数据
     * 通知资源数据
     * json格式
     */
    public static class Resource implements Serializable {
        /**
         * 加密算法类型
         * 对开启结果数据进行加密的加密算法，目前只支持AEAD_AES_256_GCM
         */
        private String algorithm;
        /**
         * 数据密文
         * Base64编码后的开启/停用结果数据密文
         */
        @SerializedName("ciphertext")
        private String cipherText;
        /**
         * 随机串
         * 加密使用的随机串
         */
        private String nonce;
        /**
         * 原始类型
         * 原始回调类型，为transaction
         */
        @SerializedName("original_type")
        private String originalType;
        /**
         * 附加数据
         *
         */
        @SerializedName("associated_data")
        private String associatedData;

        public String getAlgorithm() {
            return algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public String getCipherText() {
            return cipherText;
        }

        public void setCipherText(String cipherText) {
            this.cipherText = cipherText;
        }

        public String getNonce() {
            return nonce;
        }

        public void setNonce(String nonce) {
            this.nonce = nonce;
        }

        public String getOriginalType() {
            return originalType;
        }

        public void setOriginalType(String originalType) {
            this.originalType = originalType;
        }

        public String getAssociatedData() {
            return associatedData;
        }

        public void setAssociatedData(String associatedData) {
            this.associatedData = associatedData;
        }

        @Override
        public String toString() {
            return "Resource{" +
                    "algorithm='" + algorithm + '\'' +
                    ", cipherText='" + cipherText + '\'' +
                    ", nonce='" + nonce + '\'' +
                    ", originalType='" + originalType + '\'' +
                    ", associatedData='" + associatedData + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WxPayNotify{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", resourceType='" + resourceType + '\'' +
                ", eventType='" + eventType + '\'' +
                ", summary='" + summary + '\'' +
                ", resource=" + resource +
                '}';
    }
}
