package top.codewood.wx.pay.request.bean;

/**
 * 支付者信息
 */
public class Payer {
    /**
     * 用户在直连商户appid下的唯一标识。
     */
    private String openid;

    public Payer() {}

    public Payer(String openid) {
        this.openid = openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

}
