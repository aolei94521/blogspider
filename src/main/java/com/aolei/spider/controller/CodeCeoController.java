package com.aolei.spider.controller;

import com.aolei.spider.entity.CodeCeoEntity;
import com.aolei.spider.service.CodeCeoService;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Controller
@RequestMapping("/codeCeo")
public class CodeCeoController extends BaseController{
    @Resource
    CodeCeoService service;

    @RequestMapping(value = "/getCodeCeoList",method = {RequestMethod.GET})
    void getCodeCeoList(@RequestParam(value = "start")int start, @RequestParam(value = "count")int count, HttpServletResponse response){
        List<CodeCeoEntity> codeCeoEntities = service.getCodeCeoList(start,count);
        if (codeCeoEntities != null && !codeCeoEntities.isEmpty()){
            int size = codeCeoEntities.size();
            int nextStart = codeCeoEntities.get(size - 1).getId();
            if (codeCeoEntities.size() < count){
                ReturnResultUtils.outWriteResultList(response, CommonStaticValue.NOMORE,nextStart,codeCeoEntities);
            }else{
                ReturnResultUtils.outWriteResultList(response,CommonStaticValue.HASMORE,nextStart,codeCeoEntities);
            }
        }else{
            ReturnResultUtils.outWriteResultList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,codeCeoEntities,"没有更多了");
        }
    }
}
