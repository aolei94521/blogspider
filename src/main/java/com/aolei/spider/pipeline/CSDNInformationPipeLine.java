package com.aolei.spider.pipeline;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.CSDNInformationService;
import com.aolei.spider.util.CommonLoggerUtil;
import com.aolei.spider.util.SpringContextUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
public class CSDNInformationPipeLine extends CommonLoggerUtil implements Pipeline{
    public void process(ResultItems resultItems, Task task) {
        //AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:mybatis.xml");
        //CSDNInformationService service = (CSDNInformationService)applicationContext.getBean("CSDNInformationService");
        CSDNInformationService service = SpringContextUtil.getBean("CSDNInformationService");
        List<InformationEntity> informationEntities = resultItems.get("informationEntities");
        if (informationEntities != null && !informationEntities.isEmpty()){
            for (InformationEntity informationEntity: informationEntities) {
                System.out.println(informationEntity.toString());
                service.addCSDNInformation(informationEntity);
            }
        }
    }
}
