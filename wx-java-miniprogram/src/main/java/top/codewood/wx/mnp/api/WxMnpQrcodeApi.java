package top.codewood.wx.mnp.api;

import com.google.gson.JsonObject;
import top.codewood.wx.common.api.WxBaseHttpApi;
import top.codewood.wx.mnp.util.json.WxGsonBuilder;

import java.io.InputStream;
import java.util.Map;

public class WxMnpQrcodeApi extends WxBaseHttpApi {

    private static class Holder {
        private static final WxMnpQrcodeApi INSTANCE = new WxMnpQrcodeApi();
    }

    public static WxMnpQrcodeApi getInstance() {
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
     * @param path 扫码进入的小程序页面路径，最大长度 128 字节，不能为空；
     *             对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。
     * @param width 默认值：430. 二维码的宽度，单位 px。最小 280px，最大 1280px
     * @param autoColor 默认值：false。 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调
     * @param lineColor 默认值：{"r":0,"g":0,"b":0}。 auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
     * @param isHyaline 默认值：false。是否需要透明底色，为 true 时，生成透明底色的小程序码
     * @return
     */
    public InputStream get(String accessToken, String path, Integer width, Boolean autoColor, Map<String, Integer> lineColor, Boolean isHyaline) {
        assert accessToken != null && path != null;

        String url = String.format("https://api.weixin.qq.com/wxa/getwxacode?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("path", path);
        if (width != null) {
            json.addProperty("width", width);
        }
        if (autoColor != null) {
            json.addProperty("auto_color", autoColor);
        }
        if (lineColor != null) {
            json.addProperty("line_color", WxGsonBuilder.instance().toJson(lineColor));
        }
        if (isHyaline != null) {
            json.addProperty("is_hyaline", isHyaline);
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
     * @param path 扫码进入的小程序页面路径，最大长度 128 字节，不能为空；
     *             对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。
     * @return
     */
    public InputStream get(String accessToken, String path) {
        return get(accessToken, path, null, null, null, null);
    }

    /**
     * wxacode.getUnlimited
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。 更多用法详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/qr-code.html">获取二维码</a>。
     *
     * @param accessToken
     * @param scene 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     * @param page  默认值：主页。 必须是已经发布的小程序存在的页面（否则报错），例如 pages/index/index, 根路径前不要填加 /,不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
     * @param width 默认值：430。 二维码的宽度，单位 px，最小 280px，最大 1280px
     * @param autoColor 默认值：false。自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认 false
     * @param lineColor 默认值：{"r":0,"g":0,"b":0}。 auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
     * @param isHyaline 默认值：false。 是否需要透明底色，为 true 时，生成透明底色的小程序
     * @return
     */
    public InputStream getUnlimited(String accessToken, String scene, String page, Integer width, Boolean autoColor, Map<String, Integer> lineColor, Boolean isHyaline) {
        assert accessToken != null && scene != null;
        String url = String.format("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("scene", scene);
        if (page != null) {
            json.addProperty("page", page);
        }
        if (width != null) {
            json.addProperty("width", width);
        }
        if (autoColor != null) {
            json.addProperty("auto_color", autoColor);
        }
        if (lineColor != null) {
            json.addProperty("line_color", WxGsonBuilder.instance().toJson(lineColor));
        }
        if (isHyaline != null) {
            json.addProperty("is_hyaline", isHyaline);
        }

        return postInputStream(url, json.toString());
    }

    /**
     * wxacode.getUnlimited
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。 更多用法详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/qr-code.html">获取二维码</a>。
     *
     * @param accessToken
     * @param scene 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     * @param page  默认值：主页。 必须是已经发布的小程序存在的页面（否则报错），例如 pages/index/index, 根路径前不要填加 /,不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
    */
    public InputStream getUnlimited(String accessToken, String scene, String page) {
        return getUnlimited(accessToken, scene, page, null, null, null, null);
    }

    /**
     * wxacode.getUnlimited
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。 更多用法详见<a href="https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/qr-code.html">获取二维码</a>。
     *
     * @param accessToken
     * @param scene 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     * @return
     */
    public InputStream getUnlimited(String accessToken, String scene) {
        return getUnlimited(accessToken, scene, null, null, null, null, null);
    }

}
