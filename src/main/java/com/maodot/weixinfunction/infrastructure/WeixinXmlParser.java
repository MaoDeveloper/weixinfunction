package com.maodot.weixinfunction.infrastructure;

import com.maodot.weixinfunction.infrastructure.utils.JaxbXmlUtil;

/**
 * xml 解释器
 * @author MAODOT
 */
public class WeixinXmlParser {

    public static WeiXinMessage parse(String xmlString){

        try {
            WeiXinMessage messageTemplate = JaxbXmlUtil.convertToJavaBean(xmlString, WeiXinMessage.class);
            return messageTemplate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toXmlString(Object object){
        try {
            String toXml = JaxbXmlUtil.convertToXml(object);
            return toXml;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
