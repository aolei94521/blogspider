package com.aolei.spider.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/11.
 */
@Service
public interface UserBlogLikeAndCollectionService {
    int blogLike(String userName,int blogId,int type,int status,String tbName);
}
