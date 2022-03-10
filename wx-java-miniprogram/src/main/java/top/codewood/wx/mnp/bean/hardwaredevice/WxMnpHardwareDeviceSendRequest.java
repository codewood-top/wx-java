package top.codewood.wx.mnp.bean.hardwaredevice;

import com.google.gson.annotations.SerializedName;
import top.codewood.wx.mnp.bean.WxMnpTemplateData;

import java.io.Serializable;
import java.util.List;

public class WxMnpHardwareDeviceSendRequest implements Serializable {

    /**
     * 必填
     * 接收者（用户）的 openid 列表
     */
    @SerializedName("to_openid_list")
    private List<String> toOpenidList;

    /**
     * 必填
     * 所需下发的订阅模板id
     */
    @SerializedName("template_id")
    private String templateId;

    /**
     * 必填
     * 设备唯一序列号。由厂商分配，长度不能超过128字节。字符只接受数字，大小写字母，下划线（_）和连字符（-）。
     */
    private String sn;

    /**
     * 必填
     * 设备型号 id ，通过注册设备获得。
     */
    private String modelId;

    /**
     * 必填
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
     */
    private String page;

    /**
     * 必填
     * 模板内容，格式形如 { "key1": { "value": "xxx" }, "key2": { "value": "xxx" } } ，value 为枚举值。
     */
    private List<WxMnpTemplateData> data;

    /**
     * 必填：否
     * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
     */
    @SerializedName("miniprogram_state")
    private String miniprogramState;

    /**
     * 必填：否
     * 进入小程序查看”的语言类型，支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN
     * 返回值
     */
    private String lang;

    public List<String> getToOpenidList() {
        return toOpenidList;
    }

    public void setToOpenidList(List<String> toOpenidList) {
        this.toOpenidList = toOpenidList;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<WxMnpTemplateData> getData() {
        return data;
    }

    public void setData(List<WxMnpTemplateData> data) {
        this.data = data;
    }

    public String getMiniprogramState() {
        return miniprogramState;
    }

    public void setMiniprogramState(String miniprogramState) {
        this.miniprogramState = miniprogramState;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "WxMnpHardwareDeviceSendRequest{" +
                "toOpenidList=" + toOpenidList +
                ", templateId='" + templateId + '\'' +
                ", sn='" + sn + '\'' +
                ", modelId='" + modelId + '\'' +
                ", page='" + page + '\'' +
                ", data=" + data +
                ", miniprogramState='" + miniprogramState + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
