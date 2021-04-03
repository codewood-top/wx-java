package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("xml")
public class WxMpXmlMessage implements Serializable {

    @XStreamAlias("ToUserName")
    private String toUser;

    @XStreamAlias("FromUserName")
    private String fromUser;

    @XStreamAlias("CreateTime")
    private Long createTime;

    @XStreamAlias("MsgType")
    private String msgType;

    @XStreamAlias("MsgId")
    private String msgId;

    @XStreamAlias("Content")
    private String content;

    @XStreamAlias("Event")
    private String event;

    @XStreamAlias("EventKey")
    private String eventKey;

    @XStreamAlias("MenuId")
    private String menuId;

    /**
     * 图片链接（由系统生成）
     */
    @XStreamAlias("PicUrl")
    private String picUrl;

    /**
     * 视频消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XStreamAlias("MediaId")
    private String mediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

    /**
     * 语音格式：amr
     */
    @XStreamAlias("Format")
    private String format;

    /**
     * 语音识别结果，UTF8编码
     */
    @XStreamAlias("Recognition")
    private String recognition;

    /**
     * 地理位置纬度(LocationX)
     */
    @XStreamAlias("Location_X")
    private Double latitude;

    /**
     * 地理位置经度(LocationY)
     */
    @XStreamAlias("Location_Y")
    private Double longitude;

    @XStreamAlias("Scale")
    private Integer scale;

    /**
     * 	地理位置信息
     */
    @XStreamAlias("Label")
    private String label;

    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String description;

    @XStreamAlias("Url")
    private String url;



    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WxMpXmlMessage{" +
                "toUser='" + toUser + '\'' +
                ", fromUser='" + fromUser + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                ", msgId='" + msgId + '\'' +
                ", content='" + content + '\'' +
                ", event='" + event + '\'' +
                ", eventKey='" + eventKey + '\'' +
                '}';
    }

}