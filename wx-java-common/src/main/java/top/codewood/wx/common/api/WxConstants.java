package top.codewood.wx.common.api;

/**
 * 微信常量类
 */
public class WxConstants {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";
    public static final String FAIL = "FAIL";

    public interface XmlMsgType {
        String TEXT = "text";
        String IMAGE = "image";
        String VOICE = "voice";
        String VIDEO = "video";
        String MUSIC = "music";
        String NEWS = "news";
        String SHORT_VIDEO = "shortvideo";
        String LOCATION = "location";
        String LINK = "link";
        String EVENT = "event";
        String TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";
    }

    public interface EventType {
        String SUBSCRIBE = "subscribe";
        String UNSUBSCRIBE = "unsubscribe";
        String SCAN = "SCAN";
        String LOCATION = "LOCATION";
        /**
         * 点击菜单拉取消息时的事件推送
         */
        String CLICK = "CLICK";
        /**
         * 点击菜单跳转链接时的事件推送
         */
        String VIEW = "VIEW";
        /**
         * 扫码推事件的事件推送
         */
        String SCANCODE_PUSH = "scancode_push";
        /**
         * 扫码推事件且弹出“消息接收中”提示框的事件推送
         */
        String SCANCODE_WAITMSG = "scancode_waitmsg";
        /**
         * pic_sysphoto：弹出系统拍照发图的事件推送
         */
        String PIC_SYSPHOTO = "pic_sysphoto";
        /**
         * pic_photo_or_album：弹出拍照或者相册发图的事件推送
         */
        String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
        /**
         * pic_weixin：弹出微信相册发图器的事件推送
         */
        String PIC_WEIXIN = "pic_weixin";
        /**
         * location_select：弹出地理位置选择器的事件推送
         */
        String LOCATION_SELECT = "location_select";
        /**
         * 点击菜单跳转小程序的事件推送
         */
        String VIEW_MINIPROGRAM = "view_miniprogram";

        /**
         * 模板信息发送完成
         */
        String TEMPLATE_SEND_JOB_FINISH = "TEMPLATESENDJOBFINISH";

    }

    public interface MediaType {
        String IMAGE = "image";
        String VOICE = "voice";
        String VIDEO = "video";
        String THUMB = "thumb";
    }

    public interface MediaFileType {
        String IMAGE_PNG = "png";
        String IMAGE_JPEG = "jpeg";
        String IMAGE_JPG = "jpg";
        String IMAGE_GIF = "gif";
        String VOICE_AMR = "amr";
        String VOICE_MP3 = "mp3";
        String VIDEO_MP4 = "mp4";
        String THUMB = "jpg";
    }

    public interface KefuMsgType {
        String TEXT = "text";
        String IMAGE = "image";
        String VOICE = "voice";
        String VIDEO = "video";
        String MUSIC = "music";
        /**
         * 发送图文消息（点击跳转到外链） 图文消息条数限制在1条以内，注意，如果图文数超过1，则将会返回错误码45008
         */
        String NEWS = "news";

        /**
         * 发送图文消息（点击跳转到图文消息页面） 图文消息条数限制在1条以内，注意，如果图文数超过1，则将会返回错误码45008。
         */
        String MPNEWS = "mpnews";

        String MSGMENU = "msgmenu";

        /**
         * 发送卡券
         */
        String WXCARD = "wxcard";

        /**
         * 发送小程序卡片（要求小程序与公众号已关联）
         */
        String MINIPROGRAMPAGE = "miniprogrampage";
    }

    public interface MpAuthorizeScope {

        /**
         * 不弹出授权页面，直接跳转，只能获取用户openid
         */
        String BASE = "snsapi_base";

        /**
         * 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息
         */
        String USER_INFO = "snsapi_userinfo";
    }

    /**
     * 公众号 | 小程序 | app
     */
    public interface AppType {

        String MP = "mp";

        String MINIPROGRAM = "miniprogram";

        String APP = "app";
    }

}
