package top.codewood.wx.mp.api;

import top.codewood.wx.common.util.file.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class WxMpMediaApi extends WxMpApi {


    /**
     * 上传临时素材
     * @param acccessToken
     * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param fileType 图片（image）: 10M，支持PNG\JPEG\JPG\GIF格式, 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式, 视频（video）：10MB，支持MP4格式, 缩略图（thumb）：64KB，支持JPG格式
     * @return {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
     */
    public static void upload(String acccessToken, String mediaType, String fileType, InputStream inputStream) throws IOException {
        assert acccessToken != null && mediaType != null && fileType != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s", acccessToken, mediaType);
        upload(url, FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), fileType));
    }

    /**
     * 获取临时素材
     * @param accessToken
     * @param mediaId
     * @return
     */
    public static InputStream get(String accessToken, String mediaId) {
        assert accessToken != null && mediaId != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", accessToken, mediaId);
        return getStream(url);
    }

}
