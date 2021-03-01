package top.codewood.wx.mp.bean.kefu.message.builder;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;

import java.rmi.server.SkeletonMismatchException;

public class MiniprogramPageBuilder extends BaseBuilder<MiniprogramPageBuilder> {

    private String title;
    private String appid;
    private String pagePath;
    private String thumbMediaId;

    public MiniprogramPageBuilder() {
        this.msgType = WxConstants.KefuMsgType.MINIPROGRAMPAGE;
    }

    public MiniprogramPageBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MiniprogramPageBuilder appid(String appid) {
        this.appid = appid;
        return this;
    }

    public MiniprogramPageBuilder pagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }

    public MiniprogramPageBuilder thumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
        return this;
    }

    @Override
    public WxMpKfMessage build() {
        WxMpKfMessage kfMessage = super.build();
        kfMessage.setTitle(this.title);
        kfMessage.setAppid(this.appid);
        kfMessage.setPagePath(this.pagePath);
        kfMessage.setThumbMediaId(this.thumbMediaId);
        return kfMessage;
    }
}
