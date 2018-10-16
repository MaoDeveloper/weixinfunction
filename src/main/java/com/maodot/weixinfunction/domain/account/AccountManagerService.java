package com.maodot.weixinfunction.domain.account;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maodot.weixinfunction.infrastructure.WeixinInterface;
import com.maodot.weixinfunction.infrastructure.http.WeiXinHttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户管理
 * @author maodot
 */
@Service
public class AccountManagerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeiXinHttpService weiXinHttpService;

    public static final String LANG_DEFAULT = "zh_CN";

    // 获取用户信息 openId 方式
    public UserInfo getUserInfo(String openId , String lang){
        if (lang == null || lang.isEmpty()){
            lang = LANG_DEFAULT;
        }
        Map<String,Object> params = new HashMap<>(3);
        params.put("openid",openId);
        params.put("lang",lang);
        String response = weiXinHttpService.sendGetToWx(WeixinInterface.ACCOUNT_USER_INFO, params);
        JSONObject jsonObject = JSON.parseObject(response);
        //请求成功
        if (jsonObject.containsKey("subscribe")){
            int subscribe = jsonObject.getIntValue("subscribe");
            if (subscribe == 0){
                logger.info("此用户未关注公众号，openID：{}",openId);
            }else{
                UserInfo userInfo = JSON.parseObject(response, UserInfo.class);
                return userInfo;
            }
        }
        if (jsonObject.containsKey("errcode")){
            logger.info("请求用户信息发生错误：{}",jsonObject.get("errmsg"));
        }
        return null;
    }

}
