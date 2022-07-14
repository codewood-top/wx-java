package top.codewood.wx.mnp.bean.express.business;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressBindAccountRequest implements Serializable {

    /**
     * 必填：是
     * bind表示绑定，unbind表示解除绑定
     */
    private String type;
    /**
     * 必填：是
     * 快递公司客户编码
     */
    @SerializedName("biz_id")
    private String bizId;
    /**
     * 必填：是
     * 快递公司ID
     */
    @SerializedName("delivery_id")
    private String deliveryId;
    /**
     * 必填：否
     * 快递公司客户密码, ems，顺丰，京东非必填
     */
    private String password;

    /**
     * 必填：否
     * 备注内容（提交 EMS 审核需要）
     * 格式要求：
     * 电话：xxxxx
     * 联系人：xxxxx
     * 服务类型：xxxxx
     * 发货地址：xxxx
     */
    @SerializedName("remark_content")
    private String remarkContent;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent;
    }

    @Override
    public String toString() {
        return "WxMnpExpressBindAccountRequest{" +
                "type='" + type + '\'' +
                ", bizId='" + bizId + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", password='" + password + '\'' +
                ", remarkContent='" + remarkContent + '\'' +
                '}';
    }
}
