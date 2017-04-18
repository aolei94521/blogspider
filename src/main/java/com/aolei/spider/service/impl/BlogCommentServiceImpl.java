package com.aolei.spider.service.impl;

import com.aolei.spider.dao.CommentEntityMapper;
import com.aolei.spider.entity.CommentEntity;
import com.aolei.spider.service.BaseService;
import com.aolei.spider.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service("BlogCommentService")
public class BlogCommentServiceImpl extends BaseService implements BlogCommentService{
    @Resource
    @Autowired
    private CommentEntityMapper commentEntityMapper;
    public int blogComment(String tbName, String userName, String content,int blogId) {
        CommentEntity commentEntity = new CommentEntity();
        int result = 0;
        commentEntity.setTbname(tbName);
        commentEntity.setCommentusername(userName);
        commentEntity.setCommentcontent(content);
        commentEntity.setBlogid(blogId);
        result = commentEntityMapper.insertSelective(commentEntity);
        return result;
    }

    public int blogReplay(String tbName, String userName, String content, String replayUserName, String replayContent,int blogId) {
        CommentEntity commentEntity = new CommentEntity();
        int result = 0;
        commentEntity.setTbname(tbName);
        commentEntity.setCommentusername(userName);
        commentEntity.setCommentcontent(content);
        commentEntity.setReplayusername(replayUserName);
        commentEntity.setReplaycontent(replayContent);
        commentEntity.setBlogid(blogId);
        result = commentEntityMapper.insertSelective(commentEntity);

        return result;
    }

    public List<CommentEntity> getCommentList(int blogId,String tbName,int start,int count){
        if (count < 0 || count > 20){
            count = 20;
        }
        List<CommentEntity> commentEntityList = commentEntityMapper.selectComment(blogId,tbName,start,count);
        return commentEntityList;
    }
}
