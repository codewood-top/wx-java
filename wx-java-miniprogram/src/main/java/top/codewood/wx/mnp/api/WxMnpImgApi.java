package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.mnp.bean.img.WxMnpImgAiCropResult;
import top.codewood.wx.mnp.bean.img.WxMnpImgScanQRCodeResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class WxMnpImgApi extends WxBaseHttpApi {

    private static String UPLOAD_FILE_NAME = "img";

    private static class Holder {
        private static final WxMnpImgApi INSTANCE = new WxMnpImgApi();
    }

    public static WxMnpImgApi getInstance() { return Holder.INSTANCE; }

    /**
     * img.aiCrop
     * 本接口提供基于小程序的图片智能裁剪能力.
     * 说明 文件大小限制：小于2M 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 ratios参数为可选，如果为空，则算法自动裁剪最佳宽高比；如果提供多个宽高比，请以英文逗号“,”分隔，最多支持5个宽高比
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.aiCrop.html">开发文档</a>
     *
     * @param accessToken
     * @param imgUrl
     * @param ratios
     * @return
     */
    public WxMnpImgAiCropResult aiCrop(String accessToken, String imgUrl, double ...ratios) {
        assert accessToken != null && imgUrl != null;
        String url = String.format("https://api.weixin.qq.com/cv/img/aicrop?access_token=access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("img_url", imgUrl);

        if (ratios.length > 0) {
            json.addProperty("ratios", String.join(",", Arrays.asList(ratios).stream().map(ratio -> String.valueOf(ratio)).collect(Collectors.toList())));
        }

        String respStr = post(url, json.getAsString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpImgAiCropResult.class);
    }

    /**
     * img.aiCrop
     * 本接口提供基于小程序的图片智能裁剪能力.
     * 说明 文件大小限制：小于2M 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 ratios参数为可选，如果为空，则算法自动裁剪最佳宽高比；如果提供多个宽高比，请以英文逗号“,”分隔，最多支持5个宽高比
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.aiCrop.html">开发文档</a>
     *
     * @param accessToken
     * @param img
     * @param ratios
     * @return
     */
    public WxMnpImgAiCropResult aiCrop(String accessToken, File img, double ...ratios) {
        assert accessToken != null && img != null;
        String url = String.format("https://api.weixin.qq.com/cv/img/aicrop?access_token=access_token=%s", accessToken);
        if (ratios.length > 0) {
            url = url + "&ratios=" + String.join(",", Arrays.asList(ratios).stream().map(ratio -> String.valueOf(ratio)).collect(Collectors.toList()));
        }
        String respStr = upload(url, img, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpImgAiCropResult.class);
    }

    /**
     * img.aiCrop
     * 本接口提供基于小程序的图片智能裁剪能力.
     * 说明 文件大小限制：小于2M 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 ratios参数为可选，如果为空，则算法自动裁剪最佳宽高比；如果提供多个宽高比，请以英文逗号“,”分隔，最多支持5个宽高比
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.aiCrop.html">开发文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @param ratios
     * @return
     */
    public WxMnpImgAiCropResult aiCrop(String accessToken, InputStream inputStream, double ...ratios) throws IOException {
        assert accessToken != null && inputStream != null;
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        return aiCrop(accessToken, tmpFile, ratios);
    }

    /**
     * img.scanQRCode
     * 本接口提供基于小程序的条码/二维码识别的API。
     * 图片说明 文件大小限制：小于2M
     * 二维码说明 支持条码、二维码、DataMatrix和PDF417的识别。 二维码、DataMatrix会返回位置坐标，条码和PDF417暂不返回位置坐标。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.scanQRCode.html">参考文档</a>
     *
     * @param accessToken
     * @param imgUrl
     * @return
     */
    public WxMnpImgScanQRCodeResult scanQRCode(String accessToken, String imgUrl) {
        assert accessToken != null && imgUrl != null;

        String url = String.format("https://api.weixin.qq.com/cv/img/qrcode?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("img_url", imgUrl);

        String respStr = post(url, json.getAsString());
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpImgScanQRCodeResult.class);
    }

    /**
     * img.scanQRCode
     * 本接口提供基于小程序的条码/二维码识别的API。
     * 图片说明 文件大小限制：小于2M
     * 二维码说明 支持条码、二维码、DataMatrix和PDF417的识别。 二维码、DataMatrix会返回位置坐标，条码和PDF417暂不返回位置坐标。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.scanQRCode.html">参考文档</a>
     *
     * @param accessToken
     * @param img
     * @return
     */
    public WxMnpImgScanQRCodeResult scanQRCodeResult(String accessToken, File img) {
        assert accessToken != null && img != null;

        String url = String.format("https://api.weixin.qq.com/cv/img/qrcode?access_token=%s", accessToken);
        String respStr = upload(url, img, UPLOAD_FILE_NAME);

        return WxGsonBuilder.instance().fromJson(respStr, WxMnpImgScanQRCodeResult.class);
    }

    /**
     * img.scanQRCode
     * 本接口提供基于小程序的条码/二维码识别的API。
     * 图片说明 文件大小限制：小于2M
     * 二维码说明 支持条码、二维码、DataMatrix和PDF417的识别。 二维码、DataMatrix会返回位置坐标，条码和PDF417暂不返回位置坐标。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.scanQRCode.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @return
     */
    public WxMnpImgScanQRCodeResult scanQRCodeResult(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        return scanQRCodeResult(accessToken, tmpFile);
    }

    /**
     * img.superresolution
     * 本接口提供基于小程序的图片高清化能力。
     * 说明 文件大小限制：小于2M 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 目前支持将图片超分辨率高清化2倍，即生成图片分辨率为原图2倍大小
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.superresolution.html">参考文档</a>
     *
     * @param accessToken
     * @param imgUrl
     * @return media_id 有效期为3天，期间可以通过“获取临时素材”接口获取图片二进制。获取url: https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
     */
    public String supperResolution(String accessToken, String imgUrl) {
        assert accessToken != null && imgUrl != null;
        String url = String.format("https://api.weixin.qq.com/cv/img/superresolution?access_token=%s", accessToken);

        JsonObject json = new JsonObject();
        json.addProperty("img_url", imgUrl);

        String respStr = post(url, json.getAsString());
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return respJson.get("media_id").getAsString();
    }

    /**
     * img.superresolution
     * 本接口提供基于小程序的图片高清化能力。
     * 说明 文件大小限制：小于2M 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 目前支持将图片超分辨率高清化2倍，即生成图片分辨率为原图2倍大小
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.superresolution.html">参考文档</a>
     *
     * @param accessToken
     * @param img
     * @return media_id 有效期为3天，期间可以通过“获取临时素材”接口获取图片二进制。获取url: https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
     */
    public String supperResolution(String accessToken, File img) {
        assert accessToken != null && img != null;
        String url = String.format("https://api.weixin.qq.com/cv/img/superresolution?access_token=%s", accessToken);

        String respStr = upload(url, img, UPLOAD_FILE_NAME);

        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return respJson.get("media_id").getAsString();
    }

    /**
     * img.superresolution
     * 本接口提供基于小程序的图片高清化能力。
     * 说明 文件大小限制：小于2M 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 目前支持将图片超分辨率高清化2倍，即生成图片分辨率为原图2倍大小
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/img/img.superresolution.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @return media_id 有效期为3天，期间可以通过“获取临时素材”接口获取图片二进制。获取url: https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
     */
    public String supperResolution(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        return supperResolution(accessToken, tmpFile);
    }

}
