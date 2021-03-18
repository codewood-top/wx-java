package top.codewood.wx.mp;

import top.codewood.util.http.WxHttpClient;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.service.WxMpMediaApi;
import top.codewood.wx.mp.bean.media.WxMediaUploadImgResult;
import top.codewood.wx.mp.bean.media.WxMediaUploadResult;
import top.codewood.wx.util.Strings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class WxMpMediaTest {

    String accessToken = "";

    String mediaId = "";

    //@Test
    public void mediaUploadTest() throws IOException {
        InputStream is = WxHttpClient.getInstance().getInputStream("http://img1.codewood.top/developer/images/code-logo-large.png");
        File file = FileUtils.createTmpFile(is, UUID.randomUUID().toString(), WxConstants.MediaFileType.IMAGE_JPG);
        WxMediaUploadResult wxMediaUploadResult = WxMpMediaApi.getInstance().upload(accessToken, WxConstants.MediaType.IMAGE, file);
        System.out.println(wxMediaUploadResult);
    }

    //@Test
    public void mediaGetTest() throws IOException {
        InputStream inputStream = WxMpMediaApi.getInstance().get(accessToken, mediaId);
        File file = new File(String.format("/tmp/files/%s.jpg", Strings.randomString(16)));
        System.out.println(file.getAbsolutePath());
        FileUtils.copy(inputStream, new FileOutputStream(file));
    }

    //@Test
    public void medieUploadImgTest() throws IOException {
        InputStream is = WxHttpClient.getInstance().getInputStream("http://img1.codewood.top/developer/images/code-logo-large.png");
        WxMediaUploadImgResult result = WxMpMediaApi.getInstance().uploadImg(accessToken, FileUtils.createTmpFile(is, UUID.randomUUID().toString(), WxConstants.MediaFileType.IMAGE_JPG));
        System.out.println(result.getUrl());
    }

}
