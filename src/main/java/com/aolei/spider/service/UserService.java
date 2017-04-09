package com.aolei.spider.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/9.
 */
@Service
public interface UserService {
    /**
     * 用户注册
     * @param userName
     * @param userPwd
     * @return
     */
    int userRegist(String userName,String userPwd);

    /**
     * 用户登录
     * @param userName
     * @param userPwd
     * @return
     */
    boolean userLogin(String userName,String userPwd);
}
