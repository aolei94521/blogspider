package com.aolei.spider.dao;

import com.aolei.spider.entity.TuiKuEntity;

import java.util.List;

public interface TuiKuEntityMapper {

    /**
     * 插入一条推库文章
     * @param record
     * @return
     */
    int insertSelective(TuiKuEntity record);

    /**
     * 查询所有的推库技术文章
     * @return
     */
    List<TuiKuEntity> getAllTuiKu();

    /**
     * 查询一定数量的推库文章，分页
     * @param start
     * @param count
     * @return
     */
    List<TuiKuEntity> getTuiKuList(int start,int count);

    TuiKuEntity selectById(int id);
}