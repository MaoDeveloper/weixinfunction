package com.maodot.weixinfunction.domain.model;

import java.io.Serializable;

/**
 * 接收的文本消息模板
 * @author MAODOT
 */
public class TextMessageTemplate implements Serializable {

    public static final String TYPE = "text";

    private String toUserName;
    private String fromUserName;
    private Long createTime;
    private String msgType;
    private String content;
    private String msgId;

    public TextMessageTemplate() {
    }

    public TextMessageTemplate(String toUserName, String fromUserName, Long createTime, String msgType, String content, String msgId) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.content = content;
        this.msgId = msgId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

}
