package com.maodot.weixinfunction.infrastructure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maodot.weixinfunction.infrastructure.http.WeiXinHttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于获取 access_token
 * @author MAODOT
 */
@Service
public class AccessTokenService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String GRANT_TYPE = "client_credential";

    private static final String ACCESS_TOKEN = "access_token";

    private static final String EXPIRES_IN = "expires_in";

    private static final String ERR_CODE = "errcode";

    private static final String ERR_MSG = "errmsg";

    private static final AccessToken TOKEN_CACHE = new AccessToken(null,0L);

    @Value("${weixin.gz.appid}")
    private String appId;

    @Value("${weixin.gz.appsecret}")
    private String appSecret;

    @Autowired
    private WeiXinHttpService weiXinHttpService;

    /**
     * 获取可用的 access_token
     * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
     * @return
     */
    public synchronized String getAccessToken(){

        //redis 中是否存在access_token , 暂时用缓存代替
        if (!TOKEN_CACHE.isExpired()){
            return TOKEN_CACHE.getAccessToken();
        }
        String responseString = requestAccessToken();
        logger.info("获取的access_token：{}" , responseString);

        if (responseString != null) {
            JSONObject jsonObject = JSON.parseObject(responseString);
            if (jsonObject.containsKey(ACCESS_TOKEN)){
                long expiresIn = jsonObject.getLongValue(EXPIRES_IN);
                String accessToken = jsonObject.getString(ACCESS_TOKEN);
                TOKEN_CACHE.reset(accessToken,expiresIn);
            }else {
                int code = jsonObject.getInteger(ERR_CODE);
                String msg = jsonObject.getString(ERR_MSG);
                logger.error("请求access_token时发生【{} ， {}】的错误",code , msg);
            }
        }
        return TOKEN_CACHE.getAccessToken();
    }

    private String requestAccessToken() {
        Map<String,Object> params = new HashMap<>();
        params.put("grant_type" , GRANT_TYPE);
        params.put("appid" , appId);
        params.put("secret" , appSecret);
        // http 请求 access_token
        return weiXinHttpService.sendGet(WeixinInterface.ACCESS_TOKEN, params);
    }

    private static class AccessToken{
        /**
         * access_token
         */
        private String accessToken;
        /**
         * 时间戳：过期时间
         */
        private Long expiresTime;

        AccessToken(String accessToken , long expiresIn){
            this.reset(accessToken,expiresIn);
        }

        /**
         * 是否过期
         * @return true 过期 ，false 没过期
         */
        public boolean isExpired(){
            long now = System.currentTimeMillis()/1000;
            if (now > this.expiresTime){
                return true;
            }
            return false;
        }

        public String getAccessToken(){
            return this.accessToken;
        }

        public void reset(String accessToken , long expiresIn){
            this.accessToken = accessToken;
            long now = System.currentTimeMillis()/1000;
            this.expiresTime = now + expiresIn;
        }

    }

}
