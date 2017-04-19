package com.aolei.spider.service;

import com.aolei.spider.entity.CNBlogsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
@Service
public interface CNBlogService {

   void addCNBlogs(List<CNBlogsEntity> list);
}
