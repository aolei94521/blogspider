package com.aolei.spider.data;

import com.aolei.spider.entity.SearchResultEntity;
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
 * Created by Administrator on 2017/4/26.
 */
public class CSDNSearchPage extends CommonLoggerUtil implements PageProcessor{
    private Site site =Site.me().setSleepTime(CommonStaticValue.SLEEPTIME).setRetryTimes(CommonStaticValue.RETRYTIME).setCharset(CommonStaticValue.CHARSET);
    public void process(Page page) {
        //List<String> csdnRequestUrls = CommonUtils.getCSDNSearchTargetUrls("");
        List<SearchResultEntity> searchResultEntities = new ArrayList<SearchResultEntity>();
        List<String> urls = page.getHtml().css("span.page-nav").links().all();
        page.addTargetRequests(urls);
        //logger.info("+++++++++++++++++++++++++++++"+urls.size());
        //logger.info("============================="+urls.toString());
        List<String> valueList = page.getHtml().xpath("dl[@class='search-list']").all();

        SearchResultEntity searchResultEntity;
        for (int index = 0;  index < valueList.size(); index++){
            searchResultEntity = new SearchResultEntity();
            searchResultEntity.setTitle(CommonUtils.getElementValue(page.getHtml().xpath("//dt[@class='csdn-tracking-statistics']/a/em/text()").all(),index));
            searchResultEntity.setAuthor(CommonUtils.getElementValue(page.getHtml().xpath("//dd[@class='author-time']/a/text()").all(),index));
            searchResultEntity.setContent(CommonUtils.getElementValue(page.getHtml().xpath("//d[@class='search-detail']/text()").all(),index));
            searchResultEntity.setUrl(CommonUtils.getElementValue(page.getHtml().xpath("//dd[@class='search-link']/a/@href").all(),index));
            searchResultEntities.add(searchResultEntity);
        }

        logger.info("=+++++++++++++++++++++++++++=="+searchResultEntities.size());
    }

    public Site getSite() {
        return site;
    }
    public static void main(String args[]){
        Spider.create(new CSDNSearchPage()).addUrl("http://so.csdn.net/so/search/s.do?p=1&q=java&t=blog&domain=&o=&s=&u=null&l=null&f=null").thread(CommonStaticValue.THREAD_COUNT).run();
    }
}
