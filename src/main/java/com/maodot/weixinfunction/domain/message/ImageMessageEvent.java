package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationEvent;

/**
 * 图片消息事件
 * @author
 */
public class ImageMessageEvent extends ApplicationEvent {

    private String toUserName;
    private String fromUserName;
    private long createTime;
    private String msgType;
    private String picUrl;
    private String mediaId;
    private Long msgId;

    public ImageMessageEvent(Object source, String toUserName, String fromUserName, long createTime, String msgType, String picUrl, String mediaId, Long msgId) {
        super(source);
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.picUrl = picUrl;
        this.mediaId = mediaId;
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

    public String getPicUrl() {
        return picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public Long getMsgId() {
        return msgId;
    }
}
