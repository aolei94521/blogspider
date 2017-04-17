package com.aolei.spider.controller;

import com.aolei.spider.service.UserBlogLikeAndCollectionService;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/16.
 */
@Controller
@RequestMapping("/bloglike")
public class UserBlogLikeAndCollectController extends BaseController{
    @Resource
    private UserBlogLikeAndCollectionService blogLikeService;

    @RequestMapping(value = "like",method={RequestMethod.GET})
    public void bolgLike(@RequestParam(value="userName",required = true) String userName, @RequestParam(value="blogId",required = true) int blogId, @RequestParam(value="type",required = true) int type, @RequestParam(value="status",required = true) int status, @RequestParam(value="tbName",required = true) String tbName, HttpServletResponse response){
        int result = blogLikeService.blogLike(userName,blogId,type,status,tbName);
        if (result > 0){
            ReturnResultUtils.outWriteResult(response,"操作成功");
        }else{
            ReturnResultUtils.outWriteResult(response,"操作失败","操作失败");
        }
    }
}
