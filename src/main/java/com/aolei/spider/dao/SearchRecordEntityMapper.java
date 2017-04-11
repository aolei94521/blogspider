package com.aolei.spider.dao;

import com.aolei.spider.entity.SearchRecordEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SearchRecordEntityMapper {
    @Delete({
        "delete from tb_search_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_search_record (id, key, ",
        "userName, createTime)",
        "values (#{id,jdbcType=INTEGER}, #{key,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(SearchRecordEntity record);

    int insertSelective(SearchRecordEntity record);

    @Select({
        "select",
        "id, key, userName, createTime",
        "from tb_search_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    SearchRecordEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchRecordEntity record);

    @Update({
        "update tb_search_record",
        "set key = #{key,jdbcType=VARCHAR},",
          "userName = #{username,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SearchRecordEntity record);
}