package top.codewood.wx.mnp.bean.security;

public class WxMnpSecurityMsgSecCheckRequest extends WxMnpSecurityBaseRequest {

    /**
     * 必填
     * 需检测的文本内容，文本字数的上限为2500字，需使用UTF-8编码
     */
    private String content;
    /**
     * 必填： 否
     * 用户昵称，需使用UTF-8编码
     */
    private String nickname;
    /**
     * 必填： 否
     * 文本标题，需使用UTF-8编码
     */
    private String title;
    /**
     * 必填： 否
     * 个性签名，该参数仅在资料类场景有效(scene=1)，需使用UTF-8编码
     */
    private String signature;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "WxMnpSecurityMsgSecCheckRequest{" +
                "version=" + version +
                ", openid='" + openid + '\'' +
                ", scene=" + scene +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

    public static class Builder {
        private Integer version = 2;
        private String openid;
        private Integer scene;
        private String content;
        private String nickname;
        private String title;
        private String signature;

        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        public Builder openid(String openid) {
            this.openid = openid;
            return this;
        }

        public Builder scene(Integer scene) {
            this.scene = scene;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder signature(String signature) {
            this.signature = signature;
            return this;
        }

        public WxMnpSecurityMsgSecCheckRequest build() {
            WxMnpSecurityMsgSecCheckRequest request = new WxMnpSecurityMsgSecCheckRequest();
            request.setVersion(this.version);
            request.setOpenid(this.openid);
            request.setScene(this.scene);
            request.setContent(this.content);
            request.setNickname(this.nickname);
            request.setTitle(this.title);
            request.setSignature(this.signature);
            return request;
        }

    }

}
