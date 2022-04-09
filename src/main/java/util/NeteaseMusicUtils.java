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
     * ����������
     * ����������ַǰ
     *
     * @param domain ����������ʽ��http(s)://example.com��
     */
    public static void setApiDomain(String domain) {
        NeteaseMusicUtils.domain = domain;
    }

    /**
     * GET����
     *
     * @param url    ��ַ��ɾ����������
     * @param cookie Cookie����ΪNull��
     * @return ������
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