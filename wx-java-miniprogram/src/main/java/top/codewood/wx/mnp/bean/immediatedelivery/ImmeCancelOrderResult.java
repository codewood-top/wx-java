package top.codewood.wx.mnp.bean.immediatedelivery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImmeCancelOrderResult implements Serializable {

    /**
     * 扣除的违约金(单位：元)，精确到分
     */
    @SerializedName("deduct_fee")
    private BigDecimal deductFee;

    /**
     * 说明
     */
    private String desc;

    public BigDecimal getDeductFee() {
        return deductFee;
    }

    public void setDeductFee(BigDecimal deductFee) {
        this.deductFee = deductFee;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ImmeCancelOrderResult{" +
                "deductFee=" + deductFee +
                ", desc='" + desc + '\'' +
                '}';
    }
}
