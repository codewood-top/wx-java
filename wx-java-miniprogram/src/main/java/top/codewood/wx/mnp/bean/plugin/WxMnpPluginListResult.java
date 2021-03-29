package top.codewood.wx.mnp.bean.plugin;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpPluginListResult implements Serializable {

    @SerializedName("plugin_list")
    private List<PluginInfo> pluginList;

    public List<PluginInfo> getPluginList() {
        return pluginList;
    }

    public void setPluginList(List<PluginInfo> pluginList) {
        this.pluginList = pluginList;
    }

    @Override
    public String toString() {
        return "WxMnpPluginListResult{" +
                "pluginList=" + pluginList +
                '}';
    }

    public static class PluginInfo implements Serializable {

        /**
         * 插件 appId
         */
        private String appid;

        /**
         * 插件状态
         */
        private String status;

        /**
         * 插件昵称
         */
        private String nickname;

        /**
         * 插件头像
         */
        @SerializedName("headimgurl")
        private String headImgUrl;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        @Override
        public String toString() {
            return "PluginInfo{" +
                    "appid='" + appid + '\'' +
                    ", status='" + status + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", headImgUrl='" + headImgUrl + '\'' +
                    '}';
        }
    }

}
