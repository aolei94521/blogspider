package com.aolei.spider.service.impl;

import com.aolei.spider.dao.TuiKuEntityMapper;
import com.aolei.spider.entity.TuiKuEntity;
import com.aolei.spider.service.BaseService;
import com.aolei.spider.service.TuiKuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/9.
 */
@Service("TuiKuService")
public class TuiKuServiceImpl extends BaseService implements TuiKuService{
    @Resource
    @Autowired
    private TuiKuEntityMapper mapper;
    public void addTuiKuInfo(TuiKuEntity tuiKuEntity) {
         mapper.insertSelective(tuiKuEntity);
    }

    public List<TuiKuEntity> getAllTuiKu() {
        return mapper.getAllTuiKu();
    }

    public List<TuiKuEntity> getTuiKuList(int start, int count) {
        //设置每次请求20条数据
        if (count < 0 || count > 20){
            count = 20;
        }
        return mapper.getTuiKuList(start,count);
    }

    public List<TuiKuEntity> search(Map<String, Object> params) {
        return mapper.search(params);
    }
}
