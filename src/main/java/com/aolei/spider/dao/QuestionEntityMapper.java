package com.aolei.spider.dao;

import com.aolei.spider.entity.QuestionEntity;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuestionEntityMapper {


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

    List<QuestionEntity> getAllQuestion(int start,int count);

    List<QuestionEntity> getQuestionByName(String userName);

    List<QuestionEntity> selectQuestionByQuestionId(List<Integer> idList);
}