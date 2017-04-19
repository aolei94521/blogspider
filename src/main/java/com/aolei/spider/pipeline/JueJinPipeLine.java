package com.aolei.spider.pipeline;

import com.aolei.spider.entity.JueJinEntity;
import com.aolei.spider.service.JueJinService;
import com.aolei.spider.util.CommonLoggerUtil;
import com.aolei.spider.util.SpringContextUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
public class JueJinPipeLine extends CommonLoggerUtil implements Pipeline{
    public void process(ResultItems resultItems, Task task) {
        JueJinService service = (JueJinService) SpringContextUtil.getBean("JueJinService");
        List<JueJinEntity> list = resultItems.get("jueJinEntities");
        if (list != null && !list.isEmpty()){
            service.addJuejinEntity(list);
        }
    }
}
