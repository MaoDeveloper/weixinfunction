package com.maodot.weixinfunction.domain.newcustomerservice;

import org.springframework.context.ApplicationEvent;

/**
 * 客服接口 - 发送消息
 * @author maodot
 */
public class KeFuSendTextMessageEvent extends ApplicationEvent {

    /**
     * openId
     */
    private String touser;
    private String msgType;
    private String content;

    public KeFuSendTextMessageEvent(Object source, String touser, String msgType, String content) {
        super(source);
        this.touser = touser;
        this.msgType = msgType;
        this.content = content;
    }

    public String getTouser() {
        return touser;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getContent() {
        return content;
    }
}
