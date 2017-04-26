package com.aolei.spider.controller;

import com.aolei.spider.service.UserService;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/9.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{
    @Resource
    UserService userService;

    /**
     * 用户注册
     * @param userName
     * @param userPwd
     * @param response
     */
    @RequestMapping(value = "userRegist", method = {RequestMethod.GET})
    public void userRegist(@RequestParam(value="userName",required = true) String userName,@RequestParam(value="userPwd",required = true) String userPwd, HttpServletResponse response){
        int registSuccuss = userService.userRegist(userName,userPwd);
        if (registSuccuss > 0){//注册成功
            ReturnResultUtils.outWriteSuccess(response,"[]","注册成功");
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"[]","注册失败请重新注册");
        }
    }

    /**
     * 用户登录
     * @param userName
     * @param userPwd
     * @param response
     */
    @RequestMapping(value = "userLogin", method = {RequestMethod.GET})
    public void userLogin(@RequestParam(value="userName",required = true) String userName,@RequestParam(value="userPwd",required = true) String userPwd, HttpServletResponse response){
        if (userService.userLogin(userName,userPwd)){
            ReturnResultUtils.outWriteResultForRegist(response,"登录成功");
        }else{
            ReturnResultUtils.outWriteResultForRegist(response,"登录失败,请检查您的登陆信息");
        }
    }
}
