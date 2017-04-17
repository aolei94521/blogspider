package com.aolei.spider.dao;

import com.aolei.spider.entity.LikeEntity;

public interface LikeEntityMapper {


    int insertSelective(LikeEntity record);


    int updateByPrimaryKeySelective(LikeEntity record);

    LikeEntity selectByBlogIdAndType(int blogId,String tbName);
}