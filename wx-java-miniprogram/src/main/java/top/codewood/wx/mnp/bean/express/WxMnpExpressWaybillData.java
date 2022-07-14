package top.codewood.wx.mnp.bean.express;

import java.io.Serializable;

public class WxMnpExpressWaybillData implements Serializable {
    /**
     * 运单信息 key
     */
    private String key;
    /**
     * 运单信息 value
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "WaybillData{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
