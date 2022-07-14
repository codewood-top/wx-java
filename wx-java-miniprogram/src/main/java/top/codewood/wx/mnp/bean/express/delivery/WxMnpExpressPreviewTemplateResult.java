package top.codewood.wx.mnp.bean.express.delivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressPreviewTemplateResult implements Serializable {

    /**
     * 运单ID
     */
    @SerializedName("waybill_id")
    private String waybillId;

    /**
     * 渲染后的面单 HTML 文件（已经过 Base64 编码）
     */
    @SerializedName("rendered_waybill_template")
    private String renderedWaybillTemplate;

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public String getRenderedWaybillTemplate() {
        return renderedWaybillTemplate;
    }

    public void setRenderedWaybillTemplate(String renderedWaybillTemplate) {
        this.renderedWaybillTemplate = renderedWaybillTemplate;
    }
}
