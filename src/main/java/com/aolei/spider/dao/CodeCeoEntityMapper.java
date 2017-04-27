package com.aolei.spider.dao;

import com.aolei.spider.entity.CodeCeoEntity;

import java.util.List;

public interface CodeCeoEntityMapper {

    int insertSelective(CodeCeoEntity record);


    int updateByPrimaryKeySelective(CodeCeoEntity record);

    List<CodeCeoEntity> getCodeCeoList(int start,int count);

    CodeCeoEntity selectById(int id);
}