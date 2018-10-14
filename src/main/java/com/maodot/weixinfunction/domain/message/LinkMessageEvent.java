package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationEvent;

/**
 * 链接消息
 * @author maodot
 */
public class LinkMessageEvent extends ApplicationEvent {

    private String toUserName;
    private String fromUserName;
    private long createTime;
    private String msgType;
    private String title;
    private String description;
    private String url;
    private long msgId;

    public LinkMessageEvent(Object source, String toUserName, String fromUserName, long createTime, String msgType, String title, String description, String url, long msgId) {
        super(source);
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.title = title;
        this.description = description;
        this.url = url;
        this.msgId = msgId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public long getMsgId() {
        return msgId;
    }
}
