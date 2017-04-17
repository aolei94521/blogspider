package com.aolei.spider.util;

import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/4/4.
 */
@Component
public class SpringContextUtil extends CommonLoggerUtil{
    private static AbstractApplicationContext applicationContext;
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException{
        applicationContext = new ClassPathXmlApplicationContext("classpath:mybatis.xml");

        return (T) applicationContext.getBean(name);
    }
}
