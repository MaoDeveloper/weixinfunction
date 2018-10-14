package com.maodot.weixinfunction.infrastructure.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 用于基本的http请求
 * @author maodot
 */
@Service
public class HttpService {

    //TODO create HttpParams class
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

}
