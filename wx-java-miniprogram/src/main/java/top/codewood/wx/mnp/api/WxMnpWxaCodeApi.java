package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.bean.wxacode.WxMnpWxaCodeRequest;
import top.codewood.wx.mnp.bean.wxacode.WxMnpWxaCodeUnlimitedRequest;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.InputStream;

public class WxMnpWxaCodeApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpWxaCodeApi INSTANCE = new WxMnpWxaCodeApi();
    }

    public static WxMnpWxaCodeApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * wxacode.createQRCode
     * 获取小程序二维码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制，详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/qr-code.html">获取二维码</a>。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.createQRCode.html">参考文档</a>
     *
     * @param accessToken
     * @param path 扫码进入的小程序页面路径，最大长度 128 字节，不能为空；对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。
     * @param width 默认值：430。 二维码的宽度，单位 px。最小 280px，最大 1280px
     * @return
     */
    public InputStream createQrcode(String accessToken, String path, Integer width) {
        assert accessToken != null && path != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("path", path);
        if (width != null) {
            json.addProperty("width", width);
        }
        return postInputStream(url, json.toString());
    }


    /**
     * wxacode.get
     * 获取小程序码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制，详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/qr-code.html">获取二维码</a>。
     *
     * <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/qr-code/wxacode.get.html">参考文档</a>
     *
     * @param accessToken
     * @param request
     * @return
     */
    public InputStream get(String accessToken, WxMnpWxaCodeRequest request) {
        assert accessToken != null && request != null && request.getPath() != null;

        String url = String.format("https://api.weixin.qq.com/wxa/getwxacode?access_token=%s", accessToken);
        return postInputStream(url, WxGsonBuilder.instance().toJson(request));
    }


    /**
     * wxacode.getUnlimited
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。
     * 更多用法详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/qr-code.html">获取二维码</a>。
     *
     * @param accessToken
     * @param request
     * @return
     */
    public InputStream getUnlimited(String accessToken, WxMnpWxaCodeUnlimitedRequest request) {
        assert accessToken != null && request != null && request.getScene() != null;
        String url = String.format("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s", accessToken);
        return postInputStream(url, WxGsonBuilder.instance().toJson(request));
    }


}
