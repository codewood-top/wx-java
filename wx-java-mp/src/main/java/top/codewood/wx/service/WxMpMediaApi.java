package top.codewood.wx.service;

import top.codewood.wx.mp.bean.media.WxMediaUploadImgResult;
import top.codewood.wx.common.bean.media.WxMediaUploadResult;
import top.codewood.wx.mp.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WxMpMediaApi extends WxMpApi {

    private static class Holder {
        private static WxMpMediaApi INSTANCE = new WxMpMediaApi();
    }

    public static WxMpMediaApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 上传临时素材
     * 图片（image）: 10M，支持PNG\JPEG\JPG\GIF格式, 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式, 视频（video）：10MB，支持MP4格式, 缩略图（thumb）：64KB，支持JPG格式
     *
     * @param accessToken
     * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file
     * @return {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
     */
    public WxMediaUploadResult upload(String accessToken, String mediaType,  File file) throws IOException {
        assert accessToken != null && mediaType != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s", accessToken, mediaType);
        String respStr = upload(url, file);
        return WxGsonBuilder.create().fromJson(respStr, WxMediaUploadResult.class);
    }

    /**
     * 获取临时素材
     *
     * @param accessToken
     * @param mediaId
     * @return
     */
    public InputStream get(String accessToken, String mediaId) {
        assert accessToken != null && mediaId != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", accessToken, mediaId);
        return getInputStream(url);
    }

    /**
     * 上传图片接口
     * 开发者需调用该接口上传商户图标至微信服务器，获取相应logo_url/icon_list/image_url，用于卡券创建。
     *
     * @param accessToken
     * @param file
     * @return
     */
    public WxMediaUploadImgResult uploadImg(String accessToken, File file) {
        assert accessToken != null && file != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s", accessToken);
        String respStr = upload(url, file);
        return WxGsonBuilder.create().fromJson(respStr, WxMediaUploadImgResult.class);
    }

}
