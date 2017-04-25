package com.aolei.spider.controller;

import com.aolei.spider.entity.CNBlogsEntity;
import com.aolei.spider.service.CNBlogService;
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
@RequestMapping("CNBlog")
public class CNBlogController extends BaseController{
    @Resource
    CNBlogService cnBlogService;
    @RequestMapping(value = "getCnblog",method = {RequestMethod.GET})
    public void getJunJinList(@RequestParam(value = "start")int start, @RequestParam(value = "count")int count, @RequestParam(value = "userName") String userName,@RequestParam(value = "tbName") String tbName,@RequestParam(value = "type") int type, HttpServletResponse response){
        List<CNBlogsEntity> cnBlogsEntities = cnBlogService.getCnblog(start,count);
        if (cnBlogsEntities != null && !cnBlogsEntities.isEmpty()){
            int size = cnBlogsEntities.size();
            int nextStart = cnBlogsEntities.get(size - 1).getId();
            for (CNBlogsEntity cnBlog: cnBlogsEntities) {

            }
            if (cnBlogsEntities.size() < count){
                ReturnResultUtils.outWriteResultList(response, CommonStaticValue.NOMORE,nextStart,cnBlogsEntities);
            }else{
                ReturnResultUtils.outWriteResultList(response,CommonStaticValue.HASMORE,nextStart,cnBlogsEntities);
            }
        }else{
            ReturnResultUtils.outWriteResultList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,cnBlogsEntities,"没有更多了");
        }
    }
}
