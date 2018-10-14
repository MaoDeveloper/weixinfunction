package com.maodot.weixinfunction.application;

import com.maodot.weixinfunction.domain.message.TextMessageEvent;
import com.maodot.weixinfunction.infrastructure.WeiXinMessage;
import com.maodot.weixinfunction.infrastructure.WeixinFunctionContext;
import org.springframework.stereotype.Service;

/**
 * 消息分发（分类）
 * @author MAODOT
 */
@Service
public class WeiXinMessageDistributeService {

    /**
     * 处理业务
     * 由于采用事件抛出方式，将直接返回success，回复消息都采用异步回复的方式
     * @return
     * @param weiXinMessage
     */
    public Object businessHandle(WeiXinMessage weiXinMessage){
        if (weiXinMessage == null) {
            return "success";
        }
        // 消息管理 - 接收普通消息 -
        if (weiXinMessage.msgType.equals("text")){
            TextMessageEvent event = new TextMessageEvent(this, weiXinMessage.toUserName, weiXinMessage.fromUserName, weiXinMessage.createTime, weiXinMessage.msgType, weiXinMessage.content, weiXinMessage.msgId);
            WeixinFunctionContext.publish(event);
        }else if (weiXinMessage.msgType.equals("image")){

        }else if (weiXinMessage.msgType.equals("voice")){

        }else if (weiXinMessage.msgType.equals("shortvideo")){

        }else if (weiXinMessage.msgType.equals("location")){

        }else if (weiXinMessage.msgType.equals("link")){

        }else if (weiXinMessage.msgType.equals("voice")){

        // 接收事件推送
        }else if (weiXinMessage.msgType.equals("event")){
            // 订阅
            if (weiXinMessage.event.equals("subscribe")){

                // 普通订阅
                if (weiXinMessage.eventKey == null){

                }
                // 扫描带参数二维码事件 - 1. 用户未关注时，进行关注后的事件推送
                if (weiXinMessage.eventKey.startsWith("qrscene_")){

                }

            }
            // 扫描带参数二维码事件 - 2. 用户已关注时的事件推送
            if (weiXinMessage.event.equals("SCAN")){

            }
            // 取消订阅
            if (weiXinMessage.event.equals("unsubscribe")){

            }
            // 上报地理位置事件
            if (weiXinMessage.event.equals("LOCATION")){

            }
            //自定义菜单事件 - 点击菜单拉取消息时的事件推送
            if (weiXinMessage.event.equals("CLICK")){

            }
            //自定义菜单事件 - 点击菜单跳转链接时的事件推送
            if (weiXinMessage.event.equals("VIEW")){

            }
        }else if (weiXinMessage.msgType.equals("voice")){

        }else if (weiXinMessage.msgType.equals("voice")){

        }else if (weiXinMessage.msgType.equals("voice")){

        }else if (weiXinMessage.msgType.equals("voice")){

        }

        return "success";
    }

}
