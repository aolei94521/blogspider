package com.aolei.spider.controller;

import com.aolei.spider.entity.TuiKuEntity;
import com.aolei.spider.service.TuiKuService;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
            ReturnResultUtils.outWriteSuccess(response,"",tuiKuEntities);
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"您查询的数据为空",tuiKuEntities);
        }
    }
    @RequestMapping(value = "getTuiKuList", method = {RequestMethod.GET})
    void getTuiKuList(@RequestParam(value = "start")int start, @RequestParam(value = "count")int count, HttpServletResponse response){
        List<TuiKuEntity> tuiKuEntities = tuiKuService.getTuiKuList(start,count);
        /**将数据返回**/
        if (tuiKuEntities != null && !tuiKuEntities.isEmpty()){
            int size = tuiKuEntities.size();
            int nextStart = tuiKuEntities.get(size - 1).getId();
            if (tuiKuEntities.size() < count){
                ReturnResultUtils.outWriteSuccessList(response, CommonStaticValue.NOMORE,nextStart,"",tuiKuEntities);
            }else{

                ReturnResultUtils.outWriteSuccessList(response,CommonStaticValue.HASMORE,nextStart,"",tuiKuEntities);
            }
        }else{
            ReturnResultUtils.outWriteUnSuccessList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"没有更多了",tuiKuEntities);
        }
    }
}
