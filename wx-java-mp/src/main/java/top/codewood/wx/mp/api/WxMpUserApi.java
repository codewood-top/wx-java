package top.codewood.wx.mp.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class WxMpUserApi extends WxMpApi {

    /**
     *  创建标签  一个公众号，最多可以创建100个标签。
     * @param accessToken
     * @param name 标签名
     * @return { "tag":{ "id":134,//标签id "name":"广东" } }
     */
    public static String tagCreate(String accessToken, String name) {
        assert accessToken != null && name != null;
        String tagStr = String.format("{\"tag\":{\"name\":\"%s\"}}", name);
        String url = String.format("https://api.weixin.qq.com/cgi-bin/tags/create?access_token=%s", accessToken);
        return post(url, tagStr);
    }

    /**
     *  编辑标签
     * @param accessToken
     * @param id    标签id
     * @param name  标签名
     * @return
     */
    public static String tagUpdate(String accessToken, Integer id, String name) {
        assert accessToken != null && id != null && name != null;
        String tagStr = String.format("{\"tag\":{\"id\":%s, \"name\": \"%s\"}}", id, name);
        String url = String.format("https://api.weixin.qq.com/cgi-bin/tags/update?access_token=%s", accessToken);
        return post(url, tagStr);
    }

    /**
     * 删除标签
     * @param accessToken
     * @param id    标签id
     * @return
     */
    public static String tagDelete(String accessToken, Integer id) {
        assert accessToken != null && id != null;
        String tagStr = String.format("{\"tag\":{\"id\":%s}}", id);
        String url = String.format("https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=%s", accessToken);
        return post(url, tagStr);
    }

    /**
     * 获取标签下粉丝列表
     * @param accessToken
     * @param id
     * @param nextOpenid
     * @return  {"count":1,"data":{"openid":["o_OzS5uSJf1Br8H9gLQ66NjfwluM"]},"next_openid":"o_OzS5uSJf1Br8H9gLQ66NjfwluM"} // {"count": 0}
     */
    public static String tagUsersGet(String accessToken, Integer id, String nextOpenid) {
        assert accessToken != null;
        if (nextOpenid == null) nextOpenid = "";
        String tagStr = String.format("{\"tagid\": %s, \"next_openid\":\"%s\"}", id, nextOpenid);
        String url = String.format("https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=%s", accessToken);
        return post(url, tagStr);
    }

    /**
     * 批量为用户打标签, 标签功能目前支持公众号为用户打上最多20个标签。
     * @param accessToken
     * @param id 标签id
     * @param openids 每次传入的openid列表个数不能超过50个
     * @return
     */
    public static String tagUsers(String accessToken, Integer id, List<String> openids) {
        assert accessToken != null && id != null;
        assert openids != null && openids.size() > 0;

        JsonObject json = new JsonObject();
        json.addProperty("tagid", id);
        json.add("openid_list", new Gson().toJsonTree(openids).getAsJsonArray());

        String url = String.format("https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=%s", accessToken);

        return post(url, json.toString());
    }

    /**
     * 批量为用户取消标签
     * @param accessToken
     * @param id  标签id
     * @param openids 每次传入的openid列表个数不能超过50个
     * @return
     */
    public static String unTagUsers(String accessToken, Integer id, List<String> openids) {
        assert accessToken != null && id != null;
        assert openids != null && openids.size() > 0;

        JsonObject json = new JsonObject();
        json.addProperty("tagid", id);
        json.add("openid_list", new Gson().toJsonTree(openids).getAsJsonArray());

        String url = String.format("https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=%s", accessToken);
        return post(url, json.toString());

    }

    /**
     * 获取用户身上的标签列表
     * @param accessToken
     * @param openid
     * @return
     */
    public static String userTags(String accessToken, String openid) {
        assert accessToken != null && openid != null;

        String tagStr = String.format("{\"openid\": \"%s\"}", openid);
        String url = String.format("https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=%s", accessToken);

        return post(url, tagStr);
    }

    /**
     * 获取公众号已创建的标签
     * @param accessToken
     * @return
     *    { "tags":[{
     *     "id":1,
     *     "name":"每天一罐可乐星人",
     *     "count":0 //此标签下粉丝数
     *      }
     *    ] }
     */
    public static String tagsGet(String accessToken) {
        assert accessToken != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/tags/get?access_token=%s", accessToken);
        return get(url);
    }

    /**
     *
     * @param accessToken
     * @param openid
     * @param remark 新的备注名，长度必须小于30字符
     * @return
     */
    public static String remarkUser(String accessToken, String openid, String remark) {
        assert accessToken != null && openid != null && remark != null;

        String url = String.format("https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=%s", accessToken);
        JsonObject json = new JsonObject();
        json.addProperty("openid", openid);
        json.addProperty("remark", remark);

        return post(url, json.toString());
    }

    /**
     * 获取用户基本信息（包括UnionID机制） lang: 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @param accessToken
     * @param openid
     * @return
     */
    public static String userInfo(String accessToken, String openid) {
        assert accessToken != null && openid != null;
        String url = String.format("https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN", accessToken, openid);
        return get(url);
    }

    /**
     * 批量获取用户基本信息 开发者可通过该接口来批量获取用户基本信息。最多支持一次拉取100条。
     * @param accessToken
     * @param openids
     * @return
     */
    public static String userInfoBatchGet(String accessToken, List<String> openids) {
        assert accessToken != null;
        assert openids != null && openids.size() > 0;

        JsonObject json = new JsonObject();
        JsonArray openidArr = new JsonArray();
        openids.stream().forEach(openid -> {
            JsonObject openidJson = new JsonObject();
            openidJson.addProperty("openid", openid);
            openidJson.addProperty("lang", "zh_CN");
            openidArr.add(openidJson);
        });
        json.add("user_list", openidArr);

        String url = String.format("https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=%s", accessToken);
        return post(url, json.toString());
    }

    /**
     * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     * @param accessToken
     * @param nextOpenid
     * @return {
     *     "total":2,
     *     "count":2,
     *     "data":{
     *     "openid":["OPENID1","OPENID2"]},
     *     "next_openid":"NEXT_OPENID"
     * }
     */
    public static String userOpenidList(String accessToken, String nextOpenid) {
        assert accessToken != null;
        if (nextOpenid == null) nextOpenid = "";
        String url = String.format("https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s", accessToken, nextOpenid);
        return get(url);

    }

}
