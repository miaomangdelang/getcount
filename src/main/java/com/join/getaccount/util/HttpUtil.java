package com.join.getaccount.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * 描述
 *
 * @Author: huangtt(bleuhtt @ 163.com)
 * @CreateDate: 2018/6/14 上午10:26
 * @Version: 1.0
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 默认的连接设置
     */
    private static RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(60000) // 从服务器获取响应数据需要等待的时间
            .setConnectTimeout(10000) // 设置等待连接超时时间
            .setConnectionRequestTimeout(10000) // 设置从连接池获取连接超时时间
            .build();

    /**
     * 获取HttpClient对象
     *
     * @return
     */
    private static HttpClient getClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        return client;
    }

    /**
     * 发送PUT请求
     *
     * @param uri
     * @param form
     * @return
     * @throws IOException
     */
    public static String sendPut(String uri, Object form) throws IOException {
        HttpPut put = new HttpPut(uri);
        put.setConfig(defaultRequestConfig);
        put.setEntity(getEntity(form));
        HttpResponse response = getClient().execute(put);
        logger.info(response.getStatusLine().toString());
        String respStr = EntityUtils.toString(response.getEntity());
        logger.info("Response content: " + respStr);
        return respStr;
    }

    /**
     * 发送POST请求
     *
     * @param uri
     * @param form
     * @return
     */
    public static String sendPost(String uri, Object form) throws IOException {
        HttpPost post = new HttpPost(uri);
        post.setConfig(defaultRequestConfig);
        post.setEntity(getEntity(form));

        HttpResponse response = getClient().execute(post);
        logger.info(response.getStatusLine().toString());
        String respStr = EntityUtils.toString(response.getEntity());
        logger.info("Response content: " + respStr);

        return respStr;
    }

    /**
     * 发送GET请求
     *
     * @param uri
     * @param parametersMap
     * @return
     */
    public static String sendGet(String uri, Map<String, String> parametersMap,Map<String,String> headerMap) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder(uri);
        if (parametersMap != null) {
            for (Map.Entry entry : parametersMap.entrySet()) {
                uriBuilder.addParameter(String.valueOf(entry.getKey()), (String) entry.getValue());
            }
        }
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Content-type", ContentType.APPLICATION_JSON.toString());
        for (Map.Entry<String,String> entry : headerMap.entrySet()) {
            httpGet.setHeader(entry.getKey(),entry.getValue());
        }
        httpGet.setConfig(defaultRequestConfig);

        HttpResponse response = getClient().execute(httpGet);
        logger.info(response.getStatusLine().toString());
        String respStr = EntityUtils.toString(response.getEntity());
//        logger.info("Response content: " + respStr);
        return respStr;
    }


    /**
     * 获取请求体
     *
     * @param object
     * @return
     */
    public static HttpEntity getEntity(Object object) {
        String reqStr = JSONObject.toJSONString(object);
        return EntityBuilder.create().setText(reqStr).setContentType(ContentType.APPLICATION_JSON).build();
    }

}
