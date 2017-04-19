package com.aolei.spider.pipeline;

import com.aolei.spider.entity.CNBlogsEntity;
import com.aolei.spider.service.CNBlogService;
import com.aolei.spider.util.CommonLoggerUtil;
import com.aolei.spider.util.SpringContextUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
public class CNBlogPipeLine extends CommonLoggerUtil implements Pipeline{
    public void process(ResultItems resultItems, Task task) {
        CNBlogService service = (CNBlogService)SpringContextUtil.getBean("CNBlogService");
        List<CNBlogsEntity> cnBlogsEntities = new ArrayList<CNBlogsEntity>();
        cnBlogsEntities = resultItems.get("cnBlogsEntities");
        if (cnBlogsEntities != null && !cnBlogsEntities.isEmpty()){
            service.addCNBlogs(cnBlogsEntities);
        }
    }
}
