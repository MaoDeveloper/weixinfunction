package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 处理语音消息
 * @author maodot
 */
@Component
public class VoiceMessageListener implements ApplicationListener<VoiceMessageEvent> {
    @Override
    public void onApplicationEvent(VoiceMessageEvent event) {

    }
}
