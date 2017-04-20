package com.aolei.spider.data;

import com.aolei.spider.entity.CodeCeoEntity;
import com.aolei.spider.pipeline.CodeCeoPipeLine;
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
public class CodeCeoPage extends CommonLoggerUtil implements PageProcessor{
    private Site site = Site.me().setRetryTimes(CommonStaticValue.RETRYTIME).setSleepTime(CommonStaticValue.SLEEPTIME).setCharset(CommonStaticValue.CHARSET);
    public void process(Page page) {
        List<CodeCeoEntity> codeCeoEntities = new ArrayList<CodeCeoEntity>();
        page.addTargetRequests(page.getHtml().css("div.paging").links().all());
        List<String> valueList = page.getHtml().xpath("article[@class='excerpt']").all();
        CodeCeoEntity codeCeoEntity;
        for (int index = 0; index < valueList.size();index++){
            codeCeoEntity = new CodeCeoEntity();
            codeCeoEntity.setTitle(CommonUtils.getElementValue(page.getHtml().xpath("//h3/a/text()").all(),index));
            codeCeoEntity.setLink(CommonUtils.getElementValue(page.getHtml().xpath("//h3/a/@href").all(),index));
            codeCeoEntity.setContent(CommonUtils.getElementValue(page.getHtml().xpath("div[@class='note']/text()").all(),index));
            codeCeoEntity.setIamgelink(CommonUtils.getElementValue(page.getHtml().xpath("//img/@src").all(),index));
            codeCeoEntities.add(codeCeoEntity);
        }
        page.putField("codeCeoEntities",codeCeoEntities);
    }

    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        Spider.create(new CodeCeoPage()).addUrl("http://www.codeceo.com/article/tag/node.js").thread(CommonStaticValue.THREAD_COUNT).addPipeline(new CodeCeoPipeLine()).run();
    }
}
