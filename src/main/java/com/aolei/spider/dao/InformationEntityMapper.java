package com.aolei.spider.dao;

import com.aolei.spider.entity.InformationEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InformationEntityMapper {

    List<InformationEntity> selectAllNews();

    void addNews(InformationEntity entity);

    List<InformationEntity> getInformationList(int start,int count);
}