package top.codewood.wx.pay.v3.request.bean;

/**
 * 订单金额信息
 */
public class Amount {
    /**
     * 订单总金额，单位为分
     */
    private int total;
    /**
     * CNY：人民币，境内商户号仅支持人民币
     */
    private String currency = "CNY";

    public Amount() {}

    public Amount(int total) {
        this.total = total;
    }

    public Amount(int total, String currency) {
        this.total = total;
        this.currency = currency;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
