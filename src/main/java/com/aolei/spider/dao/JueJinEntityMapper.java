package com.aolei.spider.dao;

import com.aolei.spider.entity.JueJinEntity;

import java.util.List;
import java.util.Map;

public interface JueJinEntityMapper {

    int insertSelective(JueJinEntity record);


    int updateByPrimaryKeySelective(JueJinEntity record);

    List<JueJinEntity> getJueJinList(int start,int count);
    JueJinEntity selectById(int id);

    List<JueJinEntity> search(Map<String,Object> params);
}