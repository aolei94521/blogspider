package com.aolei.spider.service;

import com.aolei.spider.entity.TuiKuEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
@Service
public interface TuiKuService {
    /**
     * 向数据库中插入一条推酷网爬取的数据
     * @param tuiKuEntity
     */
    void addTuiKuInfo(TuiKuEntity tuiKuEntity);

    /**
     * 查询所有的推库表信息
     * @return List<TuiKuEntity>
     */
    List<TuiKuEntity> getAllTuiKu();

    List<TuiKuEntity> getTuiKuList(int start,int count);
}
