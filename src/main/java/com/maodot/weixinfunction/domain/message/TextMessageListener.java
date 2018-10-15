package com.maodot.weixinfunction.domain.message;

import com.maodot.weixinfunction.domain.newcustomerservice.KeFuSendTextMessageEvent;
import com.maodot.weixinfunction.infrastructure.WeixinFunctionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 处理文本消息
 * @author maodot
 */
@Component
public class TextMessageListener implements ApplicationListener<TextMessageEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //如果希望将消息转发到客服系统，则需要开发者在响应包中返回MsgType为transfer_customer_service的消息，微信服务器收到响应后会把当次发送的消息转发至客服系统

    @Override
    public void onApplicationEvent(TextMessageEvent event) {
        // 异步回复
        logger.info("接收到文本消息：{}",event.getContent());
        //用客服返回
        KeFuSendTextMessageEvent event1 = new KeFuSendTextMessageEvent(this,event.getFromUserName(),"text",event.getContent());
        WeixinFunctionContext.publish(event1);
    }
}
