package com.aolei.spider.pipeline;

import com.aolei.spider.entity.CodeCeoEntity;
import com.aolei.spider.service.CodeCeoService;
import com.aolei.spider.util.CommonLoggerUtil;
import com.aolei.spider.util.SpringContextUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
public class CodeCeoPipeLine extends CommonLoggerUtil implements Pipeline{
    public void process(ResultItems resultItems, Task task) {
        CodeCeoService service = (CodeCeoService) SpringContextUtil.getBean("CodeCeoService");
        List<CodeCeoEntity> codeCeoEntities = resultItems.get("codeCeoEntities");
        if (codeCeoEntities != null && !codeCeoEntities.isEmpty()){
            service.addCodeCeoEntity(codeCeoEntities);
        }
    }
}
