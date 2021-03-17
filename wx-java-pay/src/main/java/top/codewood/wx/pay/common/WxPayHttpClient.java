package top.codewood.wx.pay.common;

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
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;

public class WxPayHttpClient {

    public static final String CHARSET = "UTF-8";

    public static final String USER_AGENT = "codewood.top/wx-java" +
            " (" + System.getProperty("os.arch") + " " + System.getProperty("os.name") + " " + System.getProperty("os.version") +
            ") Java/" + System.getProperty("java.version") + " HttpClient/" + HttpClient.class.getPackage().getImplementationVersion();

    private WxPayConfig wxPayConfig;

    private int connectTimeoutMs = 5 * 1000;
    private int readTimeoutMs = 5 * 1000;

    public WxPayHttpClient() {}

    public WxPayHttpClient(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
        this.connectTimeoutMs = wxPayConfig.getConnectTimeoutMs();
        this.readTimeoutMs = wxPayConfig.getReadTimeoutMs();
    }

    private String request(final String url, String data, boolean useCert) throws Exception {

        if (wxPayConfig == null) throw new RuntimeException("wxPayConfig 未配置!");

        BasicHttpClientConnectionManager connManager;
        if (useCert) {
            char[] password = wxPayConfig.getMchid().toCharArray();
            InputStream certStream = wxPayConfig.getCertStream();
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(certStream, password);

            // 实例化密钥库 & 初始化密钥工厂
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, password);

            // 创建 SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                    sslContext,
                    new String[]{"TLSv1"},
                    null,
                    new DefaultHostnameVerifier());
            connManager = new BasicHttpClientConnectionManager(
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", sslConnectionSocketFactory)
                            .build(),
                    null,
                    null,
                    null
            );

        } else {
            connManager = new BasicHttpClientConnectionManager(
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", SSLConnectionSocketFactory.getSocketFactory())
                            .build(),
                    null,
                    null,
                    null
            );
        }

        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .build();
        HttpPost httpPost = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeoutMs)
                .setSocketTimeout(readTimeoutMs)
                .build();
        httpPost.setConfig(requestConfig);

        StringEntity postEntity = new StringEntity(data, CHARSET);
        httpPost.setEntity(postEntity);

        httpPost.addHeader("Content-Type", "text/html");
        httpPost.addHeader("User-Agent", USER_AGENT + " " + wxPayConfig.getMchid());


        HttpResponse httpResponse = httpClient.execute(httpPost);

        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHARSET);
    }

    public String requestWithoutCert(String url, String data) throws Exception {
        return this.request(url, data, false);
    }

    public String requestWithCert(String url, String data) throws Exception {
        return this.request(url, data, true);
    }

    private HttpResponse v3Request(String url, String method, String data, String token) throws IOException {
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

    public String v3Get(String url, String token) throws IOException {
        HttpResponse httpResponse = v3Request(url, WxPayConstants.HttpMethod.GET, null, token);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHARSET);
    }

    public HttpResponse v3GetWithResponse(String url, String token) throws IOException {
        return v3Request(url, WxPayConstants.HttpMethod.GET, null, token);
    }

    public String v3Post(String url, String data, String token) throws IOException {
        HttpResponse httpResponse = v3Request(url, WxPayConstants.HttpMethod.POST, data, token);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, CHARSET);
    }

    public HttpResponse v3PostWithResponse(String url, String data, String token) throws IOException {
        return v3Request(url, WxPayConstants.HttpMethod.POST, data, token);
    }

}