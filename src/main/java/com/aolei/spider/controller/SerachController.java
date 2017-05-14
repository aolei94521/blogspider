package com.aolei.spider.controller;

import com.aolei.spider.entity.SearchRecordEntity;
import com.aolei.spider.service.SearchService;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */
@Controller
@RequestMapping("/blog")
public class SerachController {
    @Resource
    private SearchService searchService;
    @RequestMapping("search")
    public void getSearchResult(@RequestParam(value = "start")int start, @RequestParam(value = "count")int count, @RequestParam(value = "word")String word, @RequestParam(value = "tbName")String tbName, HttpServletResponse response){
        List<?> resultList = searchService.search(start,count,word,tbName);
        if (resultList != null && !resultList.isEmpty()){
            if (resultList.size() < count){
                ReturnResultUtils.outWriteSuccessList(response, CommonStaticValue.HASMORE,CommonStaticValue.NOSTART,"",resultList);
            }else{
                ReturnResultUtils.outWriteSuccessList(response, CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"",resultList);
            }
        }else {
            ReturnResultUtils.outWriteUnSuccessList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"暂无结果",resultList);
        }
    }
    @RequestMapping("addSearchRecord")
    public void addRecord(@RequestParam(value = "userName")String userName, @RequestParam(value = "word")String word,HttpServletResponse response){
        searchService.addRecord(userName,word);
        ReturnResultUtils.outWriteSuccess(response,"","");
    }
    @RequestMapping("getSearchRecord")
    public void getSearchRecord(@RequestParam(value = "userName")String userName,HttpServletResponse response){
        List<SearchRecordEntity> list = searchService.getRecord(userName);
        if (list != null && !list.isEmpty()){
            ReturnResultUtils.outWriteSuccess(response,"",list);
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"暂无记录",list);
        }
    }
}
