package com.aolei.spider.data;

import com.aolei.spider.entity.TuiKuEntity;
import com.aolei.spider.pipeline.TuiKuPipeLine;
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
 * Created by Administrator on 2017/4/9.
 */
public class TuiKuPage extends CommonLoggerUtil implements PageProcessor{
    private Site site = Site.me().setRetryTimes(CommonStaticValue.RETRYTIME).setSleepTime(CommonStaticValue.SLEEPTIME).setCharset(CommonStaticValue.CHARSET);
    public void process(Page page) {
        List<String> requestTargetUrlList = CommonUtils.getRequestTargetUrls();
        page.addTargetRequests(requestTargetUrlList);
        List<TuiKuEntity> tuiKuEntities = new ArrayList<TuiKuEntity>();
        List<String> valueList = page.getHtml().xpath("div[@class='list_article_item']").all();
        TuiKuEntity tuiKuEntity;
        for (int index = 0; index < valueList.size();index++) {
            tuiKuEntity = new TuiKuEntity();
            tuiKuEntity.setTitle(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='title']/a/@title").all(),index));
            tuiKuEntity.setUrl(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='title']/a/@href").all(),index));
            tuiKuEntity.setAuther(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='tip']/span[1]/text()").all(),index));
            tuiKuEntity.setImgurl(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='article_thumb_image']/img/@src").all(),index));
            tuiKuEntity.setTime(CommonUtils.getElementDate(page.getHtml().xpath("//div[@class='tip']/span[3]/text()").all(),index,CommonStaticValue.TUIKUDATATYPE));
            tuiKuEntities.add(tuiKuEntity);
        }
        page.putField("tuiKuEntities",tuiKuEntities);
    }

    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        Spider.create(new TuiKuPage()).addUrl("http://www.tuicool.com/ah/20/0?lang=1").thread(CommonStaticValue.THREAD_COUNT).addPipeline(new TuiKuPipeLine()).run();
    }
}
