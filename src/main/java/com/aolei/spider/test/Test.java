package com.aolei.spider.test;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.CSDNInformationService;
import com.aolei.spider.service.SpringContextHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
public class Test {
    public static void main(String args[]){
        CSDNInformationService csdnInformationService = SpringContextHolder.getBean(CSDNInformationService.class);
        if (csdnInformationService != null){
            List<InformationEntity> list =  csdnInformationService.getAllInformation();
            if (list!= null && !list.isEmpty()){
                System.out.println("test");
            }
        }

    }
}