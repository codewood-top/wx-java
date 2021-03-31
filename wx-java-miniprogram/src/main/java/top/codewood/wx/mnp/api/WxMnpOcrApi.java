package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.mnp.bean.ocr.*;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Driver;
import java.util.UUID;

public class WxMnpOcrApi extends WxBaseHttpApi {

    private static String UPLOAD_FILE_NAME = "img";

    private static class Holder {
        private static final WxMnpOcrApi INSTANCE = new WxMnpOcrApi();
    }

    public static WxMnpOcrApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * ocr.bankcard
     * 本接口提供基于小程序的银行卡 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.bankcard.html">参考文档</a>
     *
     * @param accessToken
     * @param img
     * @return
     */
    public String bankcard(String accessToken, File img) {
        assert accessToken != null && img != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/bankcard?access_token=%s", accessToken);
        String respStr = upload(url, img, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, JsonObject.class).get("number").getAsString();
    }

    /**
     * ocr.bankcard
     * 本接口提供基于小程序的银行卡 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.bankcard.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @return
     */
    public String bankcard(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/bankcard?access_token=%s", accessToken);
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        String respStr = upload(url, tmpFile, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, JsonObject.class).get("number").getAsString();
    }

    /**
     * ocr.bankcard
     * 本接口提供基于小程序的银行卡 OCR 识别
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.bankcard.html">参考文档</a>
     *
     * @param accessToken
     * @param imgUrl
     * @return
     */
    public String bankcard(String accessToken, String imgUrl) {
        assert accessToken != null && imgUrl != null;
        String encodedUrl = null;
        try {
            encodedUrl = URLEncoder.encode(imgUrl, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            encodedUrl = imgUrl;
        }
        String url = String.format("https://api.weixin.qq.com/cv/ocr/bankcard?img_url=%s&access_token=%s", encodedUrl, accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, JsonObject.class).get("number").getAsString();
    }


    /**
     * ocr.businessLicense
     * 本接口提供基于小程序的营业执照 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 返回字段仅包含当前营业执照图片中存在的字段，若对应字段不存在则不返回
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.businessLicense.html">参考文档</a>
     *
     * @param accessToke
     * @param file
     * @return
     */
    public BusinessLincense businessLicense(String accessToke, File file) {
        assert accessToke != null && file != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/bizlicense?access_token=%s", accessToke);
        String respStr = upload(url, file, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, BusinessLincense.class);
    }

    /**
     * ocr.businessLicense
     * 本接口提供基于小程序的营业执照 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 返回字段仅包含当前营业执照图片中存在的字段，若对应字段不存在则不返回
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.businessLicense.html">参考文档</a>
     *
     * @param accessToke
     * @param inputStream
     * @return
     */
    public BusinessLincense businessLicense(String accessToke, InputStream inputStream) throws IOException {
        assert accessToke != null && inputStream != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/bizlicense?access_token=%s", accessToke);
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        String respStr = upload(url, tmpFile, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, BusinessLincense.class);
    }

    /**
     * ocr.businessLicense
     * 本接口提供基于小程序的营业执照 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 返回字段仅包含当前营业执照图片中存在的字段，若对应字段不存在则不返回
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.businessLicense.html">参考文档</a>
     *
     * @param accessToke
     * @param imgUrl
     * @return
     */
    public BusinessLincense businessLicense(String accessToke, String imgUrl) throws IOException {
        assert accessToke != null && imgUrl != null;
        String encodedUrl = null;
        try {
            encodedUrl = URLEncoder.encode(imgUrl, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            encodedUrl = imgUrl;
        }
        String url = String.format("https://api.weixin.qq.com/cv/ocr/bizlicense?img_url=%s&access_token=%s", encodedUrl, accessToke);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, BusinessLincense.class);
    }

    /**
     * ocr.idcard
     * 本接口提供基于小程序的身份证 OCR 识别
     *
     * 接口限制 微信OCR能力已全面接入服务平台计费系统。除服务平台接入方式外，原内测API，插件接入方式也均已接入计费系统。2020.4.1起，已接入内测的开发者，免费额度会统一调整为100次/天。更强的能力需求，可以走<a href="https://fuwu.weixin.qq.com/detail/000ce4cec24ca026d37900ed551415">服务市场调用</a>。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.idcard.html">参考文档</a>
     *
     * @param accessToken
     * @param imgUrl
     * @return
     */
    public DriverLicense driverLicense(String accessToken, String imgUrl) {
        assert accessToken != null && imgUrl != null;
        String encodedUrl = null;
        try {
            encodedUrl = URLEncoder.encode(imgUrl, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            encodedUrl = imgUrl;
        }
        String url = String.format("https://api.weixin.qq.com/cv/ocr/drivinglicense?img_url=%s&access_token=%s", encodedUrl, accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, DriverLicense.class);
    }

    /**
     * ocr.idcard
     * 本接口提供基于小程序的身份证 OCR 识别
     *
     * 接口限制 微信OCR能力已全面接入服务平台计费系统。除服务平台接入方式外，原内测API，插件接入方式也均已接入计费系统。2020.4.1起，已接入内测的开发者，免费额度会统一调整为100次/天。更强的能力需求，可以走<a href="https://fuwu.weixin.qq.com/detail/000ce4cec24ca026d37900ed551415">服务市场调用</a>。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.idcard.html">参考文档</a>
     *
     * @param accessToken
     * @param file
     * @return
     */
    public DriverLicense driverLicense(String accessToken, File file) {
        assert accessToken != null && file != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/idcard?access_token=%s", accessToken);
        String respStr = upload(url, file, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, DriverLicense.class);
    }

    /**
     * ocr.idcard
     * 本接口提供基于小程序的身份证 OCR 识别
     *
     * 接口限制 微信OCR能力已全面接入服务平台计费系统。除服务平台接入方式外，原内测API，插件接入方式也均已接入计费系统。2020.4.1起，已接入内测的开发者，免费额度会统一调整为100次/天。更强的能力需求，可以走<a href="https://fuwu.weixin.qq.com/detail/000ce4cec24ca026d37900ed551415">服务市场调用</a>。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.idcard.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @return
     */
    public DriverLicense driverLicense(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/idcard?access_token=%s", accessToken);
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        String respStr = upload(url, tmpFile, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, DriverLicense.class);
    }

    /**
     * ocr.printedText
     * 本接口提供基于小程序的通用印刷体 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 通用印刷体OCR适用于屏幕截图、印刷体照片等场景
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.printedText.html">参考文档</a>
     *
     * @param accessToken
     * @param imgUrl
     * @return
     */
    public PrintedTextOcrResult printedText(String accessToken, String imgUrl) {
        assert accessToken != null && imgUrl != null;
        String encodedUrl = null;
        try {
            encodedUrl = URLEncoder.encode(imgUrl, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            encodedUrl = imgUrl;
        }
        String url = String.format("https://api.weixin.qq.com/cv/ocr/comm?img_url=%s&access_token=%s", encodedUrl, accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, PrintedTextOcrResult.class);
    }

    /**
     * ocr.printedText
     * 本接口提供基于小程序的通用印刷体 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 通用印刷体OCR适用于屏幕截图、印刷体照片等场景
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.printedText.html">参考文档</a>
     *
     * @param accessToken
     * @param file
     * @return
     */
    public PrintedTextOcrResult printedText(String accessToken, File file) {
        assert accessToken != null && file != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/comm?access_token=%s", accessToken);
        String respStr = upload(url, file, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, PrintedTextOcrResult.class);
    }

    /**
     * ocr.printedText
     * 本接口提供基于小程序的通用印刷体 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。 通用印刷体OCR适用于屏幕截图、印刷体照片等场景
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.printedText.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @return
     */
    public PrintedTextOcrResult printedText(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/comm?access_token=%s", accessToken);
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        String respStr = upload(url, tmpFile, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, PrintedTextOcrResult.class);
    }

    /**
     * ocr.idcard
     * 本接口提供基于小程序的身份证 OCR 识别
     *
     * 接口限制 微信OCR能力已全面接入服务平台计费系统。除服务平台接入方式外，原内测API，插件接入方式也均已接入计费系统。2020.4.1起，已接入内测的开发者，免费额度会统一调整为100次/天。更强的能力需求，可以走服务市场调用。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.idcard.html">参考文档</a>
     *
     * @param accessToken
     * @param imgUrl
     * @return
     */
    public IdCard idCard(String accessToken, String imgUrl) {
        assert accessToken != null && imgUrl != null;
        String encodedUrl = null;
        try {
            encodedUrl = URLEncoder.encode(imgUrl, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            encodedUrl = imgUrl;
        }
        String url = String.format("https://api.weixin.qq.com/cv/ocr/idcard?img_url=%s&access_token=%s", encodedUrl, accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, IdCard.class);
    }

    /**
     * ocr.idcard
     * 本接口提供基于小程序的身份证 OCR 识别
     *
     * 接口限制 微信OCR能力已全面接入服务平台计费系统。除服务平台接入方式外，原内测API，插件接入方式也均已接入计费系统。2020.4.1起，已接入内测的开发者，免费额度会统一调整为100次/天。更强的能力需求，可以走服务市场调用。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.idcard.html">参考文档</a>
     *
     * @param accessToken
     * @param file
     * @return
     */
    public IdCard idCard(String accessToken, File file) {
        assert accessToken != null && file != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/idcard?access_token=%s", accessToken);
        String respStr = upload(url, file, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, IdCard.class);
    }

    /**
     * ocr.idcard
     * 本接口提供基于小程序的身份证 OCR 识别
     *
     * 接口限制 微信OCR能力已全面接入服务平台计费系统。除服务平台接入方式外，原内测API，插件接入方式也均已接入计费系统。2020.4.1起，已接入内测的开发者，免费额度会统一调整为100次/天。更强的能力需求，可以走服务市场调用。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.idcard.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @return
     */
    public IdCard idCard(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/idcard?access_token=%s", accessToken);
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        String respStr = upload(url, tmpFile, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, IdCard.class);
    }

    /**
     * ocr.vehicleLicense
     * 本接口提供基于小程序的行驶证 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.vehicleLicense.html">参考文档</a>
     *
     * @param accessToken
     * @param imgUrl
     * @return
     */
    public VehicleLicense vehicleLicense(String accessToken, String imgUrl) {
        assert accessToken != null && imgUrl != null;
        String encodedUrl = null;
        try {
            encodedUrl = URLEncoder.encode(imgUrl, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            encodedUrl = imgUrl;
        }
        String url = String.format("https://api.weixin.qq.com/cv/ocr/driving?img_url=%s&access_token=%s", encodedUrl, accessToken);
        String respStr = get(url);
        return WxGsonBuilder.instance().fromJson(respStr, VehicleLicense.class);
    }

    /**
     * ocr.vehicleLicense
     * 本接口提供基于小程序的行驶证 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.vehicleLicense.html">参考文档</a>
     *
     * @param accessToken
     * @param file
     * @return
     */
    public VehicleLicense vehicleLicense(String accessToken, File file) {
        assert accessToken != null && file != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/driving?img_url=%s&access_token=%s", accessToken);
        String respStr = upload(url, file, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, VehicleLicense.class);
    }

    /**
     * ocr.vehicleLicense
     * 本接口提供基于小程序的行驶证 OCR 识别
     *
     * 接口限制 内测期间已认证的订阅号、服务号、企业号、小程序可直接调用，次数限制为100次/天。
     * 使用 Tips 此接口为后台接口，可基于自有业务承载情况，搭配小程序的拍照、相册选照等一起使用，即可完成身份证照片的采集、上传、识别、信息返回等流程，用于需要基于身份证、银行卡等实体卡或证，采集照片或文字信息等的业务场景。
     * 图片说明 文件大小限制：小于2M
     * 图片支持使用img参数实时上传，也支持使用img_url参数传送图片地址，由微信后台下载图片进行识别。type 有两种类型
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/ocr/ocr.vehicleLicense.html">参考文档</a>
     *
     * @param accessToken
     * @param inputStream
     * @return
     */
    public VehicleLicense vehicleLicense(String accessToken, InputStream inputStream) throws IOException {
        assert accessToken != null && inputStream != null;
        String url = String.format("https://api.weixin.qq.com/cv/ocr/driving?access_token=%s", accessToken);
        File tmpFile = FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg");
        String respStr = upload(url, tmpFile, UPLOAD_FILE_NAME);
        return WxGsonBuilder.instance().fromJson(respStr, VehicleLicense.class);
    }

}