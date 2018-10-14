package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 处理图片消息
 * @author maodot
 */
@Component
public class ImageMessageListener implements ApplicationListener<ImageMessageEvent> {
    @Override
    public void onApplicationEvent(ImageMessageEvent event) {

    }
}
