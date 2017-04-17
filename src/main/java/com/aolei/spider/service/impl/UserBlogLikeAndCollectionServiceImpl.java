package com.aolei.spider.service.impl;

import com.aolei.spider.dao.LikeEntityMapper;
import com.aolei.spider.dao.UserLikeAndCollectionEntityMapper;
import com.aolei.spider.entity.LikeEntity;
import com.aolei.spider.entity.UserLikeAndCollectionEntity;
import com.aolei.spider.service.UserBlogLikeAndCollectionService;
import com.aolei.spider.util.CommonLoggerUtil;
import com.aolei.spider.util.CommonStaticValue;
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
    UserLikeAndCollectionEntityMapper userLikeAndCollectionMapper;
    @Resource
    @Autowired
    LikeEntityMapper likeEntityMapper;
    public int blogLike(String userName, int blogId, int type, int status, String tbName) {
        UserLikeAndCollectionEntity entity;
        int result = 0;
        entity = new UserLikeAndCollectionEntity();
        entity.setUserName(userName);
        entity.setBlogId(blogId);
        entity.setCreateTime(new Date());
        entity.setTbname(tbName);
        entity.setType(type);
        entity.setStatus(status);
        /**
         *判断该用户是否收藏或者点赞过该博客
         */
        if (userLikeAndCollectionMapper.selectByTbNameAndTypeAndUserName(blogId,userName,type) != null){
            //点赞或者收藏过，更新
            result = userLikeAndCollectionMapper.updateByPrimaryKeySelective(entity);
            //判断Like表中是否有该条数据，如果有则在likeCount加一没有则插入一条
            if (type == CommonStaticValue.LIKE){
                updateTbLike(blogId,tbName,status);
            }
        }else{
            //没有点赞或者收藏过，添加
            if (type == CommonStaticValue.LIKE){
                updateTbLike(blogId,tbName,status);
            }
            result = userLikeAndCollectionMapper.insert(entity);

        }
        return result;
    }
    private void updateTbLike(int blogId,String tbName,int status){
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setTbname(tbName);
        likeEntity.setCreatetime(new Date());
        likeEntity.setLikecount(1);
        likeEntity.setBlogid(blogId);
        LikeEntity tempLikeEntity = likeEntityMapper.selectByBlogIdAndType(blogId,tbName);
        //如果为空，则添加一条记录
        if (tempLikeEntity == null){
            likeEntityMapper.insertSelective(likeEntity);
        }else{
            //已经存在，更新
            int likeCount = tempLikeEntity.getLikecount();
            if (status == CommonStaticValue.LIKESTATUS){
                likeEntity.setLikecount(likeCount + 1);
            }else{
                likeEntity.setLikecount(likeCount - 1);
            }
            likeEntity.setId(tempLikeEntity.getId());
            likeEntityMapper.updateByPrimaryKeySelective(likeEntity);
        }
    }
}
