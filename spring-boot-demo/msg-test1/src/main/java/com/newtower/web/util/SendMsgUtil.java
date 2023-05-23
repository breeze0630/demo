package com.newtower.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;


/**
 * @author : R1cardo.M.Lu
 * @date : 2021/6/15 16:27
 */

public class SendMsgUtil {




    static final String URL = "https://10.230.196.20:24310/api/ziot/fems/thdTask/createForOther";

    public static String  send() {
        Map<String, Object> param = convertMsg("光伏智能监控摄像头发生入侵", "光伏智能监控系统",
                Arrays.asList("17602525437"));

        System.out.println("参数: " + JSON.toJSONString(param));
        String s = sendMsg(JSON.toJSONString(param), 30000);
        System.out.println("结果: " + s );
        return s;
    }

    private static Map<String, Object> convertMsg(String message, String title, List<String> phoneList) {
        Map<String, Object> param = new HashMap<>();
        List<Map<String, Object>> extraTo = new ArrayList<>();
        for (String phone : phoneList) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("phone", phone);
            userMap.put("name", "刘彪");
            extraTo.add(userMap);
        }
        param.put("extraTo", extraTo);
        param.put("data", message);
        param.put("signName", title);
        return param;
    }

    /**
     * 向指定URL发送请求，参数放在body中
     * @param param 传的参数
     * @param timeout 时间
     * @return
     */
    public static String sendMsg(String param, int timeout) {

        JSONObject js = JSON.parseObject(param);
        JSONArray extraTo = js.getJSONArray("extraTo");
        String params = param;

        String responseInfo = null;
        CloseableHttpClient httpclient = null;
        try {
             httpclient = buildSSLCloseableHttpClient();
            //设置连接属性
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout)
                    .build();

            HttpPost httpPost = new HttpPost(URL);
            httpPost.setConfig(requestConfig);
            // 设置通用的请求属性
            httpPost.setHeader("connection", "Keep-Alive");
            httpPost.setHeader("user-agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Cache-Control","max-age=0");
            //httpPost.setHeader("Host","sou.chinanews.com");
            httpPost.setHeader("Accept","*/*");
            httpPost.setHeader("Accept-Encoding","gzip, deflate, br");
            //参数编码设置
            System.out.println("requestEntity==>" + params);

            StringEntity requestEntity = new StringEntity(params, Charset.forName("UTF-8"));

            httpPost.setEntity(requestEntity);
            CloseableHttpResponse execute = httpclient.execute(httpPost);
            System.out.println("response==>"+execute);

            responseInfo = JSON.toJSONString(execute.getEntity());
        } catch (Exception e) {
            System.out.println("Exception"+e.toString());
        } finally {
            try {
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                System.out.println("IOException"+e.toString());
            }
        }
        return responseInfo;
    }


    /**
     * ============忽略证书
     */
    private static CloseableHttpClient buildSSLCloseableHttpClient()
            throws Exception {
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,
                new TrustStrategy() {
                    // 信任所有
                    @Override
                    public boolean isTrusted(X509Certificate[] chain,
                                             String authType) throws CertificateException {
                        return true;
                    }
                }).build();
        //"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"
        // ALLOW_ALL_HOSTNAME_VERIFIER:这个主机名验证器基本上是关闭主机名验证的,实现的是一个空操作，并且不会抛出javax.net.ssl.SSLException异常。
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslContext, new String[]{"TLSv1.2"}, null,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    private static CloseableHttpClient buildSSLCloseableHttpClient2()
            throws Exception {
        return HttpClients.custom().build();
    }
}
