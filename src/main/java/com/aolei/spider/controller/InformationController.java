package com.aolei.spider.controller;

import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.CSDNIfService;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Controller
@RequestMapping("/info")
public class InformationController extends BaseController {

    @Resource
    private CSDNIfService service;

    @RequestMapping(value = "showInfo", method = {RequestMethod.GET})
    public void get(HttpServletRequest request, HttpServletResponse response) {
        List<InformationEntity> list = service.getAllInformation();
        logger.debug("======================================"+list.size());
        if (list != null && !list.isEmpty()){
            ReturnResultUtils.outWriteResult(response, list);
        }

    }

    @RequestMapping(value = "addInfo", method = {RequestMethod.GET})
    public void add(HttpServletRequest request, HttpServletResponse response) {
        InformationEntity entity = new InformationEntity();
        entity.setReadcount("1");
        entity.setTitle("1");
        entity.setRecomment("sddf");
        entity.setPereview("sdf");
        entity.setTime(new Date());
        entity.setUrl("sdfsdf");
        service.addCSDNInformation(entity);
        ReturnResultUtils.outWriteResult(response, new ResponseStatus());
    }
}
