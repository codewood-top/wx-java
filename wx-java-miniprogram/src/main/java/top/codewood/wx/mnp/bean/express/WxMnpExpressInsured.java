package top.codewood.wx.mnp.bean.express;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpExpressInsured implements Serializable {

    /**
     * 必填：是
     * 是否保价，0 表示不保价，1 表示保价
     */
    @SerializedName("use_insured")
    private Integer useInsured;
    /**
     * 必填：是
     * 保价金额，单位是分，比如: 10000 表示 100 元（注：如果不保价，那保价金额填 0 即可）
     */
    @SerializedName("insured_value")
    private Integer insuredValue;

    public Integer getUseInsured() {
        return useInsured;
    }

    public void setUseInsured(Integer useInsured) {
        this.useInsured = useInsured;
    }

    public Integer getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(Integer insuredValue) {
        this.insuredValue = insuredValue;
    }

    @Override
    public String toString() {
        return "WxMnpExpressInsured{" +
                "useInsured=" + useInsured +
                ", insuredValue=" + insuredValue +
                '}';
    }
}
