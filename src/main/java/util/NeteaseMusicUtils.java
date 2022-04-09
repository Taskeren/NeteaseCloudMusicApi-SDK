package util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * @author JackuXL
 */
public class NeteaseMusicUtils {
    public static String domain;

    /**
     * 设置主域名
     * 添加在请求地址前
     *
     * @param domain 主域名（格式：http(s)://example.com）
     */
    public static void setApiDomain(String domain) {
        NeteaseMusicUtils.domain = domain;
    }

    /**
     * GET请求
     *
     * @param url    地址（删除主域名）
     * @param cookie Cookie（可为Null）
     * @return 请求结果
     */
    public static String sendByGetUrl(String url, String cookie) {
        if (cookie == null) {
            cookie = "";
        }
        String urlWithDomain = NeteaseMusicUtils.domain + url;
        String result;
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request;
        request = new Request.Builder()
                .addHeader("Cookie", cookie)
                .url(urlWithDomain)
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            result = Objects.requireNonNull(response.body(), "Receive empty body when requesting "+urlWithDomain).string();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}