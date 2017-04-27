package com.aolei.spider.service.impl;

import com.aolei.spider.dao.AnswerEntityMapper;
import com.aolei.spider.dao.QuestionEntityMapper;
import com.aolei.spider.entity.AnswerEntity;
import com.aolei.spider.entity.QuestionEntity;
import com.aolei.spider.service.BaseService;
import com.aolei.spider.service.QuestionService;
import com.aolei.spider.util.CommonStaticValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/4/22.
 */
@Service("QuestionService")
public class QuestionServiceImpl extends BaseService implements QuestionService{
    @Resource
    @Autowired
    QuestionEntityMapper questionEntityMapper;
    @Resource
    @Autowired
    AnswerEntityMapper answerEntityMapper;
    private QuestionEntity questionEntity;
    private AnswerEntity answerEntity;
    public void applyQuestion(String userName, String questionTitle, String questionContent) {
        questionEntity = new QuestionEntity();
        questionEntity.setApplyusername(userName);
        questionEntity.setCreatetime(new Date());
        questionEntity.setQuestiontitle(questionTitle);
        questionEntity.setQuestioncontent(questionContent);
        questionEntity.setStatus(CommonStaticValue.NORMAL);
        questionEntityMapper.insertSelective(questionEntity);
    }

    public void deleteQuestion(int id) {
        questionEntity = new QuestionEntity();
        questionEntity.setId(id);
        questionEntity.setStatus(CommonStaticValue.UNNORMAL);
        questionEntityMapper.updateByPrimaryKeySelective(questionEntity);
    }

    public void likeQuestion(int id, int likeStatus) {
        questionEntity = new QuestionEntity();
        questionEntity = questionEntityMapper.selectByPrimaryKey(id);
        int likeCount = questionEntity.getLikecount();
        if (likeStatus == CommonStaticValue.LIKESTATUS){
            questionEntity.setLikecount(++likeCount);
        }else{
            questionEntity.setLikecount(--likeCount);
        }
        questionEntityMapper.updateByPrimaryKeySelective(questionEntity);
    }

    public List<QuestionEntity> getAllQuestion(int start, int count) {
        if (count > 20 || count < 0){
            count = 20;
        }
        return questionEntityMapper.getAllQuestion(start,count);
    }

    public List<QuestionEntity> getQuestionByName(String userName) {
        return questionEntityMapper.getQuestionByName(userName);
    }

    public void answerQuestion(int questionId, String userName, String content,String replayUserName,String replayContent) {
        answerEntity = new AnswerEntity();
        answerEntity.setQuestionid(questionId);
        answerEntity.setCreatetime(new Date());
        answerEntity.setAnswerusername(userName);
        if (content != null && content.length() != 0){
            answerEntity.setAnswercontent(content);
        }
        if ((replayUserName != null && replayUserName.length() != 0) && (replayContent != null && replayContent.length() != 0)){
            answerEntity.setReplayusername(replayUserName);
            answerEntity.setReplaycontent(replayContent);
            answerEntity.setReplaytime(new Date());
            //answerEntityMapper.updateByPrimaryKeySelective(answerEntity);
            //return ;
        }
        answerEntity.setStatus(CommonStaticValue.NORMAL);
        answerEntityMapper.insertSelective(answerEntity);
    }

    public List<QuestionEntity> getMyAnswerQuestion(String userName){
        List<QuestionEntity> questionEntities = new ArrayList<QuestionEntity>();
        List<Integer> questionIdList = answerEntityMapper.selectQuestionIdByUserName(userName);
        logger.info("ssssssssssssss"+questionIdList.toString());
        List<Integer> tempList = new ArrayList<Integer>();
        if (questionIdList != null && !questionIdList.isEmpty()){
            Set<Integer> questionIdSet = new HashSet<Integer>();
            questionIdSet.addAll(questionIdList);
            tempList.addAll(questionIdSet);
            logger.info("ssssssssssssssssssssss"+tempList);
            questionEntities = questionEntityMapper.selectQuestionByQuestionId(tempList);
            logger.info("======================="+questionEntities.toString());
        }
        return questionEntities;
    }

    public List<AnswerEntity> getAnswer(int questionId) {
        return answerEntityMapper.getAnswers(questionId);
    }
}
