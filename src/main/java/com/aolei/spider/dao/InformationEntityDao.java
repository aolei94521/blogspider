package com.aolei.spider.dao;

import com.aolei.spider.entity.InformationEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface InformationEntityDao {
    @Select("select * from tb_news")
    List<InformationEntity> selectAll();
}
