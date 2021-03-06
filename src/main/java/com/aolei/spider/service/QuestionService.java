package com.aolei.spider.service;

import com.aolei.spider.entity.AnswerEntity;
import com.aolei.spider.entity.QuestionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */
@Service
public interface QuestionService {
    /**
     * 发布问题
     * @param userName
     * @param questionTitle
     * @param questionContent
     */
    void applyQuestion(String userName,String questionTitle,String questionContent);

    /**
     * 删除问题
     * @param id
     */
    void deleteQuestion(int id);

    /**
     * 更新问题的点赞数量
     * @param id
     * @param likeStatus
     */
    void likeQuestion(int id,int likeStatus);

    /**
     * 请求所有的问题
     * @param start
     * @param count
     */
    List<QuestionEntity> getAllQuestion(int start, int count);

    /**
     * 查询用户发布的问题
     * @param userName
     * @return
     */
    List<QuestionEntity> getQuestionByName(String userName);

    /**
     * 回答问题
     * @param questionId
     * @param userName
     * @param content
     */
    int answerQuestion(int questionId,String userName,String content);

    /**
     * 回复回答
     * @param questionId
     * @param userName
     * @param content
     * @param replayUserName
     * @param replayContent
     * @return
     */
    int replayQuestion(int questionId,String userName,String content,String replayUserName,String replayContent);

    /**
     * 查询我回答的问题
     * @param userName
     * @return
     */
    List<QuestionEntity> getMyAnswerQuestion(String userName);

    /**
     * 获取回复列表
     * @param questionId
     * @return
     */
    List<AnswerEntity> getAnswer(int questionId);
}
