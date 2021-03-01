package top.codewood.wx.common.bean.error;

/**
 * <a href="https://developers.weixin.qq.com/doc/offiaccount/Getting_Started/Global_Return_Code.html">全局返回码</a>
 */
public enum WxErrorEnum {

    CODE_1(-1, "系统繁忙，此时请开发者稍候再试"),

    CODE_0(0, "成功"),

    CODE_40001(40001, "AppSecret错误或者AppSecret不属于这个公众号，请开发者确认AppSecret的正确性"),

    CODE_40002(40002, "请确保grant_type字段值为client_credential"),

    CODE_40003(40003, "不合法的 OpenID ，请开发者确认 OpenID （该用户）是否已关注公众号，或是否是其他公众号的 OpenID"),

    CODE_42001(42001, "access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明"),

    CODE_65400(65400, "API不可用，即没有开通/升级到新客服功能"),

    CODE_65403(65403, "客服昵称不合法"),

    CODE_65404(65404, "客服帐号不合法"),

    CODE_65405(65405, "帐号数目已达到上限，不能继续添加"),

    CODE_65406(65406, "已经存在的客服帐号"),

    CODE_89503(89503, "此IP调用需要管理员确认,请联系管理员"),

    CODE_89501(89501, "此IP正在等待管理员确认,请联系管理员"),

    CODE_89506(89506, "24小时内该IP被管理员拒绝调用两次，24小时内不可再使用该IP调用"),

    CODE_89507(89507, "1小时内该IP被管理员拒绝调用一次，1小时内不可再使用该IP调用")
    ;

    private int code;
    private String msg;

    WxErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getCodeMsg(int code) {
        for (WxErrorEnum errVal : WxErrorEnum.values()) {
            if (errVal.code == code) return errVal.msg;
        }
        return null;
    }
}