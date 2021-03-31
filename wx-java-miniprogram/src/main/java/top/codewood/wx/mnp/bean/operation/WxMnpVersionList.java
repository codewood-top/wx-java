package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpVersionList implements Serializable {

    /**
     * 版本列表
     */
    private List<ClientVersionList> cvlist;

    public List<ClientVersionList> getCvlist() {
        return cvlist;
    }

    public void setCvlist(List<ClientVersionList> cvlist) {
        this.cvlist = cvlist;
    }

    @Override
    public String toString() {
        return "WxMnpVersionList{" +
                "cvlist=" + cvlist +
                '}';
    }

    public static class ClientVersionList implements Serializable {
        /**
         * 查询类型 1 代表客户端，2 代表服务直达
         */
        private int type;
        /**
         * 版本列表
         */
        @SerializedName("client_version_list")
        private List<String> clientVersionList;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<String> getClientVersionList() {
            return clientVersionList;
        }

        public void setClientVersionList(List<String> clientVersionList) {
            this.clientVersionList = clientVersionList;
        }
    }

}
