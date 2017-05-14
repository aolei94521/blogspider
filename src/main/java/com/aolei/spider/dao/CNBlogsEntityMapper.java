package com.aolei.spider.dao;

import com.aolei.spider.entity.CNBlogsEntity;

import java.util.List;
import java.util.Map;

public interface CNBlogsEntityMapper {

    int insertSelective(CNBlogsEntity record);


    int updateByPrimaryKeySelective(CNBlogsEntity record);

    List<CNBlogsEntity> getCnblogList(int start,int count);

    CNBlogsEntity selectById(int id);

    List<CNBlogsEntity> search(Map<String,Object> params);
}