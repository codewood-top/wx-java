package top.codewood.util.http;

import okhttp3.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Map;

public class AppHttpClient {

    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType MEDIA_FORM_DATA = MediaType.parse("multipart/form-data");

    private OkHttpClient client = new OkHttpClient();

    private static class Holder {
        private static AppHttpClient INSTANCE = new AppHttpClient();
    }

    public static AppHttpClient getInstance() {
        return Holder.INSTANCE;
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String get(String url, Map<String, String> headers) throws IOException {
        Request.Builder requestBuilder = new Request.Builder();

        if (headers != null) {
            headers.entrySet().stream().forEach(kv -> requestBuilder.addHeader(kv.getKey(), kv.getValue()));
        }
        Request request = requestBuilder.url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String post(String url, Map<String, String> params) throws IOException {
        return post(url, params, null);
    }

    public String post(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
        Request.Builder requestBuilder = new Request.Builder();

        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (params != null) {
            params.entrySet().stream().forEach(kv -> formBodyBuilder.add(kv.getKey(), kv.getValue()));
        }
        requestBuilder.post(formBodyBuilder.build());

        if (headers != null) {
            headers.entrySet().forEach(kv -> requestBuilder.addHeader(kv.getKey(), kv.getValue()));
        }

        Request request = requestBuilder.url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String post(String url, String jsonData) throws IOException {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, jsonData);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String upload(String url, File file) throws IOException {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MEDIA_FORM_DATA)
                .addFormDataPart("media", file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public InputStream getStream(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().byteStream();
    }

    public String sslPost(String url, String jsonData, String filePath, String password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        InputStream instream = this.getClass().getResourceAsStream(filePath);// 加载本地的证书进行https加密传输
        keyStore.load(instream, password.toCharArray());
        instream.close();
        SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory)
                .build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(jsonData, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

}
