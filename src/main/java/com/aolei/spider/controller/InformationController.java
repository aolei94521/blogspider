package com.aolei.spider.controller;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.CSDNInformationService;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.CommonUtils;
import com.aolei.spider.util.NumberUtils;
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
 * Created by Administrator on 2017/3/30.
 */
@Controller
@RequestMapping("/zixun")
public class InformationController extends BaseController {

    @Resource
    private CSDNInformationService service;

    @RequestMapping(value = "getAllInfo", method = {RequestMethod.GET})
    public void getAllInfo(HttpServletRequest request, HttpServletResponse response) {
        List<InformationEntity> list = service.getAllInformation();
        logger.debug("======================================"+list.size());
        if (list != null && !list.isEmpty()){
            ReturnResultUtils.outWriteSuccess(response, "",list);
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"您查询的数据为空",list);
        }

    }

    @RequestMapping(value="getInfoList" ,method = {RequestMethod.GET})
    public void getInfoList(HttpServletRequest request,HttpServletResponse response){
          int start = NumberUtils.toInt(request.getParameter("start"));
          int count = NumberUtils.toInt(request.getParameter("count"));
          logger.debug("================================"+start+"==="+count);
          List<InformationEntity> informationEntities = service.getInformationList(start,count);
            /**将数据返回**/
          if (!CommonUtils.listIsEmputyOrNull(informationEntities)){
            int size = informationEntities.size();
            int nextStart = informationEntities.get(size - 1).getId();
            if (informationEntities.size() < count){
                ReturnResultUtils.outWriteSuccessList(response, CommonStaticValue.NOMORE,nextStart,"",informationEntities);
            }else{
                ReturnResultUtils.outWriteSuccessList(response,CommonStaticValue.HASMORE,nextStart,"",informationEntities);
            }
        }else{
              ReturnResultUtils.outWriteUnSuccessList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"没有更多了",informationEntities);
          }
    }
    @RequestMapping(value = "getList",method = {RequestMethod.GET})
    public void getInfoList(@RequestParam(value="start") int start,@RequestParam(value = "count")int count,@RequestParam(value = "type") int type, HttpServletResponse response){
        List<?> infoList = service.getInfoList(start,count,type);
        if (infoList != null && !infoList.isEmpty()){
            if (infoList.size() >= count){
               ReturnResultUtils.outWriteSuccessList(response,CommonStaticValue.HASMORE,CommonStaticValue.NOSTART,"",infoList);
            }else{
                ReturnResultUtils.outWriteSuccessList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"",infoList);
            }
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"暂无资讯",infoList);
        }
    }
}
