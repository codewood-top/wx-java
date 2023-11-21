package top.codewood.wx.pay.v3.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WxPayHttpClient {


    public static final String CHARSET = "UTF-8";
    public static final String USER_AGENT = "codewood.top/wx-java" +
            " (" + System.getProperty("os.arch") + " " + System.getProperty("os.name") + " " + System.getProperty("os.version") +
            ") Java/" + System.getProperty("java.version") + " HttpClient/" + HttpClient.class.getPackage().getImplementationVersion();

    private final int connectTimeoutMs = 5 * 1000;
    private final int readTimeoutMs = 5 * 1000;

    private HttpResponse request(String url, String method, String data, String token) throws IOException {
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
        if (WxPayConstants.HttpMethod.GET.equals(method)) {
            httpRequest = new HttpGet(url);
        } else {
            httpRequest = new HttpPost(url);
            StringEntity postEntity = new StringEntity(data, CHARSET);
            ((HttpPost)httpRequest).setEntity(postEntity);
        }

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeoutMs)
                .setSocketTimeout(readTimeoutMs)
                .build();
        httpRequest.setConfig(requestConfig);

        httpRequest.addHeader("Content-Type", "application/json");
        httpRequest.addHeader("Accept", "application/json");
        if (token != null) {
            httpRequest.addHeader("Authorization", token);
        }
        return httpClient.execute(httpRequest);
    }

    public String get(String url, String token) throws IOException {
        HttpResponse httpResponse = request(url, WxPayConstants.HttpMethod.GET, null, token);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHARSET);
    }

    public HttpResponse getWithResponse(String url, String token) throws IOException {
        return request(url, WxPayConstants.HttpMethod.GET, null, token);
    }

    public String post(String url, String data, String token) throws IOException {
        HttpResponse httpResponse = request(url, WxPayConstants.HttpMethod.POST, data, token);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHARSET);
    }

    public HttpResponse postWithResponse(String url, String data, String token) throws IOException {
        return request(url, WxPayConstants.HttpMethod.POST, data, token);
    }

    private static class Holder {
        private static final WxPayHttpClient INSTANCE = new WxPayHttpClient();
    }

    public static final WxPayHttpClient getInstance() {
        return Holder.INSTANCE;
    }

}