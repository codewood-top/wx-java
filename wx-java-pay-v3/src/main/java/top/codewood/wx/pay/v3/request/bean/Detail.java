package top.codewood.wx.pay.v3.request.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 优惠功能
 *
 */
public class Detail {
    /**
     * 订单原价
     * 1、商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。
     * 2、当订单原价与支付金额不相等，则不享受优惠。
     * 3、该字段主要用于防止同一张小票分多次支付，以享受多次优惠的情况，正常支付订单不必上传此参数。
     */
    @SerializedName("cost_price")
    private int costPrice;
    /**
     * 商品小票ID
     */
    @SerializedName("invoice_id")
    private String invoiceId;
    /**
     * 单品列表
     */
    @SerializedName("goods_detail")
    private GoodsDetail goodsDetail;

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public GoodsDetail getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(GoodsDetail goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
}
