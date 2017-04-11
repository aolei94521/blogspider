package com.aolei.spider.dao;

import com.aolei.spider.entity.KeyEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface KeyEntityMapper {
    @Delete({
        "delete from tb_key",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_key (id, key)",
        "values (#{id,jdbcType=INTEGER}, #{key,jdbcType=VARCHAR})"
    })
    int insert(KeyEntity record);

    int insertSelective(KeyEntity record);

    @Select({
        "select",
        "id, key",
        "from tb_key",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    KeyEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeyEntity record);

    @Update({
        "update tb_key",
        "set key = #{key,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(KeyEntity record);
}