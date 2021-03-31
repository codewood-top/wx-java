package top.codewood.wx.mnp.bean.operation;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpFeedbackResult implements Serializable {

    private List<Record> list;
    @SerializedName("total_num")
    private int totalNum;

    public List<Record> getList() {
        return list;
    }

    public void setList(List<Record> list) {
        this.list = list;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "WxMnpFeedBackResult{" +
                "list=" + list +
                ", totalNum=" + totalNum +
                '}';
    }

    public static class Record implements Serializable {

        @SerializedName("record_id")
        private int recordId;

        @SerializedName("create_time")
        private long createTime;

        private String content;

        private String openid;

        private String nickname;

        @SerializedName("head_url")
        private String headUrl;

        private Integer type;

        private List<String> mediaIds;
        private Object systemInfo;

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public List<String> getMediaIds() {
            return mediaIds;
        }

        public void setMediaIds(List<String> mediaIds) {
            this.mediaIds = mediaIds;
        }

        public Object getSystemInfo() {
            return systemInfo;
        }

        public void setSystemInfo(Object systemInfo) {
            this.systemInfo = systemInfo;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "recordId=" + recordId +
                    ", createTime=" + createTime +
                    ", content='" + content + '\'' +
                    ", openid='" + openid + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", headUrl='" + headUrl + '\'' +
                    ", type=" + type +
                    ", mediaIds=" + mediaIds +
                    ", systemInfo=" + systemInfo +
                    '}';
        }
    }

}
