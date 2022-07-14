package top.codewood.wx.mnp.bean.express;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressService implements Serializable {

    /**
     * 必填：是
     * 服务类型ID，详见<a href="https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/industry/express-old/expressinfo.html">已经支持的快递公司基本信息</a>
     */
    @SerializedName("service_type")
    private String serviceType;
    /**
     * 必填：是
     * 服务名称，详见<a href="https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/industry/express-old/expressinfo.html">已经支持的快递公司基本信息</a>
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
        return "WxMnpExpressService{" +
                "serviceType='" + serviceType + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
