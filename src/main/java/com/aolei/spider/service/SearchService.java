package com.aolei.spider.service;

import com.aolei.spider.entity.SearchRecordEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */
@Service
public interface SearchService {
    List<?> search(int start,int count,String word,String key);
    void addRecord(String userName,String word);
    List<SearchRecordEntity> getRecord(String userName);
}
