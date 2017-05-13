package com.aolei.spider.data;

import com.aolei.spider.entity.QiuBaiEntity;
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
 * Created by Administrator on 2017/5/11.
 */
public class QiuBaiPage extends CommonLoggerUtil implements PageProcessor{
    private Site site = Site.me().setRetryTimes(CommonStaticValue.RETRYTIME).setSleepTime(CommonStaticValue.SLEEPTIME).setCharset(CommonStaticValue.CHARSET);
    public void process(Page page) {
        logger.info("AOLEIDEBUG3==="+page.toString());
        List<String> string = page.getHtml().css("ul.pagination").links().all();
        logger.info("AOLEIDEBUG2====="+string.toString());
        page.addTargetRequests(page.getHtml().xpath("ul[@class='pagination']").links().all());
        List<String> valueList = page.getHtml().xpath("div[@class='article block untagged mb15']").all();
        List<QiuBaiEntity> qiuBaiEntities = new ArrayList<QiuBaiEntity>();
        QiuBaiEntity qiuBaiEntity;
        logger.info("AOLEIDEBUG1==="+valueList);
        for (int index = 0;index < valueList.size();index++){
             qiuBaiEntity = new QiuBaiEntity();
             qiuBaiEntity.setUserName(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='author clearfix']/a[2]/@title").all(),index));
             qiuBaiEntity.setImageLink(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='author clearfix']/a[1]/@herf").all(),index));
             qiuBaiEntity.setContent(CommonUtils.getElementValue(page.getHtml().xpath("//div[@class='content']/span/text").all(),index));
             qiuBaiEntities.add(qiuBaiEntity);
        }
        logger.debug("AOLEIDEBUG===="+qiuBaiEntities.toString());

    }

    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
         Spider.create(new QiuBaiPage()).addUrl("https://www.qiushibaike.com/").thread(1).run();
    }
}
