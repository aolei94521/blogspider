package com.aolei.spider.dao;

import com.aolei.spider.entity.ViewBlogEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ViewBlogEntityMapper {
    @Delete({
        "delete from tb_view_blog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_view_blog (id, \" blogId\", ",
        "tbName, title, content, ",
        "link, time, imagelink, ",
        "author)",
        "values (#{id,jdbcType=INTEGER}, #{blogid,jdbcType=INTEGER}, ",
        "#{tbname,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{link,jdbcType=VARCHAR}, #{time,jdbcType=TIMESTAMP}, #{imagelink,jdbcType=VARCHAR}, ",
        "#{author,jdbcType=VARCHAR})"
    })
    int insert(ViewBlogEntity record);

    int insertSelective(ViewBlogEntity record);

    @Select({
        "select",
        "id, \" blogId\", tbName, title, content, link, time, imagelink, author",
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
          "imagelink = #{imagelink,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ViewBlogEntity record);

    List<ViewBlogEntity> getAllRecord(String userName);

    int deleteByRecordId(int recordId,String userNmae);

    int deleteByUserName(String userName);
}