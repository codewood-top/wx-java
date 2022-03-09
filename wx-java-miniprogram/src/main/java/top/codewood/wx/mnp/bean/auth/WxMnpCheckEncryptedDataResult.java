package top.codewood.wx.mnp.bean.auth;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpCheckEncryptedDataResult implements Serializable {

    /**
     * 是否是合法的数据
     */
    private boolean valid;
    /**
     * 加密数据生成的时间戳，计数单位：秒
     */
    @SerializedName("create_time")
    private int createTime;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }
}
