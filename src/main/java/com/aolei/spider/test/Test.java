package com.aolei.spider.test;

import com.aolei.spider.service.UserBlogLikeAndCollectionService;
import com.aolei.spider.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/3/29.
 */

public class Test{
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    /*public static void main(String args[]){
       *//* CSDNInformationService csdnInformationService = SpringContextUtil.getBean("classpath:mybatis.xml");
        List<InformationEntity> list = csdnInformationService.getAllInformation();
        logger.debug("======================================"+list.size());*//*
        //ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:mybatis.xml");
       *//* AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:mybatis.xml");
        CSDNInformationService service = (CSDNInformationService)applicationContext.getBean("CSDNInformationService");*//*
        CSDNInformationService service = SpringContextUtil.getBean("CSDNInformationService");
        if (service != null){
            logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
        List<InformationEntity> list = service.getAllInformation();
        InformationEntity entity = new InformationEntity();
        entity.setUrl("ssssssssssssss");
        entity.setTime(new Date());
        entity.setPereview("sdfsdf");
        entity.setRecomment("dssfsd");
        entity.setTitle("sdfsdf");
        entity.setReadcount("sfdsdf");
        service.addCSDNInformation(entity);
        logger.debug("==============================================="+list.toString());
    }*/
    public static void main(String args[]){
        UserBlogLikeAndCollectionService service = (UserBlogLikeAndCollectionService) SpringContextUtil.getBean("UserBlogLikeAndCollectionService");
        int resulst = service.blogLike("debug",1,1,2,"tb_news");
        logger.info("===================================="+resulst);
    }
}