package top.codewood.wx.mnp.bean.msg;

import top.codewood.wx.mnp.bean.WxMnpTemplateData;

import java.io.Serializable;
import java.util.List;

/**
 * gson: 配合 WxMnpUniformMessageGsonAdapter
 */
public class WxMnpUniformMessage implements Serializable {

    /**
     * 用户openid，可以是小程序的openid，也可以是mp_template_msg.appid对应的公众号的openid
     */
    private String toUser;

    /**
     * 小程序模板消息相关的信息，可以参考小程序模板消息接口; 有此节点则优先发送小程序模板消息
     */
    private WeAppTemplate weAppTemplateMsg;

    /**
     * 公众号模板消息相关的信息，可以参考公众号模板消息接口；有此节点并且没有weapp_template_msg节点时，发送公众号模板消息
     */
    private MpTempalte mpTempalte;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public WeAppTemplate getWeAppTemplateMsg() {
        return weAppTemplateMsg;
    }

    public void setWeAppTemplateMsg(WeAppTemplate weAppTemplateMsg) {
        this.weAppTemplateMsg = weAppTemplateMsg;
    }

    public MpTempalte getMpTempalte() {
        return mpTempalte;
    }

    public void setMpTempalte(MpTempalte mpTempalte) {
        this.mpTempalte = mpTempalte;
    }

    @Override
    public String toString() {
        return "WxMnpUniformMessage{" +
                "toUser='" + toUser + '\'' +
                ", weAppTemplateMsg=" + weAppTemplateMsg +
                ", mpTempalte=" + mpTempalte +
                '}';
    }

    public static class WeAppTemplate implements Serializable {

        /**
         * 小程序模板ID
         */
        private String templateId;

        /**
         * 小程序页面路径
         */
        private String page;

        /**
         * 小程序模板消息formid
         */
        private String formId;

        /**
         * 小程序模板数据
         */
        private List<WxMnpTemplateData> data;

        /**
         * 小程序模板放大关键词
         *  "emphasis_keyword":"keyword1.DATA"
         */
        private String emphasisKeyword;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getFormId() {
            return formId;
        }

        public void setFormId(String formId) {
            this.formId = formId;
        }

        public List<WxMnpTemplateData> getData() {
            return data;
        }

        public void setData(List<WxMnpTemplateData> data) {
            this.data = data;
        }

        public String getEmphasisKeyword() {
            return emphasisKeyword;
        }

        public void setEmphasisKeyword(String emphasisKeyword) {
            this.emphasisKeyword = emphasisKeyword;
        }

        @Override
        public String toString() {
            return "WeAppTemplate{" +
                    "templateId='" + templateId + '\'' +
                    ", page='" + page + '\'' +
                    ", formId='" + formId + '\'' +
                    ", data='" + data + '\'' +
                    ", emphasisKeyword='" + emphasisKeyword + '\'' +
                    '}';
        }
    }

    public static class MpTempalte implements Serializable {

        /**
         * 公众号appid，要求与小程序有绑定且同主体
         */
        private String appid;

        /**
         * 公众号模板id
         */
        private String templateId;

        /**
         * 公众号模板消息所要跳转的url
         */
        private String url;

        /**
         * 公众号模板消息所要跳转的小程序，小程序的必须与公众号具有绑定关系
         */
        private String miniprogram;

        /**
         * 公众号模板消息的数据
         */
        private List<WxMnpTemplateData> data;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
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

        public String getMiniprogram() {
            return miniprogram;
        }

        public void setMiniprogram(String miniprogram) {
            this.miniprogram = miniprogram;
        }

        public List<WxMnpTemplateData> getData() {
            return data;
        }

        public void setData(List<WxMnpTemplateData> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "MpTempalte{" +
                    "appid='" + appid + '\'' +
                    ", templateId='" + templateId + '\'' +
                    ", url='" + url + '\'' +
                    ", miniprogram='" + miniprogram + '\'' +
                    ", data='" + data + '\'' +
                    '}';
        }

    }

}
