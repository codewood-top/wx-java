package top.codewood.wx.mnp.bean.wxacode;

public class WxMnpWxaCodeRequest extends WxMnpWxaCodeBaseRequest {

    /**
     * 必填
     * 扫码进入的小程序页面路径，最大长度 128 字节，不能为空；
     * 对于小游戏，可以只传入 query 部分，来实现传参效果，
     * 如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。
     */
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "WxMnpWxaCodeRequest{" +
                "envVersion='" + envVersion + '\'' +
                ", width=" + width +
                ", autoColor=" + autoColor +
                ", lineColor=" + lineColor +
                ", hyaline=" + hyaline +
                ", path='" + path + '\'' +
                '}';
    }
}
