package com.aolei.spider.service.impl;

import com.aolei.spider.dao.CSDNEntityMapper;
import com.aolei.spider.entity.CSDNEntity;
import com.aolei.spider.service.BaseService;
import com.aolei.spider.service.CSDNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/26.
 */
@Service("CSDNService")
public class CSDNServiceImpl extends BaseService implements CSDNService {
    @Resource
    @Autowired
    CSDNEntityMapper mapper;
    public List<CSDNEntity> getCSDNList(int start, int count) {
        //设置每次请求20条数据
        if (count < 0 || count > 20){
            count = 20;
        }
        return mapper.getCSDNList(start,count);
    }

    public List<CSDNEntity> search(Map<String, Object> params) {
        return mapper.search(params);
    }
}
