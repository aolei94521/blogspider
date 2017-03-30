package com.aolei.spider.service.impl;

import com.aolei.spider.dao.InformationEntityMapper;
import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.CSDNInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service("CSDNInformationService")
public class CSDNInformationServiceImpl implements CSDNInformationService{
    @Resource
    private InformationEntityMapper dao;
    public void addCSDNInformation(InformationEntity entity) {
        dao.insert(entity);
    }

    public List<InformationEntity> getAllInformation() {
            return dao.selectAll();
    }
}
