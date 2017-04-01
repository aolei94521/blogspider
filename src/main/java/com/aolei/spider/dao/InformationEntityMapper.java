package com.aolei.spider.dao;

import com.aolei.spider.entity.InformationEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InformationEntityMapper {
    @Delete({
            "delete from tb_news",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into tb_news (url, ",
            "title, time, readCount, ",
            "recomment, pereview)",
            "values (#{url,jdbcType=VARCHAR}, ",
            "#{title,jdbcType=VARCHAR}, #{time,jdbcType=DATE}, #{readcount,jdbcType=VARCHAR}, ",
            "#{recomment,jdbcType=VARCHAR}, #{pereview,jdbcType=LONGVARCHAR})"
    })
    int insert(InformationEntity record);

    int insertSelective(InformationEntity record);

   /* @Select({
        "select",
        "id, url, title, time, readCount, recomment, pereview",
        "from tb_news",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    InformationEntity selectByPrimaryKey(Integer id);*/

    /*int updateByPrimaryKeySelective(InformationEntity record);

    @Update({
        "update tb_news",
        "set url = #{url,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=DATE},",
          "readCount = #{readcount,jdbcType=VARCHAR},",
          "recomment = #{recomment,jdbcType=VARCHAR},",
          "pereview = #{pereview,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(InformationEntity record);

    @Update({
        "update tb_news",
        "set url = #{url,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=DATE},",
          "readCount = #{readcount,jdbcType=VARCHAR},",
          "recomment = #{recomment,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(InformationEntity record);*/

//    @Select("select * from tb_news where id=#{id}")
//    InformationEntity select(Integer id);

    @Select("select * from tb_news")
    List<InformationEntity> selectAll();
}