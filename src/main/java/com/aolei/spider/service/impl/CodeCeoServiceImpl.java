package com.aolei.spider.service.impl;

import com.aolei.spider.dao.CodeCeoEntityMapper;
import com.aolei.spider.entity.CodeCeoEntity;
import com.aolei.spider.service.CodeCeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Service("CodeCeoService")
public class CodeCeoServiceImpl implements CodeCeoService{
    @Resource
    @Autowired
    private CodeCeoEntityMapper mapper;
    public int addCodeCeoEntity(List<CodeCeoEntity> codeCeoEntities) {
        for (CodeCeoEntity codeCeoEntity:codeCeoEntities) {
            mapper.insertSelective(codeCeoEntity);
        }
        return 0;
    }

    public List<CodeCeoEntity> getCodeCeoList(int start, int count) {
       if (count > 20 || count < 0){
           count = 20;
       }
       return mapper.getCodeCeoList(start,count);
    }
}
