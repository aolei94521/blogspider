package com.aolei.spider.dao;

import com.aolei.spider.entity.JueJinEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface JueJinEntityMapper {
    @Delete({
        "delete from tb_juejin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_juejin (id, title, ",
        "author, link, imageLink)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{author,jdbcType=VARCHAR}, #{link,jdbcType=VARCHAR}, #{imagelink,jdbcType=VARCHAR})"
    })
    int insert(JueJinEntity record);

    int insertSelective(JueJinEntity record);

    @Select({
        "select",
        "id, title, author, link, imageLink",
        "from tb_juejin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    JueJinEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JueJinEntity record);

    @Update({
        "update tb_juejin",
        "set title = #{title,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "link = #{link,jdbcType=VARCHAR},",
          "imageLink = #{imagelink,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(JueJinEntity record);
}