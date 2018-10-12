package com.maodot.weixinfunction.domain;

import com.maodot.weixinfunction.domain.model.TextMessageTemplate;
import com.maodot.weixinfunction.domain.reply.ResponseToUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 接收文本消息之后的服务
 * @author MAODOT
 */
@Service
public class TextService {

    @Autowired
    private ResponseToUserService responseToUserService;

    public Object execute(TextMessageTemplate template) {
        // TEST
        String user = template.getFromUserName();
        String server = template.getToUserName();
        String content = "hello bitch";
        String sendText = responseToUserService.sendText(user, server, content);
        return sendText;
    }
}
