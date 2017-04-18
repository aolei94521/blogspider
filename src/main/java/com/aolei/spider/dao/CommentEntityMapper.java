package com.aolei.spider.dao;

import com.aolei.spider.entity.CommentEntity;

import java.util.List;

public interface CommentEntityMapper {


    int insertSelective(CommentEntity record);


    int updateByPrimaryKeySelective(CommentEntity record);

    List<CommentEntity> selectComment(int blogId,String tbName,int start,int count);
}