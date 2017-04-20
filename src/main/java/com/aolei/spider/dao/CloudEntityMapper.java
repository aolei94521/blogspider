package com.aolei.spider.dao;

import com.aolei.spider.entity.CloudEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CloudEntityMapper {
    @Delete({
        "delete from tb_cloud",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_cloud (id, url, ",
        "title, time, readCount, ",
        "recomment, pereview)",
        "values (#{id,jdbcType=INTEGER}, #{url,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{time,jdbcType=VARCHAR}, #{readcount,jdbcType=VARCHAR}, ",
        "#{recomment,jdbcType=VARCHAR}, #{pereview,jdbcType=LONGVARCHAR})"
    })
    int insert(CloudEntity record);

    int insertSelective(CloudEntity record);

    @Select({
        "select",
        "id, url, title, time, readCount, recomment, pereview",
        "from tb_cloud",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    CloudEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CloudEntity record);

    @Update({
        "update tb_cloud",
        "set url = #{url,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "readCount = #{readcount,jdbcType=VARCHAR},",
          "recomment = #{recomment,jdbcType=VARCHAR},",
          "pereview = #{pereview,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(CloudEntity record);

    @Update({
        "update tb_cloud",
        "set url = #{url,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "readCount = #{readcount,jdbcType=VARCHAR},",
          "recomment = #{recomment,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CloudEntity record);
}