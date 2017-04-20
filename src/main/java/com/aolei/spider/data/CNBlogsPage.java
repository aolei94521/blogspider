package com.aolei.spider.data;

import com.aolei.spider.entity.CNBlogsEntity;
import com.aolei.spider.pipeline.CNBlogPipeLine;
import com.aolei.spider.util.CommonLoggerUtil;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.CommonUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
public class CNBlogsPage extends CommonLoggerUtil implements PageProcessor{
    private Site site = Site.me().setRetryTimes(CommonStaticValue.RETRYTIME).setSleepTime(CommonStaticValue.SLEEPTIME).setCharset(CommonStaticValue.CHARSET);
    public void process(Page page) {
        List<CNBlogsEntity> cnBlogsEntities = new ArrayList<CNBlogsEntity>();
        page.addTargetRequests(page.getHtml().xpath("div[@class=pager]").links().all());
        List<String> valueList = page.getHtml().xpath("div[@class='content']").all();
        CNBlogsEntity cnBlogsEntity;
        for (int index = 0; index < valueList.size();index++){
            cnBlogsEntity = new CNBlogsEntity();
            cnBlogsEntity.setTitle(CommonUtils.getElementValue(page.getHtml().xpath("//h2[@class='entry_title']/a[2]/text()").all(),index));
            cnBlogsEntity.setLink(CommonUtils.getElementValue(page.getHtml().xpath("//h2[@class='entry_title']/a[2]/@href").all(),index));
            cnBlogsEntity.setContent(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='entry_summary']/text()").all(),index));
            cnBlogsEntity.setAuthor(CommonUtils.getElementValue(page.getHtml().xpath("//h2[@class='entry_title']/a[1]/text()").all(),index));
            cnBlogsEntities.add(cnBlogsEntity);
        }
        page.putField("cnBlogsEntities",cnBlogsEntities);
    }

    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        Spider.create(new CNBlogsPage()).addUrl("https://home.cnblogs.com/blog/").thread(CommonStaticValue.THREAD_COUNT).addPipeline(new CNBlogPipeLine()).run();
    }
}
