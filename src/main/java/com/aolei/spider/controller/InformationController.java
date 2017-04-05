package com.aolei.spider.controller;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.CSDNInformationService;
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
            ReturnResultUtils.outWriteResult(response, list);
        }

    }

    /*@RequestMapping(value = "addInfo", method = {RequestMethod.GET})
    public void add(HttpServletRequest request, HttpServletResponse response) {
        InformationEntity entity = new InformationEntity();
        entity.setReadcount(request.getParameter("re"));
        entity.setTitle("1");
        entity.setRecomment("sddf");
        entity.setPereview("sdf");
        entity.setTime(new Date());
        entity.setUrl("sdfsdf");
        service.addCSDNInformation(entity);
        ReturnResultUtils.outWriteResult(response);
    }*/
    @RequestMapping(value="getInfoList" ,method = {RequestMethod.GET})
    public void getInfoList(HttpServletRequest request,HttpServletResponse response){
          int start = NumberUtils.toInt(request.getParameter("start"));
          int count = NumberUtils.toInt(request.getParameter("count"));
          logger.debug("================================"+start+"==="+count);
          List<InformationEntity> informationEntities = service.getInformationList(start,count);
          if (informationEntities != null && !informationEntities.isEmpty()){
              int size = informationEntities.size();
              int nextStart = informationEntities.get(size - 1).getId();
              if (informationEntities.size() < count){
                  ReturnResultUtils.outWriteResultList(response,0,nextStart,informationEntities);
              }else{
                  ReturnResultUtils.outWriteResultList(response,1,nextStart,informationEntities);
              }
          }
    }
}
