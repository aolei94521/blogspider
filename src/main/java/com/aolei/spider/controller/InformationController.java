package com.aolei.spider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/30.
 */
@Controller
@RequestMapping("/info")
public class InformationController {
    /*@Resource
    private CSDNInformationService service;
    @RequestMapping(value = "showInfo", method={RequestMethod.GET})
    public void get(HttpServletRequest request, HttpServletResponse response){
        List<InformationEntity> list = service.getAllInformation();
        System.out.println(list.size());
            ReturnResultUtils.outWriteResult(response,list);
    }
    @RequestMapping(value = "addInfo",method = {RequestMethod.GET})
    public void add(HttpServletRequest request,HttpServletResponse response){
        InformationEntity entity = new InformationEntity();
        entity.setReadcount("1");
        entity.setTitle("1");
        entity.setRecomment("sddf");
        entity.setPereview("sdf");
        entity.setTime(new Date());
        entity.setUrl("sdfsdf");
        service.addCSDNInformation(entity);
        ReturnResultUtils.outWriteResult(response,new ResponseStatus());
    }*/
}
