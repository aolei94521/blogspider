package com.aolei.spider.test;

import com.aolei.spider.service.CSDNInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/29.
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String args[]){
        /*CSDNInformationService csdnInformationService = SpringContextHolder.getBean(CSDNInformationService.class);
        if (csdnInformationService != null){
            List<InformationEntity> list =  csdnInformationService.getAllInformation();
            if (list!= null && !list.isEmpty()){
                System.out.println("test");
            }
        }*/
        AbstractApplicationContext app = new ClassPathXmlApplicationContext(new String[]{"classpath:\\spring-mvc.xml"});
        CSDNInformationService csdnInformationService = (CSDNInformationService)app.getBean("CSDNInformationServiceImpl.class");
        if (csdnInformationService.getAllInformation() == null || csdnInformationService.getAllInformation().isEmpty()){
            System.out.println("sss");
        }
        app.close();
    }
}