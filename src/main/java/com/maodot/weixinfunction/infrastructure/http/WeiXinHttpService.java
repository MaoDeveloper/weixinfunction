package com.maodot.weixinfunction.infrastructure.http;

import com.alibaba.fastjson.JSON;
import com.maodot.weixinfunction.infrastructure.AccessTokenService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 用于基本的http请求
 * @author maodot
 */
@Service
public class WeiXinHttpService {

    @Autowired
    private AccessTokenService accessTokenService;

    public String sendGetToWx(String url , Map<String,Object> params){
        String accessToken = accessTokenService.getAccessToken();
        params.put("access_token",accessToken);
        return this.sendGet(url , params);
    }

    public String sendPostToWx(String url , Map<String,Object> params){
        String accessToken = accessTokenService.getAccessToken();
        return this.sendPost(url+"?access_token="+accessToken , params);
    }

    /**
     * 发送 get 请求
     * @param url
     * @param params
     * @return
     */
    public String sendGet(String url , Map<String,Object> params){
        Set<String> keys = params.keySet();
        StringBuilder uri = new StringBuilder(url);
        uri.append("?");
        keys.forEach(key -> {
            uri.append(key).append("=").append(params.get(key)).append("&");
        });
        HttpGet httpGet = new HttpGet(uri.toString());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK){
                HttpEntity responseEntity = response.getEntity();
                return EntityUtils.toString(responseEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送 Post Raw 请求
     * @param url
     * @param params
     * @return
     */
    public String sendPost(String url , Map<String,Object> params){
        String jsonString = JSON.toJSONString(params);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("cache-control","no-cache");
        StringEntity stringEntity = new StringEntity( jsonString ,"utf-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
