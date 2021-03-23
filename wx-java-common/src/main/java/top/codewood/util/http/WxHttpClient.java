package top.codewood.util.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import top.codewood.wx.common.bean.error.WxError;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.common.util.json.WxGsonBaseBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WxHttpClient {

    public static final String CHAR_SET_UTF_8 = "UTF-8";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";

    private static class Holder {
        private static WxHttpClient INSTANCE = new WxHttpClient();
    }

    public static WxHttpClient getInstance() {
        return Holder.INSTANCE;
    }

    private int connectTimeoutMs = 5 * 1000;
    private int readTimeoutMs = 5 * 1000;

    private HttpResponse request(final String url, String method, Object data, File file) throws IOException {
        BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.getSocketFactory())
                        .register("https", SSLConnectionSocketFactory.getSocketFactory())
                        .build(),
                null,
                null,
                null
        );

        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .build();

        HttpRequestBase httpRequest;
        if (HTTP_METHOD_GET.equals(method)) {
            httpRequest = new HttpGet(url);
        } else {
            httpRequest = new HttpPost(url);
            if (data != null) {
                if (data instanceof String) {
                    StringEntity postEntity = new StringEntity((String) data, CHAR_SET_UTF_8);
                    ((HttpPost) httpRequest).setEntity(postEntity);
                } else if (data instanceof List) {
                    ((HttpPost) httpRequest).setEntity(new UrlEncodedFormEntity((List<? extends NameValuePair>) data, CHAR_SET_UTF_8));
                }
            }
            if (file != null) {
                HttpEntity entity = MultipartEntityBuilder.create()
                        .addBinaryBody("media", file)
                        .setMode(HttpMultipartMode.RFC6532)
                        .build();
                ((HttpPost) httpRequest).setEntity(entity);
            }
        }

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeoutMs)
                .setSocketTimeout(readTimeoutMs)
                .build();
        httpRequest.setConfig(requestConfig);

        return httpClient.execute(httpRequest);

    }

    public String get(String url) throws IOException {
        HttpResponse httpResponse =  request(url, HTTP_METHOD_GET, null, null);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHAR_SET_UTF_8);
    }

    public String post(String url, String data) throws IOException {
        HttpResponse httpResponse =  request(url, HTTP_METHOD_POST, data, null);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHAR_SET_UTF_8);
    }

    public String post(String url, List<? extends NameValuePair> parameters) throws IOException {
        HttpResponse httpResponse =  request(url, HTTP_METHOD_POST, parameters, null);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHAR_SET_UTF_8);
    }

    public String upload(String url, File file) throws IOException {
        HttpResponse httpResponse =  request(url, HTTP_METHOD_POST, null, file);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHAR_SET_UTF_8);
    }

    public InputStream getInputStream(String url) throws IOException {
        HttpResponse httpResponse = request(url, HTTP_METHOD_GET, null, null);

        Header[] contentTypeHeaders = httpResponse.getHeaders("Content-Type");
        if (contentTypeHeaders != null && contentTypeHeaders.length > 0) {
            if (contentTypeHeaders[0].getValue().startsWith(ContentType.APPLICATION_JSON.getMimeType()) || contentTypeHeaders[0].getValue().startsWith(ContentType.TEXT_PLAIN.getMimeType())) {
                String respContent = EntityUtils.toString(httpResponse.getEntity(), CHAR_SET_UTF_8);
                throw new WxErrorException(WxGsonBaseBuilder.create().fromJson(respContent, WxError.class));
            }
        }
        HttpEntity httpEntity = httpResponse.getEntity();
        return httpEntity.getContent();
    }
}
