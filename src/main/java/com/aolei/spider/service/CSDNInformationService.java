package com.aolei.spider.service;

import com.aolei.spider.entity.InformationEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service
public interface CSDNInformationService {
    void addCSDNInformation(InformationEntity entity);

    List<InformationEntity> getAllInformation();
}
