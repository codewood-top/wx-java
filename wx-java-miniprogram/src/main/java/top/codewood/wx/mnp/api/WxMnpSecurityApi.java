package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.mnp.bean.security.WxMnpSecurityMediaCheckAsyncRequest;
import top.codewood.wx.mnp.bean.security.WxMnpSecurityMsgSecCheckRequest;
import top.codewood.wx.mnp.bean.security.WxMnpSecurityMsgSecCheckResult;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class WxMnpSecurityApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpSecurityApi INSTANCE = new WxMnpSecurityApi();
    }

    public static WxMnpSecurityApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * security.imgSecCheck
     * 校验一张图片是否含有违法违规内容。详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/operation.html">内容安全解决方案</a>
     * 应用场景举例：
     * 图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；
     * 敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等。 ** 频率限制：单个 appId 调用上限为 2000 次/分钟，200,000 次/天 （ 图片大小限制：1M **）
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/security.imgSecCheck.html">参考文档</a>
     *
     * @param accessToken
     * @param file
     */
    @Deprecated
    public void imgSecCheck(String accessToken, File file) {
        assert accessToken != null && file != null;
        String url = String.format("https://api.weixin.qq.com/wxa/img_sec_check?access_token=%s", accessToken);
        upload(url, file);
    }

    /**
     * security.imgSecCheck
     * 校验一张图片是否含有违法违规内容。详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/operation.html">内容安全解决方案</a>
     * 应用场景举例：
     * 图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；
     * 敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等。 ** 频率限制：单个 appId 调用上限为 2000 次/分钟，200,000 次/天 （ 图片大小限制：1M **）
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/sec-check/security.imgSecCheck.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @throws top.codewood.wx.common.bean.error.WxErrorException
     */
    @Deprecated
    public void imgSecCheck(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        imgSecCheck(accessToken, tmpFile);
    }

    /**
     * security.mediaCheckAsync-v1
     * 异步校验图片/音频是否含有违法违规内容。
     * 应用场景举例：
     * 语音风险识别：社交类用户发表的语音内容检测；
     * 图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；
     * 敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等。 频率限制：单个 appId 调用上限为 2000 次/分钟，200,000 次/天；文件大小限制：单个文件大小不超过10M
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/framework/security.mediaCheckAsync-v1.html">参考文档</a>
     *
     * @param accessToken
     * @param mediaUrl 要检测的多媒体url
     * @param mediaType 1:音频;2:图片
     * @return trace_id: 1:音频;2:图片。异步检测结果在 30 分钟内会推送到你的消息接收服务器。<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/server-ability/message-push.html">点击查看消息接收服务器配置</a>
     */
    @Deprecated
    public String mediaCheckAsync(String accessToken, String mediaUrl, int mediaType) {
        assert  accessToken != null && mediaUrl != null;
        String url = String.format("https://api.weixin.qq.com/wxa/media_check_async?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("media_url", mediaUrl);
        json.addProperty("media_type", mediaType);
        String respStr = post(url, json.toString());
        JsonObject retJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);
        return retJson.get("trace_id").getAsString();
    }

    /**
     * security.msgSecCheck
     * 检查一段文本是否含有违法违规内容。
     * 应用场景举例：
     * 用户个人资料违规文字检测；
     * 媒体新闻类用户发表文章，评论内容检测；
     * 游戏类用户编辑上传的素材(如答题类小游戏用户上传的问题及答案)检测等。 频率限制：单个 appId 调用上限为 4000 次/分钟，2,000,000 次/天*
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/sec-check/security.msgSecCheck.html">参考文档</a>
     *
     * @param accessToken
     * @param content
     * @throws top.codewood.wx.common.bean.error.WxErrorException
     */
    @Deprecated
    public void msgSecCheck(String accessToken, String content) {
        assert accessToken != null && content != null;
        String url = String.format("https://api.weixin.qq.com/wxa/msg_sec_check?access_token=%s", accessToken);
        String postData = String.format("{\"content\":\"%s\"}", content);
        post(url, postData);
    }

    /**
     * security.mediaCheckAsync
     * 异步校验图片/音频是否含有违法违规内容。
     *
     * 应用场景举例：
     *      语音风险识别：社交类用户发表的语音内容检测；
     *      图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；
     *      敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等。 频率限制：单个 appId 调用上限为 2000 次/分钟，200,000 次/天；文件大小限制：单个文件大小不超过10M
     *
     * @param accessToken
     * @param request
     * @return trace_id 唯一请求标识，标记单次请求，用于匹配异步推送结果
     */
    public String mediaCheckAsync(String accessToken, WxMnpSecurityMediaCheckAsyncRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/wxa/media_check_async?access_token=%s", accessToken);

        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        JsonObject respJson = WxGsonBuilder.instance().fromJson(respStr, JsonObject.class);

        return respJson.get("trace_id").getAsString();
    }

    /**
     * security.msgSecCheck
     *
     * 检查一段文本是否含有违法违规内容。
     * 应用场景举例：
     *      用户个人资料违规文字检测；
     *      媒体新闻类用户发表文章，评论内容检测；
     *      游戏类用户编辑上传的素材(如答题类小游戏用户上传的问题及答案)检测等。 频率限制：单个 appId 调用上限为 4000 次/分钟，2,000,000 次/天*
     *
     * @param accessToken
     * @param request
     * @return
     */
    public WxMnpSecurityMsgSecCheckResult msgSecCheck(String accessToken, WxMnpSecurityMsgSecCheckRequest request) {
        assert accessToken != null && request != null;
        String url = String.format("https://api.weixin.qq.com/wxa/msg_sec_check?access_token=%s", accessToken);
        String respStr = post(url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, WxMnpSecurityMsgSecCheckResult.class);
    }

}
