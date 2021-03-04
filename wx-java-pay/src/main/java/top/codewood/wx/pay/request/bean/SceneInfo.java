package top.codewood.wx.pay.request.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 场景信息
 * 支付场景描述
 */
public class SceneInfo {

    /**
     * 用户终端IP
     * 调用微信支付API的机器IP，支持IPv4和IPv6两种格式的IP地址
     */
    @SerializedName("payer_client_ip")
    private String payerClientIp;
    /**
     * 商户端设备号
     * 商户端设备号（门店号或收银设备ID
     */
    @SerializedName("device_id")
    private String deviceId;
    /**
     * 商户门店信息
     */
    @SerializedName("store_info")
    private StoreInfo storeInfo;

    public String getPayerClientIp() {
        return payerClientIp;
    }

    public void setPayerClientIp(String payerClientIp) {
        this.payerClientIp = payerClientIp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public StoreInfo getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        this.storeInfo = storeInfo;
    }
}
