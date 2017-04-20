package com.aolei.spider.data;

import com.aolei.spider.entity.JueJinEntity;
import com.aolei.spider.pipeline.JueJinPipeLine;
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
public class JueJinPage extends CommonLoggerUtil implements PageProcessor{
    private Site site = Site.me().setCharset(CommonStaticValue.CHARSET).setRetryTimes(CommonStaticValue.RETRYTIME).setSleepTime(CommonStaticValue.SLEEPTIME);
    public void process(Page page) {
        List<JueJinEntity> jueJinEntities = new ArrayList<JueJinEntity>();
        List<String> valueList = page.getHtml().xpath("div[@class='conetnt-box']").all();
        JueJinEntity jueJinEntity;
        for (int index = 0; index < valueList.size();index++){
            jueJinEntity = new JueJinEntity();
            jueJinEntity.setTitle(CommonUtils.getElementValue(page.getHtml().xpath("//a[@class='title']/text()").all(),index));
            jueJinEntity.setLink(CommonUtils.getElementValue(page.getHtml().xpath("//a[@class='title']/@href").all(),index));
            jueJinEntity.setAuthor(CommonUtils.getElementValue(page.getHtml().xpath("span[@class='username']/text()").all(),index));
            jueJinEntities.add(jueJinEntity);
        }
        page.putField("jueJinEntities",jueJinEntities);
    }

    public Site getSite() {
        return site;
    }
    public static void main(String args[]){
        Spider.create(new JueJinPage()).addUrl("https://juejin.im/welcome/product").thread(CommonStaticValue.THREAD_COUNT).addPipeline(new JueJinPipeLine()).run();
    }
}
