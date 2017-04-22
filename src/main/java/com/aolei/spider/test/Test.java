package com.aolei.spider.test;

import com.aolei.spider.service.QuestionService;
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
    /*public static void main(String args[]){
        UserBlogLikeAndCollectionService service = (UserBlogLikeAndCollectionService) SpringContextUtil.getBean("UserBlogLikeAndCollectionService");
        UserService service1 = (UserService) SpringContextUtil.getBean("UserService");
        int resulst = service.blogLike("debug1",1,2,1,"tb_news");
        //int result1 = service1.userRegist("sssdfsfsdf","sdfsdfsdfsfsd");
        logger.info("===================================="+resulst);
    }*/
    public static void main(String args[]){
       /* CodeCeoService service = (CodeCeoService) SpringContextUtil.getBean("CodeCeoService");
        CodeCeoEntity codeCeoEntity = new CodeCeoEntity();
        codeCeoEntity.setIamgelink("ssssssssssss");
        codeCeoEntity.setLink("ssssssssssssss");
        codeCeoEntity.setTitle("ssssssssssssssss");
        codeCeoEntity.setContent("sssssssssssssssssss");
        List<CodeCeoEntity> list = new ArrayList<CodeCeoEntity>();
        list.add(codeCeoEntity);
        int result = service.addCodeCeoEntity(list);
        logger.info("=============================="+result);*/
        QuestionService service = (QuestionService) SpringContextUtil.getBean("QuestionService");
        service.getMyAnswerQuestion("debug");
    }
}