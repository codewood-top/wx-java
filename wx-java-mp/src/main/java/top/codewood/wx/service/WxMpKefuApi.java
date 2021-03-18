package top.codewood.wx.service;

import com.google.gson.JsonObject;
import top.codewood.wx.common.bean.error.WxRuntimeException;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.mp.bean.kefu.message.WxMpKfMessage;
import top.codewood.wx.mp.bean.kefu.request.WxMpKfAccountRequest;
import top.codewood.wx.mp.bean.kefu.result.*;
import top.codewood.wx.mp.util.json.WxGsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class WxMpKefuApi extends WxMpApi {

    private static class Holder {
        private static final WxMpKefuApi INSTANCE = new WxMpKefuApi();
    }

    public static WxMpKefuApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     *  添加客服帐号
     * @param accessToken
     * @param kfAccount 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickname 客服昵称，最长6个汉字或12个英文字符
     * @param pswmd5 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
     * @return
     */
    public void add(String accessToken, String kfAccount, String nickname, String pswmd5) {
        assert accessToken != null;
        assert kfAccount != null && nickname != null;

        String url = String.format("https://api.weixin.qq.com/customservice/kfaccount/add?access_token=%s", accessToken);
        post(url, WxGsonBuilder.create().toJson(new WxMpKfAccountRequest(kfAccount, nickname, pswmd5)));
    }

    /**
     * 修改客服帐号
     * @param accessToken
     * @param kfAccount
     * @param nickname
     * @param pswmd5
     */
    public void update(String accessToken, String kfAccount, String nickname, String pswmd5) {
        assert accessToken != null;
        assert kfAccount != null && nickname != null;
        String url = String.format("https://api.weixin.qq.com/customservice/kfaccount/update?access_token=%s", accessToken);
        post(url, WxGsonBuilder.create().toJson(new WxMpKfAccountRequest(kfAccount, nickname, pswmd5)));
    }

    /**
     * 删除客服账号
     * @param accessToken
     * @param kfAccount
     */
    public void del(String accessToken, String kfAccount) {
        assert accessToken != null && kfAccount != null;
        String kefuStr = String.format("{\"kf_account\":\"%s\"}", kfAccount);
        String url = String.format("https://api.weixin.qq.com/customservice/kfaccount/del?access_token=%s", accessToken);
        post(url, kefuStr);
    }

    /**
     * 设置客服头像
     * 开发者可调用本接口来上传图片作为客服人员的头像，头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果
     * @param accessToken
     * @param kfAccount
     * @param inputStream
     * @return
     * @throws IOException
     */
    public void updateHeadimg(String accessToken, String kfAccount, InputStream inputStream) throws IOException {
        assert accessToken != null && kfAccount != null;
        String url = String.format(" https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=%s&kf_account=%s", accessToken, kfAccount);
        upload(url, FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), "jpg"));
    }

    /**
     * 设置客服昵称
     * @param accessToken
     * @param kfAccount
     * @param nickname
     * @return
     */
    public void updateNickname(String accessToken, String kfAccount, String nickname) {
        assert accessToken != null && kfAccount != null && nickname != null;
        String updateStr = String.format("{\"kf_account\":\"%s\", \"nickname\":\"%s\"}", kfAccount, nickname);
        String url = String.format("https://api.weixin.qq.com/customservice/kfaccount/update?access_token=%s", accessToken);
        post(url, updateStr);
    }

    /**
     * 获取所有客服账号
     * 开发者通过本接口，获取公众号中所设置的客服基本信息，包括客服工号、客服昵称、客服登录账号
     * @param accessToken
     * @return
     */
    public List<WxMpKfInfo> list(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=%s", accessToken);
        String respStr = get(url);
        WxMpKfList mpKfList = WxGsonBuilder.create().fromJson(respStr, WxMpKfList.class);
        if (mpKfList == null || mpKfList.getKfList() == null || mpKfList.getKfList().size() == 0) {
            return Collections.EMPTY_LIST;
        }
        return mpKfList.getKfList();
    }

    /**
     * 获取所有在线客户账号
     * @param accessToken
     * @return
     */
    public List<WxMpKfInfo> onlineList(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=%s", accessToken);
        String respStr = get(url);
        WxMpKfOnlineList mpKfOnlineList = WxGsonBuilder.create().fromJson(respStr, WxMpKfOnlineList.class);
        if (mpKfOnlineList == null || mpKfOnlineList.getOnlineList() == null || mpKfOnlineList.getOnlineList().size() == 0) {
            return Collections.EMPTY_LIST;
        }
        return mpKfOnlineList.getOnlineList();
    }

    /**
     * 公众号客服邀请绑定
     * @param accessToken
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param inviteWx  接收绑定邀请的客服微信号
     */
    public void inviteWorker(String accessToken, String kfAccount, String inviteWx) {
        assert accessToken != null && kfAccount != null && inviteWx != null;
        String postStr = String.format("{\"kf_account\":\"%s\",\"invite_wx\":\"%s\"}", kfAccount, inviteWx);
        String url = String.format("https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token=%s", accessToken);
        post(url, postStr);
    }

    /**
     * 发送客服信息
     * <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Service_Center_messages.html#7">发送客服信息</a>
     * @param accessToken
     * @param wxMpKfMessage
     */
    public void sendMsg(String accessToken, WxMpKfMessage wxMpKfMessage) {
        assert accessToken != null && wxMpKfMessage != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s", accessToken);
        post(url, WxGsonBuilder.create().toJson(wxMpKfMessage));
    }

    /**
     *  客服输入状态
     *  此接口需要客服消息接口权限。
     *  1、如果不满足发送客服消息的触发条件，则无法下发输入状态。
     *  2、下发输入状态，需要客服之前30秒内跟用户有过消息交互。
     *  3、在输入状态中（持续15s），不可重复下发输入态。
     *  4、在输入状态中，如果向用户下发消息，会同时取消输入状态。
     * @param accessToken
     * @param toUser 用户openid
     * @param typing "Typing"：对用户下发“正在输入"状态 "CancelTyping"：取消对用户的”正在输入"状态
     */
    public void typing(String accessToken, String toUser, boolean typing) {
        assert accessToken != null && toUser != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token=%s", accessToken);
        String typingStr = String.format("{\"touser\": \"%s\", \"command\": \"%s\"}", toUser, typing?"Typing":"CancelTyping");
        post(url, typingStr);
    }

    /**
     * 创建会话
     * 此接口在客服和用户之间创建一个会话，如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线
     * @param accessToken
     * @param kfAccount
     * @param openid
     */
    public void createSession(String accessToken, String kfAccount, String openid) {
        assert accessToken != null && kfAccount != null && openid != null;

        String url = String.format("https://api.weixin.qq.com/customservice/kfsession/create?access_token=%s", accessToken);
        String postStr = String.format("{\"kf_account\":\"%s\", \"openid\":\"%s\"}", kfAccount, openid);
        post(url, postStr);
    }

    /**
     *  关闭会话
     * @param accessToken
     * @param kfAccount
     * @param openid
     */
    public void closeSession(String accessToken, String kfAccount, String openid) {
        assert accessToken != null && kfAccount != null && openid != null;

        String url = String.format("https://api.weixin.qq.com/customservice/kfsession/close?access_token=%s", accessToken);
        String postStr = String.format("{\"kf_account\":\"%s\", \"openid\":\"%s\"}", kfAccount, openid);
        post(url, postStr);
    }

    /**
     * 获取客户会话状态
     * 此接口获取一个客户的会话，如果不存在，则kf_account为空。
     * @param accessToken
     * @param openid
     * @return  { "createtime": 123456789, "kf_account": "test1@test" }
     */
    public WxMpKfSession getSession(String accessToken, String openid) {
        assert accessToken != null && openid != null;
        String url = String.format("https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=%s&openid=%s", accessToken, openid);
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxMpKfSession.class);
    }

    /**
     * 获取客服会话列表
     * @param accessToken
     * @param kfAccount
     * @return
     */
    public List<WxMpKfSession> getSessionList(String accessToken, String kfAccount) {
        assert accessToken != null && kfAccount != null;
        String url = String.format("https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token=%s&kf_account=%s", accessToken, kfAccount);
        String respStr = get(url);
        return WxGsonBuilder.create().fromJson(respStr, WxMpKfSessionList.class).getKfSessionList();
    }

    /**
     * 获取未接入会话列表
     * @param accessToken
     * @return
     */
    public WxMpKfSessionWaitCaseList getWaitCaseList(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=%s", accessToken);
        String respStr = get(url);
        System.out.println(respStr);
        return WxGsonBuilder.create().fromJson(respStr, WxMpKfSessionWaitCaseList.class);
    }

    /**
     * 获取聊天记录
     * 此接口返回的聊天记录中
     * @param accessToken
     * @param startTime 起始时间，unix时间戳
     * @param endTime   结束时间，unix时间戳，每次查询时段不能超过24小时
     * @param msgId 消息id顺序从小到大，从1开始
     * @param number  每次获取条数，最多10000条
     * @return
     */
    public WxMpKfMsgList getKfMsgList(String accessToken, LocalDateTime startTime, LocalDateTime endTime, Long msgId, Integer number) {
        assert accessToken != null;

        if (number == null) number = 10000;
        if (number > 10000) throw new WxRuntimeException("每次获取条数，最多10000条");
        if (startTime.isAfter(endTime)) throw new WxRuntimeException("结束时间不能晚于开始时间");
        if (msgId == null) msgId = 1L;
        JsonObject json = new JsonObject();
        json.addProperty("starttime", startTime.toEpochSecond(ZoneOffset.of("+8")));
        json.addProperty("endtime", endTime.toEpochSecond(ZoneOffset.of("+8")));
        json.addProperty("msgid", msgId);
        json.addProperty("number", number);

        String url = String.format("https://api.weixin.qq.com/customservice/msgrecord/getmsglist?access_token=%s", accessToken);
        String respStr = post(url, json.toString());
        return WxGsonBuilder.create().fromJson(respStr, WxMpKfMsgList.class);
    }

    public WxMpKfMsgList getKfMsgList(String accessToken, LocalDateTime startTime, LocalDateTime endTime) {
        return getKfMsgList(accessToken, startTime, endTime, null, null);
    }

}
