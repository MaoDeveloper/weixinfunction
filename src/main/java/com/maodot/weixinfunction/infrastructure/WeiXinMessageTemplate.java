package com.maodot.weixinfunction.infrastructure;

import javax.xml.bind.annotation.*;

/**
 * 微信消息模板
 * @author MAODOT
 */
@XmlType(propOrder = {})
@XmlRootElement(name = "xml")
@XmlAccessorType(value = XmlAccessType.PUBLIC_MEMBER)
@XmlAccessorOrder(value = XmlAccessOrder.UNDEFINED)
public class WeiXinMessageTemplate {

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

    @XmlElement(name = "PicUrl")
    public String picUrl;

    @XmlElement(name = "MsgId")
    public String msgId;

    @XmlElement(name = "MediaId")
    public String mediaId;

}
