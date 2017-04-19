package com.aolei.spider.service.impl;

import com.aolei.spider.dao.JueJinEntityMapper;
import com.aolei.spider.entity.JueJinEntity;
import com.aolei.spider.service.BaseService;
import com.aolei.spider.service.JueJinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
@Service("JueJinService")
public class JuejinServiceImpl extends BaseService implements JueJinService{
    @Resource
    @Autowired
    JueJinEntityMapper jueJinEntityMapper;
    public void addJuejinEntity(List<JueJinEntity> jueJinEntities) {
        for (JueJinEntity jueJinEntity: jueJinEntities) {
            jueJinEntityMapper.insertSelective(jueJinEntity);
        }
    }
}
