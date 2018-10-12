package com.maodot.weixinfunction.controller;

import com.maodot.weixinfunction.infrastructure.WeiXinMessageTemplate;
import com.maodot.weixinfunction.infrastructure.WeixinXmlParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * main 函数
 * 用于测试
 * @author MAODOT
 */
public class MainTest {

    public static void main(String[] args) {
        File file = new File("E:\\workspace\\temp.xml");

        System.out.println(file.exists());
        System.out.println(file.isFile());

        try {
            InputStream inputStream = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String xmlString = "<xml>\n" +
                "<ToUserName><![CDATA[公众号]]></ToUserName>\n" +
                " <FromUserName><![CDATA[粉丝号]]></FromUserName>\n" +
                " <CreateTime>1460537339</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[欢迎开启公众号开发者模式]]></Content>\n" +
                " <PicUrl><![CDATA[http://mmbiz.qpic.cn/xxxxxx/0]]></PicUrl>\n" +
                " <MsgId>6272960105994287618</MsgId>\n" +
                " <MediaId><![CDATA[gyci5a-xxxxx-OL]]></MediaId>" +
                " </xml>";
        WeiXinMessageTemplate messageTemplate = WeixinXmlParser.parse(xmlString);

        System.out.println(messageTemplate.msgType);

    }

}
