package com.aolei.spider.dao;

import com.aolei.spider.entity.CNBlogsEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CNBlogsEntityMapper {
    @Delete({
        "delete from tb_cnblogs",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_cnblogs (id, title, ",
        "author, content, ",
        "link)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{author,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{link,jdbcType=VARCHAR})"
    })
    int insert(CNBlogsEntity record);

    int insertSelective(CNBlogsEntity record);

    @Select({
        "select",
        "id, title, author, content, link",
        "from tb_cnblogs",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CNBlogsEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CNBlogsEntity record);

    @Update({
        "update tb_cnblogs",
        "set title = #{title,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "link = #{link,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CNBlogsEntity record);
}