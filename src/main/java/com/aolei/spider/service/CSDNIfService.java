package com.aolei.spider.service;

import com.aolei.spider.dao.InformationEntityMapper;
import com.aolei.spider.entity.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service()
public class CSDNIfService extends BaseService {

    @Autowired
    private InformationEntityMapper dao;

    public void addCSDNInformation(InformationEntity entity) {
        //dao.insert(entity);
    }

    public List<InformationEntity> getAllInformation() {
        //return null;
        return dao.selectAll();
    }
}
