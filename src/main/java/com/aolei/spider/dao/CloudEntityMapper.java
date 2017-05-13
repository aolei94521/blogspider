package com.aolei.spider.dao;

import com.aolei.spider.entity.CloudEntity;

import java.util.List;
import java.util.Map;

public interface CloudEntityMapper {

    int insertSelective(CloudEntity record);


    int updateByPrimaryKeySelective(CloudEntity record);

    List<CloudEntity> getCloudList(Map<String,Object> params);
}