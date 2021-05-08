package top.codewood.wx.mnp.bean.live;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpLiveRoomInfo implements Serializable {

    /**
     * 直播间ID
     */
    private String roomid;

    /**
     * 直播间名称
     */
    private String name;

    /**
     * 直播间背景图链接
     */
    @SerializedName("cover_img")
    private String coverImg;

    /**
     * 直播间分享图链接
     */
    @SerializedName("share_img")
    private String shareImg;

    /**
     * 直播间状态。101：直播中，102：未开始，103已结束，104禁播，105：暂停，106：异常，107：已过期
     */
    @SerializedName("live_status")
    private Integer liveStatus;

    /**
     * 直播间开始时间，列表按照start_time降序排列
     */
    @SerializedName("start_time")
    private Integer startTime;

    /**
     * 直播计划结束时间
     */
    @SerializedName("end_time")
    private Integer endTime;

    /**
     * 主播名
     */
    @SerializedName("anchor_name")
    private String anchorName;

    /**
     * 直播类型，1 推流 0 手机直播
     */
    @SerializedName("live_type")
    private Integer liveType;

    /**
     * 是否关闭点赞 【0：开启，1：关闭】（若关闭，观众端将隐藏点赞按钮，直播开始后不允许开启）
     */
    @SerializedName("close_like")
    private Integer closeLike;

    /**
     * 是否关闭货架 【0：开启，1：关闭】（若关闭，观众端将隐藏商品货架，直播开始后不允许开启）
     */
    @SerializedName("close_goods")
    private Integer closeGoods;

    /**
     * 是否关闭评论 【0：开启，1：关闭】（若关闭，观众端将隐藏评论入口，直播开始后不允许开启）
     */
    @SerializedName("close_comment")
    private Integer closeComment;

    /**
     * 是否关闭客服 【0：开启，1：关闭】 默认关闭客服（直播开始后允许开启）
     */
    @SerializedName("close_kf")
    private Integer closeKf;

    /**
     * 是否关闭回放 【0：开启，1：关闭】默认关闭回放（直播开始后允许开启）
     */
    @SerializedName("close_replay")
    private Integer closeReplay;

    /**
     * 是否开启官方收录，1 开启，0 关闭
     */
    @SerializedName("is_feeds_public")
    private Integer isFeedsPublic;

    /**
     * 创建者openid
     */
    @SerializedName("creater_openid")
    private String createrOpenid;

    /**
     * 官方收录封面
     */
    @SerializedName("feeds_img")
    private String feedsImg;

    /**
     * 直播间关联商品
     */
    private List<WxMnpLiveGoodsInfo> goodsInfo;


    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }

    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public Integer getLiveType() {
        return liveType;
    }

    public void setLiveType(Integer liveType) {
        this.liveType = liveType;
    }

    public Integer getCloseLike() {
        return closeLike;
    }

    public void setCloseLike(Integer closeLike) {
        this.closeLike = closeLike;
    }

    public Integer getCloseGoods() {
        return closeGoods;
    }

    public void setCloseGoods(Integer closeGoods) {
        this.closeGoods = closeGoods;
    }

    public Integer getCloseComment() {
        return closeComment;
    }

    public void setCloseComment(Integer closeComment) {
        this.closeComment = closeComment;
    }

    public Integer getCloseKf() {
        return closeKf;
    }

    public void setCloseKf(Integer closeKf) {
        this.closeKf = closeKf;
    }

    public Integer getCloseReplay() {
        return closeReplay;
    }

    public void setCloseReplay(Integer closeReplay) {
        this.closeReplay = closeReplay;
    }

    public Integer getIsFeedsPublic() {
        return isFeedsPublic;
    }

    public void setIsFeedsPublic(Integer isFeedsPublic) {
        this.isFeedsPublic = isFeedsPublic;
    }

    public String getCreaterOpenid() {
        return createrOpenid;
    }

    public void setCreaterOpenid(String createrOpenid) {
        this.createrOpenid = createrOpenid;
    }

    public String getFeedsImg() {
        return feedsImg;
    }

    public void setFeedsImg(String feedsImg) {
        this.feedsImg = feedsImg;
    }

    @Override
    public String toString() {
        return "WxMnpLiveRoomInfo{" +
                "roomid='" + roomid + '\'' +
                ", name='" + name + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", shareImg='" + shareImg + '\'' +
                ", liveStatus=" + liveStatus +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", anchorName='" + anchorName + '\'' +
                ", liveType=" + liveType +
                ", closeLike=" + closeLike +
                ", closeGoods=" + closeGoods +
                ", closeComment=" + closeComment +
                ", closeKf=" + closeKf +
                ", closeReplay=" + closeReplay +
                ", isFeedsPublic=" + isFeedsPublic +
                ", createrOpenid='" + createrOpenid + '\'' +
                ", feedsImg='" + feedsImg + '\'' +
                '}';
    }
}
