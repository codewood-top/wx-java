package top.codewood.wx.mp;

import org.junit.Test;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.util.file.FileUtils;
import top.codewood.wx.mp.api.WxMpMediaApi;
import top.codewood.wx.util.Strings;

import java.io.*;

public class MpMediaTest {

    String accessToken = "42_usRYd3vd0aUji3foOQHz4zXwsX4F4jn1uB1qZg-5EafxzGsyqIYrp0HHz7xY9LvcbSXoHb0QwlLcgP0d6eL1havqcoVrlaQEv3kYcTe4p97KPoVWs6KIzm29K0NiRjC2LKvEWvp2cP3waOj3FKMeACAPUW";

    String mediaId = "-oYikNVIUUkLrwQLIW3hTNIUVBl9hs0lohhtREeuRBqXfGM1VbdN-cQVb3vKq18e";

    @Test
    public void mediaUploadTest() throws IOException {
        File file = new File("C:\\Users\\ASUS1\\Pictures\\arbos_001.jpg");
        String respStr = WxMpMediaApi.upload(accessToken, WxConstants.MediaType.IMAGE, WxConstants.MediaFileType.IMAGE_JPG, new FileInputStream(file));
        System.out.println(respStr);
    }

    @Test
    public void mediaGetTest() throws IOException {
        InputStream inputStream = WxMpMediaApi.get(accessToken, mediaId);
        File file = new File(String.format("\\tmp\\files\\%s.jpg", Strings.randomString(16)));
        FileUtils.copy(inputStream, new FileOutputStream(file));
    }

}
