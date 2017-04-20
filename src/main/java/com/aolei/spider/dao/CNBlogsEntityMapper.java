package com.aolei.spider.dao;

import com.aolei.spider.entity.CNBlogsEntity;

import java.util.List;

public interface CNBlogsEntityMapper {

    int insertSelective(CNBlogsEntity record);


    int updateByPrimaryKeySelective(CNBlogsEntity record);

    List<CNBlogsEntity> getCnblogList(int start,int count);
}