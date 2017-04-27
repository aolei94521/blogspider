package com.aolei.spider.dao;

import com.aolei.spider.entity.ViewRecordEntity;

public interface ViewRecordEntityMapper {

    int insertSelective(ViewRecordEntity record);


    int updateByPrimaryKeySelective(ViewRecordEntity record);

    int deleteByRecordId(int recordId,String userNmae);

    int deleteByUserName(String userName);
}