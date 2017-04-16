package com.aolei.spider.dao;

import com.aolei.spider.entity.UserLikeAndCollectionEntity;

public interface UserLikeAndCollectionEntityMapper {


    int insertSelective(UserLikeAndCollectionEntity record);


    int updateByPrimaryKeySelective(UserLikeAndCollectionEntity record);

    /**
     * 查询是否该blog已经被收藏
     * @param blogId
     * @param userName
     * @param type
     * @return
     */
    UserLikeAndCollectionEntity selectByTbNameAndTypeAndUserName(int blogId,String userName,int type);

}