package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpGetPerformanceRequest implements Serializable {

    /**
     * 可选值 1（启动总耗时）， 2（下载耗时），3（初次渲染耗时）
     */
    @SerializedName("cost_time_type")
    private int costTimeType = 1;

    /**
     * 查询开始时间
     */
    @SerializedName("default_start_time")
    private Long defaultStartTime;

    /**
     * 查询结束时间
     */
    @SerializedName("default_end_time")
    private Long defaultEndTime;

    /**
     * 系统平台，可选值 "@_all:"（全部），1（IOS）， 2（android）
     */
    private String device = "@_all";

    /**
     * 是否下载代码包，当 type 为 1 的时候才生效，可选值 "@_all:"（全部），1（是）， 2（否）
     */
    @SerializedName("is_download_code")
    private String downloadCode = "@_all";

    /**
     * 访问来源，当 type 为 1 或者 2 的时候才生效，通过 getSceneList 接口获取
     */
    private String scene;

    /**
     *	网络环境, 当 type 为 2 的时候才生效，可选值 "@_all:"，wifi, 4g, 3g, 2g
     */
    @SerializedName("networktype")
    private String networkType = "@_all";

    public int getCostTimeType() {
        return costTimeType;
    }

    public void setCostTimeType(int costTimeType) {
        this.costTimeType = costTimeType;
    }

    public Long getDefaultStartTime() {
        return defaultStartTime;
    }

    public void setDefaultStartTime(Long defaultStartTime) {
        this.defaultStartTime = defaultStartTime;
    }

    public Long getDefaultEndTime() {
        return defaultEndTime;
    }

    public void setDefaultEndTime(Long defaultEndTime) {
        this.defaultEndTime = defaultEndTime;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDownloadCode() {
        return downloadCode;
    }

    public void setDownloadCode(String downloadCode) {
        this.downloadCode = downloadCode;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    @Override
    public String toString() {
        return "WxMnpGetPerformanceRequest{" +
                "costTimeType=" + costTimeType +
                ", defaultStartTime=" + defaultStartTime +
                ", defaultEndTime=" + defaultEndTime +
                ", device='" + device + '\'' +
                ", downloadCode='" + downloadCode + '\'' +
                ", scene='" + scene + '\'' +
                ", networkType='" + networkType + '\'' +
                '}';
    }

    public static class Builder {
        private int costTimeType = 1;
        private Long defaultStartTime;
        private Long defaultEndTime;
        private String device = "@_all";
        private String downloadCode = "@_all";
        private String scene;
        private String networkType = "@_all";

        public Builder costTimeType(int costTimeType) {
            this.costTimeType = costTimeType;
            return this;
        }

        public Builder defaultStartTime(long defaultStartTime) {
            this.defaultStartTime = defaultStartTime;
            return this;
        }

        public Builder defaultEndTime(long defaultEndTime) {
            this.defaultEndTime = defaultEndTime;
            return this;
        }

        public Builder device(String device) {
            this.device = device;
            return this;
        }

        public Builder downloadCode(String downloadCode) {
            this.downloadCode = downloadCode;
            return this;
        }

        public Builder scene(String scene) {
            this.scene = scene;
            return this;
        }

        public Builder networkType(String networkType) {
            this.networkType = networkType;
            return this;
        }

        public WxMnpGetPerformanceRequest build() {
            WxMnpGetPerformanceRequest getPerformanceRequest = new WxMnpGetPerformanceRequest();
            getPerformanceRequest.setCostTimeType(this.costTimeType);
            getPerformanceRequest.setDefaultStartTime(this.defaultStartTime);
            getPerformanceRequest.setDefaultEndTime(this.defaultEndTime);
            getPerformanceRequest.setDevice(this.device);
            getPerformanceRequest.setDownloadCode(this.downloadCode);
            getPerformanceRequest.setScene(this.scene);
            getPerformanceRequest.setNetworkType(this.networkType);
            return getPerformanceRequest;
        }

    }

}
