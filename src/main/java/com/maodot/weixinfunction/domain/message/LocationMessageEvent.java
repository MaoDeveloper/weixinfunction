package com.maodot.weixinfunction.domain.message;

import org.springframework.context.ApplicationEvent;

/**
 * 处理地理位置消息
 * @author maodot
 */
public class LocationMessageEvent extends ApplicationEvent {

    private String toUserName;
    private String fromUserName;
    private long createTime;
    private String msgType;
    private double locationX;
    private double locationY;
    private int scale;
    private String label;
    private long msgId;

    public LocationMessageEvent(Object source, String toUserName, String fromUserName, long createTime, String msgType, double locationX, double locationY, int scale, String label, long msgId) {
        super(source);
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.locationX = locationX;
        this.locationY = locationY;
        this.scale = scale;
        this.label = label;
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

    public double getLocationX() {
        return locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public int getScale() {
        return scale;
    }

    public String getLabel() {
        return label;
    }

    public long getMsgId() {
        return msgId;
    }
}
