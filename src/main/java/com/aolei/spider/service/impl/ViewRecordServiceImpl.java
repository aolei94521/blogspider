package com.aolei.spider.service.impl;

import com.aolei.spider.dao.ViewRecordEntityMapper;
import com.aolei.spider.entity.ViewRecordEntity;
import com.aolei.spider.service.BaseService;
import com.aolei.spider.service.ViewRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service("ViewRecordService")
public class ViewRecordServiceImpl extends BaseService implements ViewRecordService{
    @Resource
    @Autowired
    ViewRecordEntityMapper viewRecordEntityMapper;
    public int addViewRecord(int blogId, String tbName, String userName) {
        int result = 0;
        ViewRecordEntity viewRecordEntity = new ViewRecordEntity();
        viewRecordEntity.setBlogid(blogId);
        viewRecordEntity.setTbname(tbName);
        viewRecordEntity.setUsername(userName);
        viewRecordEntity.setViewtime(new Date());
        result = viewRecordEntityMapper.insertSelective(viewRecordEntity);
        return result;
    }

    public int deleteViewRecord(int recordId) {
        return viewRecordEntityMapper.deleteByRecordId(recordId);
    }

    public int deleteAllViewReocrd(String userName) {
        return viewRecordEntityMapper.deleteByUserName(userName);
    }

}