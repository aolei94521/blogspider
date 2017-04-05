package com.aolei.spider.test;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.CSDNInformationService;
import com.aolei.spider.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class Test{
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String args[]){
       /* CSDNInformationService csdnInformationService = SpringContextUtil.getBean("classpath:mybatis.xml");
        List<InformationEntity> list = csdnInformationService.getAllInformation();
        logger.debug("======================================"+list.size());*/
        //ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:mybatis.xml");
       /* AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:mybatis.xml");
        CSDNInformationService service = (CSDNInformationService)applicationContext.getBean("CSDNInformationService");*/
        CSDNInformationService service = SpringContextUtil.getBean("CSDNInformationService");
        if (service != null){
            logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
        List<InformationEntity> list = service.getAllInformation(1);
        InformationEntity entity = new InformationEntity();
        entity.setUrl("ssssssssssssss");
        entity.setTime(new Date());
        entity.setPereview("sdfsdf");
        entity.setRecomment("dssfsd");
        entity.setTitle("sdfsdf");
        entity.setReadcount("sfdsdf");
        service.addCSDNInformation(entity);
        logger.debug("==============================================="+list.toString());
    }
}