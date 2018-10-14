package com.maodot.weixinfunction.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

@Service
public class WeixinFunctionContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        WeixinFunctionContext.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> tClass){
        return applicationContext.getBean(tClass);
    }

    public static void publish(ApplicationEvent event){
        WeixinFunctionContext.applicationContext.publishEvent(event);
    }
}
