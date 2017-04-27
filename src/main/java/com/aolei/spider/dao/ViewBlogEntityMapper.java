package com.aolei.spider.dao;

import com.aolei.spider.entity.ViewBlogEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ViewBlogEntityMapper {
    @Delete({
        "delete from tb_view_blog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_view_blog (id, \" blogId\", ",
        "tbName, title, content, ",
        "link, time, imagelink)",
        "values (#{id,jdbcType=INTEGER}, #{blogid,jdbcType=INTEGER}, ",
        "#{tbname,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{link,jdbcType=VARCHAR}, #{time,jdbcType=TIMESTAMP}, #{imagelink,jdbcType=VARCHAR})"
    })
    int insert(ViewBlogEntity record);

    int insertSelective(ViewBlogEntity record);

    @Select({
        "select",
        "id, \" blogId\", tbName, title, content, link, time, imagelink",
        "from tb_view_blog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    ViewBlogEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ViewBlogEntity record);

    @Update({
        "update tb_view_blog",
        "set \" blogId\" = #{blogid,jdbcType=INTEGER},",
          "tbName = #{tbname,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "link = #{link,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "imagelink = #{imagelink,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ViewBlogEntity record);
}