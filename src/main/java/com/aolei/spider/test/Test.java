package com.aolei.spider.test;

import com.aolei.spider.service.CSDNIfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/3/29.
 */
public class Test{
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String args[]){
        /*CSDNIfService cSDNIfService = SpringContextHolder.getBean(CSDNIfService.class);
        if (cSDNIfService != null){
            List<InformationEntity> list =  cSDNIfService.getAllInformation();
            if (list!= null && !list.isEmpty()){
                System.out.println("test");
            }
        }*/
        /*AbstractApplicationContext app = new ClassPathXmlApplicationContext(new String[]{"classpath:\\spring-mvc.xml"});
        CSDNInformationService csdnInformationService = (CSDNInformationService)app.getBean("CSDNInformationServiceImpl.class");
        if (csdnInformationService.getAllInformation() == null || csdnInformationService.getAllInformation().isEmpty()){
            System.out.println("sss");
        }
        app.close();*/
        CSDNIfService service = new CSDNIfService();
        logger.debug(service.getAllInformation().size()+"================================");
    }
}