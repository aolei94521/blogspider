package com.aolei.spider.controller;

import com.aolei.spider.entity.JueJinEntity;
import com.aolei.spider.service.JueJinService;
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
@RequestMapping("/juejin")
public class JueJinController extends BaseController{
    @Resource
    JueJinService jueJinService;
    @RequestMapping(value = "getJunjin",method = {RequestMethod.GET})
    public void getJunJinList(@RequestParam(value = "start")int start, @RequestParam(value = "count")int count, HttpServletResponse response){
        List<JueJinEntity> jueJinEntities = jueJinService.getJueJinList(start,count);
        if (jueJinEntities != null && !jueJinEntities.isEmpty()){
            int size = jueJinEntities.size();
            int nextStart = jueJinEntities.get(size - 1).getId();
            if (jueJinEntities.size() < count){
                ReturnResultUtils.outWriteResultList(response, CommonStaticValue.NOMORE,nextStart,jueJinEntities);
            }else{
                ReturnResultUtils.outWriteResultList(response,CommonStaticValue.HASMORE,nextStart,jueJinEntities);
            }
        }else{
            ReturnResultUtils.outWriteResultList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,jueJinEntities,"没有更多了");
        }
    }

}
