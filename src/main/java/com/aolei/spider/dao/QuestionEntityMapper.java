package com.aolei.spider.dao;

import com.aolei.spider.entity.QuestionEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface QuestionEntityMapper {
    @Delete({
        "delete from tb_question",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_question (id, applyUserName, ",
        "status, likeCount, ",
        "questionTitle, createTime, ",
        "questionContent)",
        "values (#{id,jdbcType=INTEGER}, #{applyusername,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{likecount,jdbcType=INTEGER}, ",
        "#{questiontitle,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{questioncontent,jdbcType=LONGVARCHAR})"
    })
    int insert(QuestionEntity record);

    int insertSelective(QuestionEntity record);

    @Select({
        "select",
        "id, applyUserName, status, likeCount, questionTitle, createTime, questionContent",
        "from tb_question",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    QuestionEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionEntity record);

    @Update({
        "update tb_question",
        "set applyUserName = #{applyusername,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "likeCount = #{likecount,jdbcType=INTEGER},",
          "questionTitle = #{questiontitle,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "questionContent = #{questioncontent,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(QuestionEntity record);

    @Update({
        "update tb_question",
        "set applyUserName = #{applyusername,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "likeCount = #{likecount,jdbcType=INTEGER},",
          "questionTitle = #{questiontitle,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionEntity record);
}