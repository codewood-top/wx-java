package top.codewood.wx.common.bean.error;

public class WxRuntimeException extends RuntimeException {

    public WxRuntimeException(String errorMsg) {
        super(errorMsg);
    }

}
