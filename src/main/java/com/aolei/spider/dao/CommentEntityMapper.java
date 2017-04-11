package com.aolei.spider.dao;

import com.aolei.spider.entity.CommentEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CommentEntityMapper {
    @Delete({
        "delete from tb_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_comment (id, blogId, ",
        "tbName, commentUserName, ",
        "commentContent, replayUserName, ",
        "replayContent)",
        "values (#{id,jdbcType=INTEGER}, #{blogid,jdbcType=INTEGER}, ",
        "#{tbname,jdbcType=VARCHAR}, #{commentusername,jdbcType=VARCHAR}, ",
        "#{commentcontent,jdbcType=VARCHAR}, #{replayusername,jdbcType=VARCHAR}, ",
        "#{replaycontent,jdbcType=VARCHAR})"
    })
    int insert(CommentEntity record);

    int insertSelective(CommentEntity record);

    @Select({
        "select",
        "id, blogId, tbName, commentUserName, commentContent, replayUserName, replayContent",
        "from tb_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CommentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentEntity record);

    @Update({
        "update tb_comment",
        "set blogId = #{blogid,jdbcType=INTEGER},",
          "tbName = #{tbname,jdbcType=VARCHAR},",
          "commentUserName = #{commentusername,jdbcType=VARCHAR},",
          "commentContent = #{commentcontent,jdbcType=VARCHAR},",
          "replayUserName = #{replayusername,jdbcType=VARCHAR},",
          "replayContent = #{replaycontent,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommentEntity record);
}