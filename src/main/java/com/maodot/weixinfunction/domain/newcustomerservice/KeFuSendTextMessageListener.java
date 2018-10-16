package com.maodot.weixinfunction.domain.newcustomerservice;

import com.maodot.weixinfunction.domain.account.AccountManagerService;
import com.maodot.weixinfunction.domain.account.UserInfo;
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

    @Autowired
    private AccountManagerService accountManagerService;

    @Override
    public void onApplicationEvent(KeFuSendTextMessageEvent event) {
        String content1 ;

        // 获取用户基本信息
        UserInfo userInfo = accountManagerService.getUserInfo(event.getTouser(), null);
        if (userInfo != null){
            content1 = "你是来自" + userInfo.getCountry() + "的" + userInfo.getNickname() + "，你说的一句：" + event.getContent();
        }else {
            content1 = "你能不能说国语？";
        }

        //拼凑数据
        Map<String ,Object> map = new HashMap<>(3);
        map.put("touser" , event.getTouser());
        map.put("msgtype" , "text");
        Map<String,Object> text = new HashMap<>(1);
        text.put("content",content1);
        map.put("text",text);
        String response = weiXinHttpService.sendPostToWx(WeixinInterface.KF_MESSAGE_SEND, map);
        logger.info("通过客服发送文本消息返回结果：{}",response);
    }
}
