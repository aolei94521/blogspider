package com.aolei.spider.dao;

import com.aolei.spider.entity.CSDNEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CSDNEntityMapper {
    @Delete({
        "delete from tb_cnblogs_geek",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_cnblogs_geek (id, title, ",
        "auther, time, ",
        "url, imageLink)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{auther,jdbcType=VARCHAR}, #{time,jdbcType=TIMESTAMP}, ",
        "#{url,jdbcType=VARCHAR}, #{imagelink,jdbcType=VARCHAR})"
    })
    int insert(CSDNEntity record);

    int insertSelective(CSDNEntity record);

    @Select({
        "select",
        "id, title, auther, time, url, imageLink",
        "from tb_cnblogs_geek",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CSDNEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CSDNEntity record);

    @Update({
        "update tb_cnblogs_geek",
        "set title = #{title,jdbcType=VARCHAR},",
          "auther = #{auther,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "url = #{url,jdbcType=VARCHAR},",
          "imageLink = #{imagelink,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CSDNEntity record);

    List<CSDNEntity> getCSDNList(int start, int count);
}