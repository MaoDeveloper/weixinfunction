package com.maodot.weixinfunction.domain.newcustomerservice;

import com.maodot.weixinfunction.infrastructure.WeixinInterface;
import com.maodot.weixinfunction.infrastructure.http.WeiXinHttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理客服添加
 * @author maodot
 */
@Component
public class KeFuAddListener implements ApplicationListener<KeFuAddEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeiXinHttpService weiXinHttpService;

    @Override
    public void onApplicationEvent(KeFuAddEvent event) {
        Map<String,Object> params = new HashMap<>(3);
        params.put("kf_account" , event.getAccount());
        params.put("nickname" , event.getNickname());
        params.put("password" , event.getPassword());
        String result = weiXinHttpService.sendPost(WeixinInterface.KF_ACCOUNT_ADD, params);
        logger.info("添加客服结果：{}" , result);
        // TODO somthing?
    }
}
