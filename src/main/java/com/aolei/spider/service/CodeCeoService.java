package com.aolei.spider.service;

import com.aolei.spider.entity.CodeCeoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Service
public interface CodeCeoService {
    int addCodeCeoEntity(List<CodeCeoEntity> codeCeoEntities);
}
