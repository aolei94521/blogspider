package com.aolei.spider.dao;

import com.aolei.spider.entity.AnswerEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AnswerEntityMapper {
    @Delete({
        "delete from tb_answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_answer (id, questionId, ",
        "answerUserName, replayUserName, ",
        "answerContent, replayContent, ",
        "status, createTime, ",
        "replayTime)",
        "values (#{id,jdbcType=INTEGER}, #{questionid,jdbcType=INTEGER}, ",
        "#{answerusername,jdbcType=VARCHAR}, #{replayusername,jdbcType=VARCHAR}, ",
        "#{answercontent,jdbcType=VARCHAR}, #{replaycontent,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{replaytime,jdbcType=TIMESTAMP})"
    })
    int insert(AnswerEntity record);

    int insertSelective(AnswerEntity record);

    @Select({
        "select",
        "id, questionId, answerUserName, replayUserName, answerContent, replayContent, ",
        "status, createTime, replayTime",
        "from tb_answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    AnswerEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnswerEntity record);

    @Update({
        "update tb_answer",
        "set questionId = #{questionid,jdbcType=INTEGER},",
          "answerUserName = #{answerusername,jdbcType=VARCHAR},",
          "replayUserName = #{replayusername,jdbcType=VARCHAR},",
          "answerContent = #{answercontent,jdbcType=VARCHAR},",
          "replayContent = #{replaycontent,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "replayTime = #{replaytime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AnswerEntity record);
}