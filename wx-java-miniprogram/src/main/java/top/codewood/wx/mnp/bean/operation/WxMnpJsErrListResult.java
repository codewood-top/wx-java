package top.codewood.wx.mnp.bean.operation;

import java.io.Serializable;
import java.util.List;

public class WxMnpJsErrListResult implements Serializable {

    private List<WxMnpJsErr> data;
    private int totalCount;

    public List<WxMnpJsErr> getData() {
        return data;
    }

    public void setData(List<WxMnpJsErr> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "WxMnpJsErrListResult{" +
                "data=" + data +
                ", totalCount=" + totalCount +
                '}';
    }

    public static class WxMnpJsErr implements Serializable {
        private String errorMsgMd5;
        private String errorMsg;
        private int uv;
        private int pv;
        private String errorStackMd5;
        private String errorStack;
        private String pvPercent;
        private String uvPercent;

        public String getErrorMsgMd5() {
            return errorMsgMd5;
        }

        public void setErrorMsgMd5(String errorMsgMd5) {
            this.errorMsgMd5 = errorMsgMd5;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public int getUv() {
            return uv;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }

        public int getPv() {
            return pv;
        }

        public void setPv(int pv) {
            this.pv = pv;
        }

        public String getErrorStackMd5() {
            return errorStackMd5;
        }

        public void setErrorStackMd5(String errorStackMd5) {
            this.errorStackMd5 = errorStackMd5;
        }

        public String getErrorStack() {
            return errorStack;
        }

        public void setErrorStack(String errorStack) {
            this.errorStack = errorStack;
        }

        public String getPvPercent() {
            return pvPercent;
        }

        public void setPvPercent(String pvPercent) {
            this.pvPercent = pvPercent;
        }

        public String getUvPercent() {
            return uvPercent;
        }

        public void setUvPercent(String uvPercent) {
            this.uvPercent = uvPercent;
        }

        @Override
        public String toString() {
            return "WxMnpJsErr{" +
                    "errorMsgMd5='" + errorMsgMd5 + '\'' +
                    ", errorMsg='" + errorMsg + '\'' +
                    ", uv=" + uv +
                    ", pv=" + pv +
                    ", errorStackMd5='" + errorStackMd5 + '\'' +
                    ", errorStack='" + errorStack + '\'' +
                    ", pvPercent='" + pvPercent + '\'' +
                    ", uvPercent='" + uvPercent + '\'' +
                    '}';
        }
    }

}
