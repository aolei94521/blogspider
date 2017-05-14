package com.aolei.spider.dao;

import com.aolei.spider.entity.SearchRecordEntity;

public interface SearchRecordEntityMapper {


    int insertSelective(SearchRecordEntity record);


    int updateByPrimaryKeySelective(SearchRecordEntity record);

    int searchRecord(String userName);

}