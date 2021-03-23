package top.codewood.wx.mnp.api;

import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.bean.media.WxMediaUploadResult;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 临时素材接口
 */
public class WxMnpMediaApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpMediaApi INSTANCE = new WxMnpMediaApi();
    }

    public static WxMnpMediaApi getInstance() {
        return Holder.INSTANCE;
    }


    /**
     * customerServiceMessage.uploadTempMedia
     * 把媒体文件上传到微信服务器。目前仅支持图片。用于发送客服消息或被动回复用户消息。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.uploadTempMedia.html">参考文档</a>
     *
     * @param accessToken
     * @return {type: '文件类型', media_id: '媒体文件上传后，获取标识，3天内有效。', created_at: '媒体文件上传时间戳'}
     */
    public WxMediaUploadResult uploadTempMedia(String accessToken, File file) {
        assert accessToken != null && file != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=image", accessToken);
        String respStr = upload(url, file);
        return WxGsonBuilder.create().fromJson(respStr, WxMediaUploadResult.class);
    }

    /**
     * customerServiceMessage.uploadTempMedia
     * 把媒体文件上传到微信服务器。目前仅支持图片。用于发送客服消息或被动回复用户消息。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.uploadTempMedia.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream 文件输入流
     * @return {type: '文件类型', media_id: '媒体文件上传后，获取标识，3天内有效。', created_at: '媒体文件上传时间戳'}
     */
    public WxMediaUploadResult uploadTempMedia(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        return uploadTempMedia(accessToken, tmpFile);
    }

    /**
     * customerServiceMessage.getTempMedia
     * 获取客服消息内的临时素材。即下载临时的多媒体文件。目前小程序仅支持下载图片文件。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.getTempMedia.html">参考文档</a>
     *
     * @param accessToken
     * @param mediaId
     * @return inputstream 网络文件流
     * @throws top.codewood.wx.common.bean.error.WxErrorException
     */
    public InputStream getTempMedia(String accessToken, String mediaId) {
        assert accessToken != null && mediaId != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", accessToken, mediaId);
        return getInputStream(url);
    }

}
