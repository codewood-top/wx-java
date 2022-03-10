package top.codewood.wx.mnp.bean.security;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpSecurityMsgSecCheckResult implements Serializable {

    /**
     * 唯一请求标识，标记单次请求
     */
    @SerializedName("trace_id")
    private String traceId;
    /**
     * 综合结果: 综合了多个策略的结果给出了建议，包含的属性有
     */
    private Result result;
    /**
     * 详细检测结果: 包含多个策略类型的检测结果，策略类型的检查结果可能存在的属性如下
     */
    private List<DetailInfo> detail;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<DetailInfo> getDetail() {
        return detail;
    }

    public void setDetail(List<DetailInfo> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "WxMnpSecurityMsgSecCheckResult{" +
                "traceId='" + traceId + '\'' +
                ", result=" + result +
                ", detail=" + detail +
                '}';
    }

    public static class Result implements Serializable {
        /**
         * 建议，有risky、pass、review三种值
         */
        private String suggest;

        /**
         * 命中标签枚举值，100 正常；10001 广告；20001 时政；20002 色情；20003 辱骂；20006 违法犯罪；20008 欺诈；20012 低俗；20013 版权；21000 其他
         */
        private Integer label;

        public String getSuggest() {
            return suggest;
        }

        public void setSuggest(String suggest) {
            this.suggest = suggest;
        }

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "suggest='" + suggest + '\'' +
                    ", label='" + label + '\'' +
                    '}';
        }
    }

    public static class DetailInfo implements Serializable {
        /**
         * 策略类型
         */
        private String strategy;
        /**
         * 错误码，仅当该值为0时，该项结果有效
         */
        @SerializedName("errcode")
        private Integer errCode;

        /**
         * 建议，有risky、pass、review三种值
         */
        private String suggest;

        /**
         * 命中标签枚举值，100 正常；10001 广告；20001 时政；20002 色情；20003 辱骂；20006 违法犯罪；20008 欺诈；20012 低俗；20013 版权；21000 其他
         */
        private Integer label;

        /**
         * 0-100，代表置信度，越高代表越有可能属于当前返回的标签（label）
         */
        private Integer prob;

        /**
         * 命中的自定义关键词
         */
        private String keyword;

        public String getStrategy() {
            return strategy;
        }

        public void setStrategy(String strategy) {
            this.strategy = strategy;
        }

        public Integer getErrCode() {
            return errCode;
        }

        public void setErrCode(Integer errCode) {
            this.errCode = errCode;
        }

        public String getSuggest() {
            return suggest;
        }

        public void setSuggest(String suggest) {
            this.suggest = suggest;
        }

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        public Integer getProb() {
            return prob;
        }

        public void setProb(Integer prob) {
            this.prob = prob;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        @Override
        public String toString() {
            return "DetailInfo{" +
                    "strategy='" + strategy + '\'' +
                    ", errCode=" + errCode +
                    ", suggest='" + suggest + '\'' +
                    ", label=" + label +
                    ", prob=" + prob +
                    ", keyword='" + keyword + '\'' +
                    '}';
        }
    }

}
