package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationListener;

/**
 * 处理小视频消息
 * @author maodot
 */
public class ShortVideoMessageListener implements ApplicationListener<ShortvideoMessageEvent> {
    @Override
    public void onApplicationEvent(ShortvideoMessageEvent event) {

    }
}
