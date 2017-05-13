package com.aolei.spider.dao;

import com.aolei.spider.entity.SDEntity;

import java.util.List;
import java.util.Map;

public interface SDEntityMapper {

    int insertSelective(SDEntity record);


    int updateByPrimaryKeySelective(SDEntity record);

    List<SDEntity> getSDList(Map<String,Object> params);
}