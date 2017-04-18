package com.aolei.spider.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/11.
 */
@Service
public interface UserBlogLikeAndCollectionService {
    /**
     * 博客点赞，评论，取消赞，取消评论
     * @param userName
     * @param blogId
     * @param type
     * @param status
     * @param tbName
     * @return
     */
    int blogLike(String userName,int blogId,int type,int status,String tbName);
}
