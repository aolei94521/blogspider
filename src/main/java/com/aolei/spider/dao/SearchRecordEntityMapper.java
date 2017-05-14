package com.aolei.spider.dao;

import com.aolei.spider.entity.SearchRecordEntity;

import java.util.List;

public interface SearchRecordEntityMapper {


    int insertSelective(SearchRecordEntity record);


    int updateByPrimaryKeySelective(SearchRecordEntity record);

    List<SearchRecordEntity> searchRecord(String userName);

}