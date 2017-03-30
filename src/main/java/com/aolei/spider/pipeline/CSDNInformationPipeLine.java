package com.aolei.spider.pipeline;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.impl.CSDNInformationServiceImpl;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by Administrator on 2017/3/29.
 */
public class CSDNInformationPipeLine implements Pipeline{
    public void process(ResultItems resultItems, Task task) {
        CSDNInformationServiceImpl infomationServiceImpl = new CSDNInformationServiceImpl();
        InformationEntity informationEntity = resultItems.get("informationEntity");
        System.out.println(informationEntity.toString());
        infomationServiceImpl.addCSDNInformation(informationEntity);
    }
}
