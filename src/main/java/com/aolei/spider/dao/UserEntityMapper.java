package com.aolei.spider.dao;

import com.aolei.spider.entity.UserEntity;

public interface UserEntityMapper {
    /**
     * 插入一条用户信息
     * @param record
     * @return
     */
    int insertSelective(UserEntity record);

    /**
     * 查询用户是否存在，用户登陆时查询
     * @param userEntity
     * @return
     */
    UserEntity selectUser(UserEntity userEntity);
}