package com.aolei.spider.service;

import com.aolei.spider.entity.CSDNEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/26.
 */
@Service
public interface CSDNService {
    List<CSDNEntity> getCSDNList(int start, int count);
    List<CSDNEntity> search(Map<String,Object> params);
}
