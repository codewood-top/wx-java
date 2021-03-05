package top.codewood.wx.pay.v3.request.bean;

/**
 * 单品列表信息
 */
public class GoodsDetail {

    /**
     * 商户侧商品编码
     * 由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。
     */
    private String merchantGoodsId;
    /**
     * 微信侧商品编码
     * 微信支付定义的统一商品编号（没有可不传）
     */
    private String wechatPayGoodsId;
    /**
     * 商品名称
     * 商品的实际名称
     */
    private String goodsName;
    /**
     * 商品数量
     * 用户购买的数量
     */
    private int quantity;
    /**
     * 商品单价
     * 商品单价，单位为分
     */
    private int unitPrice;

    public String getMerchantGoodsId() {
        return merchantGoodsId;
    }

    public void setMerchantGoodsId(String merchantGoodsId) {
        this.merchantGoodsId = merchantGoodsId;
    }

    public String getWechatPayGoodsId() {
        return wechatPayGoodsId;
    }

    public void setWechatPayGoodsId(String wechatPayGoodsId) {
        this.wechatPayGoodsId = wechatPayGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
