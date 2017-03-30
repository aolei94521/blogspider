package com.aolei.spider.data;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.pipeline.CSDNInformationPipeLine;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.CommonUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
public class CSDNInformationPage implements PageProcessor{
    private Site site = Site.me().setSleepTime(CommonStaticValue.SLEEPTIME).setRetryTimes(CommonStaticValue.RETRYTIME).setCharset(CommonStaticValue.CHARSET);
    public void process(Page page) {
        //page.addTargetRequests(page.getHtml().css("div.page_nav").links().all());
         List<String> valueList = page.getHtml().xpath("div[@class='unit']").all();
        InformationEntity informationEntiy = new InformationEntity();
        for (int index = 0; index < valueList.size();index++){
            informationEntiy.setUrl(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='unit']/h1/a/@href").all(),index));
            informationEntiy.setTitle(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='unit']/h1/a/text()").all(),index));
            informationEntiy.setPereview(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='unit']/dl/dd/text()").all(),index));
            informationEntiy.setRecomment(CommonUtils.getElementValue(page.getHtml().xpath("//span[@class='num_recom']/text()").all(),index));
            informationEntiy.setReadcount(CommonUtils.getElementValue(page.getHtml().xpath("//span[@class='view_time']/text()").all(),index));
            /*informationEntiy.setTitle(page.getHtml().xpath("//div[@class='unit']/h1/a/text()").all().toString());
            informationEntiy.setPereview(page.getHtml().xpath("//div[@class='unit']/dl/dd/text()").all().toString());
            informationEntiy.setRecomment(page.getHtml().xpath("//span[@class='num_recom']/text()").all().toString());
            informationEntiy.setReadcount(page.getHtml().xpath("//span[@class='view_time']/text()").all().toString());
            String time = page.getHtml().xpath("//span[@class='ago']/text()").all().toString();
            System.out.println(time);*/
            informationEntiy.setTime(CommonUtils.getElementDate(page.getHtml().xpath("//span[@class='ago']/text()").all(),index));
            //System.out.println(informationEntiy);
            page.putField("informationEntity",informationEntiy);
        }

    }

    public Site getSite() {
        return site;
    }
    public static void main(String args[]){
        Spider.create(new CSDNInformationPage()).addUrl("http://news.csdn.net").thread(1).addPipeline(new CSDNInformationPipeLine()).run();
    }
}
