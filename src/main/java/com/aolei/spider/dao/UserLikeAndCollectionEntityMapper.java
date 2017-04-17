package com.aolei.spider.dao;

import com.aolei.spider.entity.UserLikeAndCollectionEntity;

public interface UserLikeAndCollectionEntityMapper {

    int insert(UserLikeAndCollectionEntity record);


    int updateByPrimaryKeySelective(UserLikeAndCollectionEntity record);

    UserLikeAndCollectionEntity selectByTbNameAndTypeAndUserName(int blogId,String userName,int type);
}