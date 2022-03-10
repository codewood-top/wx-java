package top.codewood.wx.mnp.bean.wxacode;

import com.google.gson.annotations.SerializedName;

public class WxMnpWxaCodeUnlimitedRequest extends WxMnpWxaCodeBaseRequest {

    /**
     * 必填：是
     * 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，
     * 其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     */
    private String scene;

    /**
     * 必填：否
     * default: 主页
     * 页面 page，例如 pages/index/index，根路径前不要填加 /，不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
     *
     */
    private String page;
    /**
     * 必填： 否
     * default: true
     * 检查 page 是否存在，为 true 时 page 必须是已经发布的小程序存在的页面（否则报错）；
     * 为 false 时允许小程序未发布或者 page 不存在，
     * 但 page 有数量上限（60000个）请勿滥用
     */
    @SerializedName("check_path")
    private Boolean checkPath;


    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Boolean getCheckPath() {
        return checkPath;
    }

    public void setCheckPath(Boolean checkPath) {
        this.checkPath = checkPath;
    }

    @Override
    public String toString() {
        return "WxMnpWxaCodeUnlimitedRequest{" +
                "envVersion='" + envVersion + '\'' +
                ", width=" + width +
                ", autoColor=" + autoColor +
                ", lineColor=" + lineColor +
                ", hyaline=" + hyaline +
                ", scene='" + scene + '\'' +
                ", page='" + page + '\'' +
                ", checkPath=" + checkPath +
                '}';
    }
}
