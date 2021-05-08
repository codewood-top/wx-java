package top.codewood.wx.mnp.bean.live;

import java.io.Serializable;

public class WxMnpLiveGoodsAddResult implements Serializable {

    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 审核单ID
     */
    private Integer auditId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }
}
