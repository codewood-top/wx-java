package top.codewood.wx.mp.bean.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WxMpTemplateMessage implements Serializable {

    /**
     * 接收者openid
     */
    private String toUser;

    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     */
    private String url;

    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    private MiniProgram miniProgram;

    /**
     * 模板数据
     */
    private List<WxMpTemplateData> data = new ArrayList<>();

    public WxMpTemplateMessage addData(WxMpTemplateData tmplData) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(tmplData);
        return this;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MiniProgram getMiniProgram() {
        return miniProgram;
    }

    public void setMiniProgram(MiniProgram miniProgram) {
        this.miniProgram = miniProgram;
    }

    public List<WxMpTemplateData> getData() {
        return data;
    }

    public void setData(List<WxMpTemplateData> data) {
        this.data = data;
    }

    public static class MiniProgram implements Serializable {
        /**
         * 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
         */
        private String appid;
        /**
         * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），要求该小程序已发布，暂不支持小游戏
         */
        private String pagePath;

        public MiniProgram() {}

        public MiniProgram(String appid, String pagePath) {
            this.appid = appid;
            this.pagePath = pagePath;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagePath() {
            return pagePath;
        }

        public void setPagePath(String pagePath) {
            this.pagePath = pagePath;
        }
    }
}
