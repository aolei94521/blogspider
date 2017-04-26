package com.aolei.spider.controller;

import com.aolei.spider.entity.CSDNEntity;
import com.aolei.spider.service.CSDNService;
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
 * Created by Administrator on 2017/4/26.
 */
@Controller
@RequestMapping("/CSDN")
public class CSDNController extends BaseController{
    @Resource
    CSDNService csdnService;
    @RequestMapping(value = "getCSDNList",method = {RequestMethod.GET})
    public void getCSDNList(@RequestParam(value = "start") int start, @RequestParam(value = "count") int count, HttpServletResponse response){
        List<CSDNEntity> csdnEntities = csdnService.getCSDNList(start,count);
        /**将数据返回**/
        if (csdnEntities != null && !csdnEntities.isEmpty()){
            int size = csdnEntities.size();
            int nextStart = csdnEntities.get(size - 1).getId();
            if (csdnEntities.size() < count){
                ReturnResultUtils.outWriteUnSuccessList(response, CommonStaticValue.NOMORE,nextStart,"",csdnEntities);
            }else{

                ReturnResultUtils.outWriteUnSuccessList(response,CommonStaticValue.HASMORE,nextStart,"",csdnEntities);
            }
        }else{
            ReturnResultUtils.outWriteUnSuccessList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"没有更多了",csdnEntities);
        }
    }
}
