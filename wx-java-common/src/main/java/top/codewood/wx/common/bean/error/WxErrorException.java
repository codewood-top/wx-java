package top.codewood.wx.common.bean.error;

public class WxErrorException extends RuntimeException {

    public WxErrorException(WxError wxError) {
        super(wxError.toString());
    }

    public WxErrorException(String errMsg) {
        super(errMsg);
    }

}
