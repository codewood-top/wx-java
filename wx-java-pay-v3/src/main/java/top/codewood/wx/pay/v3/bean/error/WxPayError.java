package top.codewood.wx.pay.v3.bean.error;

import java.io.Serializable;

public class WxPayError implements Serializable {

    private int status;
    private String code;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WxPayError{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
