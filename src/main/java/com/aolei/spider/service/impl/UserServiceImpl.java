package com.aolei.spider.service.impl;

import com.aolei.spider.dao.UserEntityMapper;
import com.aolei.spider.entity.UserEntity;
import com.aolei.spider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/9.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    @Autowired
    UserEntityMapper mapper;
    public int userRegist(String userName, String userPwd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userName);
        userEntity.setUserpwd(userPwd);
        return mapper.insertSelective(userEntity);
    }

    public boolean userLogin(String userName, String userPwd) {
        boolean loginSuccess = false;
        UserEntity userEntity = new UserEntity();
        UserEntity resultUserEntity;
        userEntity.setUsername(userName);
        userEntity.setUserpwd(userPwd);
        resultUserEntity = mapper.selectUser(userEntity);
        if (resultUserEntity != null){
            loginSuccess =  true;
        }
        return loginSuccess;
    }
}
