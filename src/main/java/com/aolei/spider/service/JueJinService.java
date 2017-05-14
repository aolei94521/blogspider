package com.aolei.spider.service;

import com.aolei.spider.entity.JueJinEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/19.
 */
@Service
public interface  JueJinService {
    void addJuejinEntity(List<JueJinEntity> jueJinEntities);
    List<JueJinEntity> getJueJinList(int start,int count);
    List<JueJinEntity> search(Map<String,Object> params);
}
