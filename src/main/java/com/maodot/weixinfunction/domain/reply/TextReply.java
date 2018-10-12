package com.maodot.weixinfunction.domain.reply;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {})
@XmlRootElement(name = "xml")
@XmlAccessorType(value = XmlAccessType.PUBLIC_MEMBER)
@XmlAccessorOrder(value = XmlAccessOrder.UNDEFINED)
public class TextReply {

    @XmlElement(name = "ToUserName")
    public String toUserName;

    @XmlElement(name = "FromUserName")
    public String fromUserName;

    @XmlElement(name = "CreateTime")
    public Long createTime;

    @XmlElement(name = "MsgType")
    public String msgType;

    @XmlElement(name = "Content")
    public String content;

}
