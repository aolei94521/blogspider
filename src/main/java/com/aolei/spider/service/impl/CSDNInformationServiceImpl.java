package com.aolei.spider.service.impl;

import com.aolei.spider.dao.InformationEntityMapper;
import com.aolei.spider.entity.InformationEntity;
import com.aolei.spider.service.BaseService;
import com.aolei.spider.service.CSDNInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service("CSDNInformationService")
public class CSDNInformationServiceImpl extends BaseService implements CSDNInformationService {
    @Resource
    @Autowired
    private InformationEntityMapper dao;

    /**
     * 添加一条InformationEntity记录
     * @param entity
     */
    public void addCSDNInformation(InformationEntity entity) {
        dao.addNews(entity);
    }

    /**
     * 查询所有的资讯
     * @return
     */
    public List<InformationEntity> getAllInformation() {
            return dao.selectAllNews();
    }

    /**
     * 分页获取资讯信息，每页返回20条数据
     * @param start
     * @param count
     * @return
     */
    public List<InformationEntity> getInformationList(int start,int count){
        logger.debug("+++++++++++++++++++++++++++++++++"+start+"+++"+count);
        //每次请求的数据为20条
        if (count < 0 || count > 20){
            count = 20;
        }
        return dao.getInformationList(start,count);
    }
}
