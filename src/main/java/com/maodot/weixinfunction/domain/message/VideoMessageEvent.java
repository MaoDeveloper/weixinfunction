package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationEvent;

/**
 * 视频消息事件
 * @author maodot
 */
public class VideoMessageEvent extends ApplicationEvent {

    private String toUserName;
    private String fromUserName;
    private long createTime;
    private String msgType;
    private String mediaId;
    private String thumbMediaId;
    private long msgId;

    public VideoMessageEvent(Object source, String toUserName, String fromUserName, long createTime, String msgType, String mediaId, String thumbMediaId, long msgId) {
        super(source);
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.mediaId = mediaId;
        this.thumbMediaId = thumbMediaId;
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

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public long getMsgId() {
        return msgId;
    }
}
