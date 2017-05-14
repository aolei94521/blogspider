package com.aolei.spider.dao;

import com.aolei.spider.entity.CodeCeoEntity;

import java.util.List;
import java.util.Map;

public interface CodeCeoEntityMapper {

    int insertSelective(CodeCeoEntity record);


    int updateByPrimaryKeySelective(CodeCeoEntity record);

    List<CodeCeoEntity> getCodeCeoList(int start,int count);

    CodeCeoEntity selectById(int id);

    List<CodeCeoEntity> search(Map<String,Object> params);
}