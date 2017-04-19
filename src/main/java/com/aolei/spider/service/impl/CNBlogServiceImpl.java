package com.aolei.spider.service.impl;

import com.aolei.spider.dao.CNBlogsEntityMapper;
import com.aolei.spider.entity.CNBlogsEntity;
import com.aolei.spider.service.CNBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
@Service("CNBlogService")
public class CNBlogServiceImpl implements CNBlogService{
    @Resource
    @Autowired
    private CNBlogsEntityMapper mapper;
    public void addCNBlogs(List<CNBlogsEntity> list) {
        for (CNBlogsEntity cnBlogsEntity:list) {
            mapper.insertSelective(cnBlogsEntity);
        }
    }
}
