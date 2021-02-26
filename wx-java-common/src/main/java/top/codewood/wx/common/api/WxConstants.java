package top.codewood.wx.common.api;

/**
 * 微信常量类
 */
public class WxConstants {

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


}
