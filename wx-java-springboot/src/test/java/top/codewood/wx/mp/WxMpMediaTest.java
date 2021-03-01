package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.util.http.AppHttpClient;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.mp.api.WxMpMediaApi;
import top.codewood.wx.util.Strings;

import java.io.*;

public class WxMpMediaTest {

    String accessToken = "";

    String mediaId = "";


    //@Test
    public void mediaUploadTest() throws IOException {
        InputStream is = AppHttpClient.getInstance().getStream("http://img1.codewood.top/developer/images/code-logo-large.png");
        WxMpMediaApi.upload(accessToken, WxConstants.MediaType.IMAGE, WxConstants.MediaFileType.IMAGE_JPG, is);

    }

    //@Test
    public void mediaGetTest() throws IOException {
        InputStream inputStream = WxMpMediaApi.get(accessToken, mediaId);
        File file = new File(String.format("/tmp/files/%s.jpg", Strings.randomString(16)));
        FileUtils.copy(inputStream, new FileOutputStream(file));
    }

}
