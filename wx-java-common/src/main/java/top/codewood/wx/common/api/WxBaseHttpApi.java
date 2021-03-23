package top.codewood.wx.common.api;

import org.apache.http.NameValuePair;
import top.codewood.util.http.WxHttpClient;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.common.util.json.WxGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WxBaseHttpApi {

    protected static String get(String url) {
        try {
            String respStr = WxHttpClient.getInstance().get(url);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String post(String url, String postData) {
        try {
            String respStr = WxHttpClient.getInstance().post(url, postData);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String post(String url, List<? extends NameValuePair> parameters) {
        try {
            String respStr = WxHttpClient.getInstance().post(url, parameters);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String upload(String url, File file) {
        try {
            String respStr = WxHttpClient.getInstance().upload(url, file);
            return handleResponse(respStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static InputStream getInputStream(String url) {
        try {
            return WxHttpClient.getInstance().getInputStream(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String handleResponse(String resp) {
        WxError wxError = WxGsonBuilder.create().fromJson(resp, WxError.class);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
        return resp;
    }

}
