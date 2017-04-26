package com.aolei.spider.controller;

import com.aolei.spider.entity.CheckEntity;
import com.aolei.spider.entity.UserLikeAndCollectionEntity;
import com.aolei.spider.service.UserBlogLikeAndCollectionService;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 */
@Controller
@RequestMapping("/check")
public class CheckController extends BaseController{
    @Resource
    UserBlogLikeAndCollectionService service;
    @RequestMapping(value = "checkStatus",method = {RequestMethod.GET})
    public void checkBlogStatus(@RequestParam(value = "userName") String userName, @RequestParam(value = "tbName") String tbName, @RequestParam(value = "type")int type,@RequestParam(value = "blogId")int blogId, HttpServletResponse response){
        UserLikeAndCollectionEntity userLikeAndCollectionEntity = service.selectStatus(userName,type,tbName,blogId);
        List<CheckEntity> checkEntities = new ArrayList<CheckEntity>();
        CheckEntity checkEntity;
        if (userLikeAndCollectionEntity != null){
            checkEntity = new CheckEntity();
            checkEntity.setStatus(CommonStaticValue.CONLLECTIONORLIKE);
            checkEntities.add(checkEntity);
            ReturnResultUtils.outWriteSuccess(response,"",checkEntity);
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"",checkEntities);
        }
    }
}
