package top.codewood.wx.pay.v3.bean.error;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxPayError implements Serializable {


    private String code;
    private String message;

    private Detail detail;


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

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "WxPayError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", detail=" + detail +
                '}';
    }

    static class Detail implements Serializable {

        private String field;
        private String issue;
        private String location;
        @SerializedName("sign_information")
        private SignInformation signInformation;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public SignInformation getSignInformation() {
            return signInformation;
        }

        public void setSignInformation(SignInformation signInformation) {
            this.signInformation = signInformation;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "field='" + field + '\'' +
                    ", issue='" + issue + '\'' +
                    ", location='" + location + '\'' +
                    ", signInformation=" + signInformation +
                    '}';
        }
    }

    static class SignInformation implements Serializable {
        private String method;
        private String url;
        private String truncatedSignMessage;
        private int signMessageLength;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTruncatedSignMessage() {
            return truncatedSignMessage;
        }

        public void setTruncatedSignMessage(String truncatedSignMessage) {
            this.truncatedSignMessage = truncatedSignMessage;
        }

        public int getSignMessageLength() {
            return signMessageLength;
        }

        public void setSignMessageLength(int signMessageLength) {
            this.signMessageLength = signMessageLength;
        }

        @Override
        public String toString() {
            return "SignInformation{" +
                    "method='" + method + '\'' +
                    ", url='" + url + '\'' +
                    ", truncatedSignMessage='" + truncatedSignMessage + '\'' +
                    ", signMessageLength=" + signMessageLength +
                    '}';
        }
    }

}
