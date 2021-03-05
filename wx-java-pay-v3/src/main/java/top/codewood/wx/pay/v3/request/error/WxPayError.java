package top.codewood.wx.pay.v3.request.error;

public class WxPayError {

    private String code;
    private String message;

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
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
