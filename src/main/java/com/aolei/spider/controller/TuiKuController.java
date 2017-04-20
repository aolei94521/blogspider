package com.aolei.spider.controller;

import com.aolei.spider.entity.TuiKuEntity;
import com.aolei.spider.service.TuiKuService;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.CommonUtils;
import com.aolei.spider.util.NumberUtils;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
@Controller
@RequestMapping("tuiku")
public class TuiKuController extends BaseController{
    @Resource
    TuiKuService tuiKuService;

    /**
     * 查询所有的TuiKuEntity
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getAllTuiKu", method = {RequestMethod.GET})
    void getAllTuiKu(HttpServletRequest request, HttpServletResponse response){
        List<TuiKuEntity> tuiKuEntities = tuiKuService.getAllTuiKu();
        if (tuiKuEntities != null && !tuiKuEntities.isEmpty()){
            ReturnResultUtils.outWriteResult(response,tuiKuEntities);
        }else{
            ReturnResultUtils.outWriteResult(response,tuiKuEntities,"您查询的数据为空");
        }
    }
    @RequestMapping(value = "getTuiKuList", method = {RequestMethod.GET})
    void getTuiKuList(HttpServletRequest request,HttpServletResponse response){
        int start = NumberUtils.toInt(request.getParameter("start"));
        int count = NumberUtils.toInt(request.getParameter("count"));
        List<TuiKuEntity> tuiKuEntities = tuiKuService.getTuiKuList(start,count);
        /**将数据返回**/
        if (!CommonUtils.listIsEmputyOrNull(tuiKuEntities)){
            int size = tuiKuEntities.size();
            int nextStart = tuiKuEntities.get(size - 1).getId();
            if (tuiKuEntities.size() < count){
                ReturnResultUtils.outWriteResultList(response, CommonStaticValue.NOMORE,nextStart,tuiKuEntities);
            }else{
                ReturnResultUtils.outWriteResultList(response,CommonStaticValue.HASMORE,nextStart,tuiKuEntities);
            }
        }else{
            ReturnResultUtils.outWriteResultList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"您查询的数据为空");
        }
    }
}
