package com.maodot.weixinfunction.controller;

import com.maodot.weixinfunction.application.WeiXinMessageDistributeService;
import com.maodot.weixinfunction.domain.AccessTokenService;
import com.maodot.weixinfunction.infrastructure.utils.SHA1;
import com.maodot.weixinfunction.infrastructure.WeiXinMessage;
import com.maodot.weixinfunction.infrastructure.WeixinXmlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 微信基础接入接口
 * @author MAODOT
 */
@RestController
public class WeixinBaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${weixin.gz.token}")
    private String token;

    @Autowired
    private WeiXinMessageDistributeService weiXinMessageDistributeService;

    @Autowired
    private AccessTokenService accessTokenService;

    @RequestMapping(path = "/wx" , method = RequestMethod.GET)
    public String checkServer(
            @RequestParam("signature") String signature ,
            @RequestParam("timestamp") String timestamp ,
            @RequestParam("nonce") String nonce ,
            @RequestParam("echostr") String echostr){
    //public String checkServer(@RequestParam WeixinCheckServerParam params){
        // 验证参数
//        if (!params.checkAllParamHasReceive()){
//            return "";
//        }
        List<String> stringList = new ArrayList<>(3);
        stringList.add(token);
        stringList.add(timestamp);
        stringList.add(nonce);
        // 字典序排序
        Collections.sort(stringList);
        // SHA1加密
        String hashcode = SHA1.encode(stringList.get(0) + stringList.get(1) + stringList.get(2));
        if (hashcode.equals(signature)){
            logger.info("微信服务器验证成功！");
            return echostr;
        }
        logger.info("微信服务器验证失败！");
        return "";
    }

    @RequestMapping(path = "/wx" , method = RequestMethod.POST)
    public Object receive(@RequestParam String xmlString){
        // 解析xml
        WeiXinMessage messageTemplate = WeixinXmlParser.parse(xmlString);
        return weiXinMessageDistributeService.businessHandle(messageTemplate);
    }

    @RequestMapping(path = "/wx/token" , method = RequestMethod.GET)
    public String getAccessToken(){
        return accessTokenService.getAccessToken();
    }

}
