package com.maodot.weixinfunction.domain.model;

import java.io.Serializable;

/**
 * 接收的图片消息模板
 * @author MAODOT
 */
public class ImageMessageTemplate implements Serializable {

    public static final String TYPE = "image";

    private String toUserName;
    private String fromUserName;
    private Long createTime;
    private String msgType;
    private String picUrl;
    private String msgId;
    private String mediaId;

    public ImageMessageTemplate() {
    }

    public ImageMessageTemplate(String toUserName, String fromUserName, Long createTime, String msgType, String picUrl, String msgId, String mediaId) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.picUrl = picUrl;
        this.msgId = msgId;
        this.mediaId = mediaId;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
