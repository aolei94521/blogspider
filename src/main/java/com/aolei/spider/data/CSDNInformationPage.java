package com.aolei.spider.data;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.pipeline.CSDNInformationPipeLine;
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
 * Created by Administrator on 2017/3/29.
 */
public class CSDNInformationPage extends CommonLoggerUtil implements PageProcessor{
    private Site site = Site.me().setSleepTime(CommonStaticValue.SLEEPTIME).setRetryTimes(CommonStaticValue.RETRYTIME).setCharset(CommonStaticValue.CHARSET);
    public void process(Page page) {
        List<InformationEntity> informationEntities = new ArrayList<InformationEntity>();
        page.addTargetRequests(page.getHtml().css("div.page_nav").links().all());
        List<String> valueList = page.getHtml().xpath("div[@class='unit']").all();
        InformationEntity informationEntiy;
            for (int index = 0; index < valueList.size();index++){
            informationEntiy = new InformationEntity();
            informationEntiy.setUrl(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='unit']/h1/a/@href").all(),index));
            informationEntiy.setTitle(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='unit']/h1/a/text()").all(),index));
            informationEntiy.setPereview(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='unit']/dl/dd/text()").all(),index));
            informationEntiy.setRecomment(CommonUtils.getElementValue(page.getHtml().xpath("//span[@class='num_recom']/text()").all(),index));
            informationEntiy.setReadcount(CommonUtils.getElementValue(page.getHtml().xpath("//span[@class='view_time']/text()").all(),index));
            informationEntiy.setTime(CommonUtils.getElementDate(page.getHtml().xpath("//span[@class='ago']/text()").all(),index,CommonStaticValue.COMMONDATATYPE));
            informationEntities.add(informationEntiy);
        }
        page.putField("informationEntities",informationEntities);

    }

    public Site getSite() {
        return site;
    }
    public static void main(String args[]){
        Spider.create(new CSDNInformationPage()).addUrl("http://news.csdn.net").thread(CommonStaticValue.THREAD_COUNT).addPipeline(new CSDNInformationPipeLine()).run();
    }
}
