package top.codewood.wx.mnp.bean.live;

import top.codewood.wx.annotation.Required;

import java.io.Serializable;

/**
 * 请求创建小程序直接间
 * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/liveplayer/studio-api.html#1">参考文档</a>
 */
public class WxMnpLiveRoomCreateRequest implements Serializable {

    /**
     * 直播间id
     * 编辑直播间需要加上id
     */
    private Long id;

    /**
     * 直播间名字，最短3个汉字，最长17个汉字，1个汉字相当于2个字符
     */
    @Required
    private String name;

    /**
     * 背景图，填入mediaID（mediaID获取后，三天内有效）；图片mediaID的获取，请参考以下文档： https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html；直播间背景图，图片规则：建议像素1080*1920，大小不超过2M
     */
    @Required
    private String coverImg;

    /**
     * 时间戳(秒)
     * 直播计划开始时间（开播时间需要在当前时间的10分钟后 并且 开始时间不能在 6 个月后）
     */
    @Required
    private Integer startTime;

    /**
     * 时间戳(秒)
     * 直播计划结束时间（开播时间和结束时间间隔不得短于30分钟，不得超过24小时）
     */
    @Required
    private Integer endTime;

    /**
     * 主播昵称，最短2个汉字，最长15个汉字，1个汉字相当于2个字符
     */
    @Required
    private String anchorName;

    /**
     * 主播微信号，如果未实名认证，需要先前往“小程序直播”小程序进行实名验证, 小程序二维码链接：https://res.wx.qq.com/op_res/9rSix1dhHfK4rR049JL0PHJ7TpOvkuZ3mE0z7Ou_Etvjf-w1J_jVX0rZqeStLfwh
     */
    @Required
    private String anchorWechat;

    /**
     * 主播副号微信号，如果未实名认证，需要先前往“小程序直播”小程序进行实名验证, 小程序二维码链接：https://res.wx.qq.com/op_res/9rSix1dhHfK4rR049JL0PHJ7TpOvkuZ3mE0z7Ou_Etvjf-w1J_jVX0rZqeStLfwh
     */
    private String subAnchorWechat;

    /**
     * 创建者微信号，不传入则此直播间所有成员可见。传入则此房间仅创建者、管理员、超管、直播间主播可见
     */
    private String createrWechat;

    /**
     * 分享图，填入mediaID（mediaID获取后，三天内有效）；图片mediaID的获取，请参考以下文档： https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html；直播间分享图，图片规则：建议像素800*640，大小不超过1M；
     */
    @Required
    private String shareImg;

    /**
     * 购物直播频道封面图，填入mediaID（mediaID获取后，三天内有效）；图片mediaID的获取，请参考以下文档： https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html; 购物直播频道封面图，图片规则：建议像素800*800，大小不超过100KB；
     */
    @Required
    private String feedsImg;

    /**
     * 是否开启官方收录 【1: 开启，0：关闭】，默认开启收录
     */
    private Integer isFeedsPublic = 1;

    /**
     * 直播间类型 【1: 推流，0：手机直播】
     */
    @Required
    private Integer type = 0;

    /**
     * 是否关闭点赞 【0：开启，1：关闭】（若关闭，观众端将隐藏点赞按钮，直播开始后不允许开启）
     */
    @Required
    private Integer closeLike = 0;

    /**
     * 是否关闭货架 【0：开启，1：关闭】（若关闭，观众端将隐藏商品货架，直播开始后不允许开启）
     */
    @Required
    private Integer closeGoods = 0;

    /**
     * 是否关闭评论 【0：开启，1：关闭】（若关闭，观众端将隐藏评论入口，直播开始后不允许开启
     */
    @Required
    private Integer closeComment = 0;

    /**
     * 是否关闭回放 【0：开启，1：关闭】默认关闭回放（直播开始后允许开启）
     */
    @Required
    private Integer closeReplay = 0;

    /**
     * 是否关闭分享 【0：开启，1：关闭】默认开启分享（直播开始后不允许修改）
     */
    @Required
    private Integer closeShare = 0;

    /**
     * 是否关闭客服 【0：开启，1：关闭】 默认关闭客服（直播开始后允许开启）
     */
    @Required
    private Integer closeKf = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAnchorWechat() {
        return anchorWechat;
    }

    public void setAnchorWechat(String anchorWechat) {
        this.anchorWechat = anchorWechat;
    }

    public String getSubAnchorWechat() {
        return subAnchorWechat;
    }

    public void setSubAnchorWechat(String subAnchorWechat) {
        this.subAnchorWechat = subAnchorWechat;
    }

    public String getCreaterWechat() {
        return createrWechat;
    }

    public void setCreaterWechat(String createrWechat) {
        this.createrWechat = createrWechat;
    }

    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }

    public String getFeedsImg() {
        return feedsImg;
    }

    public void setFeedsImg(String feedsImg) {
        this.feedsImg = feedsImg;
    }

    public Integer getIsFeedsPublic() {
        return isFeedsPublic;
    }

    public void setIsFeedsPublic(Integer isFeedsPublic) {
        this.isFeedsPublic = isFeedsPublic;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getCloseReplay() {
        return closeReplay;
    }

    public void setCloseReplay(Integer closeReplay) {
        this.closeReplay = closeReplay;
    }

    public Integer getCloseShare() {
        return closeShare;
    }

    public void setCloseShare(Integer closeShare) {
        this.closeShare = closeShare;
    }

    public Integer getCloseKf() {
        return closeKf;
    }

    public void setCloseKf(Integer closeKf) {
        this.closeKf = closeKf;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String coverImg;
        private Integer startTime;
        private Integer endTime;
        private String anchorName;
        private String anchorWechat;
        private String subAnchorWechat;
        private String createrWechat;
        private String shareImg;
        private String feedsImg;
        private Integer isFeedsPublic = 1;
        private Integer type = 0;
        private Integer closeLike = 0;
        private Integer closeGoods = 0;
        private Integer closeComment = 0;
        private Integer closeReplay = 0;
        private Integer closeShare = 0;
        private Integer closeKf = 0;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder coverImg(String coverImg) {
            this.coverImg = coverImg;
            return this;
        }

        public Builder startTime(Integer startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Integer endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder anchorName(String anchorName) {
            this.anchorName = anchorName;
            return this;
        }

        public Builder anchorWechat(String anchorWechat) {
            this.anchorWechat = anchorWechat;
            return this;
        }

        public Builder subAnchorWechat(String subAnchorWechat) {
            this.subAnchorWechat = subAnchorWechat;
            return this;
        }

        public Builder createrWechat(String createrWechat) {
            this.createrWechat = createrWechat;
            return this;
        }

        public Builder shareImg(String shareImg) {
            this.shareImg = shareImg;
            return this;
        }

        public Builder feedsImg(String feedsImg) {
            this.feedsImg = feedsImg;
            return this;
        }

        public Builder isFeedsPublic(Integer isFeedsPublic) {
            this.isFeedsPublic = isFeedsPublic;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public Builder closeLike(Integer closeLike) {
            this.closeLike = closeLike;
            return this;
        }

        public Builder closeGoods(Integer closeGoods) {
            this.closeGoods = closeGoods;
            return this;
        }

        public Builder closeComment(Integer closeComment) {
            this.closeComment = closeComment;
            return this;
        }

        public Builder closeReplay(Integer closeReplay) {
            this.closeReplay = closeReplay;
            return this;
        }

        public Builder closeShare(Integer closeShare) {
            this.closeShare = closeShare;
            return this;
        }

        public Builder closeKf(Integer closeKf) {
            this.closeKf = closeKf;
            return this;
        }

        public WxMnpLiveRoomCreateRequest build() {
            WxMnpLiveRoomCreateRequest request = new WxMnpLiveRoomCreateRequest();
            request.setId(this.id);
            request.setName(this.name);
            request.setCoverImg(this.coverImg);
            request.setStartTime(this.startTime);
            request.setEndTime(this.endTime);
            request.setAnchorName(this.anchorName);
            request.setAnchorWechat(this.anchorWechat);
            request.setSubAnchorWechat(this.subAnchorWechat);
            request.setCreaterWechat(this.createrWechat);
            request.setShareImg(this.shareImg);
            request.setFeedsImg(this.feedsImg);
            request.setIsFeedsPublic(this.isFeedsPublic);
            request.setType(this.type);
            request.setCloseLike(this.closeLike);
            request.setCloseGoods(this.closeGoods);
            request.setCloseComment(this.closeComment);
            request.setCloseReplay(this.closeReplay);
            request.setCloseShare(this.closeShare);
            request.setCloseKf(this.closeKf);
            return request;
        }


    }

}