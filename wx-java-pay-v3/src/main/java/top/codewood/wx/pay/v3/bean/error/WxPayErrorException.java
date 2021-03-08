package top.codewood.wx.pay.v3.bean.error;

public class WxPayErrorException extends RuntimeException {

    private WxPayError error;

    public WxPayErrorException(WxPayError wxPayError) {
        super(wxPayError.toString());
        this.error = wxPayError;
    }

    public void setError(WxPayError error) {
        this.error = error;
    }

    public WxPayError getError() {
        return error;
    }
}
