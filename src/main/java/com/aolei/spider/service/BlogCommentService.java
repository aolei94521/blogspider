package com.aolei.spider.service;

import com.aolei.spider.entity.CommentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service
public interface BlogCommentService {
    /**
     * 博客评论
     * @param tbName
     * @param userName
     * @param content
     * @return
     */
    int blogComment(String tbName,String userName,String content,int blogId);

    /**
     * 回复评论
     * @param tbName
     * @param userName
     * @param content
     * @param replayUserName
     * @param replayContent
     * @return
     */
    int blogReplay(String tbName,String userName,String content,String replayUserName,String replayContent,int blogId);

    /**
     * 获取评论列表，每次请求20条评论
     * @param blogId
     * @param tbName
     * @param start
     * @param count
     * @return
     */
    List<CommentEntity> getCommentList(int blogId, String tbName, int start, int count);
}
