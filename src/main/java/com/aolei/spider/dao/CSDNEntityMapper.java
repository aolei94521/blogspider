package com.aolei.spider.dao;

import com.aolei.spider.entity.CSDNEntity;

import java.util.List;
import java.util.Map;

public interface CSDNEntityMapper {

    int insertSelective(CSDNEntity record);


    int updateByPrimaryKeySelective(CSDNEntity record);


    List<CSDNEntity> getCSDNList(int start, int count);

    CSDNEntity selectById(int id);

    List<CSDNEntity> search(Map<String,Object> params);
}