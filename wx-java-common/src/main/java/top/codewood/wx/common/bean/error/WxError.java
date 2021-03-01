package top.codewood.wx.common.bean.error;

import java.io.Serializable;

public class WxError implements Serializable {

    private int errorCode;

    private String errorMsg;

    public WxError() {}

    public WxError(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return String.format("错误代码：%s, 错误信息：%s", errorCode, errorMsg);
    }
}
