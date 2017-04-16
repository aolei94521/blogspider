package com.aolei.spider.service.impl;

import com.aolei.spider.dao.UserLikeAndCollectionEntityMapper;
import com.aolei.spider.entity.UserLikeAndCollectionEntity;
import com.aolei.spider.service.UserBlogLikeAndCollectionService;
import com.aolei.spider.util.CommonLoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/11.
 */
@Service("UserBlogLikeAndCollectionService")
public class UserBlogLikeAndCollectionServiceImpl extends CommonLoggerUtil implements UserBlogLikeAndCollectionService {
    @Resource
    @Autowired
    UserLikeAndCollectionEntityMapper mapper;
    public int blogLike(String userName, int blogId, int type, int status, String tbName) {
        UserLikeAndCollectionEntity entity;
        int result = 0;
        entity = new UserLikeAndCollectionEntity();
        if (mapper.selectByTbNameAndTypeAndUserName(blogId,userName,type) != null){
            entity.setUsername(userName);
            entity.setBlogid(blogId);
            entity.setCreatetime(new Date());
            entity.setTbname(tbName);
            entity.setType(type);
            entity.setStatus(status);
            result = mapper.updateByPrimaryKeySelective(entity);
        }else{
            result = mapper.insertSelective(entity);
        }
        return result;
    }
}
