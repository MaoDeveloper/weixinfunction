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
 * 处理 通过客服发送消息
 * @author maodot
 */
@Component
public class KeFuSendTextMessageListener implements ApplicationListener<KeFuSendTextMessageEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeiXinHttpService weiXinHttpService;

    @Override
    public void onApplicationEvent(KeFuSendTextMessageEvent event) {
        //拼凑数据
        Map<String ,Object> map = new HashMap<>(3);
        map.put("touser" , event.getTouser());
        map.put("msgtype" , "text");
        Map<String,Object> text = new HashMap<>(1);
        text.put("content",event.getContent());
        map.put("text",text);
        String response = weiXinHttpService.sendPostToWx(WeixinInterface.KF_MESSAGE_SEND, map);
        logger.info("通过客服发送文本消息返回结果：{}",response);
    }
}
