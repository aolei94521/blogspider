package com.aolei.spider.dao;

import com.aolei.spider.entity.MobileEntity;

import java.util.List;
import java.util.Map;

public interface MobileEntityMapper {

    int insertSelective(MobileEntity record);


    int updateByPrimaryKeySelective(MobileEntity record);

    List<MobileEntity> getMobileList(Map<String,Object> params);
}