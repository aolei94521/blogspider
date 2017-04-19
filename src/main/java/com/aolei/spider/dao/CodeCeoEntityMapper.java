package com.aolei.spider.dao;

import com.aolei.spider.entity.CodeCeoEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CodeCeoEntityMapper {
    @Delete({
        "delete from tb_manong",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_manong (id, title, ",
        "content, link, iamgeLink)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{link,jdbcType=VARCHAR}, #{iamgelink,jdbcType=VARCHAR})"
    })
    int insert(CodeCeoEntity record);

    int insertSelective(CodeCeoEntity record);

    @Select({
        "select",
        "id, title, content, link, iamgeLink",
        "from tb_manong",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CodeCeoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeCeoEntity record);

    @Update({
        "update tb_manong",
        "set title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "link = #{link,jdbcType=VARCHAR},",
          "iamgeLink = #{iamgelink,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CodeCeoEntity record);
}