package com.join.getaccount.util;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @ClassName HttpClientUtils
 * @Description
 * @Author Administrator
 * @Date 2018/10/16 15:49
 */
public class HttpClientUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
    /**
     * get请求传输数据
     *
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String getetData(String url){
        String result = "";
        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建get方式请求对象
        HttpGet httpGet = new HttpGet(url);
//        httpGet.addHeader("Content-type", "application/json");
//        httpGet.setHeader();
        // 通过请求对象获取响应对象
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            // 获取结果实体
            // 判断网络连接状态码是否正常(0--200都数正常)
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
            // 释放链接
            response.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            logger.error("httpclient链接出错",e);
        } catch (IOException e) {
//            e.printStackTrace();
            logger.error("httpclientIO出错",e);
        }
        return result;
    }


}
