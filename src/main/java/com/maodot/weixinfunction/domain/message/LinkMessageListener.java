package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationListener;

/**
 * 处理链接消息
 * @author maodot
 */
public class LinkMessageListener implements ApplicationListener<LinkMessageEvent> {
    @Override
    public void onApplicationEvent(LinkMessageEvent event) {

    }
}
