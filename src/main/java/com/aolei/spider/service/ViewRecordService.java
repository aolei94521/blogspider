package com.aolei.spider.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service
public interface ViewRecordService {
    int addViewRecord(int blogId,String tbName,String userName);

    int deleteViewRecord(int recordId);

    int deleteAllViewReocrd(String userName);
}
