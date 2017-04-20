package com.aolei.spider.dao;

import com.aolei.spider.entity.MobileEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MobileEntityMapper {
    @Delete({
        "delete from tb_mobile",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_mobile (id, url, ",
        "title, time, readCount, ",
        "recomment, pereview)",
        "values (#{id,jdbcType=INTEGER}, #{url,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{time,jdbcType=VARCHAR}, #{readcount,jdbcType=VARCHAR}, ",
        "#{recomment,jdbcType=VARCHAR}, #{pereview,jdbcType=LONGVARCHAR})"
    })
    int insert(MobileEntity record);

    int insertSelective(MobileEntity record);

    @Select({
        "select",
        "id, url, title, time, readCount, recomment, pereview",
        "from tb_mobile",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    MobileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MobileEntity record);

    @Update({
        "update tb_mobile",
        "set url = #{url,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "readCount = #{readcount,jdbcType=VARCHAR},",
          "recomment = #{recomment,jdbcType=VARCHAR},",
          "pereview = #{pereview,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(MobileEntity record);

    @Update({
        "update tb_mobile",
        "set url = #{url,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "readCount = #{readcount,jdbcType=VARCHAR},",
          "recomment = #{recomment,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MobileEntity record);
}