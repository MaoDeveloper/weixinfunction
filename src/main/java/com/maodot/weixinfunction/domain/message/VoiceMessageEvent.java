package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationEvent;

/**
 * 语音消息事件
 * attention ：未开通语音识别情况下
 * @author madoot
 */
public class VoiceMessageEvent extends ApplicationEvent {

    private String toUserName;
    private String fromUserName;
    private long createTime;
    private String msgType;
    private String mediaId;
    private String format;
    private String msgId;

    public VoiceMessageEvent(Object source, String toUserName, String fromUserName, long createTime, String msgType, String mediaId, String format, String msgId) {
        super(source);
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.mediaId = mediaId;
        this.format = format;
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

    public String getMediaId() {
        return mediaId;
    }

    public String getFormat() {
        return format;
    }

    public String getMsgId() {
        return msgId;
    }
}
