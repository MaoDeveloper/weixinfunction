package com.maodot.weixinfunction.domain.reply;

import com.maodot.weixinfunction.infrastructure.WeixinXmlParser;
import org.springframework.stereotype.Service;

/**
 * @author MAODOT
 */
@Service
public class ResponseToUserService {

    public String sendText(String toUserName , String fromUserName , String content){
        TextReply textReply = new TextReply();
        textReply.toUserName = toUserName;
        textReply.fromUserName = fromUserName;
        textReply.msgType = "text";
        textReply.content = content;
        textReply.createTime = System.currentTimeMillis()/1000;

        return WeixinXmlParser.toXmlString(textReply);
    }

}
