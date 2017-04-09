package com.aolei.spider.pipeline;

import com.aolei.spider.entity.TuiKuEntity;
import com.aolei.spider.service.TuiKuService;
import com.aolei.spider.util.CommonLoggerUtil;
import com.aolei.spider.util.SpringContextUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public class TuiKuPipeLine extends CommonLoggerUtil implements Pipeline{
    public void process(ResultItems resultItems, Task task) {
        TuiKuService service = SpringContextUtil.getBean("TuiKuService");
        List<TuiKuEntity> tuiKuEntities = resultItems.get("tuiKuEntities");
        for (TuiKuEntity tuiKuEntity: tuiKuEntities) {
            service.addTuiKuInfo(tuiKuEntity);
        }
    }
}
