package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 处理视频消息
 * @author maodot
 */
@Component
public class VideoMessageListener implements ApplicationListener<VideoMessageEvent> {
    @Override
    public void onApplicationEvent(VideoMessageEvent event) {

    }
}
