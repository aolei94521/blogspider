package com.aolei.spider.dao;

import com.aolei.spider.entity.InformationEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InformationEntityMapper {
    /**
     * 查询所有的csdn资讯
     * @return
     */
    List<InformationEntity> selectAllNews();

    /**
     * 添加csdn资讯
     * @param entity
     */
    void addNews(InformationEntity entity);

    /**
     * 分页获取csdn资讯
     * @param start
     * @param count
     * @return
     */
    List<InformationEntity> getInformationList(int start,int count);
}