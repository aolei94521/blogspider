package com.aolei.spider.service;

import com.aolei.spider.entity.ViewBlogEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service
public interface ViewRecordService {
    int addViewRecord(int blogId,String tbName,String userName);

    int deleteViewRecord(int recordId,String userName);

    int deleteAllViewReocrd(String userName);

    List<ViewBlogEntity> getAllViewRecord(String userName);
}
