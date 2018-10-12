package com.maodot.weixinfunction.application;

import com.maodot.weixinfunction.domain.ImageService;
import com.maodot.weixinfunction.domain.TextService;
import com.maodot.weixinfunction.domain.VoiceService;
import com.maodot.weixinfunction.domain.model.ImageMessageTemplate;
import com.maodot.weixinfunction.domain.model.TextMessageTemplate;
import com.maodot.weixinfunction.domain.model.VoiceMessageTemplate;
import com.maodot.weixinfunction.infrastructure.WeiXinMessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MAODOT
 */
@Service
public class WeiXinBaseService {

    @Autowired
    private TextService textService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private VoiceService voiceService;

    /**
     * 处理业务
     * @return
     * @param messageTemplate
     */
    public Object businessHandle(WeiXinMessageTemplate messageTemplate){
        if (messageTemplate == null) {
            return "success";
        }

        if (messageTemplate.msgType.equals(TextMessageTemplate.TYPE)){
            TextMessageTemplate template = new TextMessageTemplate(
                    messageTemplate.toUserName,
                    messageTemplate.fromUserName,
                    messageTemplate.createTime,
                    messageTemplate.msgType,
                    messageTemplate.content,
                    messageTemplate.msgId
                    );
            return textService.execute(template);
        }
        if (messageTemplate.msgType.equals(ImageMessageTemplate.TYPE)){
            ImageMessageTemplate template = new ImageMessageTemplate(
                    messageTemplate.toUserName,
                    messageTemplate.fromUserName,
                    messageTemplate.createTime,
                    messageTemplate.msgType,
                    messageTemplate.picUrl,
                    messageTemplate.msgId,
                    messageTemplate.mediaId
                    );
            return imageService.execute(template);
        }
        if (messageTemplate.msgType.equals(VoiceMessageTemplate.TYPE)){
            //return voiceService.execute();
        }

        return "success";
    }

}
